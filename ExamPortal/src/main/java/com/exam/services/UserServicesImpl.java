package com.exam.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleDao;
import com.exam.repo.UserDao;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private RoleDao roledao;

	
	//Creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User localUser=this.userdao.findByUsername(user.getUsername());
		
		if(localUser!=null) {
			System.out.println("User is Already there !");
			throw new Exception("User is Already Present !!");
		}
		else {
			//User create
			
			for(UserRole ur : userRoles) {
				roledao.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			localUser=this.userdao.save(user);
			
		}
		return localUser;
	}

}
