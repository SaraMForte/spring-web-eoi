package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_web_eoi.jdbc.application.ClientService;
import spring_web_eoi.jdbc.application.exception.DataDeleteException;
import spring_web_eoi.jdbc.infrastructure.controller.model.ClienteDTO;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableFactory;

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
            clienteDTO = clientService.findById(id.get())
                    .map(ClienteDTO::fromDomain)
                    .orElseThrow();
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
        List<ClienteDTO> clientes;

        if (id.isPresent()) {
            clientes = clientService.findById(id.get())
                    .map(ClienteDTO::fromDomain)
                    .stream()
                    .toList();
        } else {
            clientes = clientService.findAll()
                    .stream()
                    .map(ClienteDTO::fromDomain)
                    .toList();
        }

        model.addAttribute("table", GenericTableFactory.create(clientes, ClienteDTO.class));
        model.addAttribute("formUrl", "/form/client");
        model.addAttribute("deleteUrl", "client");
        return "index-generic";
    }

    @DeleteMapping("client")
    public ResponseEntity<String> deleteClient(
            @RequestParam(value = "id", required = true) int id
    ) {
        try {
            clientService.deleteById(id);
            return ResponseEntity.ok("Client deleted successfully");
        } catch (DataDeleteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
