package spring_web_eoi.jdbc.infrastructure.util.generictable;

import java.util.List;

public record GenericTable(List<String> columns, List<List<String>> rows) {
}
