package rest;

import org.apache.http.HttpStatus;

public class ApiException extends RuntimeException{
    private String code;
    private String description;
    private Integer statusCode = HttpStatus.SC_INTERNAL_SERVER_ERROR;

    public ApiException (String code,String description){
        this.code = code;
        this.description = description;
    }

    public ApiException (String code,String description, Integer statusCode){
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
