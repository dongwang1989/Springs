package cn.zzdz.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import cn.zzdz.ErrorMessage;

@EnableConfigurationProperties(ErrorMessage.class)
public class Error extends RuntimeException {
	@Autowired
	private ErrorMessage message;
	private String values;

	public Error(ErrorMessage message, String... params) {
		for (String param : params) {
			this.values += param;
		}
		this.message = message;
		this.values += this.message.name();
	}

	@Override
	public String getMessage() {
		return values;
	}

}
