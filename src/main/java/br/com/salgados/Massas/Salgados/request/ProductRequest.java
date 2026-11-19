package br.com.salgados.Massas.Salgados.request;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequest(
        String name,
        String description,
        BigDecimal price,
        Long categoryId,
        Long fillingId
) {

}

