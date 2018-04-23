package cn.zzdz.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import cn.zzdz.dto.ResultDto;
import cn.zzdz.enums.ErrorMessage;

public class Error extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String values;
	@Autowired
	private MessageSource ms;

	public Error(ErrorMessage message, String... params) {

		values = ms.getMessage(message.toString(), params, null);
	}

	@Override
	public String getMessage() {
		ResultDto resultdto = new ResultDto();
		resultdto.setResult(values);
		return resultdto.toString();
	}

}
