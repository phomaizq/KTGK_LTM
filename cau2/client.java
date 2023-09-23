/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau2;

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

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Nhập số phần tử của mảng
            System.out.print("Nhập số phần tử của mảng (2 < n < 100): ");
            int n = Integer.parseInt(input.readLine());
            out.println(n);

            // Nhập các phần tử của mảng
            System.out.print("Nhập các phần tử của mảng A: ");
            String elements = input.readLine();
            out.println(elements);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
