package cn.zzdz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextRepository;

import cn.zzdz.repository.ContentRepository;

@Configuration
@EnableWebSecurity // 代理 不可能 weishenme 优先于aop 编译 运行时 为什么spring spring的拦截器是个什么
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.securityContext().securityContextRepository(createsecurity()).and().authorizeRequests()
				.antMatchers("/", "/hello/{param}", "/login", "/whoim", "/whoim2", "/exception/{param}").permitAll()
				.anyRequest().authenticated().and().csrf().disable();
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
