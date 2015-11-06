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
 * Servlet implementation class ManagerUpdate
 */
@WebServlet("/ManagerUpdate")
public class ManagerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");

		String managerId = request.getParameter("managerId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String identification = request.getParameter("identification");
		String address = request.getParameter("address");
		String degree = request.getParameter("degree");
		String usable = request.getParameter("usable");
		

		ManagerEntity manager = new ManagerEntity();
	
		manager.setManagerId(managerId);
		manager.setPassword(password);
		manager.setName(name);
		manager.setPhone(phone);
		manager.setIdentification(identification);
		manager.setAddress(address);
		manager.setDegree(degree);
		manager.setUsable(usable);

		new ManagerDAO().updateManager(manager);

		response.sendRedirect("ManagerList");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request , response);
	}

}
