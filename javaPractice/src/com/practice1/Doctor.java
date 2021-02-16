package com.practice1;

public class Doctor extends Employee{
    private int favNum = 24;
    public static int numObj = 0;
    public static void hello()///static method; Don't need to be instantiated to invoke;one copy is shared among all objects of the class, just like variables
    {

        System.out.println("Testing static method");
    }
    public Doctor(){}//default constructor

    public Doctor(String n)
    {
        //Invocation of a superclass constructor must be the first line in the subclass constructor.
        super(n);//calls super class constructor with string argument
        Doctor.numObj++;
    }


    public void greet(int favNum)
    {

        System.out.println("Instance variable (this.favNum) of this object is "+ this.favNum);
        System.out.println("Local variable (favNum) of this object is "+ favNum);

    }
    public void gb()
    {
        System.out.println("goodbye");
    }


}
