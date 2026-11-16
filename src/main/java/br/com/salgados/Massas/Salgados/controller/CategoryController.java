package br.com.salgados.Massas.Salgados.controller;

import br.com.salgados.Massas.Salgados.service.CategoryService;
import br.com.salgados.Massas.Salgados.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/massal/category")
@RequiredArgsConstructor //Anotaçao que faz construtores de forma automatica
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getallCategory(){
        return categoryService.findAll();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getByCategoryId(@PathVariable Long id){
        Optional<Category> optionalCategory = categoryService.findyById(id);
        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        }
            return null;
        }
        @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteCategory(id);
        }

    }




