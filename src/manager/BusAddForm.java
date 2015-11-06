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


@WebServlet("/BusAddForm")
public class BusAddForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ArrayList<BusEntity> list = new BusDAO().getBusList();
		ArrayList<ManagerEntity> list2 = new ManagerDAO().getManagerList();
		
		request.setAttribute("busList", list);
		request.setAttribute("managerList", list2);

		request.setAttribute("content", "BusAddForm.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	}
}
