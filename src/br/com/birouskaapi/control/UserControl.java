package br.com.birouskaapi.control;

import br.com.birouskaapi.dao.UserDAO;
import br.com.birouskaapi.model.User;
import java.util.List;

public class UserControl {
	
	UserDAO userDAO = new UserDAO();
	
	public List<User> List()
	{
		return userDAO.List();
	}
	
	public User List(int id)
	{
		return userDAO.List(id);
	}
	
	public void Create(User user)
	{
		userDAO.Create(user);
	}
	
}
