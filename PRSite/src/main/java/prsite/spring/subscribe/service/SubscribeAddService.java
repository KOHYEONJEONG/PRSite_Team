package prsite.spring.subscribe.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import prsite.spring.subscibe.dao.SubscribeDao;

public class SubscribeAddService implements ISubscribeService {
// 구독추가
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session = request.getSession();
		
		//로그인한 id
		String LoginID = (String)session.getAttribute("LoginID");
		
		//인플루언서 id
		String Iid = request.getParameter("Iid");
		
		SubscribeDao dao = new SubscribeDao();
		
		dao.subscribeInsert(LoginID, Iid);
		
	}

}
