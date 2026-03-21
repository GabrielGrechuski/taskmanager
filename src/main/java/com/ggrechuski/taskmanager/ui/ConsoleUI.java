package com.ggrechuski.taskmanager.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    // Manage the methods with base in the user's choice
    public void start() {
        while (true) {
            showMenu();
            int optionMenu = readOption();

            if(optionMenu == 1){
                System.out.println("Option 1 selected!");
            }
            else if(optionMenu == 2){
                    System.out.println("Option 2 selected!");
            }
            else if(optionMenu == 3){
                System.out.println("Option 3 selected!");
            }
            else if(optionMenu == 4){
                System.out.println("Option 4 selected!");
            }
            else if(optionMenu == 0){
                System.out.println("Option 0 selected!");
            }
            else {
                System.out.println("Invalid Option! Please, enter with a valid option!");
            }
        }
    }

    // Method for show the option's menu
    public void showMenu() {
        System.out.println("============== TASK MANAGER ==============\n");
        System.out.println("MENU:\n");
        System.out.println("1 - Add Task");
        System.out.println("2 - List Tasks");
        System.out.println("3 - Complete Task");
        System.out.println("4 - Remove Task");
        System.out.println("0 - Exit\n");
        System.out.print("Select an option: ");
    }

    // Method for reading the option entered by the user
    public int readOption() {
        Scanner sc = new Scanner(System.in);

        try{
            int option = sc.nextInt();
            return option;
        }
        catch(InputMismatchException e){
            sc.next();
            return -1;
        }
    }
}
