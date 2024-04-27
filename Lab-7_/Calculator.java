package com.unique;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Calculator")
public class Calculator {

    @WebMethod(operationName = "getNumber")
    public int getNumber(@WebParam(name = "num1") int num1, @WebParam(name = "num2") int num2) {
        int sum = num1 + num2;
        return sum;
    }
}
