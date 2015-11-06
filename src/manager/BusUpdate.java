package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusDAO;
import entity.BusEntity;


@WebServlet("/BusUpdate")
public class BusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		String busId = request.getParameter("busId");
		String plateNumber = request.getParameter("plateNumber");
		String busNumberId = request.getParameter("busNumberId");
		String position_x = request.getParameter("position_x");
		String position_y = request.getParameter("position_y");
		String updateTime = request.getParameter("updateTime");
		String routeId = request.getParameter("routeId");
		String status = request.getParameter("status");
		String closestStopId = request.getParameter("closestStopId");
		String managerId = request.getParameter("managerId");
		
		BusEntity bus = new BusEntity();
		bus.setBusId(Integer.parseInt(busId));
		bus.setPlateNumber(plateNumber);
		bus.setBusNumberId(Integer.parseInt(busNumberId));
		bus.setPosition_x(Integer.parseInt(position_x));
		bus.setPosition_y(Integer.parseInt(position_y));
		bus.setUpdateTime(updateTime);
		bus.setRouteId(Integer.parseInt(routeId));
		bus.setStatus(status);
		bus.setClosestStopId(Integer.parseInt(closestStopId));
		bus.setManagerId(Integer.parseInt(managerId));
		

		new BusDAO().updateBus(bus);
		
		response.sendRedirect("BusListSearch");
	}
}
