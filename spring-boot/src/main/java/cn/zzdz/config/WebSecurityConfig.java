package cn.zzdz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// @Autowired
	// @Qualifier("ContentRepository")
	// private SecurityContextRepository contentrepository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.securityContext().securityContextRepository(pasecurity()).and().authorizeRequests()
				.antMatchers("/", "/hello/{param}", "/login", "/logins", "/whoim").permitAll().anyRequest()
				.authenticated();
		// .and()
		// .logout().permitAll()// 定义logout不需要验证
		// .and().formLogin();// 使用form表单登录 ;
	}

	@Bean
	public SecurityContextRepository pasecurity() {
		return new HttpSessionSecurityContextRepository();

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
