package com.weilai.commons.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

import com.weilai.commons.constant.ConstantInfo;
import com.weilai.commons.log.LogOutput;
import com.weilai.commons.log.dto.LogDto;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
@Override
protected void configure(HttpSecurity http) throws Exception{
	http.formLogin().loginPage("/index").permitAll();
	http.authorizeRequests().anyRequest().authenticated();
}

}
