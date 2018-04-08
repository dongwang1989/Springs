package cn.zzdz;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ERROR")
@PropertySource("classpath:/enums.properties")
public enum ErrorMessage {
	INCORRECT_PASSWORD;
}
