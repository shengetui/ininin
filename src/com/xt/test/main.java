package com.xt.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xt.mapper.Userr;
import com.xt.mapper.Usermapper;
import com.xt.model.User;

public class main {
public static void main(String[] args) {
	System.out.println("000000000000");
	// 创建Session实例
	SqlSession sqlSession = null;
	try	{
		 sqlSession = Userr.get();
		
/*//		// 创建User对象
		User user = new User("admin999",111, "男", 26);
		// 插入数据
		sqlSession.insert("com.xt.mapper.Usermapper.save", user);*/
		//返回user对象
//		User user = sqlSession.selectOne("com.xt.mapper.Usermapper.select", 1);
//		System.out.println(user);
//		user.setUsername("123");
//		user.setAge(14);
//		sqlSession.update("com.xt.mapper.Usermapper.up", user);
//		sqlSession.delete("com.xt.mapper.Usermapper.reom", 24);
		 //返回map集合，键：表列，值：内容
//		 List<Map> selectList = sqlSession.selectList("com.xt.mapper.Usermapper.ses");
//		for (Map map : selectList) {
//			System.out.println(map);
//		}
		 //加入了接口true
		
		 
		 Usermapper mapper = sqlSession.getMapper(Usermapper.class);
		 User user = new User("user111",123,"hng",18);
		
		 // mapper.reom(27);
		// mapper.save(user);
		 HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("id", 2);
		 List<User> select = mapper.selectid(map);
		 System.out.println(select);
//		 
		// User select2 = mapper2.select(1);
		 //System.out.println(select2);
	// 提交事务
		sqlSession.commit();
	} catch (Exception e) {
		// 回滚事0务
		e.printStackTrace();
		sqlSession.rollback();
		e.printStackTrace();
	}finally{
		try {
			// 关闭sqlSession
			if(sqlSession != null) sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}
