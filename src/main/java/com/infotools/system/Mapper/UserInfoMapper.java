package com.infotools.system.Mapper;

import com.infotools.system.Entity.SysLog;
import com.infotools.system.Entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info")
    List<UserInfo> findAllUserInfo();

    @Insert("insert into user_info(user_name,password,user_sex,user_birthday,user_email,user_phone,user_address,power) VALUES (#{user_name},#{password},#{user_sex},#{user_birthday},#{user_email},#{user_phone},#{user_address},#{power})")
    Integer insertUserInfo(UserInfo userInfo);

    @Delete("delete from user_info where user_id=#{user_id}")
    Integer deleteUserByID(Integer user_id);

    @Update("update user_info set user_name=#{user_name},password=#{password},user_sex=#{user_sex},user_birthday=#{user_birthday},user_email=#{user_email},user_phone=#{user_phone},user_address=#{user_address} where user_id=#{user_id}")
    Integer updateByUserId(UserInfo userInfo);

    @Select("select * from user_info where user_id=#{user_id}")
    UserInfo findUserByUserId(Integer user_id);

    @Select("select * from user_info where user_name like '%${user_name}%'")
    List<UserInfo> findUserInfoByUserName(String user_name);

    @Select("select * from user_info where user_name=#{user_name} and `password`=#{password} and power=#{power}")
    UserInfo UserLogin(String user_name,String password,Integer power);

    @Select("select * from user_info where user_email=#{checkEmail} and user_name=#{user_name}")
    UserInfo findUserInfoByEmail(String checkEmail,String user_name);

    @Insert("insert into sys_log (userID,log_content,IP_address,OS,IE,CreateDate,Remark) values (#{userID},#{log_content},#{IP_address},#{OS},#{IE},sysDate(),#{Remark})")
    Integer InsertSysLog(SysLog log);

    @Select("select sys_log.* , user_info.user_name,power from user_info join sys_log on sys_log.UserID=user_info.user_id")
    List<SysLog> findAllSysLog();

    @Select("select count(user_address) as count from user_info GROUP BY user_address")
    List<UserInfo> findAllUserud(Integer ud);
    @Select("select user_address from user_info GROUP BY user_address")
    List<UserInfo> findAllUseruc(String uc);

    @Select("select count(user_sex) as count1 from user_info GROUP BY user_sex")
    List<UserInfo> findAllUserus(Integer us);
}
