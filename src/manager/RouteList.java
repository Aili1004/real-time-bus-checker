package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusNumberDAO;
import dao.BusStopDAO;
import entity.BusNumberEntity;
import entity.BusStopEntity;
import entity.RouteEntity;


@WebServlet("/RouteList")
public class RouteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		int busNumberId = Integer.parseInt(request.getParameter("no"));
		
//		ArrayList<BusStopEntity> list = new ArrayList<BusStopEntity>();
		
//		ArrayList<RouteEntity> list = new ArrayList<RouteEntity>();
//		new BusNumberDAO().getRouteList2(busNumberId);
		
		
		
//		ArrayList<RouteEntity> list = new BusNumberDAO().getRouteList2(Integer.parseInt(busNumberId));
	
		ArrayList<BusStopEntity> stopList = new BusStopDAO().getRouteList2(busNumberId); 
		
		
		
//		request.setAttribute("detailList", list);
		request.setAttribute("stopList", stopList);
				
//		System.out.println(list);
		
		request.setAttribute("content", "RouteList.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	}
}
