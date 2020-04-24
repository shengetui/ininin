package com.xt.mapper;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Userr {
	static SqlSessionFactory build;

static{
	try (// 读取mybatis-config.xml文件
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		){
		build = new SqlSessionFactoryBuilder().build(is);
		// 初始化mybatis，创建SqlSessionFactory类的实例
		//sqlSession = sqlSessionFactory.openSession();}
	}
		catch (Exception e) {
			// TODO: handle exception
		}
		
}
public static SqlSession get(){
	
	return build.openSession();
}
}
