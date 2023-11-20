package edu.sdccd.cisc191.template;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class GroceryClient {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
//create socket to communicate with server

        Socket clientSocket;
        try {
            clientSocket = new Socket("localhost", 9999);
        } catch(ConnectException e) {
            System.err.println("backend is not started");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Enter category: ");
            String category = scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            try {
                GroceryRequest request = new GroceryRequest(category, name);
                // write info from request to output stream to send to server
                ObjectOutputStream out = new
                        ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(request);
                //read input stream and assign it to response
                ObjectInputStream in = new
                        ObjectInputStream(clientSocket.getInputStream());
                GroceryResponse response = (GroceryResponse) in.readObject();
                printResults(response);
            } catch(SocketException e) {
                System.out.println("Category or name not found");
            }
        }
//        clientSocket.close();
    }
    //method returning response to console
    public static void printResults(GroceryResponse response) {
        System.out.println("Grocery Info:");
        System.out.println("Request Category: " + response.getRequest().getCategory());
        System.out.println("Request Name: " + response.getRequest().getName());
        System.out.println("Price: $" + response.getPrice());
        System.out.println("Calories: " + response.getCalories());
    }

}

