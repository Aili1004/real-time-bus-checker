package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusStopDAO;


@WebServlet("/BusStopDelete")
public class BusStopDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		
		String stopId = request.getParameter("no");
		
		new BusStopDAO().deleteBusStop(Integer.parseInt(stopId));
		
		response.sendRedirect("BusStopList");
		
	}

}
