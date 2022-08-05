package sarinsa.megammo.util;

import sarinsa.megammo.core.MegaMMO;

import java.util.logging.Level;

/**
 * Logger interface used to easily log information from where ever with sufficient context.
 */
public interface ILogger {

    /**
     * @return a String representing where we are logging from;
     *         usually something similar to the name of the class
     *         we are logging from.
     */
    String logPrefix();

    default void log(Level level, String message) {
        MegaMMO.INSTANCE.getLogger().log(level, "[" + logPrefix() + "] " + message);
    }

    default void info(String message) {
        log(Level.INFO, message);
    }

    default void warn(String warning) {
        log(Level.WARNING, warning);
    }

    default void error(String error) {
        log(Level.SEVERE, error);
    }
}
