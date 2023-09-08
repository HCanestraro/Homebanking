package com.mindhub.homebanking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Configuration
public class WebAuthorization {
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
			.antMatchers(HttpMethod.GET, "/web/index" ).permitAll()
			.antMatchers(HttpMethod.GET, "/api/clients/current/**").hasAnyAuthority("ADMIN", "CLIENT")
			.antMatchers(HttpMethod.POST, "/api/clients/current/**").hasAnyAuthority("ADMIN", "CLIENT")
			.antMatchers(HttpMethod.GET, "/web/accounts.html").hasAnyAuthority("ADMIN", "CLIENT")
			.antMatchers(HttpMethod.GET, "/web/cards.html").hasAnyAuthority("ADMIN", "CLIENT")
			.antMatchers(HttpMethod.GET, "/web/account.html").hasAnyAuthority("ADMIN", "CLIENT")
			.antMatchers(HttpMethod.GET, "/api/admin/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/api/accounts").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/rest/**").hasAuthority("ADMIN")
			.antMatchers((HttpMethod.POST), "/api/transactions").hasAnyAuthority("ADMIN", "CLIENT")
			.antMatchers((HttpMethod.GET), "/api/transactions").hasAnyAuthority("ADMIN", "CLIENT")
			.antMatchers((HttpMethod.POST), "/api/loans").hasAnyAuthority("ADMIN", "CLIENT");

		http.formLogin()
			.usernameParameter("email")
			.passwordParameter("password")
			.loginPage("/api/login");
		
		http.logout().logoutUrl("/api/logout");
		http.csrf().disable(); // turn off checking for CSRF tokens
		http.headers().frameOptions().disable(); //disabling frameOptions so h2-console can be accessed
		http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED)); // if user is not authenticated, just send an authentication failure response
		http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req)); // if login is successful, just clear the flags asking for authentication
		http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED)); // if login fails, just send an authentication failure response
		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()); // if logout is successful, just send a success response
		return http.build();
	}
	
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
	}
}