package com.centime.service.app.module.service.exception;

public class CustomException extends CustomClientException {
	private static final long serialVersionUID = 1L;
	
	public CustomException() {
		super();
	}

	
	public CustomException(Throwable t, String domain, String code, int status, String debugMessage,
			String clientMessage) {
		super(t, domain, code, status, debugMessage, clientMessage);
	}

	public CustomException(Throwable t, String domain, String code, int status, String debugMessage,
			String clientMessage, String moreInfoLink) {
		super(t, domain, code, status, debugMessage, clientMessage, moreInfoLink);
	}


	public CustomException(String domain, String code, int status, String debugMessage, String clientMessage) {
		super(domain, code, status, debugMessage, clientMessage);
	}

		public CustomException(String domain, String code, int status, String debugMessage, String clientMessage,
			String moreInfoLink) {
		super(domain, code, status, debugMessage, clientMessage, moreInfoLink);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		builder.append(" {\n\t");
		if (domain != null) {
			builder.append("domain: ");
			builder.append(domain);
			builder.append("\n\t");
		}
		if (code != null) {
			builder.append("code: ");
			builder.append(code);
			builder.append("\n\t");
		}
		builder.append("status: ");
		builder.append(status);
		builder.append("\n\t");
		if (debugMessage != null) {
			builder.append("debugMessage: ");
			builder.append(debugMessage);
			builder.append("\n\t");
		}
		if (clientMessage != null) {
			builder.append("clientMessage: ");
			builder.append(clientMessage);
			builder.append("\n\t");
		}
		if (moreInfoLink != null) {
			builder.append("moreInfoLink: ");
			builder.append(moreInfoLink);
			builder.append("\n\t");
		}
		if (errors != null && !errors.isEmpty()) {
			builder.append("errors: ");
			builder.append(errors);
		}
		builder.append("\n}");
		return builder.toString();
	}

	
}