package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring_web_eoi.jdbc.application.ProductService;
import spring_web_eoi.jdbc.infrastructure.controller.model.ProductoDTO;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableGenerator;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoWebController {

    ProductService productService;

    public ProductoWebController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/generic/product")
    public String genericProducto(Model model) {
        List<ProductoDTO> productos = productService.findAllProducts()
                .stream()
                .map(ProductoDTO::fromDomain)
                .toList();

        model.addAttribute("table", new GenericTableGenerator<>(productos, ProductoDTO.class));
        return "index-generic";
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
        ProductoDTO producto = ProductoDTO.fromDomain(productService.findProductById(id));
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

        ProductoDTO findProduct = ProductoDTO.fromDomain(productService.findProductById(producto.getCodigoProducto()));
        List<ProductoDTO> productoDTO = new ArrayList<>();
        productoDTO.add(findProduct);

        model.addAttribute("table", new GenericTableGenerator<>(productoDTO, ProductoDTO.class));
        return "index-generic";
    }
}
