package cn.zzdz.error;

import cn.zzdz.dto.ResultDto;

public class Error extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String values;

	public Error(@SuppressWarnings("rawtypes") final Enum message, final String... params) {

		values = MessageSourceHolder.getMessageSource().getMessage(message.toString(), params, null);
	}

	@Override
	public String getMessage() {
		final ResultDto resultdto = new ResultDto();
		resultdto.setResult(values);
		return resultdto.toString();
	}

}
