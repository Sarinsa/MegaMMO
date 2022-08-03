package sarinsa.megammo.util;

import sarinsa.megammo.core.MegaMMO;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class ReflectionHelper {

    private static final String logPrefix = "[" + ReflectionHelper.class.getSimpleName() + "] ";


    public static void set(Object toAccess, String targetField, Object value) {
        try {
            Field field = toAccess.getClass().getDeclaredField(targetField);
            boolean changedAccess = field.trySetAccessible();

            if (!changedAccess) {
                MegaMMO.INSTANCE.getLogger().severe(logPrefix + "Failed to modify field access. Field: \"" + targetField + "\", " + "Target object: \"" + toAccess + "\"");
            }
            else {
                try {
                    field.set(toAccess, value);
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

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

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T> T getStatic(Class<T> targetClass, String targetField) {
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
