package org.acme.repository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.ProductEntity;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped// quando fazer o start da aplicaçao o quarkus saber que precisa gerenciar o funcionamento dessas classes
public class ProductRepository  implements PanacheRepository<ProductEntity> {
}
