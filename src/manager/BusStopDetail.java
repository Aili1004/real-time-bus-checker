package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusStopDAO;
import dao.ManagerDAO;
import entity.BusStopEntity;
import entity.ManagerEntity;


@WebServlet("/BusStopDetail")
public class BusStopDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ArrayList<ManagerEntity> list = new ManagerDAO().getManagerList();
		ArrayList<BusStopEntity> list = new ArrayList<BusStopEntity>();
		
		
		String stopId = request.getParameter("no");
		
		BusStopEntity busStop = new BusStopDAO().getBusStop(Integer.parseInt(stopId));
		
		request.setAttribute("busStopList", list);
		request.setAttribute("busStop", busStop);
		
		request.setAttribute("content", "BusStopDetail.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	}
}
