package KFRBank.KFRBank;

import LoanDeatils.Customers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CustomerService {

    static final String BANKNAME="KFR";
    static Scanner sc=new Scanner(System.in);
    static List<LoanDeatils.Customers> customersList=new ArrayList<>();
    public static void main(String[] args) {

        customersList.add(new LoanDeatils.Customers(001,"Kamalesh",23,"kamaleshkamal5432@gmail.com",30000));
        CustomerService customerService=new CustomerService();
        System.out.println("Please Enter your customer_id");
        int customer_id=sc.nextInt();
        Function<Integer, LoanDeatils.Customers> findCustomer= (id) ->{
            for(LoanDeatils.Customers customers:customersList){
                if(customers.getCut_id()==id){return customers;}
            }
            return null;
        };
        LoanDeatils.Customers temp=findCustomer.apply(customer_id);
        System.out.println(temp==null?"Customer Not Found please enter the valid Id":"Hello,"+temp.getCustomer_name()+
                " Welcome to "+BANKNAME+ " " +
                "Bank " + " how may I assist you");
        String input=sc.next();
        if(input.equalsIgnoreCase("newLoan")){
           customerService.newLoan(temp);
        }
    }

    private void newLoan(Customers customer) {
        String status=customer.newLoan();
        System.out.println("Hi,"+customer.getCustomer_name()+" "+" Your Loan "+ status +"is Approved");
        if(status!=null){
            System.out.println(customer.loanstatus());
        }else{
            System.out.println("Loan Rejected");
        }
    }

}
