package cn.edu.nju.software.gof.processor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nju.software.gof.business.PlaceUtilities;
import cn.edu.nju.software.gof.servlet.ServletParam;

public class PlaceCommentProcessor implements RequestProcessor {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String sessionID = request.getParameter(ServletParam.RequestParam.SessionID);
		String placeID = request.getParameter(ServletParam.RequestParam.PlaceID);
		String content = request.getParameter(ServletParam.RequestParam.Content);

		PlaceUtilities utilities = new PlaceUtilities();
		boolean succ = utilities.commandPlace(sessionID, placeID, content);

		ResponseUtilities.writeMessage(response, succ ? 1 : 0,
				ResponseUtilities.TEXT);
	}

}
