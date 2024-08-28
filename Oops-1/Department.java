package Employees;

import java.util.concurrent.atomic.AtomicLongArray;

public class Department implements Cloneable {

    private int dep_id;
    private String name;

    public Department(int dep_id, String name) {
        this.dep_id = dep_id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Department{" +
                "dep_id=" + dep_id +
                ", name='" + name + '\'' +
                '}';
    }
}
