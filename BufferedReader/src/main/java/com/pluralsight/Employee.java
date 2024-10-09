package com.pluralsight;

public class Employee {

    private int employeeID;
    private String name;
    private float hoursWorked;
    private double payRate;


    public Employee(int employeeID, String name, float hoursWorked, double payRate){
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;

    }

    public double getGrossPay(){
        if (hoursWorked > 40) {
            float overtimeHours = hoursWorked - 40;
            return (payRate * 40) + (payRate * overtimeHours * 1.5);
        }
        else {
            return hoursWorked* payRate;
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }


}
