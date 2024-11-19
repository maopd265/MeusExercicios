/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mauricio
 */
 
    import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class Janela extends JFrame {
    public Janela() {
        super("Display txt on JTextArea!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);

        File file = new File("C:\\Users\\Mauricio\\Desktop\\teste.txt");
        FileInputStream fis = null;
        String texto = "";

        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                texto += (char) content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        JTextArea textArea = new JTextArea(texto);
        textArea.setLineWrap(true); //quebra de linha automática
        add(textArea);
    }
}
 
