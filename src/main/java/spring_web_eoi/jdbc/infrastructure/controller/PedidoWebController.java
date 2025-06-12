package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_web_eoi.jdbc.application.OrderService;
import spring_web_eoi.jdbc.infrastructure.controller.model.PedidoDTO;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableFactory;

import java.util.List;
import java.util.Optional;

@Controller
public class PedidoWebController {

    OrderService orderService;

    public PedidoWebController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("form/order")
    public String showFormPedido(
            Model model,
            @RequestParam(value = "id", required = false) Optional<Integer> id
    ) {
        PedidoDTO pedidoDTO = new PedidoDTO();

        if (id.isPresent()) {
            pedidoDTO = orderService.findById(id.get())
                    .map(PedidoDTO::fromDomain)
                    .orElseThrow();
        }

        model.addAttribute("order", pedidoDTO);
        model.addAttribute("id", id);
        return "form-order";
    }

    @PostMapping("form/order")
    public String processFormPedido(
            @RequestParam(value = "id", required = false) Optional<Integer> id,
            @ModelAttribute("order") PedidoDTO pedidoDTO,
            RedirectAttributes redirectAttributes
    ) {
        if (id.isPresent()) {
            orderService.update(pedidoDTO.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Pedido actualizado con exito -> ");
        } else {
            orderService.save(pedidoDTO.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Pedido creado con exito -> ");
        }

        redirectAttributes.addFlashAttribute("id", pedidoDTO.getCodigoPedido());
        redirectAttributes.addFlashAttribute("successLink", "/order?id=" + pedidoDTO.getCodigoPedido());
        return "redirect:/form/order";
    }

    @GetMapping("order")
    public String showOrdes(
            Model model,
            @RequestParam(value = "id", required = false) Optional<Integer> id
    ) {
        List<PedidoDTO> pedidos;

        if (id.isPresent()) {
            pedidos = orderService.findById(id.get())
                    .map(PedidoDTO::fromDomain)
                    .stream()
                    .toList();
        } else {
            pedidos = orderService.findAll()
                    .stream()
                    .map(PedidoDTO::fromDomain)
                    .toList();
        }

        model.addAttribute("table", GenericTableFactory.create(pedidos, PedidoDTO.class));
        model.addAttribute("formUrl", "/form/order");
        model.addAttribute("deleteUrl", "order");
        return "index-generic";
    }

    @DeleteMapping("order")
    public ResponseEntity<String> deleteOrder(
            @RequestParam(value = "id", required = true) int id
    ) {
        orderService.deleteById(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
}
