package prsite.spring.member.service;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import prsite.spring.dto.MemberDto;
import prsite.spring.member.dao.MemberDao;

public class MemberJoinService implements IMemberService {
// 회원가입
	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();

		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String influyn = request.getParameter("influyn");
		String name = request.getParameter("nickname");
		

		
		
		if(id==null || pwd==null|| influyn==null || name==null) {
			System.out.println("로그인오류)입력 안됨.");
		}else {
			MemberDto member =new  MemberDto(id ,pwd,influyn, name);
			MemberDao dao = new MemberDao();
			dao.memberInsert(member);
		}
				
		

	}

}
