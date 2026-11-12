package br.com.salgados.Massas.Salgados.controller;

import br.com.salgados.Massas.Salgados.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/massal/category")
public class CategoryController {

    private CategoryService categoryService;

    public List<Category> getallCategory(){

    }
}

