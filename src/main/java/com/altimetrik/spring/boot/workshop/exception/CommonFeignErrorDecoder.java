package com.altimetrik.spring.boot.workshop.exception;

import com.altimetrik.spring.boot.workshop.model.PartResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

import static feign.FeignException.errorStatus;

public class CommonFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        PartResponse partResponse;
        if(response.status() >= 400 && response.status() <=599){
            ObjectMapper mapper = new ObjectMapper();
            try {
                JSONObject jsonObject = getJsonObject(response);
                partResponse = mapper.readValue(jsonObject.toString(), PartResponse.class);
                throw new WorkshopException(partResponse.getMessage(), HttpStatus.valueOf(Integer.valueOf(partResponse.getHttpStatus())));
            } catch (IOException e) {
                throw new WorkshopException(String.format("Error with status %s reading %s response : %s", response.status(), methodKey, response.body().toString()), HttpStatus.valueOf(response.status()));
            }
        }
        return errorStatus(methodKey, response);
    }

    private JSONObject getJsonObject(Response response) throws IOException {
        String errorMessage = null;
        if(!Objects.isNull(response.body())) {
            errorMessage = Util.toString(response.body().asReader());
        }
        return new JSONObject(errorMessage);
    }

}
