 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau4;

/**
 *
 * @author thanh
 */
import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int n = Integer.parseInt(userInput.readLine());
            out.println(n);

            String elements = userInput.readLine();
            out.println(elements);

            int k = Integer.parseInt(userInput.readLine());
            out.println(k);

            //String result = in.readLine();
            //System.out.println("Shifted array: " + result);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
