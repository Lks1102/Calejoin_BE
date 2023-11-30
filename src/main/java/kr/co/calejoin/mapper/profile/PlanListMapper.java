package kr.co.calejoin.mapper.profile;

import kr.co.calejoin.dto.CalendarDTO;
import kr.co.calejoin.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanListMapper {
    public List<CalendarDTO> selectCalendar(String uid);

    public List<CategoryDTO> selectCategory(String uid);

    public void insertPlan (CalendarDTO dto);

    public void deletePlan (int calNo);

    public void insertCategory (CategoryDTO dto);
}
