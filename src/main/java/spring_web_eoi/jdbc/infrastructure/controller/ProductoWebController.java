package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
            return "redirect:/generic/product-all";
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
            Model model
    ) {
        productService.updateProduct(producto.toDomain());

        List<ProductoDTO> productos = new ArrayList<>();
        productos.add(producto);
        model.addAttribute("table", new GenericTableGenerator<>(productos, ProductoDTO.class));
        return "index-generic";
    }

    @PostMapping("/form/product")
    public String saveProduct(@ModelAttribute("form") ProductoDTO producto, Model model) {
        productService.saveProduct(producto.toDomain());

        Optional<Product> productFind = productService.findProductById(producto.getCodigoProducto());
        if (productFind.isEmpty()) {
            return "redirect:/generic/product-all";
        }

        ProductoDTO findProduct = ProductoDTO.fromDomain(productFind.get());
        List<ProductoDTO> productoDTO = new ArrayList<>();
        productoDTO.add(findProduct);

        model.addAttribute("table", new GenericTableGenerator<>(productoDTO, ProductoDTO.class));
        return "index-generic";
    }
}
