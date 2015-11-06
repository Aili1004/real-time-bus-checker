package manager;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerDAO;
import entity.ManagerEntity;


@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		ManagerEntity manager = new ManagerDAO().getManager(id);
		if(manager != null){
			if(manager.getPassword().equals(password)){
				
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10*60);
				session.setAttribute("manager", manager);
				
				response.sendRedirect("TemplatePage.jsp");
			}else{
				out.println("<script>");
				out.println("alert('비밀번호가 틀렸습니다.')");
				out.println("location.href='ManagerLogin'");
				out.println("</script>");
			}
		}else{
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다')");
			out.println("location.href='ManagerLogin'");
			out.println("</script>");
		}
	}

}
