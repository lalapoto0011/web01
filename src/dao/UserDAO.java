package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.UserVO;

public class UserDAO {
	// UserDAO 안에 로그인 2개 있음
	
	public UserVO login(UserVO vo) { //메소드 오버로딩 - 객체화해서 아이디 패스워드 넘겨줌
		return login(vo.getId(), vo.getPassword()); 
	}
	
	public UserVO login(String id, String password) { //로그인 처리하는 함수 하나 완성...
		//리턴타입 UserVO
		
		UserVO vo = null;
		String sql = "select * from users where id=? and password=?";
		
		Connection con = null;
		PreparedStatement ps = null;	//sql구문처리객체
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setRole(rs.getString("role"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return vo;
	}
	
		
	
	public List<UserVO> userList() { // 이 메소드를 호출할 때 정말 테이블 구조 내용이 나오는지 확인해야 함
		List<UserVO> list = new ArrayList<UserVO>();
		String sql = "select * from users"; // 얘를 처리하고 싶음..
		// 이 sql구문 처리한 결과가 테이블 내용
		// book테이블에 어떤 내용이 있는지? - sql구문 처리할 수 있는 메소드 등장해야함 - 나름대로 메소드 이름 결정하기, 조원들끼리.

		// DB연동 코드 - 연결할 변수들?
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 결과값 처리할 객체

		try { // sql구문 처리하는 부분 들어감
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); // 테이블 내용을 ??

			while (rs.next()) { // 커서가 메타태그를 가리키고 있음, rs.next하면 밑으로 내려감, 데이터를 꺼내서 자바북브이오에 객체화시킴???
				UserVO vo = new UserVO(); // vo객체가 만들어졌지만 비어있음
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setRole(rs.getString("role"));
				
				list.add(vo); // vo객체를 add해주세요?
			}

		} catch (Exception e) {
			System.out.println("error" + e);
		} finally { // 무조건 자원 반납
			JDBCUtil.close(con, ps, rs);
		}

		return list;
		// resultset을 자바로 뭐 어쩐다고????
		// 리턴타입 -> 레코드가 하나가 아니라 여러개니까 -> 무조건 배열 아니면 컬렉션
	}
	
	
	
	
}
