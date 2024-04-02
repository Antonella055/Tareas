/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;



import Objetos.Partida;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.Timer;
import pokemonpikachu.Musica;

/**
 *
 * @author Antonella
 */
public class PartidaCargada extends javax.swing.JFrame {
       public final Timer tiempo;
        private int miliseg=0;
        private int segundos=0;
        private int minutos=0;
        private int horas=0;
        public String tiempoactual;
        public String time;
        private int Watts = 0;
         private static boolean AumentoWatts = false;
         private static boolean Aumento=false;
          private static boolean AumentoWatt=false;
         private int totalSegundos = 0;
    /**
     * Creates new form MenuPrincipal
     */
    public PartidaCargada() {
        initComponents();
       
        tiempo= new Timer(10,acciones);
        StartReloj();
          new Thread(() -> {
            new Musica().Reproducir("src/Sonidos/Menu.wav", -10.0f);
        }).start();
        
           Partida datos=new Partida();
        String informacion= datos.LeerPartida("PARTIDAGUARDADA.txt");
        String watts= datos.obtWatts(informacion);
         new Auxiliar().saveToTxt(watts, "aum.txt");
          
    }
   
    public void actualizarWatts(int segundos) {
       
    
        Watts = totalSegundos;
        numWatts.setText(String.valueOf(Watts));
        
        
        Auxiliar fileManager = new Auxiliar();
        
        if (fileManager.fileExists("aum.txt")) {
            String nuevobalance = fileManager.readFromTxt("aum.txt");
           if (nuevobalance != null) {
                nuevobalance = nuevobalance.trim(); // Eliminar espacios en blanco al inicio y al final
                if (!nuevobalance.isEmpty()) {
                    Watts += Integer.valueOf(nuevobalance);
                }
        } numWatts.setText(String.valueOf(Watts));
            }
    }
         
