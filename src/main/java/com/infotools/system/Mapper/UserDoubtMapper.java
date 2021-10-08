package com.infotools.system.Mapper;

import com.infotools.system.Entity.UserDoubt;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UserDoubtMapper {
    //后端留言展示
    @Select("select * from user_doubt")
    List<UserDoubt> findAllUserDoubt();

    //前端留言展示
    @Select("select * from user_doubt where mess_details is not null")
    List<UserDoubt> findAllDoubt();

    @Insert("insert into user_doubt(user_name,doc_name,user_email,user_doubt,mess_details,user_pubTime) values (#{user_name},#{doc_name},#{user_email},#{user_doubt},#{mess_details},sysDate())")
    Integer insertUserDoubt(UserDoubt userDoubt);

    @Select("select * from user_doubt where mess_id=#{mess_id}")
    UserDoubt findUserDoubtById(Integer mess_id);

    @Update("update user_doubt set user_name=#{user_name},doc_name=#{doc_name},user_email=#{user_email},user_doubt=#{user_doubt},mess_details=#{mess_details}, admin_reply = #{admin_reply} where mess_id=#{mess_id}")
    Integer updateUserDoubtById(UserDoubt userDoubt);

    @Delete("delete from user_doubt where mess_id=#{mess_id}")
    Integer deleteUserDoubtByID(Integer mess_id);
}
