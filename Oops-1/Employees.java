package Employees;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Employees implements  Cloneable{

    private int emp_id;
    private String name;
    private float marks;
    private Department department;
    static List<Employees> list= new LinkedList<>();
    public Employees(int emp_id, String name, float marks,Department department) {
        this.emp_id = emp_id;
        this.name = name;
        this.marks = marks;
        this.department=department;
    }

    static{
        list.add(new Employees(001,"Kamalesh",98,new Department(202,"CSE")));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }
    public Department getDepartment() {
        return department;
    }
    public <T> void setDepartment(Department department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Employees{" +
                "emp_id=" + emp_id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", department=" + department +
                '}';
    }
}
