package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusDAO;
import entity.BusEntity;


@WebServlet("/BusList")
public class BusList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String busNumberId = request.getParameter("busNumberId");

		ArrayList<BusEntity> list2 = new BusDAO().getBusSearchList(Integer.parseInt(busNumberId));


		request.setAttribute("searchList", list2);

		request.setAttribute("content", "BusList.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request , response);
	}
}
