package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusStopDAO;
import entity.BusStopEntity;


@WebServlet("/RouteAddForm")
public class RouteAddForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BusStopEntity> list = new BusStopDAO().getBusStopList();
		
		
		request.setAttribute("busStopList", list);
		
		request.setAttribute("content", "RouteAddForm.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
		
	}

}
