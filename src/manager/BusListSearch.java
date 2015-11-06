package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusNumberDAO;
import entity.BusNumberEntity;


@WebServlet("/BusListSearch")
public class BusListSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<BusNumberEntity> list = new BusNumberDAO().getBusNumberList();

		request.setAttribute("BusNumberList", list);

		request.setAttribute("content", "BusListSearch.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	}
}
