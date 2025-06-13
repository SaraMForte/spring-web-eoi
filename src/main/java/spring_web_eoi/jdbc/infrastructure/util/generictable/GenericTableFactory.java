package spring_web_eoi.jdbc.infrastructure.util.generictable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTableFactory {

    private GenericTableFactory() {
    }

    public static <T> GenericTable create(List<T> entities, Class<T> entityType) {
        try {
            List<String> columns = generateColumns(entityType);
            List<List<String>> rows = generateRows(entities, entityType);
            return new GenericTable(columns, rows);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> List<String> generateColumns(Class<T> entityType) {
        return (Arrays.stream(entityType.getDeclaredFields())
                .map(Field::getName)
                .toList()
        );
    }

    private static <T> List<List<String>> generateRows(List<T> entities, Class<T> entityType) throws IllegalAccessException,
            InvocationTargetException {
        List<List<String>> rowsList = new ArrayList<>();
        for (T entity : entities) {
            if (entityType.isRecord()) {
                rowsList.add(generateRowByRecord(entity, entityType));
            } else {
                rowsList.add(generateRow(entity, entityType));
            }
        }
        return rowsList;
    }

    //TODO - Cambiar el desarrollo para evitar cambiar la visibilidad de los atributos de la clase
    private static <T> List<String> generateRow(T entity, Class<T> entityType) throws IllegalAccessException {
        List<String> row = new ArrayList<>();
        for (Field field : entityType.getDeclaredFields()) {
            field.setAccessible(true);
            row.add(String.valueOf(field.get(entity)));
        }
        return row;
    }

    private static <T> List<String> generateRowByRecord(T entity, Class<T> entityType) throws IllegalAccessException,
            InvocationTargetException {
        List<String> row = new ArrayList<>();
        for (RecordComponent component : entityType.getRecordComponents()) {
            Method accessor = component.getAccessor();
            Object value = accessor.invoke(entity);
            row.add(String.valueOf(value));
        }
        return row;
    }
}