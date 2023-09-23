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

public class server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server đang lắng nghe...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client đã kết nối");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    String clientInput = in.readLine();
                    if (clientInput == null) {
                        System.out.println("Client đã ngắt kết nối một cách bất ngờ.");
                        continue;
                    }

                    long N = Long.parseLong(clientInput);

                    int evenCount = 0;
                    int oddCount = 0;

                    while (N > 0) {
                        long digit = N % 10;
                        if (digit % 2 == 0) {
                            evenCount++;
                        } else {
                            oddCount++;
                        }
                        N /= 10;
                    }

                    String result = "   " + oddCount + "  " + evenCount;

                    // Hiển thị kết quả trên máy chủ
                    System.out.println("Ket Qua Tu Server: " + result);
                } catch (IOException e) {
                    System.err.println("Lỗi trong quá trình xử lý kết nối: " + e.getMessage());
                }
                System.out.println("Client đã ngắt kết nối");
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi tạo máy chủ: " + e.getMessage());
        }
    }
}


