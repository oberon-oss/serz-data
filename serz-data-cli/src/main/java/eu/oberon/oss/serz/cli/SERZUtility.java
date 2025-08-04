package eu.oberon.oss.serz.cli;


import eu.oberon.oss.serz.cli.util.picocli.VersionProvider;
import lombok.extern.log4j.Log4j2;
import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

import static eu.oberon.oss.serz.cli.SERZUtility.APPLICATION_NAME;


@CommandLine.Command(
        versionProvider = VersionProvider.class,
        name = "java -jar " + APPLICATION_NAME + ".jar",
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true
)
@Log4j2
public class SERZUtility implements Callable<Integer> {
    public static final String APPLICATION_NAME = "serz-cli";

    @CommandLine.Option(
            names = {"-f", "--input-file"}, required = true,
            descriptionKey = "serz.utility.cli.input-file"
    )
    private File file;


    @Override
    public Integer call() {

        try {
            return 0;
        } catch (Exception e) {
            LOGGER.fatal("Processing error occurred: {}", e.getMessage(), e);
            return 10;
        }
    }


    public static void main(String[] args) {
        System.getProperties().setProperty("picocli.usage.width", "AUTO");

        CommandLine commandLine = new CommandLine(new SERZUtility());

        System.exit(commandLine.execute(args));
    }

}
