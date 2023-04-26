package ma.codipster.productservice.mappers;


import ma.codipster.productservice.dto.product.ProductResponse;
import ma.codipster.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    ProductResponse productToProductResponse(Product product);

    List<ProductResponse> productToProductResponse(List<Product> products);
}
