package cn.zzdz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // (exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class Run {
	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
}
