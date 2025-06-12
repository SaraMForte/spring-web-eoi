package spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_web_eoi.jdbc.application.ProductRepository;
import spring_web_eoi.jdbc.domain.Product;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.model.ProductoJDBC;

import java.util.List;

@Repository
public interface JDBCProductRepository extends
        ListCrudRepository<ProductoJDBC, String>,
        ProductRepository
{

    @Override
    @Query("""
            SELECT
                codigo_producto AS "product_code",
                nombre AS "name",
                gama AS "product_line",
                dimensiones AS "dimensions",
                proveedor AS "supplier",
                descripcion AS "description",
                cantidad_en_stock AS "quantity_in_stock",
                precio_venta AS "sale_price",
                precio_proveedor AS "supplier_price"
            FROM producto
            WHERE
                activo = true
            """)
    List<Product> findAllProducts();

    @Override
    @Query("""
            SELECT
                codigo_producto AS "product_code",
                nombre AS "name",
                gama AS "product_line",
                dimensiones AS "dimensions",
                proveedor AS "supplier",
                descripcion AS "description",
                cantidad_en_stock AS "quantity_in_stock",
                precio_venta AS "sale_price",
                precio_proveedor AS "supplier_price"
            FROM producto
            WHERE
                codigo_producto = :id
            """)
    Product findProductById(@Param("id") String id);

    @Override
    @Modifying
    @Query("""
               INSERT INTO producto
                   (
                    codigo_producto,
                    nombre,
                    gama,
                    dimensiones,
                    proveedor,
                    descripcion,
                    cantidad_en_stock,
                    precio_venta,
                    precio_proveedor
                    )
               VALUES
                   (
                    :#{#product.productCode},
                    :#{#product.name},
                    :#{#product.productLine},
                    :#{#product.dimensions},
                    :#{#product.supplier},
                    :#{#product.description},
                    :#{#product.quantityInStock},
                    :#{#product.salePrice},
                    :#{#product.supplierPrice}
                    )
            """)
    void saveProduct(@Param("product") Product product);

    @Override
    @Modifying
    @Query("""
            UPDATE producto
            SET
                nombre = :#{#product.name},
                gama = :#{#product.productLine},
                dimensiones = :#{#product.dimensions},
                proveedor = :#{#product.supplier},
                descripcion = :#{#product.description},
                cantidad_en_stock = :#{#product.quantityInStock},
                precio_venta = :#{#product.salePrice},
                precio_proveedor = :#{#product.supplierPrice}
            WHERE
                codigo_producto = :#{#product.productCode}
            """)
    void updateProduct(Product product);

    @Override
    @Modifying
    @Query("""
            UPDATE producto
            SET
                activo = false
            WHERE
                codigo_producto = :id
            """)
    void deleteProduct(@Param("id") String id);
}
