/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Apo
 */
public class UI {
    private Scanner reader;
    private Phonebook phonebook;
    
    public UI() {
        reader = new Scanner(System.in);
        phonebook = new Phonebook();
    }
    
    public void start() {
        printMenu();
        
        while(true) {
            System.out.print("command: ");
            String command = reader.nextLine();
            
            if(command.equals("x")) {
                break;
            }
            
            parseCommand(command);
            System.out.println("");
        }
    }
    
    private void printMenu() {
        System.out.println("phone search\n" +
                           "available operations:\n" +
                           " 1 add a number\n" +
                           " 2 search for a number\n" +
                           " 3 search for a person by phone number\n" +
                           " 4 add an address\n" +
                           " 5 search for personal information\n" +
                           " 6 delete personal information\n" +
                           " 7 filtered listing\n" +
                           " x quit");
        System.out.println("");
    }
    
    private void parseCommand(String command) {
        if(command.equals("1")) {
            addNumber();
        }
        
        else if(command.equals("2")) {
            searchNumber();
        }
        
        else if(command.equals("3")) {
            searchPerson();
        }
        
        else if(command.equals("4")) {
            addAddress();
        }
        
        else if(command.equals("5")) {
            searchInfo();
        }
        
        else if(command.equals("6")) {
            deleteInfo();
        }
        
        else if(command.equals("7")) {
            filter();
        }
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        phonebook.addNumber(name, number);
    }

    private void searchNumber() {
        System.out.print("whose number: ");
        ArrayList<String> numbers = (ArrayList)phonebook.searchNumber(
                reader.nextLine());
        
        if(numbers == null) {
            System.out.println("  not found");
            return;
        }
        
        printNumbers(numbers, 2);
    }

    private void searchPerson() {
        System.out.print("number: ");
        Person searched = phonebook.searchPersonByNumber(reader.nextLine());
        
        if(searched == null) {
            System.out.println("  not found");
            return;
        }
        
        printSpacing(2);
        System.out.println(searched.getName());
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String address = reader.nextLine();
        System.out.print("city: ");
        address += " " + reader.nextLine();
        phonebook.addAddress(name, address);
        
    }

    private void searchInfo() {
        System.out.print("whose information: ");
        Person searched = phonebook.searchPersonByName(reader.nextLine());
        
        if(searched == null) {
            System.out.println("  not found");
            return;
        }
        
        printInformation(searched);
    }

    private void deleteInfo() {
        System.out.print("whose information: ");        
        phonebook.removeInformation(reader.nextLine());
    }

    private void filter() {
        System.out.print("keyword (if empty, all listed): ");
        List<Person> filtered = phonebook.searchByKeyword(reader.nextLine());
        
        if(filtered.isEmpty()) {
            System.out.println("  keyword not found");
            return;
        }
        
        for(Person i : filtered) {
            System.out.println("");
            System.out.println(" " + i.getName());
            printInformation(i);
        }
    }
    
    private void printSpacing(int spaces) {
        while(spaces > 0) {
            System.out.print(" ");
            spaces--;
        }
    }
    
    private void printNumbers(ArrayList<String> numbers, int spaces) {
        for(String number : numbers) {
            printSpacing(spaces);
            System.out.println(number);
        }
    }
    
    private void printInformation(Person person) {
        ArrayList<String> addresses = (ArrayList)person.getAddresses();
        
        if(addresses.isEmpty()) {
            System.out.println("  address unknown");
        }
        else {
            System.out.println("  address: " + addresses.get(addresses.size() - 1));
        }
        
        ArrayList<String> numbers = (ArrayList)person.getNumbers();
        
        if(numbers.isEmpty()) {
            System.out.println("  phone number not found");
            return;
        }
        
        System.out.println("  phone numbers:");
        printNumbers(numbers, 3);
    }
}
