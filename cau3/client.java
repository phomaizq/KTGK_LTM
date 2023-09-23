/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau3;

/**
 *
 * @author thanh
 */
import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter the number of names: ");
            int numberOfNames = Integer.parseInt(reader.readLine());
            writer.println(numberOfNames);

            for (int i = 0; i < numberOfNames; i++) {
                System.out.print("Enter a name: ");
                String inputName = reader.readLine();
                writer.println(inputName);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}