package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ManagerDAO;
import entity.ManagerEntity;

/**
 * Servlet implementation class ManagerUpdateForm
 */
@WebServlet("/ManagerUpdateForm")
public class ManagerUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String managerId = request.getParameter("no");
		ManagerEntity manager = new ManagerDAO().getManager(managerId);
		request.setAttribute("ManagerList", manager); 
		
		request.setAttribute("content", "ManagerUpdateForm.jsp"); 

		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request , response);
	}

}
