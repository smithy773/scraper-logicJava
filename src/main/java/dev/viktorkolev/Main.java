package dev.viktorkolev;

import dev.viktorkolev.controller.Controller;
import dev.viktorkolev.items.WorkItem;

import java.io.IOException;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static void main(String[] args) throws IOException {

        int option = 0;

        System.out.println("\n\nWelcome to Site2Text!");

        while (option != 3) {
            System.out.print("\n\nMenu\n1) Convert site to text\n2) Additional info\n3) Exit\n\nPlease select an option (1-3): ");
            option = Integer.parseInt(scanner.next());

            switch(option) {
                case 1:
                    System.out.println("EXECUTION HERE (INPUT URL)");
                    // Call the Controller - Controller.execute(WorkItem(siteURL));
                    int choice = 0;

                    System.out.print("Please input the URL of the website you want to convert: ");
                    WorkItem item = new WorkItem(scanner.next());

                    while (choice != 3) {

                        System.out.print("\nSave the website as:\n1) HTML text\n2) just text\n\nBoth will be saved as a '.txt' file.");
                        choice = Integer.parseInt(scanner.next());

                        System.out.println("Fetching HTML...");
                        Controller.fetchHTML(item);

                        System.out.println(item.getURL());

                        switch (choice) {
                            case 1:
                                Controller.saveToTXT(item, 1);
                                break;
                            case 2:
                                Controller.saveToTXT(item, 2);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid input - please input a valid choice (1-3)");
                                break;
                        }

                        if (choice == 1 || choice == 2) {
                            choice = 3;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Additional information here...");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please input a valid option (1-3)");
                    break;
            }
        }
    }
}
