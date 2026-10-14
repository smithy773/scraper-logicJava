package dev.viktorkolev;

import dev.viktorkolev.controller.Controller;
import dev.viktorkolev.items.WorkItem;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {

        int option = 0;

        System.out.println("\n\nWelcome to Site2Text!");

        while (option != 3) {
            System.out.print("\n\nMenu\n1) Convert site to text\n2) Additional info\n3) Exit\n\nPlease select an option (1-3): ");
            option = Integer.parseInt(scanner.next());

            switch(option) {
                case 1:
                    int choice = 0;

                    System.out.print("Please input the URL of the website you want to convert: ");

                    WorkItem item = new WorkItem(scanner.next());

                    while (choice != 3) {

                        System.out.println("Fetching HTML...");
                        if (Controller.fetchHTML(item)) {
                            System.out.println(item.getURL());

                            System.out.print("\nSave the website as:\n1) HTML text\n2) Just text\n3) Cancel\n\nOption: ");
                            choice = Integer.parseInt(scanner.next());

                            switch (choice) {
                                case 1:
                                    Controller.saveToFile(item, 1);
                                    break;
                                case 2:
                                    Controller.saveToFile(item, 2);
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
                        } else {
                            option = 0;
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n\nAdditional information:\nSite2Text is a rudimentary web scraper created by Viktor Kolev for the 'Programming' course of the Software Engineering program in Plovdiv University. It allows the user to convert a site to text via a provided link and then save it as HTML in an .html file or as text in a .txt file.");
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
