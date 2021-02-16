package com.practice1;

public class Engineer extends Employee{

    int vars = 3;
    public static int numObj = 0;
    private static int sNum = 24;
    public Engineer()//default constructor
    {
        System.out.println("Engineer default constructor ");
        Engineer.numObj++;
    }

    public Engineer(String n)
    {
        //Invocation of a superclass constructor must be the first line in the subclass constructor.
        super(n);//calls super class constructor with string argument
        Engineer.numObj++;
    }

///all public member functions of a class can access its private/public/protected variables/functions
    public void greet()
    {
        System.out.println("hello i am an engineer; # of Engineer objects: "+ numObj
                + " and Engineer's private static variable is "+ this.sNum);
    }
    ///variable arguments-
    public static void printmax(double... dubs )
    {
        double result = dubs[0];
        for(int i = 1; i< dubs.length; i++)
        {
            if(dubs[i] > result)
            {
                result = dubs[i];
            }
        }
        System.out.println("max number is "+ result);
    }

}
