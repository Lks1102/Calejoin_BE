package kr.co.calejoin.service;

import kr.co.calejoin.dto.CalendarDTO;
import kr.co.calejoin.dto.CategoryDTO;
import kr.co.calejoin.mapper.Category.CategoryMapper;
import kr.co.calejoin.mapper.profile.PlanListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class PlanWriteService {

    private final PlanListMapper planListMapper;

    private final CategoryMapper categoryMapper;


    public List<CategoryDTO> selectCategory(String uid){
        return categoryMapper.selectCategory(uid);
    }

    public void insertPlan(CalendarDTO dto) {

        planListMapper.insertPlan(dto);
    };

    public void deletePlan(int calNo){
        planListMapper.deletePlan(calNo);
    }

    public void insertCategory(CategoryDTO dto){
        planListMapper.insertCategory(dto);
    }
}
