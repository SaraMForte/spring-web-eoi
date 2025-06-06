package spring_web_eoi.jdbc.infrastructure.controller.model;

import spring_web_eoi.jdbc.domain.Office;

public record OficinaDTO(
        String codigo_oficina,
        String ciudad,
        String pais,
        String region,
        String telefono,
        String linea_direccion1,
        String linea_direccion2
) {
    public static OficinaDTO fromOffice(Office office) {
        return new OficinaDTO(
                office.officeCode(),
                office.city(),
                office.country(),
                office.region(),
                office.phone(),
                office.addressLine1(),
                office.addressLine2()
        );
    }
}
