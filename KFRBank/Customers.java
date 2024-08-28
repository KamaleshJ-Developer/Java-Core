package KFRBank.KFRBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Customers {

    private int cut_id;
    private String customer_name;
    private double current_balance;
    private String email;
    private int age;
    private Loan Loan;
    private int loanBalance;
    private List<Loan> loans = new ArrayList<>();
    private long salary;
    private String[] loanTypes = {"StudyLoan", "Two-Wheeler Loan", "Four-WheelerLoan", "PersonalLoan", "HousingLoan"};
    private int loanCount = 0;

    private class Loan {

        private int id;
        private long principleAmount;
        private int duration;
        private double simpleInterest;
        private float rateOfInterest;
        private String loanType;

        public Loan(int id, long principleAmount, int duration, double simpleInterest, float rateOfInterest, String loanType) {
            this.id = id;
            this.principleAmount = principleAmount;
            this.duration = duration;
            this.simpleInterest = simpleInterest;
            this.rateOfInterest = rateOfInterest;
            this.loanType = loanType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getPrincipleAmount() {
            return principleAmount;
        }

        public void setPrincipleAmount(long principleAmount) {
            this.principleAmount = principleAmount;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public double getSimpleInterest() {
            return simpleInterest;
        }

        public void setSimpleInterest(double simpleInterest) {
            this.simpleInterest = simpleInterest;
        }

        public float getRateOfInterest() {
            return rateOfInterest;
        }

        public void setRateOfInterest(float rateOfInterest) {
            this.rateOfInterest = rateOfInterest;
        }

        public String getLoanType() {
            return loanType;
        }

        public void setLoanType(String loanType) {
            this.loanType = loanType;
        }

        @Override
        public String toString() {
            return "Loan{" +
                    "id=" + id +
                    ", principleAmount=" + principleAmount +
                    ", duration=" + duration +
                    ", simpleInterest=" + simpleInterest +
                    ", rateOfInterest=" + rateOfInterest +
                    ", loanType='" + loanType + '\'' +
                    '}';
        }
    }

    public Customers(int cut_id, String customer_name, int age, String email, long salary) {
        this.cut_id = cut_id;
        this.customer_name = customer_name;
        this.age = age;
        this.email = email;
        this.salary = salary;
    }

    public String newLoan() {
        while (true) {
            int id;
            long principleAmount;
            int duration;
            double simpleInterest;
            float rateOfInterest = 0;
            String loanType;
            Scanner sc = new Scanner(System.in);
            double loanEligibile = this.checkEligibility();
            while (true) {
                System.out.println("Eligible loan amount is=" + loanEligibile);
                System.out.println("Please enter amount you looking for :");
                principleAmount = sc.nextLong();
                if (principleAmount >= loanEligibile) {
                    System.out.println("Enter the loanAmount less than:" + loanEligibile);
                    continue;
                }
                break;
            }

            while (true) {
                System.out.println("Chose the duration of years");
                duration = sc.nextInt();
                if (duration > 1 && duration < 25) {
                    break;
                } else {
                    System.out.println(duration + "Year's is not applicable chose the duration between 1 - 25");
                    continue;
                }
            }

            while (true) {
                System.out.println("Please enter the what kind of Loan you seeking for:" + Arrays.toString(loanTypes));
                loanType = sc.next();
                if (loanType.equalsIgnoreCase("StudyLoan")) {
                    rateOfInterest = checkRateOfInterest(principleAmount);
                    break;
                }
                if (loanType.equalsIgnoreCase("Two-WheelerLoan")) {
                    rateOfInterest = checkRateOfInterest(principleAmount) + 1;
                    break;
                }
                if (loanType.equalsIgnoreCase("Four-WheelerLoan")) {
                    rateOfInterest = checkRateOfInterest(principleAmount) + 1;
                    break;
                }
                if (loanType.equalsIgnoreCase("PersonalLoan")) {
                    rateOfInterest = checkRateOfInterest(principleAmount) + 1;
                    break;
                }
                if (loanType.equalsIgnoreCase("HousingLoan")) {
                    rateOfInterest = checkRateOfInterest(principleAmount) - 1;
                    break;
                }
                if (loanType.equalsIgnoreCase("BusinessLoan")) {
                    rateOfInterest = checkRateOfInterest((long) current_balance) - 1;
                    break;
                } else {
                    System.out.println("Enter the valid LoanType");
                    continue;
                }
            }
            simpleInterest = calculateSimpleInterest(principleAmount, rateOfInterest, duration);
            Loan newLoan = new Loan(Integer.valueOf(cut_id + "" + (++loanCount)), principleAmount, duration, simpleInterest, rateOfInterest, loanType);
            loans.add(newLoan);
            return status(newLoan);
        }
    }

    public List<Customers.Loan> loanstatus() {
        return loans;
    }

    private String status(Loan newLoan) {
        return newLoan.getLoanType();
    }

    private double calculateSimpleInterest(long principleAmount, float rateOfInterest, int duration) {
        return (principleAmount * rateOfInterest * duration) / 100;
    }


    private float checkRateOfInterest(long principleAmount) {
        if (principleAmount < 500000) {
            return 11;
        }
        if (principleAmount >= 500000 && principleAmount <= 1000000) {
            return 13;
        }
        if (principleAmount > 1000000 && principleAmount <= 2000000) {
            return 15;
        }
        if (principleAmount > 2000000 && principleAmount < 5000000) {
            return 18;
        }
        return 20;
    }

    public double checkEligibility() {
        return loanCalculator();
    }

    private double loanCalculator() {
        if (this.age < 18) {
            return 0;
        }
        if (this.age >= 18 && this.age <= 50) {
            return this.salary * 2;
        }
        if (this.age > 50 && this.age <= 60) {
            return this.salary * 1.5;
        }
        return 0;
    }

    public int getCut_id() {
        return cut_id;
    }

    public void setCut_id(int cut_id) {
        this.cut_id = cut_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(double current_balance) {
        this.current_balance = current_balance;
    }

    public Customers.Loan getLoan() {
        return Loan;
    }

    public void setLoan(Customers.Loan loan) {
        Loan = loan;
    }

    public int getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(int loanBalance) {
        this.loanBalance = loanBalance;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }
}
