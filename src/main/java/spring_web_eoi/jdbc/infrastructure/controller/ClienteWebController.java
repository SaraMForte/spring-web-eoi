package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_web_eoi.jdbc.application.ClientService;
import spring_web_eoi.jdbc.infrastructure.controller.model.ClienteDTO;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClienteWebController {

    ClientService clientService;

    public ClienteWebController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("form/client")
    public String showFormCliente(
            Model model,
            @RequestParam(value = "id", required = false) Optional<Integer> id
    ) {
        ClienteDTO clienteDTO = new ClienteDTO();

        if (id.isPresent()) {
            clienteDTO = ClienteDTO.fromDomain(clientService.findById(id.get()));
        }

        model.addAttribute("client", clienteDTO);
        model.addAttribute("id", id);
        return "form-client";
    }

    @PostMapping("form/client")
    public String processFormCliente(
            @RequestParam(value = "id", required = false) Optional<Integer> id,
            @ModelAttribute("client") ClienteDTO clienteDTO,
            RedirectAttributes redirectAttributes
    ) {
        System.out.println(clienteDTO);
        if (id.isPresent()) {
            clientService.update(clienteDTO.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Cliente actualizado con exito -> ");
        } else {
            clientService.save(clienteDTO.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Cliente creado con exito -> ");
        }

        redirectAttributes.addFlashAttribute("id", clienteDTO.getCodigoCliente());
        redirectAttributes.addFlashAttribute("successLink", "/client?id=" + clienteDTO.getCodigoCliente());
        return "redirect:/form/client";
    }

    @GetMapping("client")
    public String showClients(
            Model model,
            @RequestParam(value = "id", required = false) Optional<Integer> id
    ) {
        List<ClienteDTO> clientes = new ArrayList<>();

        if (id.isPresent()) {
            ClienteDTO clienteDTO = ClienteDTO.fromDomain(clientService.findById(id.get()));
            clientes.add(clienteDTO);
        } else {
            clientes = clientService.findAll()
                    .stream()
                    .map(ClienteDTO::fromDomain)
                    .toList();
        }

        model.addAttribute("table", new GenericTableGenerator<>(clientes, ClienteDTO.class));
        model.addAttribute("formUrl", "/form/client");
        model.addAttribute("deleteUrl", "client");
        return "index-generic";
    }

    @DeleteMapping("client")
    public ResponseEntity<String> deleteClient(
            @RequestParam(value = "id", required = true) int id
    ) {
        clientService.deleteById(id);
        return ResponseEntity.ok("Client deleted successfully");
    }
}
