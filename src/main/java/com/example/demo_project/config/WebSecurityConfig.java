package com.example.demo_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	//忽略特定網址，不進行帳密登入
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //定義哪些 url 需要被保護
		.antMatchers("/resources.html").permitAll() //resource 資料夾靜態資料可匿名存取
//		.antMatchers("/hello").hasRole("user") //定義匹配到"/hello"底下的需要有 USER 的這個腳色才能進去
		.anyRequest().authenticated() //其他尚未匹配到的 url 都需要身分驗證
		.and().formLogin()
		.and().httpBasic();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
////	in memory
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("Alice").roles("admin").password(passwordEncoder().encode("123"))
//		.and()
//		.withUser("Bob").roles("user").password(passwordEncoder().encode("123"));
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//此方法與上面二擇一
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/hello.html");
//	}
}
