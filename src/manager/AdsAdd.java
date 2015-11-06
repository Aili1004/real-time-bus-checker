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

@WebServlet("/AdsAdd")
public class AdsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUploadHelper helper = new FileUploadHelper(request);
		
		
		String adsId = helper.getParameter("adsId");
		String company = helper.getParameter("company");
		String phone = helper.getParameter("phone");
		String photo = helper.getParameter("photo");
		String introduction = helper.getParameter("introduction");
		String usable = helper.getParameter("usable");
		String weight = helper.getParameter("weight");
		String stoppedName = helper.getParameter("stoppedName");
		String registerDate = helper.getParameter("registerDate");
		String managerId = helper.getParameter("managerId");
		
		
		
		AttachedFile file = helper.getAttachedFile("attachedFile");
		
		AdsEntity ads = new AdsEntity();
		ads.setAdsId(Integer.parseInt(adsId));
		ads.setCompany(company);
		ads.setPhone(phone);
		ads.setPhoto(photo);
		ads.setIntroduction(introduction);
		ads.setUsable(usable);
		ads.setWeight(Integer.parseInt(weight));
		ads.setStoppedName(stoppedName);
		ads.setRegisterDate(registerDate);
		ads.setManagerId(Integer.parseInt(managerId));
//		ads.setPhoto(file.getFileName());
		
		//DB에 앨범 정보를 추가
		new AdsDAO().addAds(ads);
		
		//서버에 업로드된 그림을 저장
		
		
		if (file != null && !file.getFileName().equals("")) {
			file.saveAs("img/" + photo, file.getFileName());
		
		
		//작업 후 앨범 목록으로 이동하도록 브라우저에게 지시
		response.sendRedirect("AdsList");
		
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request , response);
	}

}
