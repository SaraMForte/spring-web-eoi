package spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import spring_web_eoi.jdbc.application.ProductLineRepository;
import spring_web_eoi.jdbc.domain.ProductLine;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.model.GamaProductoJDBC;

import java.util.List;
import java.util.Optional;

@Repository
public interface JDBCProductLineRepository extends ListCrudRepository<GamaProductoJDBC, String>, ProductLineRepository {

    @Override
    default void deleteProductLine(String id) {
        deleteById(id);
    }

    @Override
    default void updateProductLine(ProductLine productLine) {
        save(GamaProductoJDBC.fromDomain(productLine));
    }

    @Override
    @Modifying
    @Query("""
            INSERT INTO gama_producto
                (
                gama,
                descripcion_texto,
                descripcion_html,
                imagen
                 )
            VALUES
                (
                 :#{#productLine.line},
                 :#{#productLine.textDescription},
                 :#{#productLine.htmlDescription},
                 :#{#productLine.image}
                  )
            """)
    void saveProductLine(ProductLine productLine);

    @Override
    default Optional<ProductLine> findProductLinetById(String id) {
        return findById(id).map(GamaProductoJDBC::toDomain);
    }

    @Override
    default List<ProductLine> findAllProductLines() {
        return findAll().stream()
                .map(GamaProductoJDBC::toDomain)
                .toList();
    }
}
