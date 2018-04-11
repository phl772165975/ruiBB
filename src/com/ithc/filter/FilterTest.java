package com.ithc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest implements Filter{

	private String enconding;

	@Override
	public void init(FilterConfig fc) throws ServletException {
		enconding = fc.getInitParameter("enconding");
		if(enconding==null){
			enconding = "utf-8";
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding(enconding);
		resp.setCharacterEncoding(enconding);
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		
	}

}
