package dao;

import java.util.List;

import vo.User;

public interface UserMapper {
public void addUser(User b);
	
	public void modifyUser(User b);
	
	public void deleteUser(User b);
	
	public User selectUser(User b);
	
	public List<User> queryUser(User b);
	
	public Integer countUser(User b);
}
