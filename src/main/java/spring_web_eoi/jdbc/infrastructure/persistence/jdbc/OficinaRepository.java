package spring_web_eoi.jdbc.infrastructure.persistence.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import spring_web_eoi.jdbc.application.OfficeRepository;
import spring_web_eoi.jdbc.domain.Office;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbc.model.OficinaTable;

import java.util.List;

public class OficinaRepository implements OfficeRepository {

    private JdbcTemplate jdbcTemplate;

    public OficinaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Office> findBasicAddress() {
        String sqlQuery = """
                SELECT
                    codigo_oficina,
                    ciudad,
                    pais,
                    codigo_postal,
                    region,
                    telefono,
                    linea_direccion1,
                    linea_direccion2
                FROM oficina
                """;

        List<OficinaTable> oficinaTableBasicAddresses = jdbcTemplate.query(sqlQuery, new OficinaTable());
        return oficinaTableBasicAddresses.stream()
                .map(OficinaTable::toOffice)
                .toList();
    }
}
