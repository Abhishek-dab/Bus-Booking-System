package labfinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Processing {
    String name, from, to;
    ArrayList<String> seatsBooked = new ArrayList<String>();
    int age, passengers, route, cost;
    Scanner scanner = new Scanner(System.in);

    public void input(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void compute(int passengers, int route, int cost) {
        this.passengers = passengers;
        this.route = route;
        this.cost = cost;
        System.out.println("Cost per Ticket: " + cost);
    }

    public void seat() {

        System.out.println("\nSelect the seats which you would like to travel by");
        int[][] a = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println("\n  Front           Back\n ");
        System.out.println("   1 2 3 4 5 6 7 8 9 10\n");
        for (int i = 0; i < a.length; ++i) {
            if (i == 0) System.out.print("A ");
            else if (i == 1) System.out.print("B ");
            else if (i == 2) System.out.print("C ");
            else if (i == 3) System.out.print("D ");
            for(int j = 0; j < a[i].length; ++j) {
                System.out.print(" " + a[i][j]);
            }
            if (i %2 != 0) System.out.println();
            System.out.println();
        }

        for(int k = 0; k < passengers; k ++) {
            System.out.print("\nChoose the row of the seat " + (k + 1) + " [A/B/C/D] : ");
            char rA = scanner.next().charAt(0);
            System.out.print("Choose the column of the seat " + (k + 1) + " [1-10]: ");
            int c = scanner.nextInt();
            int r = 0;
            if (rA == 'A' || rA == 'a') r = 1;
            else if (rA == 'B' || rA == 'b') r = 2;
            else if (rA == 'C' || rA == 'c') r = 3;
            else if (rA == 'D' || rA == 'd') r = 4;

            a[r - 1][c - 1] = 1;
            System.out.println("\n\n  Front           Back\n ");
            System.out.println("   1 2 3 4 5 6 7 8 9 10\n");
            for (int i = 0; i < a.length; ++i) {
                if (i == 0) System.out.print("A ");
                else if (i == 2) System.out.print("C ");
                else if (i == 3) System.out.print("D ");
                for(int j = 0; j < a[i].length; ++j) {
                    System.out.print(" " + a[i][j]);
                }
                if (i %2 != 0) System.out.println();
                System.out.println();
            }
            seatsBooked.add(rA + Integer.toString(c));
        }
        System.out.println("\nSeats selected successfully..!");
    }

    public void display(String from, String to) {
        this.from = from;
        this.to = to;

        System.out.println("\n\n--Ticket booking details--\n");
        System.out.println("Ticket booked by: " + name);
        System.out.println("Age of the passenger: " + age);
        System.out.println("Number of passengers: " + passengers);
        System.out.println("From " + from + " to " + to);
        System.out.println("Seats Booked: " + seatsBooked);
        System.out.println("Total cost of the tickets: " + cost * passengers);
        System.out.println("\n Thank You..! Visit us again\n");
    }
}