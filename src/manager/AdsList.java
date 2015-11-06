package manager;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AdsDAO;
import entity.AdsEntity;

@WebServlet("/AdsList")
public class AdsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<AdsEntity> list = new AdsDAO().getAdsList();

		request.setAttribute("AdsList", list);
		
		request.setAttribute("content", "AdsList.jsp");
		
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request , response);
	}

}
