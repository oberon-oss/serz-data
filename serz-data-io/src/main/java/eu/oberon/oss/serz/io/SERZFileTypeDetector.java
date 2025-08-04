package eu.oberon.oss.serz.io;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;
import java.util.Arrays;

/**
 * Utility class to determine if a file is a SERZ binary file.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@Log4j2
public class SERZFileTypeDetector extends FileTypeDetector {

    /**
     * Default constructor
     *
     * @since 1.0.0
     */
    public SERZFileTypeDetector() {
        // Keep javadoc happy
    }

    /**
     * probes the specified file.
     *
     * @param path the path to the file to probe
     *
     * @return "application/serz-binary" if the file is a SERZ binary file, or {@literal <null>} if not.
     *
     * @throws IOException If an error occurred opening or reading the file.
     * @since 1.0.0
     */
    @Override
    public @Nullable String probeContentType(@NotNull Path path) throws IOException {
        return checkSERZSignature(path) ? "application/serz-binary" : null;
    }

    private static final byte[] BYTES = new byte[]{0x53, 0x45, 0x52, 0x5a, 0x00, 0x00, 0x01, 0x00};

    /**
     * Static utility method to probe a file.
     *
     * @param path the path to the file to probe
     *
     * @return <b>true</b> if the file is a binary SERZ file, or <b>false</b> if not.
     *
     * @throws IOException If an error occurred opening or reading the file.
     * @since 1.0.0
     */
    public static boolean isValidSERZFile(@NotNull Path path) throws IOException {
        return checkSERZSignature(path);
    }

    private static boolean checkSERZSignature(Path path) throws IOException {
        byte[] header = new byte[8];
        boolean isSerzFile = false;
        try (InputStream is = Files.newInputStream(path)) {
            if (is.read(header) == header.length) {
                isSerzFile = Arrays.equals(header, BYTES);
                if (!isSerzFile) {
                    LOGGER.debug("SERZ SIGNATURE NOT FOUND in: {}", path);
                } else if (!path.getFileName().toString().endsWith(".bin")) {
                    LOGGER.info("Acceptable file with non .bin extension: {}", path);
                }
            }
        }
        return isSerzFile;
    }
}
