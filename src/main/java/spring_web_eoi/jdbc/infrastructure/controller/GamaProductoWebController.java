package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_web_eoi.jdbc.application.ProductLineService;
import spring_web_eoi.jdbc.infrastructure.controller.model.GamaProductoDTO;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableFactory;

import java.util.List;
import java.util.Optional;

@Controller
public class GamaProductoWebController {

    private ProductLineService productLineService;

    public GamaProductoWebController(ProductLineService productLineService) {
        this.productLineService = productLineService;
    }

    @GetMapping("form/product-line")
    public String showFormPedido(
            Model model,
            @RequestParam(value = "id", required = false) Optional<String> id
    ) {
        GamaProductoDTO gamaProducto = new GamaProductoDTO();

        if (id.isPresent()) {
            gamaProducto = productLineService.findById(id.get())
                    .map(GamaProductoDTO::fromDomain)
                    .orElseThrow();
        }

        model.addAttribute("productLine", gamaProducto);
        model.addAttribute("id", id);
        return "form-product-line";
    }

    @PostMapping("form/product-line")
    public String processFormPedido(
            @RequestParam(value = "id", required = false) Optional<String> id,
            @ModelAttribute("productLine") GamaProductoDTO gamaProducto,
            RedirectAttributes redirectAttributes
    ) {
        if (id.isPresent()) {
            productLineService.update(gamaProducto.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Gama producto actualizado con exito -> ");
        } else {
            productLineService.save(gamaProducto.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Gama producto creado con exito -> ");
        }

        redirectAttributes.addFlashAttribute("id", gamaProducto.getGama());
        redirectAttributes.addFlashAttribute("successLink", "/product-line?id=" + gamaProducto.getGama());
        return "redirect:/form/product-line";
    }

    @GetMapping("product-line")
    public String showOrdes(
            Model model,
            @RequestParam(value = "id", required = false) Optional<String> id
    ) {
        List<GamaProductoDTO> pedidos;

        if (id.isPresent()) {
            pedidos = productLineService.findById(id.get())
                    .map(GamaProductoDTO::fromDomain)
                    .stream()
                    .toList();
        } else {
            pedidos = productLineService.findAll()
                    .stream()
                    .map(GamaProductoDTO::fromDomain)
                    .toList();
        }

        model.addAttribute("table", GenericTableFactory.create(pedidos, GamaProductoDTO.class));
        model.addAttribute("formUrl", "/form/product-line");
        model.addAttribute("deleteUrl", "product-line");
        return "index-generic";
    }

    @DeleteMapping("product-line")
    public ResponseEntity<String> deleteOrder(
            @RequestParam(value = "id", required = true) String id
    ) {
        productLineService.deleteById(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
}
