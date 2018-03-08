package cn.zzdz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("ContentRepository")
	private SecurityContextRepository scr;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.securityContext().securityContextRepository(scr).and().authorizeRequests()
				.antMatchers("/", "/hello/{param}", "/login", "/whoim").permitAll().anyRequest().authenticated().and()
				.csrf().disable();
	}

	// @Bean
	// public SecurityContextRepository pasecurity() {
	// System.out.println("这个方法中");
	// // keyizuoqitacaozuo与compent区别
	// return new ContentRepository();
	// }
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
