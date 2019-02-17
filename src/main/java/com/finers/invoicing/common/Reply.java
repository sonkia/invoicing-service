package com.finers.invoicing.common;

import java.io.Serializable;

/**
 * @author finers
 * @remark Reply封装类
 */
public final class Reply implements Serializable {
    private Boolean success;
    private Integer code;
    private String message;
    private Object data;
    private Object option;

    public Reply() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getOption() {
        return option;
    }

    public void setOption(Object option) {
        this.option = option;
    }
}