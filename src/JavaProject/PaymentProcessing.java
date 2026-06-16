package JavaProject;

import java.util.*;

interface payment{
    void pay(Double amount);
}
enum PaymentType{
    UPI,
    CARD,
    NETBANKING
}
class UPI implements payment{
    private String upiId;
    public UPI(String upiId)
    {
        this.upiId=upiId;
    }
    @Override
    public void pay(Double amount) {
        System.out.println("UPI Payment Successful");
        System.out.println("Enter UPI ID: " + upiId);
        System.out.println("Amount: " + amount);
    }
    public void verifyUPI() {
        System.out.println("UPI Verified");
    }
}

class Card implements payment {
    private String cardNumber;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(Double amount) {
        System.out.println("Card Payment Successful");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount: " + amount);
    }

    public void checkCardType() {
        System.out.println("Visa Card Detected");
    }
}

class NetBanking implements payment {
    private String bankName;

    public NetBanking(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(Double amount) {
        System.out.println("Net Banking Payment Successful");
        System.out.println("Bank: " + bankName);
        System.out.println("Amount: " + amount);
    }

    public void loginBank() {
        System.out.println("Bank Login Successful");
    }
}
public class PaymentProcessing
{
    private static Double amount;

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Select payment method");
        System.out.println("1.UPI");
        System.out.println("2.Card");
        System.out.println("3.Net Banking");

        int select=sc.nextInt();
        sc.nextLine();
        payment paymt=null;
        switch (select){
            case 1:
                System.out.print("Enter UPI Id: ");
                String upiId=sc.nextLine();
                paymt=new UPI(upiId);
                break;

            case 2:
                System.out.print("Enter Card Number: ");
                String cardNumber=sc.nextLine();
                paymt=new Card(cardNumber);
                break;

            case 3:
                System.out.print("Enter Bank Name: ");
                String bankName = sc.nextLine();

                paymt = new NetBanking(bankName);
                break;

            default:
                System.out.println("Invalid Choice");
                System.exit(0);
        }
        System.out.print("Enter Amount: ");
        amount = sc.nextDouble();
        paymt.pay(amount);

        System.out.println("\n--- Downcasting & instanceof ---");
        if(paymt instanceof UPI) {
            UPI u = (UPI) paymt;
            u.verifyUPI();
        }
        else if(paymt instanceof Card) {
            Card c = (Card) paymt;
            c.checkCardType();
        }
        else if(paymt instanceof NetBanking) {
            NetBanking n = (NetBanking) paymt;
            n.loginBank();
        }
        sc.close();
    }
}
