package com.api.produto.model;

public class ResponseModel {
    private String message;
    private ProductModel productUsed;
    private Exception error;

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    public ProductModel getProductUsed() {
        return this.productUsed;
    }

    public void setProductUsed(ProductModel productUsed) {
        this.productUsed = productUsed;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
