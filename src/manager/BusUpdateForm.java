package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusDAO;
import dao.ManagerDAO;
import entity.BusEntity;
import entity.ManagerEntity;


@WebServlet("/BusUpdateForm")
public class BusUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ManagerEntity> list = new ManagerDAO().getManagerList();
		
		String busId = request.getParameter("no");
		
		
		BusEntity bus = new BusDAO().getBus(Integer.parseInt(busId));
		request.setAttribute("bus", bus);
		request.setAttribute("managerList", list);
		
		request.setAttribute("content", "BusUpdateForm.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	
	}

}
