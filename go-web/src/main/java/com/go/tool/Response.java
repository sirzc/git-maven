package com.go.tool;

import java.io.Serializable;

/**
 *
 * @ClassName: Response
 * @Description: 对公共部分进行封装
 * @author 作者：zhouchao
 * @date 创建时间：2017年4月23日 上午11:46:05
 * 
 * @param <T>
 */
public class Response<T> implements Serializable {
	
    private static final long serialVersionUID = 6138979130005367537L;
    private boolean success;
    private T result;	//T引用类型
    private String error;

    public Response() {
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public void setError(String error) {
        this.success = false;
        this.error = error;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * T值 获取引用类型值
     * @return
     */
    public T getResult() {
        return this.result;
    }

    public String getError() {
        return this.error;
    }
	
    public String toString() {
        return "Response(success=" + this.isSuccess() + ", result=" + this.getResult() + ", error=" + this.getError() + ")";
    }

}
