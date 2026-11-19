package br.com.salgados.Massas.Salgados.service;

import br.com.salgados.Massas.Salgados.entity.Category;
import br.com.salgados.Massas.Salgados.entity.Filling;
import br.com.salgados.Massas.Salgados.entity.Product;
import br.com.salgados.Massas.Salgados.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final FillingService fillingService;

    public Product save(Product product) {
        product.setCategory(findCategory(product.getCategory()));
        product.setFilling(findFilling(product.getFilling()));
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    private Category findCategory(Category category) {
        if (category == null) {
            return null;
        }

        return categoryService.findyById(category.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Categoria não encontrada"));
    }

    private Filling findFilling(Filling filling) {
        if (filling == null) {
            return null;
        }

        return fillingService.findyById(filling.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Recheio não encontrado"));
    }


}