package eu.oberon.oss.serz.cli;


import eu.oberon.oss.tools.i18n.InternalMessageBundleResolver;
import eu.oberon.oss.tools.i18n.MessageBundleResolver;
import eu.oberon.oss.tools.i18n.retriever.MessageDetailProvider;
import eu.oberon.oss.tools.i18n.retriever.MessageProcessor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;

import static org.apache.logging.log4j.Level.INFO;

/**
 * An enumeration of predefined message keys for use in logging and exception handling,
 * backed by resources from a resource bundle. Each message is associated with a key,
 * retrieved from a resource bundle, and optionally enhanced with logging levels or exception types.
 * This enum implements the {@code IMessagesHelper} interface for unified logging and exception creation.
 * <p>
 * Each message can be used for either
 * <ul>
 * <li>Logging a formatted message at a specific log level.</li>
 * <li>Creating an exception with a formatted message and a defined exception type.</li>
 * <li>Provide messages 'as-is', useful for static text etc.</li>
 * </ul>
 * <p>
 * Each instance of {@code Messages} provides access to a corresponding {@code MessagesHelper}
 * instance, which handles the actual implementation of messaging functionality.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@Log4j2
@Getter
public enum Messages implements MessageDetailProvider<Level, Messages, String> {

    CLI_REQUEST_INFO("serz.utility.cli.processing.request.info", INFO),
    CLI_RESPONSE_INFO("serz.utility.cli.processing.response.info", INFO);

    private final String messageKey;
    private @Nullable Level logLevel;
    private @Nullable Class<? extends Exception> exceptionClass;

    Messages(String messageKey) {
        this.messageKey = messageKey;
    }

    Messages(String messageKey, @Nullable Level logLevel) {
        this.messageKey = messageKey;
        this.logLevel = logLevel;
    }

    Messages(String messageKey, @Nullable Class<? extends Exception> exceptionClass) {
        this.messageKey = messageKey;
        this.exceptionClass = exceptionClass;
    }

    private static final MessageProcessor<Messages> processor;

    /**
     * Returns a message processor to create formatted messages, exception or log messages.
     *
     * @return The message processor
     *
     * @since 1.0.0
     */
    public static MessageProcessor<Messages> getMessageProcessor() {
        return processor;
    }

    static {
        MessageBundleResolver resolver = new InternalMessageBundleResolver("messages/serz-resource-bundle");
        processor = new MessageProcessor<>(resolver);
    }
}
