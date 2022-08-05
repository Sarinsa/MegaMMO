package sarinsa.megammo.util;

import sarinsa.megammo.core.MegaMMO;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

/**
 * Helper class for accessing
 * private and final fields
 * in mcMMO and whatnot.
 */
public class ReflectionHelper {

    private static final String logPrefix = "[Reflection Helper] ";


    /**
     * Attempts to set the value of the target field
     * with the specified value object.<br>
     * <br>
     * @return true if the target was replaced.
     */
    public static boolean set(Object toAccess, String targetField, Object value) {
        try {
            Field field = toAccess.getClass().getDeclaredField(targetField);
            boolean changedAccess = field.trySetAccessible();

            if (!changedAccess) {
                MegaMMO.INSTANCE.getLogger().severe(logPrefix + "Failed to modify field access. Field: \"" + targetField + "\", " + "Target object: \"" + toAccess + "\"");
                return false;
            }
            else {
                try {
                    field.set(toAccess, value);
                    return true;
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Attempts to fetch the value of the target field.<br>
     * <br>
     * @return the target field's value. Returns null if
     *         something goes wrong.
     */
    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> T get(Object toAccess, String targetField) {
        try {
            Field field = toAccess.getClass().getDeclaredField(targetField);
            boolean changedAccess = field.trySetAccessible();

            if (!changedAccess) {
                MegaMMO.INSTANCE.getLogger().severe(logPrefix + "Failed to modify field access. Field: \"" + targetField + "\", " + "Target object: \"" + toAccess + "\"");
                return null;
            }
            else {
                try {
                    return (T) field.get(toAccess);
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Attempts to fetch the value of the target field. Target must be static.<br>
     * <br>
     * @return the target field's value. Returns null if
     *         something goes wrong.
     */
    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> T getStatic(Class<?> targetClass, String targetField) {
        try {
            Field field = targetClass.getDeclaredField(targetField);
            boolean changedAccess = field.trySetAccessible();

            if (!changedAccess) {
                MegaMMO.INSTANCE.getLogger().severe(logPrefix + "Failed to modify static field access. Field: \"" + targetField + "\", " + "Target class: \"" + targetClass + "\"");
                return null;
            }
            else {
                try {
                    return (T) field.get(null);
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }
}
