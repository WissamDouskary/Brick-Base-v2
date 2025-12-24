package com.brickbase.platform.mapper;

import com.brickbase.platform.dto.requestDTO.CategoryRequestDTO;
import com.brickbase.platform.dto.responseDTO.CategoryResponseDTO;
import com.brickbase.platform.model.Category;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface CategoryMapper {

    Category toEntity(CategoryRequestDTO dto);

    CategoryResponseDTO toResponse(Category category);
}
