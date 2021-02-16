package com.practice1;

public class Employee {
    private int age;
    private String name;
    private double salary;
    private String designation;
    protected String race;



    public static int NUMOBJ = 0; //global variable for all objects of this class;
                                        // Only one copy per class and that copy is shared among all objects.
                                            // can use "final" keyword to declare it as a constant
                                                //don't need an instance to invoke; refer by className.variableName
    public Employee()//default constructor
    {

    }
    public Employee(String n)//name assignment constructor
    {
        this.name = n;
        Employee.NUMOBJ++;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void printEmployee(){
        System.out.println("Name: "+ this.name);
        System.out.println("Age: "+ this.age);
        System.out.println("Designation: "+ this.designation);
        System.out.println("Salary: "+ this.salary);

    }
    public int getNUMOBJ()
    {
        return Employee.NUMOBJ;
    }
}
