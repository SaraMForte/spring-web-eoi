package spring_web_eoi.jdbc.infrastructure.util;

import java.util.List;

public class GenericTable<T> {
    private final List<String> columns;
    private final List<List<String>> rows;

    public GenericTable(List<String> columns, List<List<String>> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public List<String> columns() {
        return columns;
    }

    public List<List<String>> rows() {
        return rows;
    }
}
