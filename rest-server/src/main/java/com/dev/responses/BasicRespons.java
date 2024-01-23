package com.dev.responses;

public class BasicRespons {
    private boolean success;
    private Integer errorCode;

    public BasicRespons(boolean success, Integer errorCode) {
        this.success = success;
        this.errorCode = errorCode;
    }

    public BasicRespons() {
        this.success = false;
        this.errorCode = null;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
