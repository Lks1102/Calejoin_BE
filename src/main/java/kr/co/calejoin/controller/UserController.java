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
        String intValue = (String) user.get("age");
        int age = Integer.parseInt(intValue);
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

    @PostMapping("/user/login")
    @ResponseBody
    public int login(@RequestBody Map<String,String> user){

        log.info("11111111");
        String uid = (String) user.get("uid");
        log.info(uid);
        String pass = (String) user.get("pass");
        log.info(pass);
        

        UserDTO dto = new UserDTO();

        log.info("2222222222");

        dto.setUid(uid);
        dto.setPass(pass);

        log.info("333333333333+ dto: " + dto.toString());
        log.info("333333333333+ dto: " + dto);


        int result = mapper.selectUser(dto);

        log.info("result~~~~~~~~~~~: " + result);
        
        
        
        
        
        
        
        if(result == 1){
            
            
            
            return result ;
        }else {
            return result;
        }
    }
}
