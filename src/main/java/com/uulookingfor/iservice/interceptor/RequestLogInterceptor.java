package com.uulookingfor.iservice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.uulookingfor.icommon.IwebLogger;

/**
 * @author suxiong.sx 
 */
public class RequestLogInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
//		IwebLogger.Request.info("url: {}, param: {}", request.getRequestURI(), GsonUtil.toJson(request.getParameterMap()));
		
		return true;
	}

}
