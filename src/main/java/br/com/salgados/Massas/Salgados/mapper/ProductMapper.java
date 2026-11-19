package br.com.salgados.Massas.Salgados.mapper;

import br.com.salgados.Massas.Salgados.entity.Category;
import br.com.salgados.Massas.Salgados.entity.Filling;
import br.com.salgados.Massas.Salgados.entity.Product;
import br.com.salgados.Massas.Salgados.request.ProductRequest;
import br.com.salgados.Massas.Salgados.response.ProductResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

    public static Product toProduct(ProductRequest request) {
        Category category = request.categoryId() == null
                ? null
                : Category.builder().id(request.categoryId()).build();

        Filling filling = request.fillingId() == null
                ? null
                : Filling.builder().id(request.fillingId()).build();

        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .category(category)
                .filling(filling)
                .build();
    }

    public static ProductResponse toProductResponse(Product product) {
        Category category = product.getCategory();
        Filling filling = product.getFilling();

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(category == null ? null : category.getId())
                .fillingId(filling == null ? null : filling.getId())
                .build();
    }
}