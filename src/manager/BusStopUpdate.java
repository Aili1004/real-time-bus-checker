package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusStopDAO;

import entity.BusStopEntity;


@WebServlet("/BusStopUpdate")
public class BusStopUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String stopId = request.getParameter("stopId");
		String stopName = request.getParameter("stopName");
		String location_x = request.getParameter("location_x");
		String location_y = request.getParameter("location_y");
		String description = request.getParameter("description");
		String registerDate = request.getParameter("registerDate");
		String managerId = request.getParameter("managerId");
		String usable = request.getParameter("usable");
		
		BusStopEntity busStop = new BusStopEntity();
		busStop.setStopId(Integer.parseInt(stopId));
		busStop.setStopName(stopName);
		busStop.setLocation_x(Integer.parseInt(location_x));
		busStop.setLocation_y(Integer.parseInt(location_y));
		busStop.setDescription(description);
		busStop.setRegisterDate(registerDate);
		busStop.setManagerId(Integer.parseInt(managerId));
		busStop.setUsable(usable);

		new BusStopDAO().updateBusStop(busStop);
		
		response.sendRedirect("BusStopList");
		
	}

}
