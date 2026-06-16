package JavaProject;
import java.util.*;

class InavlidamountException extends Exception{
    public InavlidamountException(String message){git remote remove origin
        super(message);
    }
}
class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message)
    {
        super(message);
    }
}
class AccountNotFoundException extends Exception{
    AccountNotFoundException(String message)
    {
        super(message);
    }
}
class BankAccount{
    List<Integer> accountNo=Arrays.asList(101, 102,103,104,105,106,107,108,109);
    double balance=500000;

    public void withdraw(int accNo, double amount)
            throws InavlidamountException,InsufficientBalanceException,
            AccountNotFoundException{
        Scanner sc = new Scanner(System.in);
            if(!accountNo.contains(accNo))
            {
                throw new AccountNotFoundException("Account Not Found!");
            }
            if (amount <= 0)
            {
                throw new InavlidamountException("Enter Valid Amount");
            }
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient Balance.... current balannce is " + balance);
            }
            balance=balance-amount;
            System.out.println("Amount Withdraw Successfully");
            System.out.println("Avaliable acount balance is: "+balance);
        }

        public void deposit(int accNo, double amount)
            throws InavlidamountException,AccountNotFoundException{
        if(amount<=0)
        {
            throw new InavlidamountException("Enter valid amount");
        }
        balance=balance+amount;
        System.out.println("Amount Deposited successfully");
        System.out.println("Avaliable balance: "+balance);
        }
}
public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount obj = new BankAccount();
        try {
            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();
            if(!obj.accountNo.contains(accNo))
            {
                throw new AccountNotFoundException("Account not found");
            }
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.print("Choose Option: ");
            int choice = sc.nextInt();
            if (choice != 1 && choice != 2)
            {
                System.out.println("Please select valid option");
                return;
            }
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            if (choice == 1) {
                obj.deposit(accNo, amount);
            } else {
                obj.withdraw(accNo, amount);
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter numeric values only.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    finally {
            System.out.println("Thank You For Using Banking Application");
            sc.close();
        }
    }
}


