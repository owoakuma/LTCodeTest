package Object;

import java.util.Objects;

public class Employee implements Cloneable{
    public Employee(String name, double salary, int seniority) {
        this.name = name;
        this.salary = salary;
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return name+" "+salary+" "+seniority;
    }

    public Employee(){
        this.name="null";
        this.salary=0;
        this.seniority=0;
    }

    public boolean equals(Object rhs) {//判断是否相等
        return rhs instanceof Employee && ((Employee) rhs).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Employee newEmployee=(Employee) super.clone();
        return newEmployee;
    }

    private String name;
    private double salary;
    private int seniority;
}
