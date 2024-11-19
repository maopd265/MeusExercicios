/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivosjava;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;
/**
 *
 * @author Mauricio
 */
public class JFileChooserDemo extends javax.swing.JFrame {

    private final JTextArea outputArea;
            
            
            
            
    public JFileChooserDemo() throws IOException {
        super("JFileChooser Demo");
        outputArea= new JTextArea();
        add(new JScrollPane(outputArea));
        analyzePath();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFileChooserDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFileChooserDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFileChooserDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFileChooserDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void analyzePath() throws IOException{
     Path path;
        path = getFileOrDirectoryPath().toPath();
        if(path != null && Files.exists(path))
        {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", path.getFileName()));
            builder.append(String.format("%s a directory %n",Files.isDirectory(path) ? "Is" : "Is not" ));
            
            builder.append(String.format("%s an absolute path %n", path.isAbsolute() ? "Is" : "Is not"));
            builder.append(String.format(" Last modified: %s%n", Files.getLastModifiedTime(path)));
            builder.append(String.format("Size: %s%n", Files.size(path)));
            
            builder.append(String.format("Path: %s%n", path));
            builder.append(String.format("Absolute path: %s%n", path.toAbsolutePath()));
             ProcessBuilder process   = new ProcessBuilder();
          process.command("cmd.exe", "/c", "start "+path);
          
           
          process.start();
            if(Files.isDirectory(path))
            {
                builder.append(String.format("%nDirectory contents: %n"));
                DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                for(Path p : directoryStream)
                    builder.append(String.format("%s%n", p));
            }
             
            
            //builder.append(String.format("%s:%n",));
             
 
            
            outputArea.setText(builder.toString());
        }
        else
        {
            JOptionPane.showMessageDialog(this, path.getFileName()+"does not exist.","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
    }

    private File getFileOrDirectoryPath() {
    
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);
        
        if(result==JFileChooser.CANCEL_OPTION)
            System.exit(1);
        return fileChooser.getSelectedFile();
        
        
    
    }
}
