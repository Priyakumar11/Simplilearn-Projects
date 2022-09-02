package com.learn.quiz.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.quiz.entity.LoginSession;

@Repository
public class LoginSessionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public LoginSession findByAccessToken(String accessToken) {
		System.out.println("accessToken:"+accessToken);
		List<LoginSession> rs = jdbcTemplate.query("SELECT ls.* from login_session ls where ls.access_token = ?",
				new BeanPropertyRowMapper<LoginSession>(LoginSession.class), new Object[] { accessToken });
		LoginSession loginSession = null;
		for(int i=0;i<rs.size();i++)
		{
			System.out.print(i);
			System.out.print(" id:"+rs.get(i).getId());
			System.out.print(" userId:"+rs.get(i).getUserId());
			System.out.print(" accessToken:"+rs.get(i).getAccessToken());
			System.out.println(" lastAccess:"+rs.get(i).getLastAccess());
			if(i==0)
			{
				loginSession = new LoginSession();
				loginSession.setAccessToken(rs.get(i).getAccessToken());
				loginSession.setId(rs.get(i).getId());
				loginSession.setUserId(rs.get(i).getUserId());;
				loginSession.setLastAccess(rs.get(i).getLastAccess());
			}
		}
		
		//if (rs != null && rs.size() > 0) {
			//loginSession=rs.get(0);
			return loginSession;
		//} else {
		//	return null;
		//}
	}

}
