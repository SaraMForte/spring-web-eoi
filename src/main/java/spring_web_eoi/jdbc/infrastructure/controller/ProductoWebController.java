package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_web_eoi.jdbc.application.ProductService;
import spring_web_eoi.jdbc.domain.Product;
import spring_web_eoi.jdbc.infrastructure.controller.model.ProductoDTO;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductoWebController {

    ProductService productService;

    public ProductoWebController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/generic/product-all")
    public String genericProductoAll(Model model) {
        List<ProductoDTO> productos = productService.findAllProducts()
                .stream()
                .map(ProductoDTO::fromDomain)
                .toList();

        model.addAttribute("table", new GenericTableGenerator<>(productos, ProductoDTO.class));
        return "index-generic";
    }

    @GetMapping("generic/product")
    public String genericProducto(@RequestParam(value = "id") String id, Model model) {
        Optional<Product> productFind = productService.findProductById(id);
        if (productFind.isEmpty()) {
            return "redirect:/generic/product-all";
        }

        List<ProductoDTO> productos = new ArrayList<>();
        productos.add(ProductoDTO.fromDomain(productFind.get()));
        model.addAttribute("table", new GenericTableGenerator<>(productos, ProductoDTO.class));
        return "index-generic";
    }

    @GetMapping("/form/product")
    public String formProducto(Model model) {
        model.addAttribute("product", new ProductoDTO());
        model.addAttribute("id", null);
        return "form-product";
    }

    @GetMapping("/form/product/{id}")
    public String formProducto(@PathVariable("id") String id, Model model) {
        Optional<Product> productFind = productService.findProductById(id);
        if (productFind.isEmpty()) {
            model.addAttribute("product", new ProductoDTO());
            model.addAttribute("id", id);
            return "form-product";
        }

        ProductoDTO producto = ProductoDTO.fromDomain(productFind.get());
        model.addAttribute("product", producto);
        model.addAttribute("id", id);
        return "form-product";
    }

    @PostMapping("/form/product/{id}")
    public String updateProduct(
            @ModelAttribute("product") ProductoDTO producto,
            @PathVariable("id") String id,
            RedirectAttributes redirectAttributes
    ) {
        productService.updateProduct(producto.toDomain());

        redirectAttributes.addFlashAttribute("successMessage", "Producto actualizado con exito -> ");
        redirectAttributes.addFlashAttribute("successLink", "/generic/product?id=" + producto.getCodigoProducto());
        return "redirect:/form/product/" + id;
    }

    @PostMapping("/form/product")
    public String saveProduct(
            @ModelAttribute("product") ProductoDTO producto,
            RedirectAttributes redirectAttributes
    ) {
        productService.saveProduct(producto.toDomain());

        Optional<Product> productFind = productService.findProductById(producto.getCodigoProducto());
        if (productFind.isEmpty()) {
            return "redirect:/generic/product-all";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Producto guardado con exito -> ");
        redirectAttributes.addFlashAttribute("successLink", "/generic/product?id=" + producto.getCodigoProducto());
        return "redirect:/form/product/" + producto.getCodigoProducto();
    }
}