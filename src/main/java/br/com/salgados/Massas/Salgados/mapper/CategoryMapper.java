package br.com.salgados.Massas.Salgados.mapper;

import br.com.salgados.Massas.Salgados.entity.Category;
import br.com.salgados.Massas.Salgados.request.CategoryRequest;
import br.com.salgados.Massas.Salgados.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.name())
                .build();
    }
    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();

    }
}
