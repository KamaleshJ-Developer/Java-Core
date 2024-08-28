package Employees;

import java.util.function.Function;
import java.util.function.Predicate;

public class Admin {

    public static void main(String[] args) throws CloneNotSupportedException {
        Department depECE=new Department(201,"ECE");
        Department depEEE=new Department(201,"EEE");
        Employees.list.add(new Employees(002,"Dany",89,depECE));
        Employees.list.add(new Employees(003,"Thomas",96,depEEE));
        /** Employee list **/
        System.out.println(Employees.list);
        /** shallow Copy of a Object ** which copies only the primitive types **/
        System.out.println("Shallow Copy");
        Employees emp=(Employees) Employees.list.get(1).clone();
        emp.setEmp_id(8);
        depECE.setDep_id(203);
        emp.setDepartment(depECE);
        System.out.println(emp);
        System.out.println(Employees.list.get(1));

        /** Deep Copy of a Object which need to pass new object as a refernce to another**/
        System.out.println("Deep Copy");
        Department newDepartment= (Department) (Employees.list.get(1).getDepartment().clone());
        newDepartment.setName("MECH");
        Employees newemp=(Employees) Employees.list.get(1).clone();
        newemp.setName("Dhillip");
        newemp.setEmp_id(003);
        Function<Department,Boolean> function =department -> {
            newemp.setDepartment(department);
            return true;
        };
        function.apply(newDepartment);
        System.out.println(Employees.list.get(1));
        System.out.println(newemp);

        Predicate<Employees> predicate=Predicate.isEqual(newemp);
        System.out.println(predicate.test(Employees.list.get(1)));

    }
}
