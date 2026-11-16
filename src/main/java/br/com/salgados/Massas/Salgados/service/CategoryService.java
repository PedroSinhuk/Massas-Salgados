package br.com.salgados.Massas.Salgados.service;

import br.com.salgados.Massas.Salgados.repository.CategoryRepository;
import br.com.salgados.Massas.Salgados.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public Optional<Category> findyById(Long id){
        return categoryRepository.findById(id);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


}
