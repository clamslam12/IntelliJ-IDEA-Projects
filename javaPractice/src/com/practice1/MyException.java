package com.practice1;

public class MyException extends Exception{
    private double needAmount = 0;
    private double balance = 0;
    public void stmt(){
        System.out.println("calling from user defined exception");
    }



}
