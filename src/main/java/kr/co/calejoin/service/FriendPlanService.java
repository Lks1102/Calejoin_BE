package kr.co.calejoin.service;

import kr.co.calejoin.dto.CalendarDTO;
import kr.co.calejoin.dto.CategoryDTO;
import kr.co.calejoin.mapper.profile.FriendPlanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class FriendPlanService {

    private final FriendPlanMapper friendPlanMapper;

    public List<CategoryDTO> selectCategory(String nick){
        return friendPlanMapper.selectCategory(nick);
    }
    public List<CalendarDTO> selectCalendar(String nick){
        return friendPlanMapper.selectCalendar(nick);
    }

}
