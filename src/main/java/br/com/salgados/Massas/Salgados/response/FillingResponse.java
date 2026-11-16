package br.com.salgados.Massas.Salgados.response;

import lombok.Builder;

@Builder
public record FillingResponse(Long id, String name) {
}
