package br.com.salgados.Massas.Salgados.response;

import lombok.Builder;

@Builder
public record CategoryResponse (Long id, String name) {
}
