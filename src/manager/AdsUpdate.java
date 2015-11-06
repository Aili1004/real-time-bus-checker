package manager;


import ita.AttachedFile;
import ita.FileUploadHelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdsDAO;

import entity.AdsEntity;



/**
 * Servlet implementation class AdsUpdate
 */
@WebServlet("/AdsUpdate")
public class AdsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		FileUploadHelper helper = new FileUploadHelper(request);
		

		String adsId = helper.getParameter("adsId");
		String company = helper.getParameter("company");
		String phone = helper.getParameter("phone");
		AttachedFile file = helper.getAttachedFile("file");
		String introduction = helper.getParameter("introduction");
		String usable = helper.getParameter("usable");
		String weight = helper.getParameter("weight");
		String stoppedName = helper.getParameter("stoppedName");
		String registerDate = helper.getParameter("registerDate");
		String managerId = helper.getParameter("managerId");
		
		AdsEntity ads = new AdsEntity();
		
		ads.setAdsId(Integer.parseInt(adsId));
		ads.setCompany(company);
		ads.setPhone(phone);
		ads.setPhoto(file.getFileName());
		ads.setIntroduction(introduction);
		ads.setUsable(usable);
		ads.setWeight(Integer.parseInt(weight));
		ads.setStoppedName(stoppedName);
		ads.setRegisterDate(registerDate);
		ads.setManagerId(Integer.parseInt(managerId));
		System.out.println(file);
		
		
		int id = new AdsDAO().updateAds(ads);
		
		//서버에 업로드된 그림을 저장
		file.saveAs("upload/" + id, file.getFileName());
		response.sendRedirect("AdsList");
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request , response);
//	}

}
