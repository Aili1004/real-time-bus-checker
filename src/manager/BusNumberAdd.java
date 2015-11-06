package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusNumberDAO;
import entity.BusNumberEntity;


@WebServlet("/BusNumberAdd")
public class BusNumberAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String busNumberId = request.getParameter("busNumberId");
		String firstTime = request.getParameter("firstTime");
		String lastTime = request.getParameter("lastTime");
		String registerDate = request.getParameter("registerDate");
		String managerId = request.getParameter("managerId");
		String usable = request.getParameter("usable");
		
		
		BusNumberEntity busNumber = new BusNumberEntity();
		busNumber.setBusNumberId(Integer.parseInt(busNumberId));
		busNumber.setFirstTime(firstTime);
		busNumber.setLastTime(lastTime);
		busNumber.setRegisterDate(registerDate);
		busNumber.setManagerId(Integer.parseInt(managerId));
		busNumber.setUsable(usable);
		
		
		new BusNumberDAO().addBusNumber(busNumber);
		
		response.sendRedirect("BusNumberList");
	}
}
