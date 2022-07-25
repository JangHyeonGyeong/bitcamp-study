/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class prompt {



     Static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);
       static int inputInt() {
        String str = keyboardInput.nextLine();
        return Integer.parseInt(str);
       }
       
       static int inputInt(String title) {
         System.out.print(title);
         String str = keyboardInput.nextLine();
         return Integer.parseInt(str);
       }
       
       static String inputString() {
         return keyboardInput.nextLine();
       }
       
       static String inputString(String title) {
         System.out.print(title);
         return keyboardInput.nextLine();
       } 
       static void close() {
         keboardInput.close();
       }
}


