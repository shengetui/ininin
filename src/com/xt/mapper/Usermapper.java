package com.xt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.xt.model.User;

public interface Usermapper {

	@Delete("delete from t_user where id=#{id}")
	void reom(@Param("id") int id);
	
	@Insert( "INSERT INTO t_user(username,password,name,age) VALUES (#{username},#{password},#{name},#{age})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(User user);
	
	@Update("update t_user set username=#{username},age=#{age} where id=#{id}")
	void update(User user);
	
	@Select("select * from t_user where id=#{id}")
	@Results({
			@Result(id=true, property="id",column="id"),
			@Result(property="name",column="name"),
			@Result(property="age",column="age")
			

	})
	User select(int id);
	
	
	@SelectProvider(type=com.xt.test.xxx.class,method="xxx")
	List<User> selectid(Map<String,Object> parna);
	 
}
