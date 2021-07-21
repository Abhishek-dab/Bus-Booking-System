package labfinal;
import java.util.Scanner;

class BusBook {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name, from = "", to = "";
        int age, passengers, route, cost = 0;
        try {
            while (true) {

               
                System.out.println("\n\nWelcome to Bus Ticket Booking System\n");
                
                System.out.print("Enter your name: ");
                name = sc.next();

                System.out.print("Enter your age: ");
                age = sc.nextInt();

                System.out.print("\nYour ticket booking process starts now..\n");

                System.out.print("\nEnter number of passengers: ");
                passengers = sc.nextInt();

                int[] arr_cost = { 125, 150, 400, 300, 200, 550, 450, 225, 325 };
                String[] arr_from = { "Vijayawada", "Hyderabad", "Banglore", "Chennai", "Nellore", "Vijayawada",
                        "Mysore", "Rajahmundry", "Madhurai" };
                String[] arr_to = { "Guntur", "Vijayawada", "Chennai", "Pune", "Hyderabad", "Pune", "Puducherry",
                        "Vishakapatnam", "Manali" };

                System.out.println("\n Services we provide");

                for (int i = 0; i < arr_cost.length; i++) {
                    System.out.println("[Route " + (i + 1) + "] " + arr_from[i] + "-> " + arr_to[i]);
                }

                System.out.print("\nSelect the route you want to travel by: ");
                route = sc.nextInt();

                cost = arr_cost[route - 1];
                from = arr_from[route - 1];
                to = arr_to[route - 1];

                Processing pr = new Processing();
                pr.input(age, name);
                pr.compute(passengers, route, cost);

                System.out.print("\nEnter Y to continue N to stop booking: ");
                char letter;
                letter = sc.next().charAt(0);
                switch (letter) {
                 
                    case 'Y':
                        pr.seat();
                        pr.display(from, to);
                        char again;
                        System.out.print("Would you like another ticket? [Y/N] : ");
                        again = sc.next().charAt(0);
                        switch (again) {
                            
                            case 'Y':
                                break;

                         
                           case 'N':
                                System.out.print("\nBooking successfully completed..!\t\n\n");
                                return;
                        }
                        break;

                
                    case 'N':
                        System.out.print("\nBooking cancelled..!\t\n");
                        break;
                        
                     default:
                    	 System.out.print("\nBooking cancelled..!\t\n");
                         break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("\n\nIncorrect data entered..!\n");
        }
        finally {
           
            sc.close();
        }
    }
}