package com.weilai.commons.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.weilai.commons.constant.ConstantInfo;
import com.weilai.commons.log.LogOutput;
import com.weilai.commons.log.dto.LogDto;


public class WeilaiFilter implements Filter{
    

	@Autowired(required=true)
	LogOutput logOutput;

	/**
	 * @return the logOutput
	 */
	public LogOutput getLogOutput() {
		return logOutput;
	}

	/**
	 * @param logOutput the logOutput to set
	 */
	public void setLogOutput(LogOutput logOutput) {
		this.logOutput = logOutput;
	}

	@Autowired
	private AuditHandler auditHandler ;
	
	private String appName;
	

    //public WeilaiFilter() {}

    public WeilaiFilter() {
       //this.auditHandler = AuditHandler;
    	//auditHandler = new AuditHandler();
       
    }


    public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 auditHandler.auditRequest(appName,request);
	        chain.doFilter(request, response);
	      //  LogDto logDto = new LogDto();
	        
//	    	logDto.setClassName(appName);
//			logDto.setMessageId(ConstantInfo.I000001);
//			logDto.setLogInfo("[start log]");
//			logOutput.printLog(logDto);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 appName = filterConfig.getInitParameter("appName");
		
	}

}
