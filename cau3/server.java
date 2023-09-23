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

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                int numberOfNames = Integer.parseInt(reader.readLine());

                StringBuilder formattedNames = new StringBuilder();

                for (int i = 0; i < numberOfNames; i++) {
                    String inputName = reader.readLine();
                    String formattedName = formatName(inputName);
                    formattedNames.append(formattedName).append("\n");
                }

                // Hiển thị danh sách tên đã định dạng trên máy chủ
                System.out.println("Formatted names from client:");
                System.out.println(formattedNames.toString());

                socket.close();
                System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatName(String name) {
        String[] nameParts = name.split(" ");
        StringBuilder formattedName = new StringBuilder();

        for (String part : nameParts) {
            if (!part.isEmpty()) {
                String firstChar = part.substring(0, 1).toUpperCase();
                String restChars = part.substring(1).toLowerCase();
                formattedName.append(firstChar).append(restChars).append(" ");
            }
        }

        return formattedName.toString().trim();
    }
}