package kr.co.calejoin.controller;

import kr.co.calejoin.dto.CalendarDTO;
import kr.co.calejoin.dto.CategoryDTO;
import kr.co.calejoin.service.MainService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@CrossOrigin("*")
public class MainController {

    @Autowired
    private MainService mainService;


    @GetMapping("/{uid}")
    @ResponseBody
    public Map<String, Object> home(@PathVariable() String uid) {
        log.info("home...1");

        // Plan List
        List<CalendarDTO> planList = mainService.selectCalendar(uid);

        // Category List
        List<CategoryDTO> categoryList = mainService.selectCategory(uid);

        log.info("home...2");

        Map<String, Object> result = new HashMap<>();
        result.put("plans", planList);
        result.put("categories", categoryList);

        return result;
    }

}
