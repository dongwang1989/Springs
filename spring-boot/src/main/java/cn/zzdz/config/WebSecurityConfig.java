package cn.zzdz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextRepository;

import cn.zzdz.repository.ContentRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.securityContext().securityContextRepository(createsecurity()).and().authorizeRequests()
				.antMatchers("/", "/hello/{param}", "/login", "/whoim", "/exception/{param}").permitAll().anyRequest()
				.authenticated().and().csrf().disable();
	}

	@Bean
	public SecurityContextRepository createsecurity() {
		return new ContentRepository();
	}
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.authenticationProvider(provider);
	// }
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(provider); }
	 */

}
