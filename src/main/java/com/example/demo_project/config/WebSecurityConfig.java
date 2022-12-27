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
	
	//�����S�w���}�A���i��b�K�n�J
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //�w�q���� url �ݭn�Q�O�@
		.antMatchers("/resources.html").permitAll() //resource ��Ƨ��R�A��ƥi�ΦW�s��
//		.antMatchers("/hello").hasRole("user") //�w�q�ǰt��"/hello"���U���ݭn�� USER ���o�Ӹ}��~��i�h
		.anyRequest().authenticated() //��L�|���ǰt�쪺 url ���ݭn��������
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
	
	//����k�P�W���G�ܤ@
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/hello.html");
//	}
}
