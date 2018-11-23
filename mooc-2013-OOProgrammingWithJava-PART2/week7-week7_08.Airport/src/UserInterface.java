/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.Scanner;
public class UserInterface {
    private Scanner reader;
    private Airport airport;
    public UserInterface(Scanner reader) {
        this.reader = reader;
        airport = new Airport();
    }
    
    public void startUI() {
        startAirportPanel();
        startFlightService();
    }
    
    private void startAirportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------\n");
        boolean quit = false;
        while(!quit) {
            printOperations(1);
            String input = reader.nextLine();
            if(input.equals("1")) {
                addAirplane();
            }
            else if(input.equals("2")) {
                addFlight();
            }
            else if(input.equals("x")) {
                quit = true;
            }
        }
    }
    
    private void startFlightService() {
        System.out.println("Flight service");
        System.out.println("------------\n");
        boolean quit = false;
        while(!quit) {
            printOperations(2);
            String input = reader.nextLine();
            if(input.equals("1")) {
                airport.printPlanes();
            }
            else if(input.equals("2")) {
                airport.printAllFlights();
            }
            else if(input.equals("3")) {
                printPlane();
            }
            else if(input.equals("x")) {
                quit = true;
            }
        }
    }
    
    private void printOperations(int mode) {
        System.out.println("Choose operation:");
        switch(mode) {
            case 1:
                System.out.println("[1] Add airplane");
                System.out.println("[2] Add flight");
                System.out.println("[x] Exit");
                break;
            
            case 2:
                System.out.println("[1] Print planes");
                System.out.println("[2] Print flights");
                System.out.println("[3] Print plane info");
                System.out.println("[x] Quit");
                break;
        }  
        System.out.print("> ");
    }
    
    private void addAirplane() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        airport.addPlane(id, capacity);
    }
    
    private void addFlight() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String path = reader.nextLine();
        System.out.print("Give destination airport code: ");
        path += "-" + reader.nextLine();
        airport.addFlight(id, path);
    }
    
    private void printPlane() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        airport.printPlane(id);
    }
}
