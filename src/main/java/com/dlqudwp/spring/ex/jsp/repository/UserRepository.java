package com.dlqudwp.spring.ex.jsp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dlqudwp.spring.ex.jsp.domain.User;


@Repository
public interface UserRepository {

	public int insertUser(
			@Param("name") String name
			, @Param("birthday") String birthday
			, @Param("email") String email);
			
	
	public int insertUserByObject(User user);
	
	public User selectLastUser();
	
	public List<User> selectUserList();
	
	// 전달된 email과 일치하는 행의 개수를 얻어오는 기능
	public int selectCountEmail(@Param("email") String email);
	
	
	
}
