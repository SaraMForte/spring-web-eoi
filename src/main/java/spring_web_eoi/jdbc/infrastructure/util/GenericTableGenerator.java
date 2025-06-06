package spring_web_eoi.jdbc.infrastructure.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTableGenerator<T> {
    private final List<String> columns;
    private final List<List<String>> rows;

    public GenericTableGenerator(List<T> entities, Class<T> entityType) {
        try {
            columns = generateColumns(entityType);
            rows = generateRows(entities, entityType);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> generateColumns(Class<T> entityType) {
        return (Arrays.stream(entityType.getDeclaredFields())
                .map(Field::getName)
                .toList()
        );
    }

    private List<List<String>> generateRows(List<T> entities, Class<T> entityType) throws IllegalAccessException, InvocationTargetException {
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
    private List<String> generateRow(T entity, Class<T> entityType) throws IllegalAccessException {
        List<String> row = new ArrayList<>();
        for (Field field : entityType.getDeclaredFields()) {
            field.setAccessible(true);
            row.add(String.valueOf(field.get(entity)));
        }
        return row;
    }

    private List<String> generateRowByRecord(T entity, Class<T> entityType) throws IllegalAccessException, InvocationTargetException {
        List<String> row = new ArrayList<>();
        for (RecordComponent component : entityType.getRecordComponents()) {
            Method accessor = component.getAccessor();
            Object value = accessor.invoke(entity);
            row.add(String.valueOf(value));
        }
        return row;
    }

    public List<String> columns() {
        return columns;
    }

    public List<List<String>> rows() {
        return rows;
    }
}