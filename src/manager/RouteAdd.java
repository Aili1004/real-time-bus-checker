package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RouteDAO;

import entity.RouteEntity;


@WebServlet("/RouteAdd")
public class RouteAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		String stopId = request.getParameter("stopId");
		
		RouteEntity route = new RouteEntity();
		route.setStopId(Integer.parseInt(stopId));
		
		new RouteDAO().addRoute(route);
		
		response.sendRedirect("RouteList");
	}
}
