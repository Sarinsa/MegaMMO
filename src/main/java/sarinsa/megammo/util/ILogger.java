package sarinsa.megammo.util;

import sarinsa.megammo.core.MegaMMO;

import java.util.logging.Level;

public interface ILogger {

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
