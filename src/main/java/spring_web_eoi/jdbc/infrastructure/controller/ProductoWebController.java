package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_web_eoi.jdbc.application.ProductService;
import spring_web_eoi.jdbc.application.exception.DataDeleteException;
import spring_web_eoi.jdbc.infrastructure.controller.model.ProductoDTO;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableFactory;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductoWebController {

    ProductService productService;

    public ProductoWebController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("form/product")
    public String showFormProduct(
            Model model,
            @RequestParam(value = "id", required = false) Optional<String> id
    ) {
        ProductoDTO producto = new ProductoDTO();

        if (id.isPresent()) {
            producto = productService.findById(id.get())
                    .map(ProductoDTO::fromDomain)
                    .orElseThrow();
        }

        model.addAttribute("product", producto);
        model.addAttribute("id", id);
        return "form-product";
    }

    @PostMapping("form/product")
    public String processFormProduct(
            @RequestParam(value = "id", required = false) Optional<Integer> id,
            @ModelAttribute("product") ProductoDTO producto,
            RedirectAttributes redirectAttributes
    ) {
        if (id.isPresent()) {
            productService.update(producto.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Producto actualizado con exito -> ");
        } else {
            productService.save(producto.toDomain());
            redirectAttributes.addFlashAttribute("successMessage", "Producto creado con exito -> ");
        }

        redirectAttributes.addFlashAttribute("id", producto.getCodigoProducto());
        redirectAttributes.addFlashAttribute("successLink", "/product?id=" + producto.getCodigoProducto());
        return "redirect:/form/product";
    }

    @GetMapping("product")
    public String showProducts(
            Model model,
            @RequestParam(value = "id", required = false) Optional<String> id
    ) {
        List<ProductoDTO> productos;

        if (id.isPresent()) {
            productos = productService.findById(id.get())
                    .map(ProductoDTO::fromDomain)
                    .stream()
                    .toList();
        } else {
            productos = productService.findAll()
                    .stream()
                    .map(ProductoDTO::fromDomain)
                    .toList();
        }

        model.addAttribute("table", GenericTableFactory.create(productos, ProductoDTO.class));
        model.addAttribute("formUrl", "/form/product");
        model.addAttribute("deleteUrl", "product");
        return "index-generic";
    }

    @DeleteMapping("product")
    public ResponseEntity<String> deleteProduct(
            @RequestParam(value = "id", required = true) String id
    ) {
        try {
            productService.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (DataDeleteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}