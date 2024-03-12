package com.hut.kenny.util;

public class ReturnValue {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_NOTFOUND = 404;
    public static final int STATUS_INTERNAL_ERROR = 500;
    public static final int STATUS_PARAM_ERROR = 400;
    public static final int STATUS_PERMISSION_ERROR = 401;


    /** 返回的数据 */
    private Object data;
    /** 返回的状态 成功：200, 找不到资源：404, 异常错误：500, 没有权限：401, 请求参数解析错误：400   业务错误可以在10000号以后*/
    private int status;
    private String message = "成功";
    private boolean isImage = false;

    public ReturnValue() {}

    public ReturnValue(String message) {
        this.message = message;
    }

    public ReturnValue(Object data) {
        this.status = 1;
        this.data = data;
    }

    public ReturnValue(Object data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    /**
     * 返回成功
     * @param data
     * @return
     */
    public ReturnValue success(Object data){
        this.status = 200;
        this.data = data;
        this.setMessage("成功");
        return this;
    }

    public ReturnValue returnSuccess(){
        return success(null);
    }

    public ReturnValue returnFail(String message){
        this.status = -1;
        this.message = message;
        return this;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReturnValue{" +
                "data=" + data +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }
}
