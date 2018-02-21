import java.io.*;
import java.*;
import java.nio.charset.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.math.BigDecimal;

class RETAS {
   public static boolean ehInteiro( String s ) {
    // cria um array de char
      char[] c = s.toCharArray();
      boolean d = true;
      for ( int i = 0; i < c.length; i++ ){
        // verifica se o char não é um dígito
         if ( !Character.isDigit( c[ i ] ) ) {
            d = false;
            break;
         }
      }
      return d;
   }

   public static void main (String[] args){ 
      Scanner sc = new Scanner(System.in);
      // Obs: insira as retas formatas, exemplo : x = 2 + 3t
      //                                          y = 4 + 2t
      //                                          z = 1 + 4t
      String reta1 = "",reta2 = "",x1 = "",y1 = "",z1 = "",x2 = "",y2 = "",z2 = "";
      
      JTextField reta1Field = new JTextField(10);
      JTextField x1Field = new JTextField(10);
      JTextField y1Field = new JTextField(10);
      JTextField z1Field = new JTextField(10);
   
      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Letra da reta 1:"));
      myPanel.add(reta1Field);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("x = "));
      myPanel.add(x1Field);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("y = "));
      myPanel.add(y1Field);     
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("z = "));
      myPanel.add(z1Field);
   
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Entre com os dados da reta 1: ", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         reta1 = reta1Field.getText();
         x1 = x1Field.getText();
         y1 = y1Field.getText();
         z1 = z1Field.getText();
      }
      
      JTextField reta2Field = new JTextField(10);
      JTextField x2Field = new JTextField(10);
      JTextField y2Field = new JTextField(10);
      JTextField z2Field = new JTextField(10);
   
      JPanel myPanelb = new JPanel();
      myPanelb.add(new JLabel("Letra da reta 2:"));
      myPanelb.add(reta2Field);
      myPanelb.add(Box.createHorizontalStrut(15)); // a spacer
      myPanelb.add(new JLabel("x = "));
      myPanelb.add(x2Field);
      myPanelb.add(Box.createHorizontalStrut(15)); // a spacer
      myPanelb.add(new JLabel("y = "));
      myPanelb.add(y2Field);     
      myPanelb.add(Box.createHorizontalStrut(15)); // a spacer
      myPanelb.add(new JLabel("z = "));
      myPanelb.add(z2Field);
   
      int resultb = JOptionPane.showConfirmDialog(null, myPanelb, 
               "Entre com os dados da reta 2: ", JOptionPane.OK_CANCEL_OPTION);
      if (resultb == JOptionPane.OK_OPTION) {
         reta2 = reta2Field.getText();
         x2 = x2Field.getText();
         y2 = y2Field.getText();
         z2 = z2Field.getText();
      }
      
      /*
      MyIO.println("R: "+reta1);
      MyIO.println("x = "+x1);
      MyIO.println("y = "+y1);
      MyIO.println("z = "+z1);      
      
      MyIO.println("R: "+reta2);
      MyIO.println("x = "+x2);
      MyIO.println("y = "+y2);
      MyIO.println("z = "+z2);
      */
      
      /*
       * descobrir se e multiplo escalar:
       */
      int v1x = 0, v1y = 0, v1z = 0;
      int v1a = 0, v1b = 0, v1c = 0;
      //pegar x vetor diretor reta 1
      if ( x1.charAt(0) == '-' ){
         if ( x1.length() == 2 && !(x1.contains("t"))){
            v1x = 0;
            v1a = -Integer.parseInt(""+x1.charAt(1));
         }
         else if ( x1.length() == 2 && x1.contains("t") ){
            v1x = -1;
         }
         else if ( x1.length() == 3 ){
            v1x = -(Integer.parseInt(""+x1.charAt(1)));
         }
         else if ( x1.length() == 4 ){
            v1x = -(Integer.parseInt(""+x1.charAt(1)+x1.charAt(2)));
         }
         else if ( x1.length() == 6 && x1.contains("t") ){
            if ( x1.charAt(3) == '-' ){
               v1x = -1;
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
            else{
               v1x = 1;
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
         }
         else if ( x1.length() == 7 && x1.contains("t") ){
            if ( x1.charAt(3) == '-' ){
               v1x = -(Integer.parseInt(""+x1.charAt(5)));
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
            else{
               v1x = Integer.parseInt(""+x1.charAt(5));
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
         }
      }
      else{
         if ( ehInteiro(x1) ){  
            v1x = 0;
            v1a = Integer.parseInt(""+x1);
         } 
         else if (x1.length() == 5 ) {
            if ( x1.charAt(2) == '-' ){
               v1x = -1;
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
            else {
               v1x = 1;
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
         } 
         else if (x1.length() == 6 ){
            if ( x1.charAt(2) == '-' ){
               v1x = -(Integer.parseInt(""+x1.charAt(4)));
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
            else{
               v1x = Integer.parseInt(""+x1.charAt(4));
               if ( x1.charAt(0) == '-' ){
                  v1a = -Integer.parseInt(""+x1.charAt(1));
               }
               else{
                  v1a = Integer.parseInt(""+x1.charAt(0));
               }
            }
         }
         else if (x1.length() == 7 && x1.charAt(6) == 't'){
            v1x = Integer.parseInt(""+x1.charAt(4)+x1.charAt(5));
            if ( x1.charAt(0) == '-' ){
               v1a = -Integer.parseInt(""+x1.charAt(1));
            }
            else{
               v1a = Integer.parseInt(""+x1.charAt(0));
            }
         }
         else if (x1.charAt(0) == 't'){
            v1x = 1;
            v1a = 0;
         }
         else if (x1.charAt(1) == 't'){
            v1x = Integer.parseInt(""+x1.charAt(0));
         }
         else if (x1.charAt(2) == 't'){
            v1x = Integer.parseInt(""+x1.charAt(0)+x1.charAt(1));
         }
      }
      
      //pegar y vetor diretor reta 1
      if ( y1.charAt(0) == '-' ){
         if ( y1.length() == 2 && !(y1.contains("t"))){
            v1y = 0;
            v1b = Integer.parseInt(""+y1);
         }
         else if ( y1.length() == 2 && y1.contains("t") ){
            v1y = -1;
         }
         else if ( y1.length() == 3 ){
            v1y = -(Integer.parseInt(""+y1.charAt(1)));
         }
         else if ( y1.length() == 4 ){
            v1y = -(Integer.parseInt(""+y1.charAt(1)+y1.charAt(2)));
         }
         else if ( y1.length() == 6 && y1.contains("t") ){
            if ( y1.charAt(3) == '-' ){
               v1y = -1;
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
            else{
               v1y = 1;
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
         }
         else if ( y1.length() == 7 && y1.contains("t") ){
            if ( y1.charAt(3) == '-' ){
               v1y = -(Integer.parseInt(""+y1.charAt(5)));
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
            else{
               v1y = Integer.parseInt(""+y1.charAt(5));
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
         }
      }
      else{
         if ( ehInteiro(y1) ){  
            v1y = 0;
            v1b = -Integer.parseInt(""+y1.charAt(1));
         } 
         else if (y1.length() == 5 ) {
            if ( y1.charAt(2) == '-' ){
               v1y = -1;
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
            else {
               v1y = 1;
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
         } 
         else if (y1.length() == 6 ){
            if ( y1.charAt(2) == '-' ){
               v1y = -(Integer.parseInt(""+y1.charAt(4)));
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
            else{
               v1y = Integer.parseInt(""+y1.charAt(4));
               if ( y1.charAt(0) == '-' ){
                  v1b = -Integer.parseInt(""+y1.charAt(1));
               }
               else{
                  v1b = Integer.parseInt(""+y1.charAt(0));
               }
            }
         }
         else if (y1.length() == 7 && y1.charAt(6) == 't'){
            v1y = Integer.parseInt(""+y1.charAt(4)+y1.charAt(5));
            if ( y1.charAt(0) == '-' ){
               v1b = -Integer.parseInt(""+y1.charAt(1));
            }
            else{
               v1b = Integer.parseInt(""+y1.charAt(0));
            }
         }
         else if (y1.charAt(0) == 't'){
            v1y = 1;
         }
         else if (y1.charAt(1) == 't'){
            v1y = Integer.parseInt(""+y1.charAt(0));
         }
         else if (y1.charAt(2) == 't'){
            v1y = Integer.parseInt(""+y1.charAt(0)+y1.charAt(1));
         }
      }
      
      //pegar z vetor diretor reta 1
      if ( z1.charAt(0) == '-' ){
         if ( z1.length() == 2 && !(z1.contains("t"))){
            v1z = 0;
            v1c = Integer.parseInt(""+z1);
         }
         else if ( z1.length() == 2 && z1.contains("t") ){
            v1z = -1;
         }
         else if ( z1.length() == 3 ){
            v1z = -(Integer.parseInt(""+z1.charAt(1)));
         }
         else if ( z1.length() == 4 ){
            v1z = -(Integer.parseInt(""+z1.charAt(1)+z1.charAt(2)));
         }
         else if ( z1.length() == 6 && z1.contains("t") ){
            if ( z1.charAt(3) == '-' ){
               v1z = -1;
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
            else{
               v1z = 1;
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
         }
         else if ( z1.length() == 7 && z1.contains("t") ){
            if ( z1.charAt(3) == '-' ){
               v1z = -(Integer.parseInt(""+z1.charAt(5)));
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
            else{
               v1z = Integer.parseInt(""+z1.charAt(5));
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
         }
      }
      else{
         if ( ehInteiro(z1) ){  
            v1z = 0;
            v1c = Integer.parseInt(""+z1);
         } 
         else if (z1.length() == 5 ) {
            if ( z1.charAt(2) == '-' ){
               v1z = -1;
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
            else {
               v1z = 1;
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
         } 
         else if (z1.length() == 6 ){
            if ( z1.charAt(2) == '-' ){
               v1z = -(Integer.parseInt(""+z1.charAt(4)));
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
            else{
               v1z = Integer.parseInt(""+z1.charAt(4));
               if ( z1.charAt(0) == '-' ){
                  v1c = -Integer.parseInt(""+z1.charAt(1));
               }
               else{
                  v1c = Integer.parseInt(""+z1.charAt(0));
               }
            }
         }
         else if (z1.length() == 7 && z1.charAt(6) == 't'){
            v1z = Integer.parseInt(""+z1.charAt(4)+z1.charAt(5));
            if ( z1.charAt(0) == '-' ){
               v1c = -Integer.parseInt(""+z1.charAt(1));
            }
            else{
               v1c = Integer.parseInt(""+z1.charAt(0));
            }
         }
         else if (z1.charAt(0) == 't'){
            v1z = 1;
         }
         else if (z1.charAt(1) == 't'){
            v1z = Integer.parseInt(""+z1.charAt(0));
         }
         else if (z1.charAt(2) == 't'){
            v1z = Integer.parseInt(""+z1.charAt(0)+z1.charAt(1));
         }
      }
      
      // vetor escalar reta 2
      int v2x = 0, v2y = 0, v2z = 0;
      int v2a = 0, v2b = 0, v2c = 0;
      //pegar x vetor diretor reta 2
      if ( x2.charAt(0) == '-' ){
         if ( x2.length() == 2 && !(x2.contains("s"))){
            v2x = 0;
            v2a = Integer.parseInt(""+x2);
         }
         else if ( x2.length() == 2 && x2.contains("s") ){
            v2x = -1;
         }
         else if ( x2.length() == 3 ){
            v2x = -(Integer.parseInt(""+x2.charAt(1)));
         }
         else if ( x2.length() == 4 ){
            v2x = -(Integer.parseInt(""+x2.charAt(1)+x2.charAt(2)));
         }
         else if ( x2.length() == 6 && x2.contains("s") ){
            if ( x2.charAt(3) == '-' ){
               v2x = -1;
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }
            else{
               v2x = 1;
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }
         }
         else if ( x2.length() == 7 && x2.contains("s") ){
            if ( x2.charAt(3) == '-' ){
               v2x = -(Integer.parseInt(""+x2.charAt(5)));
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }
            else{
               v2x = Integer.parseInt(""+x2.charAt(5));
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }
         }
      }
      else{
         if ( ehInteiro(x2) ){  
            v2x = 0;
            v2a = Integer.parseInt(""+x2);
         } 
         else if (x2.length() == 5 ) {
            if ( x2.charAt(2) == '-' ){
               v2x = -1;
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }
            else {
               v2x = 1;
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }
         } 
         else if (x2.length() == 6 ){
            if ( x2.charAt(2) == '-' ){
               v2x = -(Integer.parseInt(""+x2.charAt(4)));
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }
            else{
               v2x = Integer.parseInt(""+x2.charAt(4));
               if ( x2.charAt(0) == '-' ){
                  v2a = -Integer.parseInt(""+x2.charAt(1));
               }
               else{
                  v2a = Integer.parseInt(""+x2.charAt(0));
               }
            }      
         }
         else if (x2.length() == 7 && x2.charAt(6) == 's'){
            v2x = Integer.parseInt(""+x2.charAt(4)+x2.charAt(5));
            if ( x2.charAt(0) == '-' ){
               v2a = -Integer.parseInt(""+x2.charAt(1));
            }
            else{
               v2a = Integer.parseInt(""+x2.charAt(0));
            }
         }
         else if (x2.charAt(0) == 's'){
            v2x = 1;
         }
         else if (x2.charAt(1) == 's'){
            v2x = Integer.parseInt(""+x2.charAt(0));
         }
         else if (x2.charAt(2) == 's'){
            v2x = Integer.parseInt(""+x2.charAt(0)+x2.charAt(1));
         }
      }
      
      //pegar y vetor diretor reta 2
      if ( y2.charAt(0) == '-' ){
         if ( y2.length() == 2 && !(y2.contains("s"))){
            v2y = 0;
            v2b = Integer.parseInt(""+v2y);
         }
         else if ( y2.length() == 2 && y2.contains("s") ){
            v2y = -1;
         }
         else if ( y2.length() == 3 ){
            v2y = -(Integer.parseInt(""+y2.charAt(1)));
         }
         else if ( y2.length() == 4 ){
            v2y = -(Integer.parseInt(""+y2.charAt(1)+y2.charAt(2)));
         }
         else if ( y2.length() == 6 && y2.contains("s") ){
            if ( y2.charAt(3) == '-' ){
               v2y = -1;
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }
            else{
               v2y = 1;
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }
         }
         else if ( y2.length() == 7 && y2.contains("s") ){
            if ( y2.charAt(3) == '-' ){
               v2y = -(Integer.parseInt(""+y2.charAt(5)));
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }
            else{
               v2y = Integer.parseInt(""+y2.charAt(5));
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }
         }
      }
      else{
         if ( ehInteiro(y2) ){  
            v2y = 0;
            v2b = Integer.parseInt(""+y2);
         } 
         else if (y2.length() == 5 ) {
            if ( y2.charAt(2) == '-' ){
               v2y = -1;
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }
            else {
               v2y = 1;
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }
         } 
         else if (y2.length() == 6 ){
            if ( y2.charAt(2) == '-' ){
               v2y = -(Integer.parseInt(""+y2.charAt(4)));
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }
            else{
               v2y = Integer.parseInt(""+y2.charAt(4));
               if ( y2.charAt(0) == '-' ){
                  v2b = -Integer.parseInt(""+y2.charAt(1));
               }
               else{
                  v2b = Integer.parseInt(""+y2.charAt(0));
               }
            }         
         }
         else if (y2.length() == 7 && y2.charAt(6) == 's'){
            v2y = Integer.parseInt(""+y2.charAt(4)+y2.charAt(5));
            if ( y2.charAt(0) == '-' ){
               v2b = -Integer.parseInt(""+y2.charAt(1));
            }
            else{
               v2b = Integer.parseInt(""+y2.charAt(0));
            }
         }
         else if (y2.charAt(0) == 's'){
            v2y = 1;
         }
         else if (y2.charAt(1) == 's'){
            v2y = Integer.parseInt(""+y2.charAt(0));
         }
         else if (y2.charAt(2) == 's'){
            v2y = Integer.parseInt(""+y2.charAt(0)+y2.charAt(1));
         }
      }
      
      //pegar z vetor diretor reta 2
      if ( z2.charAt(0) == '-' ){
         if ( z2.length() == 2 && !(z2.contains("s"))){
            v2z = 0;
            v2c = Integer.parseInt(""+z2);
         }
         else if ( z2.length() == 2 && z2.contains("s") ){
            v2z = -1;
         }
         else if ( z2.length() == 3 ){
            v2z = -(Integer.parseInt(""+z2.charAt(1)));
         }
         else if ( z2.length() == 4 ){
            v2z = -(Integer.parseInt(""+z2.charAt(1)+z2.charAt(2)));
         }
         else if ( z2.length() == 6 && z2.contains("s") ){
            if ( z2.charAt(3) == '-' ){
               v2z = -1;
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(1));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(0));
               }
            }
            else{
               v2z = 1;
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(0));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(1));
               }
            }
         }
         else if ( z2.length() == 7 && z2.contains("s") ){
            if ( z2.charAt(3) == '-' ){
               v2z = -(Integer.parseInt(""+z2.charAt(5)));
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(1));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(0));
               }
            }
            else{
               v2z = Integer.parseInt(""+z2.charAt(5));
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(1));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(0));
               }
            }
         }
      }
      else{
         if ( ehInteiro(z2) ){  
            v2z = 0;
            v2c = Integer.parseInt(""+z2);
         } 
         else if (z2.length() == 5 ) {
            if ( z2.charAt(2) == '-' ){
               v2z = -1;
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(1));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(0));
               }
            }
            else {
               v2z = 1;
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(1));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(0));
               }
            }      
         } 
         else if (z2.length() == 6 ){
            if ( z2.charAt(2) == '-' ){
               v2z = -(Integer.parseInt(""+z2.charAt(4)));
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(1));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(0));
               }
            }
            else{
               v2z = Integer.parseInt(""+z2.charAt(4));
               if ( z2.charAt(0) == '-' ){
                  v2c = -Integer.parseInt(""+z2.charAt(1));
               }
               else{
                  v2c = Integer.parseInt(""+z2.charAt(0));
               }
            }            }
         else if (z2.length() == 7 && z2.charAt(6) == 's'){
            v2z = Integer.parseInt(""+z2.charAt(4)+z2.charAt(5));
            if ( z2.charAt(0) == '-' ){
               v2c = -Integer.parseInt(""+z2.charAt(1));
            }
            else{
               v2c = Integer.parseInt(""+z2.charAt(0));
            }
         }
         else if (z2.charAt(0) == 's'){
            v2z = 1;
         }
         else if (z2.charAt(1) == 's'){
            v2z = Integer.parseInt(""+z2.charAt(0));
         }
         else if (z2.charAt(2) == 's'){
            v2z = Integer.parseInt(""+z2.charAt(0)+z2.charAt(1));
         }
      }
      
      String vetor1 = "Vetor Diretor "+reta1+": ("+v1x+", "+v1y+", "+v1z+")";
      String vetor2 = "Vetor Diretor "+reta2+": ("+v2x+", "+v2y+", "+v2z+")";
      
      int k = v2x / v1x;
      boolean multiplos = false;
      if ( k != 0 ){
         if ( (v2x/k) == v1x && (v2y/k) == v1y && (v2z/k) == v1z ){
            multiplos = true;
         }
      }
      /*if (multiplos){
         MyIO.println ("Os vetores sao multiplos escalares.");
      }
      else{
         MyIO.println ("Os vetores nao sao multiplos escalares.");
      }*/
      
      //MyIO.println (""+reta1+": ("+v1a+", "+v1b+", "+v1c+")");
      //MyIO.println (""+reta2+": ("+v2a+", "+v2b+", "+v2c+")");
      
      /*
       * Descobrir se o sistema tem solucao:
       */
      int t1 = 0, t2 = 0, t3 = 0, s1 = 0, s2 = 0, s3 =0, r1 = 0, r2 = 0, r3 = 0;
      if ( v1x > 0 ){
         t1 = v1x;
         if (v2x > 0){
            s1 = -v2x;
         }
         else{
            s1 = -v2x;
         }
         r1 = v2a - v1a;
      }
      else {
         t1 = -v1x;
         s1 =  v2x;
         r1 = -(v2a - v1a);
      }
      
      if ( v1y > 0 ){
         t2 = v1y;
         if (v2y > 0){
            s2 = -v2y;
         }
         else{
            s2 = -v2y;
         }
         r2 = v2b - v1b;
      }
      else {
         t2 = -v1y;
         s2 =  v2y;
         r2 = -(v2b - v1b);
      }
      
      if ( v1z > 0 ){
         t3 = v1z;
         if (v2z > 0){
            s3 = -v2z;
         }
         else{
            s3 = -v2z;
         }
         r3 = v2c - v1c;
      }
      else {
         t3 = -v1z;
         s3 =  v2z;
         r3 = -(v2c - v1c);
      }
      
      boolean paralelismo = false;
      if ( v2x == 0 || v2y == 0 || v2z == 0 ){
         paralelismo = false;
      }
      else{
         int um = v1x/v2x;
         int dois = v1y/v2y;
         int tres = v1z/v2z;
      
         if ( um == dois && um == tres && dois == tres ){
            paralelismo = true;
         }
      }
      
      
      //MyIO.println ("("+t1+", "+s1+", "+r1+")");
      //MyIO.println ("("+t2+", "+s2+", "+r2+")");
      //MyIO.println ("("+t3+", "+s3+", "+r3+")");
      
      int determinant = (t1 * s2 * r3) + (s1 * r2 * t3) + (r1 * t2 * s3)-((s1 * t2 * r3) + (r1 * s2 * t3) + (t1 *r2 * s3));
      
      //MyIO.println("Determinante da matriz:"+determinant);
      
      boolean solucao = true;
      String sistema = "";
      int m1 = t1 / t2;
      if ( determinant == 0 ){
         solucao = true;
         if ( (t2*m1) == t1 && (s2*m1) == s1 ){
            solucao = false;
            sistema = "As equacoes sao multiplas, sistema sem solucao.";
         }
      }
      else {
         solucao = false;
         sistema = "O sistema linear das equacoes nao possui solucao.";
      }
      
      if (solucao){
         sistema = "O sistema linear das equacoes possui solucao.";
      }
      
      String resposta = "";
      if ( paralelismo && multiplos && solucao ){
         resposta = "RETAS PARALELAS COINCIDENTES";
      } 
      else if ( paralelismo && multiplos && !(solucao) ){
         resposta = "RETAS PARALELAS DISTINTAS";
      }
      else if ( !(paralelismo) && !(multiplos) && solucao ){
         resposta = "RETAS CONCORRENTES";
      }
      else if ( !(paralelismo) && !(multiplos) && !(solucao) ){
         resposta = "RETAS REVERSAS";
      }
      
      JFrame frameb = new JFrame("resultados");
      
      JOptionPane.showMessageDialog(frameb, reta1 + "\n" + "x = "+ x1 + "\n" + "y = " + y1 + "\n" + "z = " + z1 + "\n" + reta2 + "\n" + "x = "+ x2 + "\n" + "y = " + y2 + "\n" + "z = " + z2 + "\n" + vetor1 + "\n" + vetor2 + "\n" + sistema + "\n" + resposta, "RESULTADO: ", JOptionPane.INFORMATION_MESSAGE);
      
      System.exit(0);
   }
}