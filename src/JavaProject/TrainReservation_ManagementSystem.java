package JavaProject;
import java.util.*;

class Passenger{
    int ticketId;
    String name;
    int age;

    Passenger(int ticketId, String name, int age)
    {
        this.ticketId=ticketId;
        this.name=name;
        this.age=age;
    }
    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                ", Name: " + name +
                ", Age: " + age;
    }
}
class AgeComparator implements Comparator<Passenger>
{
    public int compare(Passenger p1, Passenger p2)
    {
        return p2.age- p1.age;
    }
}
public class TrainReservation_ManagementSystem
{
    static ArrayList<Passenger> passengers=new ArrayList<>();
    static HashSet<Integer> ticketIds=new HashSet<>();
    static HashMap<Integer,Passenger> ticketMap=new HashMap<>();
    static  Queue<Passenger> waitingList=new LinkedList<>();

    static PriorityQueue<Passenger> seniorCitizens=new PriorityQueue<>(new AgeComparator());
    static TreeMap<Integer, Passenger> reservationChart=new TreeMap<>();
    static  Scanner sc=new Scanner(System.in);

    public static void BookTicket(){
        System.out.print("Enter Ticket ID: ");
        int ticketId=sc.nextInt();
        sc.nextLine();
        if(ticketIds.contains(ticketId))
        {
            System.out.println("Ticket ID alrady exists!");
            return;
        }
        System.out.print("Enter Passenger Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Passanger Age: ");
        int age=sc.nextInt();
        Passenger p=new Passenger(ticketId, name, age);

        passengers.add(p);
        ticketIds.add(ticketId);
        ticketMap.put(ticketId, p);
        reservationChart.put(ticketId,p);

        if(age>=60)
        {
            seniorCitizens.offer(p);
        }
        System.out.println("Ticket Booked Successfully!");
    }
    public static void cancleTicket(){
        System.out.print("Enter ticketID to cancle: ");
        int ticketId=sc.nextInt();
        Passenger p=ticketMap.get(ticketId);
        if(p==null)
        {
            System.out.println("Ticket not found!");
            return;
        }
        passengers.remove(p);
        ticketIds.remove(ticketId);
        ticketMap.remove(ticketId);
        reservationChart.remove(ticketId);
        System.out.println("Ticket Cancle successfully!");
    }
    public static void searchPassenger(){
        System.out.print("Enter TicketID: ");
        int ticketId=sc.nextInt();
        Passenger p=ticketMap.get(ticketId);
        if(p!=null)
        {
            System.out.println(p);
        }else{
            System.out.println("Passenger NOT found");
        }
    }
    public static void displayReservations()
    {
        if(reservationChart.isEmpty()){
            System.out.println("No reservation found!");
            return;
        }
        System.out.println("\n==========Reservation Chart===========");
        for(Map.Entry<Integer,Passenger> entry:reservationChart.entrySet()){
            System.out.println(entry.getValue());
        }
    }
    public static void addToWaitingList()
    {
        System.out.println("Enter ticketID: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name=sc.nextLine();
        System.out.println("Enter Age: ");
        int age=sc.nextInt();

        Passenger p=new Passenger(id, name, age);
        waitingList.offer(p);
        System.out.println("Added to Waiting List!");
    }
    public static void showWaitingList()
    {
        if(waitingList.isEmpty())
        {
            System.out.println("Waiting list is empty!");
            return;
        }
        System.out.println("\n========Waiting List========");
        for(Passenger p:waitingList)
        {
            System.out.println(p);
        }
    }
    public static void showSeniorCitizens(){
        if(seniorCitizens.isEmpty())
        {
            System.out.println("No senior citizens!");
            return;
        }
        PriorityQueue<Passenger> temp=new PriorityQueue<>(seniorCitizens);
        System.out.println("\n=========Senior Citizens Priority List=========");
        while(!temp.isEmpty()){
            System.out.println(temp.poll());
        }
    }
    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("\n===== Train Reservation System =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Search Passenger");
            System.out.println("4. Display Reservation Chart");
            System.out.println("5. Add To Waiting List");
            System.out.println("6. Show Waiting List");
            System.out.println("7. Show Senior Citizens");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BookTicket();
                    break;

                case 2:
                    cancleTicket();
                    break;

                case 3:
                    searchPassenger();
                    break;

                case 4:
                    displayReservations();
                    break;

                case 5:
                    addToWaitingList();
                    break;

                case 6:
                    showWaitingList();
                    break;

                case 7:
                    showSeniorCitizens();
                    break;

                case 8:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
