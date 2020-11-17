package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO_MariaDB;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;
import vo.UserVO;

@WebServlet("/bookList.do") //이 이름으로 요청이 들어오면 해당 서비스 메소드가 실행됨, get post 상관없이
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8"); // 이거 안 하면 한글 깨짐
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		UserVO login = (UserVO)session.getAttribute("login"); //return값은 object ?? (뒷쪽을)스트링으로 캐스팅해도 되고, 앞쪽을 UserVO 타입으로 지정해줘도됨
		//로그인 객체가 UserVO에 담겨 있어서 ??? 로그인로그아웃 서블릿에서??
		if (login == null) { //로그인 페이지로 보내야 함
			//아래 부분 로그인로그아웃 서블릿에서 갖고 옴
			request.setAttribute("msg", "로그인 실패, 로그인 정보를 다시 입력하세요."); //리퀘스트 객체에 에러 메시지 박아둠
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			return; //이 이상 수행할 필요 없다?
		} 
		
		
			
		//컨트롤 시프트 o (import) / jsp에서 옮김 -- 데이터 꺼내옴
		BookDAO_MariaDB dao = new BookDAO_MariaDB();
		BookService service = new BookServiceImpl(dao);
		List<BookVO> list = service.bookList();  //list가 들어옴
		
		//데이터 출력을 해봅시다 ...
//		PrintWriter out = response.getWriter();
//		list.forEach(i -> { System.out.println(i); }); //콘솔창에 찍힘
//		list.forEach(i -> { out.println("<h3>"+i+"</h3>"); }); //out : 웹브라우저를 의미. -> 웹브라우저에 뿌려짐.
		
		//데이터 공유
		request.setAttribute("bookList", list); //list에 데이터가 담겨 있다? --> 리퀘스트 객체에 list를 넣음
		String page = "/bookList.jsp"; //해당 페이지로 포워딩 --> jsp페이지에서는 해당 데이터 꺼내서? ui작업만 해줌

		getServletContext().getRequestDispatcher("/bookList.jsp").forward(request, response); 
		
		
		
	
	}

}
