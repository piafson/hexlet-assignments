package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Validator {
    public static List<String> validate(Object object) {
        List<String> result = new ArrayList<>();
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Arrays.stream(fields)
                .iterator()
                .forEachRemaining(s -> {
                    s.setAccessible(true);
                    try {
                        Object value = s.get(object);
                        if (s.isAnnotationPresent(NotNull.class) && value == null) {
                            result.add(s.getName());
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        Class<?> aClass = address.getClass();
        Field[] errors = aClass.getDeclaredFields();
        Arrays.stream(errors)
                .iterator()
                .forEachRemaining(s -> {
                    s.setAccessible(true);
                    try {
                        List<String> message = new ArrayList<>();
                        String name = s.getName();

                        if (s.isAnnotationPresent(NotNull.class)
                                && s.get(address) == null) {
                            message.add("can not be null");
                        }


                        if (s.isAnnotationPresent(MinLength.class)
                                && s.get(address).toString().length()
                                < s.getAnnotation(MinLength.class).minLength()) {
                            int minLength = s.getAnnotation(MinLength.class)
                                    .minLength();
                            message.add("length less than " + minLength);
                        }

                        if (!message.isEmpty()) {
                            result.put(name, message);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException();
                    }
                });
        return result;
    }
}

