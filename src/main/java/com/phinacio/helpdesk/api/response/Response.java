package com.phinacio.helpdesk.api.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro.inacio on 23/04/2019.
 */
public class Response<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        if(this.errors == null){
            this.errors = new ArrayList<String>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    private List<String> errors;


}
