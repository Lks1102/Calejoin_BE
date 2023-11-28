package kr.co.calejoin.service;

import kr.co.calejoin.dto.CalendarDTO;
import kr.co.calejoin.dto.CategoryDTO;
import kr.co.calejoin.mapper.profile.PlanListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MainService {

    private final PlanListMapper planListMapper;

    public List<CalendarDTO> selectCalendar( ){
        return planListMapper.selectCalendar();
    }
    public List<CategoryDTO> selectCategory(){
        return planListMapper.selectCategory();
    }
}