    /**
     * Reloj del tiempo jugado
     */
    public  ActionListener acciones= new ActionListener(){
         
         
        @Override
        public void actionPerformed(ActionEvent e){
           miliseg ++;
           
           if (miliseg ==100){
               segundos++;
               miliseg=0;
              totalSegundos+=1;
           }if(segundos==60){
                
               minutos++;
               segundos=0;
              
               
               
           }if(minutos==60){
               horas++;
               minutos=0;
               
           }if(horas==24){
               horas=0;
           }
           
           time = actualizarEtiqueta();
        
           actualizarWatts(totalSegundos);
          
           
           if(Aumento()){
               Watts+=10;
           }
            if (Aumento2()) {
                Watts+=10;
            }
           numWatts.setText(String.valueOf(Watts));
           
           
           
              if(ResultadoApuesta()){
            int watts= new Auxiliar().obtenerWatts();
            numWatts.setText(String.valueOf( watts));
        }
            
              
            try {
                new Auxiliar().procesaWatts(Watts);
            } catch (IOException ex) {
                Logger.getLogger(PartidaCargada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                };
    
       public final void StartReloj(){
        tiempo.start();
    }
       public void StopReloj(){
           tiempo.stop();
       }
    
    public String obtenerTime(String tiempo)  {
         return tiempo=String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, miliseg);
    }         
    
   private String actualizarEtiqueta(){
       
       tiempoactual= (horas<=9?"0":"")+horas+":"+(minutos<=9?"0":"")+minutos+":"+(segundos<=9?"0":"")+segundos+":"+(miliseg <=9?"0":"")+miliseg;
       etiquetatiempo.setText(tiempoactual);
       return tiempoactual;
   }
   
   public boolean Aumento(){
           return AumentoWatts;
   }
   public void askAumento(boolean valor) {
           AumentoWatts = valor;
       }
   public boolean Aumento2(){
           return AumentoWatt;
   }
   public void askAumento2(boolean valor) {
           AumentoWatt = valor;
       }
   
   public final boolean ResultadoApuesta(){
           return Aumento;
   }
   public void askResultado(boolean valor) {
           Aumento = valor;
       }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new Fondo();
        jLabel1 = new javax.swing.JLabel();
        etiquetatiempo = new javax.swing.JLabel();
        VolverMenu = new javax.swing.JButton();
        Tienda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numWatts = new javax.swing.JLabel();
        Pokemon = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TIEMPO");

        etiquetatiempo.setFont(new java.awt.Font("Simplex_IV25", 1, 18)); // NOI18N
        etiquetatiempo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetatiempo.setText("00:00:00:00");
        etiquetatiempo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        VolverMenu.setBackground(new java.awt.Color(42, 52, 27));
        VolverMenu.setFont(new java.awt.Font("Swis721 Blk BT", 0, 12)); // NOI18N
        VolverMenu.setForeground(new java.awt.Color(255, 255, 255));
        VolverMenu.setText("Volver");
        VolverMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        VolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverMenuActionPerformed(evt);
            }
        });

        Tienda.setBackground(new java.awt.Color(210, 185, 86));
        Tienda.setForeground(new java.awt.Color(102, 102, 102));
        Tienda.setText("Tienda");
        Tienda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiendaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Watts");

        numWatts.setFont(new java.awt.Font("Simplex_IV25", 1, 18)); // NOI18N
        numWatts.setForeground(new java.awt.Color(255, 255, 255));
        numWatts.setText("0");
        numWatts.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        Pokemon.setBackground(new java.awt.Color(38, 123, 207));
        Pokemon.setForeground(new java.awt.Color(0, 0, 0));
        Pokemon.setText("Pokemon");
        Pokemon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Pokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PokemonActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 153, 51));
        jButton4.setText("JUGAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(0, 153, 153));
        Guardar.setText("Guardar Partida");
        Guardar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(numWatts)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29))
                    .addComponent(etiquetatiempo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(385, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(VolverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(numWatts))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetatiempo)
                        .addGap(65, 65, 65)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverMenuActionPerformed
        new Musica().Detener();
        setVisible(false);
         
          String fil="temporal.txt";
        File archi=new File(fil);
        if(archi.exists())
            archi.delete();
        
         String f="InfoPartida.txt";
         File arch=new File(f);
        if(arch.exists())
            arch.delete();



        String x="aum.txt";
        File ar=new File(x);
         if(ar.exists())
             ar.delete();

        String e="Partida.txt";
        File d=new File(e);
         if(d.exists())
            d.delete();

      

        String g="Inventario.txt";
        File j=new File(g);
         if(j.exists())
            j.delete();


        String filepath="pokemons_seleccionados.txt";
        File archivo=new File(filepath);
         if(archivo.exists())
            archivo.delete();

 
        
        
           try {
               new MenuInicial().setVisible(true);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(PartidaCargada.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_VolverMenuActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
        StopReloj();
        JOptionPane.showMessageDialog(null, "Partida guardada correctamente", "Guardar Partida", JOptionPane.INFORMATION_MESSAGE);
        new Partida().guardarPartida();
       
     

    }//GEN-LAST:event_GuardarActionPerformed

    
    
    
    
    
    
    private void GuardarPartida() {
         String archivoOrigenPartida = "Partida.txt"; // Reemplaza con la ruta del archivo de origen de la partida
        String archivoOrigenWatts = "watts.txt"; // Reemplaza con la ruta del archivo de origen de los watts
        String archivoDestino = "PartidaCompleta.txt"; // Reemplaza con la ruta del archivo de destino de la partida completa

        try {
            Path origenPartida = Paths.get(archivoOrigenPartida);
            Path origenWatts = Paths.get(archivoOrigenWatts);
            Path destino = Paths.get(archivoDestino);

            Files.write(destino, Files.readAllLines(origenPartida), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.write(destino, Files.readAllLines(origenWatts), StandardOpenOption.APPEND);

            System.out.println("La partida completa se ha guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al guardar la partida completa: " + e.getMessage());
        }
    }
    
    
    
    
    private void TiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiendaActionPerformed
        // TODO add your handling code here:
        new Musica().Detener();
            askAumento(true);
            numWatts.setText(String.valueOf(Watts));
        // Crear un nuevo hilo para abrir la ventana de la tienda
        Thread thread = new Thread(new Runnable() {
        public void run() {
            // Abrir la ventana de la tienda
            new TiendaInterfaz().setVisible(true);
            
            // Imprimir los Watts después de abrir la tienda
            new Auxiliar().debeImprimirWatts(true);
        }
    });
    thread.start();
    }//GEN-LAST:event_TiendaActionPerformed
    
    private void PokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PokemonActionPerformed
       
        askAumento2(true);
        new Musica().Detener();
// TODO add your handling code here:
        numWatts.setText(String.valueOf(Watts));
        new PokemonsAlmacenados().setVisible(true);
         
    }//GEN-LAST:event_PokemonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new Musica().Detener();
        new MENUJUEGOS().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(PartidaCargada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartidaCargada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartidaCargada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartidaCargada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartidaCargada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Pokemon;
    private javax.swing.JButton Tienda;
    private javax.swing.JButton VolverMenu;
    private javax.swing.JLabel etiquetatiempo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel numWatts;
    // End of variables declaration//GEN-END:variables
class Fondo extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Images/MenuPrincipal.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    
                    super.paint(g);
        }
    }
    private void escribirWatts() {
        String nombreArchivo = "watts.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(String.valueOf(Watts));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
