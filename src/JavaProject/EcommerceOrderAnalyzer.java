package JavaProject;
import java.util.*;
import java.util.stream.Collectors;

class Order{
    private int orderId;
    private String customerName;
    private double amount;

    public Order(int orderId, String customerName, double amount)
    {
        this.orderId=orderId;
        this.customerName=customerName;
        this.amount=amount;
    }
    public int getOrderId(){
        return orderId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public double getAmount(){
        return amount;
    }
    @Override
    public String toString(){
        return orderId+" | "+customerName+" | "+amount;
    }
}
public class EcommerceOrderAnalyzer {
    public static void main(String[] args)
    {
        List<Order>orders=Arrays.asList(
                new Order(101,"Vaibhavi", 12000),
                new Order(102, "Tanaya",8000),
                new Order(102,"Vaibhavi",15000),
                new Order(104,"Samir",5000),
                new Order(105, "Pragati", 20000),
                new Order(106," Kirti", 9000)
        );
        System.out.println("=======ALL ORDERS=======");
        orders.forEach(System.out::println);
        System.out.println("\n========ORDERS ABOVE 10000======");
        orders.stream()
                .filter(order -> order.getAmount()>10000)
                .forEach(System.out::println);
        double totalSales= orders.stream()
                .map(Order::getAmount)
                .reduce(0.0, Double::sum);

        System.out.println("\n=========TOTAL SALES===========");
        System.out.println(totalSales);
        Optional<Order> topCustomer=orders.stream()
                .max(Comparator.comparing(Order::getAmount));
        System.out.println("\n=========TOP CUSTOMER============");
        topCustomer.ifPresent(System.out::println);

        System.out.println("ORDER GROUPED BY CUSTOMER");
        Map<String, Long> orderCount=orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName, Collectors.counting()));

        orderCount.forEach((customer, count)-> System.out.println(customer+" = "+count));
        System.out.println("\n==========CUSTOMER NAMES===========");
        List<String> customers=orders.stream()
                .map(Order::getCustomerName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        customers.forEach(System.out::println);
    }
}
