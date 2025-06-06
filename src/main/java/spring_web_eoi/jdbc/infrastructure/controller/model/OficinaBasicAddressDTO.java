package spring_web_eoi.jdbc.infrastructure.controller.model;

import spring_web_eoi.jdbc.domain.Office;

public record OficinaBasicAddressDTO(
        String codigo_oficina,
        String ciudad,
        String telefono,
        String linea_direccion1,
        String linea_direccion2
) {

    public static OficinaBasicAddressDTO fromOffice(Office office) {
        return new OficinaBasicAddressDTO(
                office.officeCode(),
                office.city(),
                office.phone(),
                office.addressLine1(),
                office.addressLine2()
        );
    }
}
