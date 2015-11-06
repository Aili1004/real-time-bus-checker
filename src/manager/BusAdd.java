package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusDAO;
import entity.BusEntity;


@WebServlet("/BusAdd")
public class BusAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		String busId = request.getParameter("busId");
		String plateNumber = request.getParameter("plateNumber");
		String status = request.getParameter("status");
		String position_x = request.getParameter("position_x");
		String position_y = request.getParameter("position_y");
		String routeid = request.getParameter("routeId");
		String closestStopId = request.getParameter("closestStopId");
		String updatetime = request.getParameter("updateTime");
		String busNumberId = request.getParameter("busNumberId");
		String managerId = request.getParameter("managerId");

		
		BusEntity bus = new BusEntity();
		bus.setBusId(Integer.parseInt(busId));
		bus.setPlateNumber(plateNumber);
		bus.setStatus(status);
		bus.setPosition_x(Integer.parseInt(position_x));
		bus.setPosition_y(Integer.parseInt(position_y));
		bus.setRouteId(Integer.parseInt(routeid));
		bus.setClosestStopId(Integer.parseInt(closestStopId));
		bus.setUpdateTime(updatetime);
		bus.setBusNumberId(Integer.parseInt(busNumberId));
		bus.setManagerId(Integer.parseInt(managerId));
		
		new BusDAO().addBus(bus);
		
		response.sendRedirect("BusListSearch");
	}
}
