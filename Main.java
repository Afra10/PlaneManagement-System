import java.util.Scanner;

public class Main {
    private static Ticket[] tickets = new Ticket[52];
    static int sold = 0;

    public static void main(String[] args) {
        int numbers[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        double price;
        Ticket[] tickets = new Ticket[52];
        int sold = 0;
        System.out.println();
        System.out.println("Welcome to the plane management application");
        System.out.println();
        System.out.println();
        int error = 0;
        boolean not_quit = false;
        while (!not_quit || error == 1) {
            System.out.println("**********************************");
            System.out.println("            MAIN MENU        ");
            System.out.println("**********************************\n1)Buy a seat\n2)Cancel a seat\n3)Find first available seat\n4)Show seating plan\n5)Print ticket information and total sales\n6)Search ticket\n0)Quit");
            System.out.println("**********************************");
            Scanner input = new Scanner(System.in);
            System.out.print("Please select an option: ");
            if (input.hasNextInt()) {
                int option = input.nextInt();

                if (option >= 0 && option < 7) {
                    switch (option) {
                        case 1:
                            buy_seat(numbers);
                            break;
                        case 2:
                            cancel_seat(numbers);
                            break;
                        case 3:
                            int[] firstseat = find_first_available(numbers);
                            String rowletter = "";

                            if (firstseat != null) {
                                if (firstseat[0] == 0) {
                                    rowletter = "A";
                                    System.out.println("First seat available at: row - " + rowletter + ", seatnumber- " + firstseat[1]);
                                }
                                if (firstseat[0] == 1) {
                                    rowletter = "B";
                                    System.out.println("First seat available at: row - " + rowletter + ", seatnumber- " + firstseat[1]);
                                }
                                if (firstseat[0] == 2) {
                                    rowletter = "C";
                                    System.out.println("First seat available at: row - " + rowletter + ", seatnumber- " + firstseat[1]);
                                }
                                if (firstseat[0] == 3) {
                                    rowletter = "D";
                                    System.out.println("First seat available at: row - " + rowletter + ", seatnumber- " + firstseat[1]);
                                }
                            } else {
                                System.out.println("All seats are booked.");
                            }
                            break;
                        case 4:
                            show_seating_plan(numbers);
                            break;
                        case 5:
                            print_ticket_info();
                            break;
                        case 6:
                            search_seat(numbers);
                            break;
                        case 0:
                            not_quit = true;
                            break;
                    }
                } else {
                    System.out.println("Choose a valid number");
                }

            } else {
                error = 1;
                System.out.println("Input should be a number");
            }
        }
    }

    static void buy_seat(int[][] numbers) {
        int error = 0;
        int rownumber = 8;
        boolean buy_ac = true;

        while (buy_ac == true) {
            Scanner obj = new Scanner(System.in);
            System.out.println("Choose the row (A-D): ");
            String row = obj.nextLine();
            String A = "A";
            String B = "B";
            String C = "C";
            String D = "D";

            int integer = 3;
            if (row.equals(A) || row.equals(B) || row.equals(C) || row.equals(D) ) {
                buy_ac = false;
                boolean row1 = false;

                while (row1 == false || error == 1) {
                    error = 0;
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("choose the seat number: ");
                    if (scanner.hasNextInt()) {
                        int seat = scanner.nextInt();
                        if (row.equals(A)) {
                            if (seat > 0 && seat < 15) {
                                rownumber = 0;
                                if (numbers[rownumber][seat - 1] == 0) {
                                    numbers[rownumber][seat - 1] = 1;

                                } else {
                                    System.out.println("Seat unvailable");
                                    integer = 4;
                                }

                            } else {
                                System.out.println("Choose a seat between 1-14 ");
                            }
                        }
                        if (row.equals(B)) {

                            if (seat > 0 && seat < 13) {
                                rownumber=1;
                                if (numbers[rownumber][seat - 1] == 0) {

                                    numbers[rownumber][seat - 1] = 1;
                                } else {
                                    System.out.println("Seat unvailable");
                                    integer = 4;
                                }

                            } else {
                                System.out.println("Choose a seat between 1-12 ");
                                integer = 4;
                            }
                        }
                        if (row.equals(C) ) {
                            if (seat > 0 && seat < 13) {
                                rownumber = 2;
                                if (numbers[rownumber][seat - 1] == 0) {

                                    numbers[rownumber][seat - 1] = 1;
                                } else {
                                    System.out.println("Seat unavailable");
                                    integer = 4;
                                }

                            } else {
                                System.out.println("Choose a seat between 1-12");
                            }
                        }

                        if (row.equals(D)) {
                            if (seat > 0 && seat < 15) {
                                rownumber = 3;
                                if (numbers[rownumber][seat - 1] == 0) {

                                    numbers[rownumber][seat - 1] = 1;
                                } else {
                                    System.out.println("Seat unavailable");
                                    integer = 4;
                                }

                            } else {
                                System.out.println("choose a seat between 1-14");
                            }
                        }
                        int count = 0;
                        double price = 0;

                        if (seat > 0 && seat < 7) {
                            price = 200;
                        }
                        if (seat >= 7 && seat <10) {
                            price = 150;
                        }
                        if (seat >= 10 && seat < 15) {
                            price = 180;
                        }
                        if (rownumber == 0 || rownumber == 1 || rownumber == 2 || rownumber == 3) {
                            row1 = true;
                            if (integer != 4) {

                                Person pe = new Person();
                                Ticket ti = new Ticket(row, seat, price, pe);
                                ti.printInfo();
                                ti.save();
                                tickets[sold] = ti;
                                sold++;
                                System.out.println("Seat has been booked succesfully!");

                            }
                        }
                    } else {
                        error = 1;
                        System.out.println("Input should be a number");
                    }
                }
            }
            else {
                System.out.println("Choose a row between A-D.Make sure to input block letters ");
            }
        }
    }


    static void cancel_seat(int[][] numbers) {
        int error = 0;
        Boolean cancel = true;
        while (cancel == true) {
            Scanner obj = new Scanner(System.in);
            System.out.println("Choose the row (A-D): ");
            String row = obj.nextLine();
            int rownumber = 0;
            String A = "A";
            String B = "B";
            String C = "C";
            String D = "D";

            if (row.equals(A) || row.equals(B) || row.equals(C) || row.equals(D) ) {
                cancel = false;
                boolean row1 = false;
                int integer = 3;
                while ((row1 == false && integer != 5) || error == 1) {
                    error = 0;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("choose the seat number: ");
                    if (scanner.hasNextInt()) {
                        int seat = scanner.nextInt();
                        int count = 0;
                        if (row.equals(A) ) {
                            if (seat < 15) {
                                rownumber = 0;
                                if (numbers[rownumber][seat - 1] == 1) {
                                    numbers[rownumber][seat - 1] = 0;
                                    System.out.println("seat cancelled");


                                } else {
                                    System.out.println("This seat wasn't booked previously");
                                    integer = 5;

                                }

                            } else {
                                System.out.println("Choose a seat between 1-14");
                                integer = 4;
                            }
                        }
                        if (row.equals(B) ) {
                            if (seat < 12) {
                                rownumber = 1;
                                if (numbers[rownumber][seat - 1] == 1) {
                                    numbers[rownumber][seat - 1] = 0;

                                } else {
                                    System.out.println("This seat wasn't booked previously");
                                    integer = 5;
                                }
                            } else {
                                System.out.println("Choose a seat between 1-12");
                                integer = 4;
                            }
                        }


                        if (row.equals(C)) {
                            rownumber = 2;
                            if (seat > 0 && seat < 12) {
                                if (numbers[rownumber][seat - 1] == 1) {
                                    numbers[rownumber][seat - 1] = 0;

                                } else {
                                    System.out.println("This seat wasn't booked previously");
                                    integer = 5;
                                }
                            } else {
                                System.out.println("Choose a seat between 1-12");
                                integer = 4;

                            }
                        }

                        if (row.equals(D) ) {
                            rownumber = 3;
                            if (seat > 0 && seat < 14) {
                                if (numbers[rownumber][seat - 1] == 1) {
                                    numbers[rownumber][seat - 1] = 0;

                                } else {
                                    System.out.println("This seat wasn't booked previously");
                                    integer = 5;
                                }


                            } else {
                                System.out.println("Choose a seat between 1-14");
                                integer = 4;

                            }
                        }

                        if (rownumber == 0 || rownumber == 1 || rownumber == 2 || rownumber == 3) {

                            if (integer != 4) {
                                row1 = true;
                                boolean ticketFound = false;
                                for (int i = 0; i < tickets.length; i++) {
                                    if (tickets[i] != null && tickets[i].getRow().equals(row) && tickets[i].getSeat() == seat) {
                                        tickets[i] = null; // Mark ticket as cancelled by setting it to null
                                        ticketFound = true;
                                        System.out.println("Ticket cancelled successfully.");
                                        break;
                                    }
                                }
                            }
                        } else {
                            error = 1;
                            System.out.println("Input should be a number");
                        }
                    }
                    else {
                        System.out.println("Input should be a number.");
                    }
                }
            }
            else {
                System.out.println("Choose a row between A-D.Make sure to input BLOCK letters");
            }
        }
    }

    public static int[] find_first_available(int[][] numbers) {
        int i;

        for (i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == 0) {
                    return new int[]{i, j + 1};
                }
            }
        }
        return null;
    }

    static void show_seating_plan(int[][] array) {
        String num[][] = {{"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"}
        };

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    num[i][j] = "X";
                }
            }
            System.out.println();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void print_ticket_info() {
        double tot = 0;
        for (Ticket i : tickets) {

            if (i != null) {
                i.printInfo();
                System.out.println();

                tot += i.getPrice();
            }
        }
        System.out.println();
        System.out.println("Total Price: " + tot);
        System.out.println();
    }

    public static void search_seat(int[][] numbers) {
        String A = "A";
        String B = "B";
        String C = "C";
        String D = "D";
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        int error=0;
        int error1=1;
        boolean True=true;
        while (True==true ||error==0){
            Scanner obj = new Scanner(System.in);
            System.out.println("Choose the row (A-D): ");
            String row = obj.nextLine();



            if ((row.equals(A) || row.equals(B) || row.equals(C) || row.equals(D) ||error==1) ){
                error = 1;
                True = false;
                Boolean seat1 = True;
                while (seat1 == true ||error1==1) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("choose the seat number: ");
                    if (scanner.hasNextInt()) {
                        int seat = scanner.nextInt();

                        if (row.equals(A) || row.equals(D)) {
                            seat1=false;
                            if (seat > 0 && seat < 15) {
                                seat1=false;
                                error1=0;

                                Ticket found = findticket(row, seat);
                                if (found != null) {
                                    System.out.println("Seat already booked!");
                                    found.printInfo();
                                } else {
                                    System.out.println("Seat available");
                                    error1=0;
                                }

                            } else {
                                System.out.println("Choose a seat between 1-14");
                            }
                        }
                        if (row.equals(B) || row.equals(C)) {
                            seat1=false;
                            if (seat > 0 && seat < 13) {
                                error1=0;

                                seat1=false;
                                Ticket found = findticket(row, seat);
                                if (found != null) {
                                    System.out.println("Seat already booked!");
                                    found.printInfo();
                                } else {
                                    System.out.println("Seat available");
                                    error1=0;
                                }
                            }
                            else {
                                System.out.println("Choose a seat between 1-12");
                            }
                        }
                    } else {
                        System.out.println("Input should be a number");
                        error = 1;
                    }
                }
            }
            else {
                System.out.println("Choose a row between A-D.Make sure to input BLOCK letters");
            }
        }}

    public static Ticket findticket (String row,int seat){
        for (Ticket i : tickets) {
            if (i != null) {
                if (i.getSeat() == seat && i.getRow().equals(row)) {
                    return i;

                }
            }
        }
        return null;
    }
}

