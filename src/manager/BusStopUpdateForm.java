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


@WebServlet("/BusStopUpdateForm")
public class BusStopUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ManagerEntity> list = new ManagerDAO().getManagerList();
		
		String stopId = request.getParameter("no");
		BusStopEntity busStop = new BusStopDAO().getBusStop(Integer.parseInt(stopId));
		
		request.setAttribute("managerList", list);
		request.setAttribute("busStop", busStop);
		
		request.setAttribute("content", "BusStopUpdateForm.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
		
	}

}
