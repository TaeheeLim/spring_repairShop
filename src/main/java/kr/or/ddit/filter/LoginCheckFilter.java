package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//서블릿 클래스
public class LoginCheckFilter implements Filter{
	@Override
	public void init(FilterConfig config) throws ServletException{
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response
			, FilterChain chain) throws IOException, ServletException{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
	
		boolean login = false;
		
		if(session != null) {	//로그인이 되어있다면
			if(session.getAttribute("EMPVO") != null) {	//EMPVO로 로그인 되어있다면
				login = true;
			}
		}
		if (login) {	//로그인 되어 있다면
			chain.doFilter(request, response);
		} else {	//로그인 안되어있으면
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/emp/loginForm");
			dispatcher.forward(request, response);
		}
		
	}

	@Override
	public void destroy() {

		
	}
	
	
	
}
