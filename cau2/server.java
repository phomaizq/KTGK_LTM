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

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Đang chờ kết nối từ Client...");
            Socket socket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Đọc số phần tử của mảng
            int n = Integer.parseInt(in.readLine());

            // Đọc các phần tử của mảng
            String[] elements = in.readLine().split(" ");
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(elements[i]);
            }

            // Tìm giá trị nhỏ nhất và nhỏ thứ hai
            int minVal = Integer.MAX_VALUE;
            int secondMinVal = Integer.MAX_VALUE;

            for (int num : A) {
                if (num < minVal) {
                    secondMinVal = minVal;
                    minVal = num;
                } else if (num > minVal && num < secondMinVal) {
                    secondMinVal = num;
                }
            }

            // In ra kết quả
            System.out.println("Giá trị nhỏ nhất: " + minVal);
            System.out.println("Giá trị nhỏ thứ hai: " + secondMinVal);

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

