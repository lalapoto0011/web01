package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import service.UserService;
import service.UserServiceImpl;
import vo.UserVO;

@WebServlet({ "/login.do", "/logout.do" }) //배열
public class LoginOutSelvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// logout.do
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		if(session != null) {
			session.invalidate(); //세션 객체 파괴
		}
		response.sendRedirect("./index.jsp"); //index.jsp 페이지로 가겠다
	}

	
	// login.do
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 이거 안 하면 한글 깨짐
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password"); //"" 값이 jsp name의 키값이랑 동일해야 함
		
		UserDAO dao = new UserDAO(); 		
		UserService service = new UserServiceImpl(dao); //인터페이스이므로 임플 객체가 바인딩되어야 함, 이건 내부적으로 dao를써야함, 어떤 dao를 쓸것인지(?)
		
		UserVO login = service.login(id, pw);
		System.out.println(login);
		
		if (login != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login); //세션 객체에 로그인을 박음?
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		} else {
			request.setAttribute("msg", "로그인 실패, 로그인 정보를 다시 입력하세요.");
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

		}
	
	}

}
