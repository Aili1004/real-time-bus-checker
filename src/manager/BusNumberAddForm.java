package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManagerDAO;
import entity.ManagerEntity;


@WebServlet("/BusNumberAddForm")
public class BusNumberAddForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ManagerEntity> list = new ManagerDAO().getManagerList();
		
		request.setAttribute("managerList", list);
		
		request.setAttribute("content", "BusNumberAddForm.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	}

}
