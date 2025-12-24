package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.requestDTO.ProductRequestDTO;
import com.brickbase.platform.dto.responseDTO.ProductResponseDTO;
import com.brickbase.platform.model.Category;
import com.brickbase.platform.model.Product;
import com.brickbase.platform.model.User;
import org.mapstruct.*;

@Mapper(config = MapperConfig.class)
public interface ProductMapper {

    @Mapping(target = "category", source = "category")
    @Mapping(target = "worker", source = "worker")
    Product toEntity(ProductRequestDTO dto, Category category, User worker);

    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "workerId", source = "worker.id")
    ProductResponseDTO toResponse(Product product);
}
