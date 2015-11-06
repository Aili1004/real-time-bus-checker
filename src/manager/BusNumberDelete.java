package manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusNumberDAO;


@WebServlet("/BusNumberDelete")
public class BusNumberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");

		String busNumberId = request.getParameter("no");
		
		new BusNumberDAO().deleteBusNumber(Integer.parseInt(busNumberId));
		
		response.sendRedirect("BusNumberList");
	}

}
