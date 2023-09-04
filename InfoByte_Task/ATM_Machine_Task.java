package InfoByte_Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

interface ATM {

    void withdrawing(double amount);
    void depositing(double amount);
    void checkingBalance();
    void Transation();

}

class userAccount implements ATM {


    double value = 0;

    boolean transaltion = true;

    String[] arr = new String[]{"withdrawing","Deposit"};

    ArrayList<String> tran = new ArrayList<>();

    ArrayList<Integer> day = new ArrayList<>();
    ArrayList<Integer> month = new ArrayList<>();
    ArrayList<Integer> year = new ArrayList<>();
    ArrayList<Integer> hour = new ArrayList<>();
    ArrayList<Integer> min = new ArrayList<>();
    ArrayList<Integer> sec = new ArrayList<>();
    ArrayList<Double> sum =new ArrayList<>();

    @Override
    public void Transation() {
        for (int i =0;i< day.size();i++) {
            if (transaltion) {
                System.out.println(sum.get(i) + " is " + tran.get(i) + " on Date: " + day.get(i) + "/" + month.get(i) + "/" + year.get(i)+" And Time is: " + hour.get(i) + ":" + min.get(i) + ":" + sec.get(i));

            } else {
                System.out.println(sum.get(i) + " is " + tran.get(i) + " on " + day.get(i) + "/" + month.get(i) + "/" + year.get(i)+" Time is: " + hour.get(i) + ":" + min.get(i) + ":" + sec.get(i));
            }
        }
    }

    @Override
    public void withdrawing(double amount) {

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();

        if (amount<=value){

            value = value - amount;
            System.out.println("Successfully Withdraw amount of "+amount);
            System.out.println("Rest Balance in your account is: "+value);
            transaltion = false;
            sum.add(amount);
            day.add(ld.getDayOfMonth());
            month.add(ld.getMonthValue());
            year.add(ld.getYear());
            tran.add(arr[0]);
            hour.add(lt.getHour());
            min.add(lt.getMinute());
            sec.add(lt.getSecond());
            System.out.println("Thank You...");

        }else {

            System.out.println("You have not sufficient balance in your account for withdrawal...");
            System.out.println("Balance in your account is: "+value);
            System.out.println("Thank You...");

        }
    }

    @Override
    public void depositing(double amount) {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();

        value = value + amount;
        System.out.println("Successfully Deposit "+amount+" Amount in your Account...");
        System.out.println("Total amount in your account is: "+value);
        transaltion = true;
        sum.add(amount);
        day.add(ld.getDayOfMonth());
        month.add(ld.getMonthValue());
        year.add(ld.getYear());
        tran.add(arr[1]);
        hour.add(lt.getHour());
        min.add(lt.getMinute());
        sec.add(lt.getSecond());
        System.out.println("Thank You...");

    }

    @Override
    public void checkingBalance() {

        System.out.println("Total Balance in your account is: "+value);
        System.out.println("Thank You...");

    }
}

class ProcessPart {

    userAccount am = new userAccount();
    Scanner sc = new Scanner(System.in);
    int a;
    double amount;
    public void process(){

        System.out.println("Enter Number.....");
        System.out.print("Create a PIN Number for Your ATM: ");
        int createPin = sc.nextInt();
        System.out.println("...................................");
        System.out.print("Enter Your ATM PIN: ");
        int pinEnter = sc.nextInt();

        if (createPin==pinEnter) {

            try {
                do {

                    System.out.print("1.Depositing the amount\n2.Withdraw the amount\n3.Checking Balance\n4.Translation\nEnter Your Choice: ");
                    int choice = sc.nextInt();
                    // using enhance switch case
                    switch (choice) {
                        case 1 -> {
                            System.out.println("...................................");
                            System.out.print("Enter Deposit Amount: ");
                            amount = sc.nextDouble();
                            am.depositing(amount);
                            System.out.println("...................................");
                        }
                        case 2 -> {
                            System.out.println("...................................");
                            System.out.print("Enter Amount to withdraw in your account: ");
                            double withrow = sc.nextDouble();
                            am.withdrawing(withrow);
                            System.out.println("...................................");
                        }
                        case 3 -> {
                            System.out.println("...................................");
                            am.checkingBalance();
                            System.out.println("...................................");
                        }
                        case 4 -> {
                            System.out.println("...................................");
                            System.out.println("Translation list is");
                            am.Transation();
                            System.out.println("Total amount in your account is: " + am.value);
                            System.out.println("...................................");
                        }

                        default -> {
                            System.out.println("...................................");
                            System.out.println("Please Choice one of the options...");
                            System.out.println("...................................");
                        }

                    }
                    System.out.print("Enter 1 if you want to run once's again otherwise press any other number key: ");
                    a = sc.nextInt();

                } while (a == 1);

                System.out.print("Successfully Exit to the ATM Machine.\nThank You...");

            } catch (Exception exception) {

                System.out.println("...................................");
                System.out.println("Your ATM card is crash because of your wrong key enter...");
                System.out.print("...................................");

            }

        }else{
            System.out.print("Wrong PIN...");
        }
    }
}

public class ATM_Machine_Task  {
    public static void main(String[] args) {

        // Creating the object of the process class...

        ProcessPart p = new ProcessPart();
        p.process(); // call the method...

    }
}

