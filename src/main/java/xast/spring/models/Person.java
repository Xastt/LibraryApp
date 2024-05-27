package xast.spring.models;

import javax.validation.constraints.*;

public class Person{
    private int id;

    @NotEmpty(message = "Enter your full name!")
    @Size(min = 10, max = 60, message = "Your name is too short!")
    private String fullName;

    @Min(value = 1900, message = "Your data born should be more than 1900!")
    private int data_born;

    public Person() {
    }

    public Person(String fullName, int data_born) {
        this.fullName = fullName;
        this.data_born = data_born;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public int getData_born(){
        return data_born;
    }
    public void setData_born(int data_born){
        this.data_born = data_born;
    }
}