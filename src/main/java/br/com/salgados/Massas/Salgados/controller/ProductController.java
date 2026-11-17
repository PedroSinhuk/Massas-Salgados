package br.com.salgados.Massas.Salgados.controller;


import br.com.salgados.Massas.Salgados.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/massal/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
}
