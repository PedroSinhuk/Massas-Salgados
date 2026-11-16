package br.com.salgados.Massas.Salgados.mapper;

import br.com.salgados.Massas.Salgados.entity.Category;
import br.com.salgados.Massas.Salgados.entity.Filling;
import br.com.salgados.Massas.Salgados.request.CategoryRequest;
import br.com.salgados.Massas.Salgados.request.FillingRequest;
import br.com.salgados.Massas.Salgados.response.CategoryResponse;
import br.com.salgados.Massas.Salgados.response.FillingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FillingMapper {

    public static Filling toFilling(FillingRequest request){
        return Filling.builder()
                .name(request.name())
                .build();
    }
    public static FillingResponse toFillingResponse(Filling filling){
        return FillingResponse
                .builder()
                .id(filling.getId())
                .name(filling.getName())
                .build();

    }
}

