package View;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class telaInicial extends JFrame{
public static void main(String[] args) {
    System.out.println("Olá estou usando vscode!  ");
    Scanner scan = new Scanner(System.in);
    
    telaInicial tela = new telaInicial();
    JButton button = new JButton();
    tela.setVisible(true);
    tela.add(button);
    tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
    tela.setResizable(false);
    // tela.setLocationRelativeTo(button);
    tela.setTitle("My new project");
    tela.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
}
}
