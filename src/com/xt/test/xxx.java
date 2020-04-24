package com.xt.test;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class xxx {
	public String xxx(Map<String,Object> parm){
		
		
		SQL sql=new SQL(){{
			SELECT ("*");
			FROM("t_user");
			if(parm.get("id")!=null){
				WHERE("id=#{id}");			
			}
			
			
		}};
		
		
		
		
		
		return sql.toString();
		
		
	}

	
}
