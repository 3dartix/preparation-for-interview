package lesson6;

import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;

public class Main {
    @Data
    private static class HttpSender {
        int port = 8080;

        @SneakyThrows
        private void send(){
            Socket socket = new Socket("localhost", port);

            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            wr.write("GET / HTTP/1.1\r\n");
            wr.write("Host:localhost\r\n\r\n");
            wr.write("Content-Type: text/html;charset=UTF-8");
            wr.write("Connection: keep-alive");
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;

            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

            wr.close();
            rd.close();
        }
    }

    public static void main(String[] args) {
        new HttpSender().send();
    }

}
