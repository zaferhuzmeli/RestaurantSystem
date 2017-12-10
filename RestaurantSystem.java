package com.company;

import java.util.Scanner;

public class RestaurantSystem
{
    static String chefName, assistantName, sousName;
    static float chefSalary, assistantSalary, sousSalary;
    static Scanner scanner;
    static int weekendPlates;

    static void getName (String position) {
        System.out.println("Enter name of " + position + ":");

        switch (position) {
            case "chef":
                chefName = scanner.next();
                break;
            case "chef assistant":
                assistantName = scanner.next();
                break;
            default:
                sousName = scanner.next();
                break;
        }
    }

    static void getSalaries () {
        System.out.println("Enter your expected salary, " + chefName);
        chefSalary = scanner.nextInt();

        System.out.println("Enter your expected salary, " + assistantName);
        assistantSalary = scanner.nextInt();

        System.out.println("Enter your expected salary, " + sousName);
        sousSalary = scanner.nextInt();

        while (chefSalary > 2000) {
            System.out.println("Your expected salary exceeds our maximum");
            System.out.println("Lower your expected salary, please, " + chefName);
            chefSalary = scanner.nextInt();
        }

        while (assistantSalary > 1500) {
            System.out.println("Your expected salary exceeds our maximum");
            System.out.println("Lower your expected salary, please, " + assistantName);
            assistantSalary = scanner.nextInt();
        }

        while (sousSalary > 1000) {
            System.out.println("Your expected salary exceeds our maximum");
            System.out.println("Lower your expected salary, please, " + sousName);
            sousSalary = scanner.nextInt();
        }
    }

    static float calculateExtraSalary(float perPlate) {
        return 22 * (50 - 20) * perPlate
                + 8 * (weekendPlates - 20) * perPlate;
    }

    public static void main(String[] args) {
        /*
            Assignment 1: Create a project with an appropriate name, and use the class “RestaurantSystem.java”.
            Create a main method, copy this paragraph into the main method as a multiple comment line.
            Define all necessary variables for all employees to display messages that are given in sample output.
            Then, by using Scanner, ask all values to user.
         */

        scanner = new Scanner(System.in);

        System.out.println("Welcome to the Restaurant Program");
        System.out.println("Please enter all information that is asked.");

        getName("chef");
        getName("chef assistant");
        getName("sous chef");

        getSalaries();

        weekendPlates = 200 + (int) (300 * Math.random());

        chefSalary += calculateExtraSalary(0.5f);
        assistantSalary += calculateExtraSalary(0.4f);
        sousSalary += calculateExtraSalary(0.25f);

        System.out.println("Total Salary of Chef: " + chefSalary);
        System.out.println("Total Salary of Chef Assistant: " + assistantSalary);
        System.out.println("Total Salary of Sous Chef: " + sousSalary);

        System.out.println("Thank you!");
    }
}
