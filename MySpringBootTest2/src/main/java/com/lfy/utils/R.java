package com.lfy.utils;

import lombok.Data;

@Data
public class R {
    private int code;
    private Object data;
    private String msg;

    public R(){}

    public R(int code,Object data,String msg){
        this.code=code;
        this.data=data;
        this.msg=msg;
    }

    public R(int code,Object data){
        this.code=code;
        this.data=data;
    }

    public R(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

}
