package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.*;

import dao.UserDAO;
import service.UserService;
import service.UserServiceImpl;
import vo.UserVO;



class userTest02 {
	
	UserService_me service = null;
	
	@BeforeEach
	void setUp() throws Exception {
		UserDAO dao = new UserDAO();
		service = new UserServiceImpl(dao);
	}
	
	
	@Test
	void list() {
		List<UserVO> list = service.UserList();
		
		for(UserVO data : list) {
			System.out.println("----list-----");
			System.out.printf("%s|%d|%s %n", data.getId(), data.getPassword(), data.getName(), data.getRole());
			System.out.println("-------------");
		}
	}
	
//	@Test
	void add() {
		UserVO vo = new UserVO();
		vo.setId("testtest01");
		vo.setPassword("qwer1234");
		vo.setName("소은영");
		vo.setRole("student");
		
		service.UserAdd(vo);
	}
	
	

}
