package service;

import java.util.List;

import vo.UserVO;

public interface UserService { //두 가지 방법 다 쓰겠다?
	public UserVO login(UserVO vo);
	public UserVO login(String id, String password);
	
	public List<UserVO> userList();
}
