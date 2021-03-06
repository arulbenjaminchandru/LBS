package cn.edu.nju.software.gof.processor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.org.json.JSONException;
import com.google.appengine.repackaged.org.json.JSONObject;

import cn.edu.nju.software.gof.beans.json.BriefPlaceInfo;
import cn.edu.nju.software.gof.business.PlaceUtilities;
import cn.edu.nju.software.gof.servlet.ServletParam;

public class GetSubPlacesProcessor implements RequestProcessor {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String sessionID = request.getParameter(ServletParam.RequestParam.SessionID);
		String placeID = request.getParameter(ServletParam.RequestParam.PlaceID);

		PlaceUtilities utilities = new PlaceUtilities();

		List<BriefPlaceInfo> places = utilities
				.getSubPlaces(sessionID, placeID);

		if (places != null) {
			JSONObject json = new JSONObject();
			try {
				json.put(ServletParam.JsonParam.ListName, places);
				ResponseUtilities.writeMessage(response, json.toString(),
						ResponseUtilities.JSON);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

	}

}
