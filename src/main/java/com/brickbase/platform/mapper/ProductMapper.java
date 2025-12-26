package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.requestDTO.ProductRequestDTO;
import com.brickbase.platform.dto.responseDTO.ProductResponseDTO;
import com.brickbase.platform.model.Category;
import com.brickbase.platform.model.Product;
import com.brickbase.platform.model.User;
import org.mapstruct.*;

@Mapper(config = GlobalMapperConfig.class)
public interface ProductMapper {

    @Mapping(target = "category", source = "category")
    @Mapping(target = "worker", source = "worker")

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "price", source = "dto.price")
    @Mapping(target = "location", source = "dto.location")

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product toEntity(ProductRequestDTO dto, Category category, User worker);

    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "workerId", source = "worker.id")
    ProductResponseDTO toResponse(Product product);
}
