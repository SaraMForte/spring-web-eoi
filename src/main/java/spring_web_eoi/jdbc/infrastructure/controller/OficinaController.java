package spring_web_eoi.jdbc.infrastructure.controller;

import spring_web_eoi.jdbc.application.OfficeService;
import spring_web_eoi.jdbc.domain.Office;
import spring_web_eoi.jdbc.infrastructure.controller.model.OficinaBasicAddressDTO;

import java.util.List;

public class OficinaController {

    OfficeService officeService;

    public OficinaController(OfficeService officeService) {
        this.officeService = officeService;
    }

    public void printBasicAddress() {
        List<Office> offices = officeService.findBasicAddress();
        offices.stream()
                .map(OficinaBasicAddressDTO::fromOffice)
                .forEach(System.out::println);
    }
}
