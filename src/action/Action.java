package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import dao.BusStopDAO;
import dao.TurnDAO;


@WebServlet("/Action")
public class Action extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String cmd = request.getParameter("cmd");
		
//===========================================================================================================

		if(cmd.equals("BusNumberSearchList")){
			String busNumber = request.getParameter("busNumber");

			TurnDAO turn1 = new TurnDAO();
			out.print(JSONArray.fromObject(turn1.getTurnListWithBusNumber(Integer.parseInt(busNumber))));
			
//============================================================================================================
		
		}else if(cmd.equals("RouteSearchList")){
			String routeSearchBusNumber = request.getParameter("routeSearchBusNumber");
			String routeSearchBusStop = request.getParameter("routeSearchBusStop");
			
			TurnDAO turn2 = new TurnDAO();
			out.print(JSONArray.fromObject(turn2.getTurnListWithBoth(Integer.parseInt(routeSearchBusNumber), routeSearchBusStop)));

//============================================================================================================
			
		}else if(cmd.equals("BusStopSearchList")){
			String busStopSearchStopName = request.getParameter("busStopSearchStopName");
			
			TurnDAO turn3 = new TurnDAO();
			out.print(JSONArray.fromObject(turn3.getTurnListWithStopName(busStopSearchStopName)));

//=============================================================================================================
		
		
			
		}else if(cmd.equals("busStopList")){
			BusStopDAO busStop = new BusStopDAO();
			out.print(JSONArray.fromObject(busStop.getBusStopListSpinner()));
			
//================================================================================================================
			
		}else if(cmd.equals("infoList")){
			String stopName = request.getParameter("stopName");
			TurnDAO turn4 = new TurnDAO();
			out.print(JSONArray.fromObject(turn4.getTurnListWithStopName(stopName)));
		
//=================================================================================================================
			
		}else if(cmd.equals("newBusNumberSearch")){
			String busNumberId = request.getParameter("busNumberId");
			TurnDAO turn5 = new TurnDAO();
			out.print(JSONArray.fromObject(turn5.getTurnListWithBusNumber(Integer.parseInt(busNumberId))));
			
//=================================================================================================================
			
		}else if(cmd.equals("finalPage")){
			String busNumberId = request.getParameter("busNumberId");
			String stopName = request.getParameter("stopName");
			
			TurnDAO turn6 = new TurnDAO();
			out.print(JSONArray.fromObject(turn6.getTurnListWithBoth(Integer.parseInt(busNumberId), stopName)));
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
