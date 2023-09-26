package com.ktxdevelopment.siratumustakim.util.response;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.IOException;



@Getter
@Setter
public class  CustomResponseModel<T> {
    private final HttpStatus status;
    private final T data;
    private final RestError error;

    public CustomResponseModel(T data, HttpStatus status) {
        this.status = status;
        this.data = data;
        this.error = null;
    }

    public CustomResponseModel(RestError error, HttpStatus status) {
        this.status = status;
        this.error = error;
        this.data = null;
    }

    public CustomResponseModel(Throwable ex, HttpStatus status) {
        this.status = status;
        this.error = new RestError(ex.getClass().toString(), ex.getLocalizedMessage());
        this.data = null;
    }

    public CustomResponseModel(String errorTitle, String errorMessage, HttpStatus status) {
        this.status = status;
        this.error = new RestError(errorTitle,errorMessage);
        this.data = null;
    }

    public CustomResponseModel(T data) {
        this.data = data;
        this.error = null;
        this.status = HttpStatus.OK;
    }

    public CustomResponseModel(RestError error) {
        this.error = error;
        this.data = null;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public CustomResponseModel(HttpStatus httpStatus, T t, RestError restError) {
        this.status = httpStatus;
        this.data = t;
        this.error = restError;
    }

    static class CustomResponseModelSerializer<T> extends JsonSerializer<CustomResponseModel<T>> {
        @Override
        public void serialize(CustomResponseModel<T> value, JsonGenerator gen, SerializerProvider serializers)
                throws IOException {
            gen.writeStartObject();
            gen.writeStringField("status", value.getStatus().toString());
            gen.writeObjectField("data", value.getData());
            gen.writeObjectField("error", value.getError());
            gen.writeEndObject();
        }
    }

    static class CustomResponseModelDeserializer<T> extends JsonDeserializer<CustomResponseModel<T>> {
        @Override
        public CustomResponseModel<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            ObjectMapper mapper = (ObjectMapper) p.getCodec();
            JsonNode root = mapper.readTree(p);

            HttpStatus status = HttpStatus.valueOf(root.get("status").asText());
            T data = mapper.readValue(root.get("data").traverse(), new TypeReference<>() {});
            RestError error = mapper.readValue(root.get("error").traverse(), RestError.class);

            return new CustomResponseModel<>(status, data, error);
        }
    }
}
