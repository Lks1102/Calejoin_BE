package kr.co.calejoin.controller;

import kr.co.calejoin.dto.UserDTO;
import kr.co.calejoin.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;


@CrossOrigin("*")
@Controller
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final UserMapper mapper;

    
    @GetMapping(value = {"/","/index"})
    public String index(){
        
        return "http://localhost:3000/"; 
    }
    
    
    
    
    @ResponseBody
    @PostMapping("/user/register")
    public void register(@RequestBody Map<String,Object> user){

        log.info("i11");
        String uid = (String) user.get("uid");
        log.info(uid);
        String pass = (String) user.get("pass");
        log.info(pass);
        String name = (String) user.get("name");
        log.info(name);
        String hp = (String) user.get("hp");
        log.info(hp);
        int age = (int) user.get("age");
        log.info(age);
        String email = (String) user.get("email");
        log.info("email:  "+email);
        String nick = (String) user.get("nick");
        log.info("nick:  "+nick);

        UserDTO dto = new UserDTO();
        
        log.info("2222222222");
        
        dto.setUid(uid);
        dto.setPass(pass);
        dto.setName(name);
        dto.setNick(nick);
        dto.setHp(hp);
        dto.setAge(age);
        dto.setEmail(email);
        dto.setRegDate(LocalDateTime.now());

        log.info("33333333333333");
        
        
        log.info("dto확인 하기: "+ dto.toString());

        mapper.insertUser(dto);



        //mapper.insertUser(user);


        log.info("User registered");
    }


}
