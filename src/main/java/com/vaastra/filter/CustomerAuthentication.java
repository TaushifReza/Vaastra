package com.vaastra.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vaastra.model.Customer.Customer;

public class CustomerAuthentication implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Type cast servlet request and respond to httprequest and httprespond
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		Customer customer = (Customer) session.getAttribute("currentCustomer");

		if (customer != null) {
			// login
			chain.doFilter(request, response);

		} else {
			// not login
			res.sendRedirect(req.getContextPath() + "/pages/login.jsp");

		}

	}

	@Override
	public void destroy() {

	}

}
