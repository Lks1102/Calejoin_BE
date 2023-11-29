package kr.co.calejoin.mapper;

import kr.co.calejoin.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    public void  insertUser(UserDTO user);

}

