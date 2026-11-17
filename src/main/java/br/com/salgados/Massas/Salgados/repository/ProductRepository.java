package br.com.salgados.Massas.Salgados.repository;

import br.com.salgados.Massas.Salgados.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
