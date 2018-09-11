package com.paiement.web.exception;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class PaiementErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(final String methodKey, final Response response) {

		final Exception exception = this.defaultErrorDecoder.decode(methodKey, response);
		final String message = new String(exception.getMessage());

		if (300 <= response.status() && response.status() <= 399) {

			return new Proxy3XXException(message);
		} else if (400 <= response.status() && response.status() <= 499) {

			return new Proxy4XXException(message);
		} else if (500 <= response.status() && response.status() <= 599) {

			return new Proxy5XXException(message);
		}

		return exception;
	}

}
