package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring_web_eoi.jdbc.application.OfficeService;
import spring_web_eoi.jdbc.infrastructure.controller.model.OficinaBasicAddressDTO;
import spring_web_eoi.jdbc.infrastructure.controller.model.OficinaDTO;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbc.OficinaRepository;
import spring_web_eoi.jdbc.infrastructure.util.generictable.GenericTableFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OficinaWebController {

    JdbcTemplate jdbcTemplate;
    OfficeService officeService;

    public OficinaWebController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.officeService = new OfficeService(new OficinaRepository(jdbcTemplate));
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/office-basic")
    public String officeBasic(Model model) {
        List<OficinaBasicAddressDTO> oficinaBasicAddress = officeService
                .findBasicAddress()
                .stream()
                .map(OficinaBasicAddressDTO::fromOffice)
                .toList();

        model.addAttribute("oficinaBasicAddress", oficinaBasicAddress);
        return "index";
    }

    @GetMapping("/office-json-by-city")
    @ResponseBody
    public Map<String, List<OficinaDTO>> officeBasicByCity() {
        return officeService.findBasicAddress()
                .stream()
                .map(OficinaDTO::fromOffice)
                .collect(Collectors.groupingBy(OficinaDTO::pais));
    }

    @GetMapping("/office-basic-by-city")
    public String officeBasicByCity(Model model) {
        Map<String, List<OficinaDTO>> officeBasicByCity = officeService.findBasicAddress()
                .stream()
                .map(OficinaDTO::fromOffice)
                .collect(Collectors.groupingBy(OficinaDTO::pais));

        model.addAttribute("oficinaBasicByCity", officeBasicByCity);
        return "index2";
    }

    @GetMapping("office-json")
    @ResponseBody
    public List<OficinaBasicAddressDTO> officeJson() {
        return officeService
                .findBasicAddress()
                .stream()
                .map(OficinaBasicAddressDTO::fromOffice)
                .toList();
    }

    @GetMapping("/generic")
    public String genericOficina(Model model) {
        List<OficinaDTO> oficinas = officeService.findBasicAddress()
                .stream()
                .map(OficinaDTO::fromOffice)
                .toList();

        model.addAttribute("table", GenericTableFactory.create(oficinas, OficinaDTO.class));
        return "index-generic";
    }
}
