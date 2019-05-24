package com.cafe24.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//@WebFilter(value="/*", initParams = @WebInitParam(name="encoding", value = "utf-8"))
public class EncodingFilter implements Filter {
	private String encoding;
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		// web.xml에 설정한 param을 읽는 작업을 init()에 한다
		System.out.println("Encoding Filter initialized....");
		
		encoding = fConfig.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* request 처리  */
		request.setCharacterEncoding(encoding);
		
		
		chain.doFilter(request, response);
		
		
		/* response 처리 */
	}

	public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}



}
