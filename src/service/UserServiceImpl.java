package service;

import java.util.List;

import dao.UserDAO;
import vo.UserVO;

public class UserServiceImpl implements UserService {
	//메소드 형성시키기
	
	private UserDAO dao = null;
	//그냥 쓰면 널포인트 발생하니까 기본 생성자, setter getter(dao에 대한) 만들어줌 - 기본

	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserServiceImpl(UserDAO dao) { //setter 기능을 함....
		super();
		this.dao = dao;
	}

	public UserDAO getDao() {
		return dao;
	}



	public void setDao(UserDAO dao) {
		this.dao = dao;
	}



	@Override
	public UserVO login(UserVO vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}


	@Override
	public UserVO login(String id, String password) {
		// TODO Auto-generated method stub
		return dao.login(id, password);
	}

	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return dao.userList();
	}
	
	
	
	
	
	
}
