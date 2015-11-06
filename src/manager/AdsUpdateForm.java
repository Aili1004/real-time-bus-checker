package manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdsDAO;
import dao.ManagerDAO;
import entity.AdsEntity;
import entity.ManagerEntity;

/**
 * Servlet implementation class AdsUpdateForm
 */
@WebServlet("/AdsUpdateForm")
public class AdsUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");

		String adsId = request.getParameter("no");
		AdsEntity ads = new AdsDAO().getAds(Integer.parseInt(adsId));
		
		
		request.setAttribute("Ads", ads);
		
		
		ArrayList<ManagerEntity> managerList = new ManagerDAO().getManagerList();
		request.setAttribute("ManagerList", managerList);

		request.setAttribute("content", "AdsUpdateForm.jsp");
		request.getRequestDispatcher("TemplatePage.jsp").forward(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request , response);
//	}

}
