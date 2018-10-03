package com.commerce.client.business.exception;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class ClientErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(final String methodKey, final Response response) {

		if (300 <= response.status() && response.status() <= 399) {

			return new Proxy3XXException("Multiple Choices");
		} else if (400 <= response.status() && response.status() <= 499) {

			return new Proxy4XXException("Bad Request");
		} else if (500 <= response.status() && response.status() <= 599) {

			return new Proxy5XXException("Internal Server Error");
		} else {

			return this.defaultErrorDecoder.decode(methodKey, response);
		}
	}
}
