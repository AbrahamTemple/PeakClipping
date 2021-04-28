package com.spring.msadmin.exception;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.4.29
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
public class OrderException extends RuntimeException{

    public OrderException() {
        super();
    }

    public OrderException(String message) {
        super(message);
    }
}
