package br.com.salgados.Massas.Salgados.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(Long id,
                              String name,
                              String description,
                              BigDecimal price,
                              Long categoryId,
                              Long fillingId
)
{
}


