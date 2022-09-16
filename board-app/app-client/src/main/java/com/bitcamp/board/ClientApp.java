package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import com.bitcamp.util.Prompt;

public class ClientApp {

  public static void main(String[] args) {
    System.out.println("[게시글 관리 클라이언트]");

    try(Socket socket = new Socket("localhost", 8888);
        DataInputStream in = new DataInputStream( socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())){

      String response = null; // 한줄 문자열 읽음

      while(true) {
        response = in.readUTF();
        System.out.println(response);

        // 사용자의 입력값을 서버에 전달 한 후 서버의 응답을 출력한다.
        String input =  Prompt.inputString("> ");
        out.writeUTF(input);

        if (input.equals("quit")) {
          break;
        }
      }

    } catch (Exception e) {
      System.out.println("서버와 통신 중 오류 발생!");
      e.printStackTrace();
    }




    Prompt.close();

    System.out.println("종료!");
  }
}

