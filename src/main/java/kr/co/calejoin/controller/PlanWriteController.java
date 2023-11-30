package kr.co.calejoin.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.calejoin.dto.CalendarDTO;
import kr.co.calejoin.dto.CategoryDTO;
import kr.co.calejoin.service.PlanWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@CrossOrigin("*")
public class PlanWriteController {

    @Autowired
    private PlanWriteService planWriteService;

    @GetMapping("/PlanWrite/{uid}")
    @ResponseBody
    public List<CategoryDTO> category (@PathVariable String uid) {

        List<CategoryDTO> categoryList = planWriteService.selectCategory(uid);

        return categoryList;
    };


    @ResponseBody
    @PostMapping("/PlanWrite")
    public String PlanWrite (@RequestBody Map<String, Object> requestData) {
        String uid = (String) requestData.get("uid");
        log.info(uid);
        int cateNo = (int) requestData.get("cateNo");
        log.info(cateNo);
        String title = (String) requestData.get("title");
        log.info(title);
        String startTimeStr = (String) requestData.get("StartTime");
        log.info(startTimeStr);
        String endTimeStr = (String) requestData.get("endTime");
        log.info(endTimeStr);
        String memo = (String) requestData.get("memo");
        log.info(memo);
        String isPublic = (String) requestData.get("isPublic");
        log.info(isPublic);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        CalendarDTO dto = new CalendarDTO();
        dto.setUid(uid);
        dto.setCateNo(cateNo);
        dto.setTitle(title);

        // 클라이언트에서 전송된 StartTime과 endTime을 서버에서 사용하는 패턴으로 파싱
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);

        dto.setStartTime(startTime);
        dto.setEndTime(endTime);
        dto.setMemo(memo);
        dto.setIsPublic(Integer.parseInt(isPublic));
        dto.setRegDate(LocalDateTime.now());

        log.info("plan------"+dto);
        planWriteService.insertPlan(dto);
        return "insertPlan";
    };

    @ResponseBody
    @DeleteMapping("/PlanWrite/{id}")
    public void delete(@PathVariable("id")int calNo){
        planWriteService.deletePlan(calNo);
    }

    @ResponseBody
    @PostMapping("/EventPlanWrite")
    public String EventPlanWrite (@RequestBody Map<String, Object> requestData) {
        String uid = (String) requestData.get("uid");
        log.info(uid);
        String cateNo = (String) requestData.get("cateNo");
        log.info(cateNo);
        String title = (String) requestData.get("title");
        log.info(title);
        String startTimeStr = (String) requestData.get("StartTime");
        log.info(startTimeStr);
        String endTimeStr = (String) requestData.get("endTime");
        log.info(endTimeStr);
        String memo = (String) requestData.get("memo");
        log.info(memo);
        String isPublic = (String) requestData.get("isPublic");
        log.info(isPublic);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        CalendarDTO dto = new CalendarDTO();
        dto.setUid(uid);
        dto.setCateNo(Long.parseLong(cateNo));
        dto.setTitle(title);

        // 클라이언트에서 전송된 StartTime과 endTime을 서버에서 사용하는 패턴으로 파싱
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);

        dto.setStartTime(startTime);
        dto.setEndTime(endTime);
        dto.setMemo(memo);
        dto.setIsPublic(Integer.parseInt(isPublic));

        dto.setRegDate(LocalDateTime.now());

        log.info(dto);
        planWriteService.insertPlan(dto);
        return "EventPlanWrite";
    };

    @PostMapping("/InsertCategory")
    @ResponseBody
    public String insertCategory (@RequestBody Map<String, Object> requestData) {
        String uid = (String) requestData.get("uid");
        log.info(uid);
        String cateName = (String) requestData.get("cateName");
        log.info(cateName);

        CategoryDTO dto = new CategoryDTO();
        dto.setUid(uid);
        dto.setCateName(cateName);
        planWriteService.insertCategory(dto);
        return "insertCategory";
    };
}
