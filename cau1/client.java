/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau1;

/**
 *
 * @author thanh
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Nhap mot so nguyen : ");
            long N = scanner.nextLong();
            
            if (N <= 0 || N > 999999999) {
                System.out.println("Số không hợp lệ. Vui lòng nhập lại.");
                socket.close();
                return;
            }
            
            // Gửi số nguyên đến máy chủ
            out.println(N);
            
            
           
        } catch (IOException e) {
            System.err.println("Lỗi khi kết nối tới máy chủ: " + e.getMessage());
        }
    }
}

