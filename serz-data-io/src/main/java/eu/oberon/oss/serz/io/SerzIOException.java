package eu.oberon.oss.serz.io;

/**
 * Generic Exception that can be thrown from any class in this package.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class SerzIOException extends RuntimeException {

    /**
     * Exception with only a message.
     *
     * @param message Message details for the exception
     *
     * @since 1.0.0
     */
    public SerzIOException(String message) {
        super(message);
    }

    /**
     * Exception with a message and cause.
     *
     * @param message Message details for the exception
     * @param cause   The Throwable that caused this exception to be raised.
     *
     * @since 1.0.0
     */
    public SerzIOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception with message and cause and settings for suppression and/or writable stack options.
     *
     * @param message            Message details for the exception
     * @param cause              The Throwable that caused this exception to be raised.
     * @param enableSuppression  Whether suppression is enabled or disabled
     * @param writableStackTrace Whether the stack trace should be writable
     *
     * @since 1.0.0
     */
    public SerzIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
