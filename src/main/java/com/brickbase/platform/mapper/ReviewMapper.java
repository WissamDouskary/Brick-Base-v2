package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.requestDTO.ReviewRequestDTO;
import com.brickbase.platform.dto.responseDTO.ReviewResponseDTO;
import com.brickbase.platform.model.Product;
import com.brickbase.platform.model.Review;
import com.brickbase.platform.model.User;
import org.mapstruct.*;

@Mapper(config = MapperConfig.class)
public interface ReviewMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "worker", source = "worker")
    Review toEntity(ReviewRequestDTO dto, User author, Product product, User worker);

    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "workerId", source = "worker.id")
    ReviewResponseDTO toResponse(Review review);
}
