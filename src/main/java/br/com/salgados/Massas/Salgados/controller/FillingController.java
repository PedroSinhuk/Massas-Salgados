package br.com.salgados.Massas.Salgados.controller;

import br.com.salgados.Massas.Salgados.entity.Category;
import br.com.salgados.Massas.Salgados.entity.Filling;
import br.com.salgados.Massas.Salgados.mapper.CategoryMapper;
import br.com.salgados.Massas.Salgados.mapper.FillingMapper;
import br.com.salgados.Massas.Salgados.request.CategoryRequest;
import br.com.salgados.Massas.Salgados.request.FillingRequest;
import br.com.salgados.Massas.Salgados.response.CategoryResponse;
import br.com.salgados.Massas.Salgados.response.FillingResponse;
import br.com.salgados.Massas.Salgados.service.CategoryService;
import br.com.salgados.Massas.Salgados.service.FillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/massal/filling")
@RequiredArgsConstructor
public class FillingController {

    private final FillingService fillingService;

    @GetMapping()
    public ResponseEntity<List<FillingResponse>> getallFilling() {
        List<FillingResponse> fillings = fillingService.findAll()
                .stream()
                .map(FillingMapper::toFillingResponse)
                .toList();
        return ResponseEntity.ok(fillings);
    }

    @PostMapping
    public ResponseEntity<FillingResponse> saveFilling(@RequestBody FillingRequest request) {
        Filling savedFilling = fillingService.saveFilling(FillingMapper.toFilling(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(FillingMapper.toFillingResponse(savedFilling));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FillingResponse> getByFillingId(@PathVariable Long id) {
        return fillingService.findyById(id)
                .map(filling -> ResponseEntity.ok(FillingMapper.toFillingResponse(filling)))
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        fillingService.deleteFilling(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

