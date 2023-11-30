package kr.co.calejoin.mapper.Category;


import kr.co.calejoin.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CategoryMapper {
    public void insertCategory(CategoryDTO dto);

    public List<CategoryDTO> selectCategory();

}
