package src.person;

import src.sex.Sex;

public abstract class Person{
    protected String name;
    protected String dob;
    protected Sex sex;

    public Person(String name, String dob, Sex sex){
        this.name=name;
        this.dob=dob;
        this.sex=sex;
    }

    public abstract String getName();

    public abstract String getDOB();

    public abstract Sex getSex();

}
