package eu.oberon.oss.serz.io.reader;

import eu.oberon.oss.serz.defs.SerzDataStructure;
import eu.oberon.oss.serz.io.SerzIOException;

/**
 * Defines the contract for classes that want to create instances of classes that implement the {@link SerzDataStructure} interface
 *
 * @param <I> The class that provides the data that should be read and converted into the target data object.
 * @param <S> The class type of the input source
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface SerzReader<I, S extends SerzDataStructure> {
    /**
     * Reads from the input source provided that represents XML data to be processed.
     *
     * @param inputSource Input source to read from
     *
     * @return The {@link SerzDataStructure} instance that was read and constructed.
     *
     * @throws SerzIOException If any error occurred while reading.
     * @since 1.0.0
     */
    S readFromXml(I inputSource);

    /**
     * Reads from the input source provided that represents binary SERZ data to be processed.
     *
     * @param inputSource Input source to read from
     *
     * @return The {@link SerzDataStructure} instance that was read and constructed.
     *
     * @throws SerzIOException If any error occurred while reading.
     * @since 1.0.0
     */
    S readFromBinFile(I inputSource);
}
