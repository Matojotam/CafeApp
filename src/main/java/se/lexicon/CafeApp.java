package se.lexicon;

import java.util.Scanner;

public class CafeApp {
    static void main(){
        Scanner scanner = new Scanner(System.in);
        IO.print("Welcome! What is your name?");
        String name = scanner.nextLine();
        IO.println("Hi " + name + "! Here is our menu:");
        IO.println("==============================");
        IO.println("       Lexicon Cafe");
        IO.println("==============================");
        IO.println("1. Espresso         25.00 SEK");
        IO.println("2. Cappuccino       35.00 SEK");
        IO.println("3. Latte            40.00 SEK");
        IO.println("4. Croissant        30.00 SEK");
        IO.println("5. Sandwich         55.00 SEK");
        IO.println("==============================");

        double price = 0;
        double afterMemberPrice;
        String itemName = "";

        int menuItem;

        while (true) {
            IO.print("Enter item number (1-5): ");
            menuItem = Integer.parseInt(scanner.nextLine());

            if (menuItem >= 1 && menuItem <= 5) {
                break;
            }
            IO.println("Invalid choice. Please enter a number between 1 and 5.");
        }

        IO.print("How many? ");
        int amount = Integer.parseInt(scanner.nextLine());
        IO.print("Loyalty member? (Yes/No: ");
        String loyaltyMember = scanner.nextLine().toLowerCase();

        switch (menuItem) {
            case 1 -> {
                price = 25.00;
                itemName = "Espresso";
            }
            case 2 -> {
                price = 35.00;
                itemName = "Cappuccino";
            }
            case 3 ->{
                price = 40.00;
                itemName = "Latte";
            }
            case 4 -> {
                price = 30.00;
                itemName = "Croissant";
            }
            case 5 -> {
                price = 55.00;
                itemName = "Sandwich";
            }
            default -> IO.println("invalid choice");
        }
        double beforeMemberPrice = price * amount;
        double discount = 0;



        if (loyaltyMember.equals("yes")) {
            discount = beforeMemberPrice * 0.15;
            afterMemberPrice = beforeMemberPrice - discount;
        }
        else {
            afterMemberPrice = beforeMemberPrice;

        }
        double tax = afterMemberPrice * 0.12;
        double total =  afterMemberPrice + tax;

        IO.println("==============================");
        IO.println("      LEXICON CAFE");
        IO.println("==============================");
        IO.println("Customer  : " + name);
        IO.println("Item      : " + itemName + " x " + amount);
        IO.println("Subtotal  : " + String.format("%.2f", beforeMemberPrice) + " SEK");

        if (loyaltyMember.equals("yes")) {
            IO.println("Discount  : -" + String.format("%.2f", discount) + " SEK");
        }

        IO.println("VAT       : " + String.format("%.2f", tax) + " SEK");
        IO.println("------------------------------");
        IO.println("TOTAL     : " + String.format("%.2f", total) + " SEK");
        IO.println("==============================");
        IO.println("   Thank you, " + name + "!");
        IO.println("   See you next time.");
        IO.println("==============================");


    }

}
