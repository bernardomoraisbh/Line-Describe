import java.io.*;
import java.*;
import java.nio.charset.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;

public class JPanelExemplo {

   private JFrame jFrame;
   private JPanel panel1;
   private JPanel panel2;
   private JTextField textFieldNome;
   private JTextField textFieldSobrenome;

   public JPanelExemplo() {
      iniciarComponentes();
   }

   private void iniciarComponentes() {
      jFrame = new JFrame("Retas");
      jFrame.setLayout(new GridLayout(2,2));
   
      /*
       * Um JPainel para adicionar os componentes JLabel e JTextField 
       * que contém respectivamente o rótulo "Nome:" e o campo para edição. 
       */
      panel1 = new JPanel();
      panel1.setLayout(new GridLayout(1, 0));
   
      /*
       * Outro JPainel para adicionar os componentes JLabel e JTextField 
       * que contém respectivamente o rótulo "Sobrenome:" e o campo para edição. 
       */
      panel2 = new JPanel();
      panel2.setLayout(new GridLayout(1, 0));
   
      textFieldNome = new JTextField(15);
      textFieldSobrenome = new JTextField(15);
   
      //Adição dos componentes ao JPanel
      panel1.add(new JLabel("Nome: "));
      panel1.add(textFieldNome);
   
      //Adição dos componentes ao JPanel
      panel2.add(new JLabel("Sobrenome"));
      panel2.add(textFieldSobrenome);
   
      //Adição dos componentes JPanel ao JFrame
      jFrame.add(panel1);
      jFrame.add(panel2);
   
      //Ajusta automaticamente o tamanho da janela, alternativa ao setSize()
      jFrame.pack();
   
      //Centraliza a janela
      jFrame.setLocationRelativeTo(null);
   
      jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jFrame.setVisible(true);
   }

   public static void main(String[] args) {
      new JPanelExemplo();
   }
}