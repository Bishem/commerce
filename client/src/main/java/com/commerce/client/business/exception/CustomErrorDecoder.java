package com.commerce.client.business.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;

import static feign.Util.toByteArray;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(final String methodKey, final Response response) {

        try {

            final HttpStatus statusCode = HttpStatus.valueOf(response.status());

            final String statusText = response.reason();

            final HttpHeaders responseHeaders = new HttpHeaders();
            response.headers().entrySet().stream().forEach(entry -> responseHeaders.put(entry.getKey(), new ArrayList<>(entry.getValue())));

            byte[] responseBody =  toByteArray(response.body().asInputStream());

            if (response.status() >= 400 && response.status() <= 499) {

                return new HttpClientErrorException(statusCode, statusText, responseHeaders, responseBody, null);
            } else if (response.status() >= 500 && response.status() <= 599) {

                return new HttpServerErrorException(statusCode, statusText, responseHeaders, responseBody, null);
            }

        } catch (final Exception e) {

            throw new RuntimeException("Failed to process response body : " + e.getClass().getName(), e);
        }

        return this.defaultErrorDecoder.decode(methodKey, response);
    }
}
