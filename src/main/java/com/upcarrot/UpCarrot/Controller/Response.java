package com.upcarrot.UpCarrot.Controller;


import lombok.Data;

@Data
public class Response {

    private Object data;
    private String status;

    public Response(Object object) {
        this.data = object;
        this.status = "success";
    }

    public Response() {

    }

    public static Response getErrorResponse(String message) {
        Response response = new Response();
        response.setStatus("error");
        response.setData(message);
        return response;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}