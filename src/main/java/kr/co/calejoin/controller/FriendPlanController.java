package kr.co.calejoin.controller;

import kr.co.calejoin.dto.CalendarDTO;
import kr.co.calejoin.dto.CategoryDTO;
import kr.co.calejoin.service.FriendPlanService;
import kr.co.calejoin.service.PlanWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@CrossOrigin("*")
public class FriendPlanController {

    @Autowired
    private FriendPlanService friendPlanService;

    @GetMapping("/Calendar/{uid}")
    @ResponseBody
    public Map<String, Object> home(@PathVariable("uid") String uid) {
        log.info("friend...1");
        log.info("넘어오는값 확인----"+uid);

        // Plan List
        List<CalendarDTO> planList = friendPlanService.selectCalendar(uid);

        // Category List
        List<CategoryDTO> categoryList = friendPlanService.selectCategory(uid);

        log.info("friend...2");

        Map<String, Object> result = new HashMap<>();
        result.put("plans", planList);
        result.put("categories", categoryList);

        log.info("friend...3");
        return result;
    }


}
