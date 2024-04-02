/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Estructuras.List;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import pokemonpikachu.Musica;


/**
 *
 * @author Antonella
 */
public class TiendaInterfaz extends javax.swing.JFrame {
      String obj,relacion;
      private int Watts;
      private int montoAcumulado=0;
      private List<String>Inventario;
      private String nroRelacion;
     
    /**
     * Creates new form Tienda
     */
    public TiendaInterfaz() {
        initComponents();
        Inventario= new List<>();
        tabla.setModel(leerDatosDesdeArchivo("prueba.txt"));
         new Musica().Detener();
        new Thread(() -> {
          new Musica().Reproducir("src/Sonidos/Tienda.wav", -10.0f);
      }).start();
        
        
          new Thread(() -> {
        try {
            // Mini retraso para obtener los datos de los watts correctamente
            Thread.sleep(500);

            // actualizar watts
            Watts = new Auxiliar().obtenerWatts();
            watts.setText(String.valueOf(Watts));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }).start();
    }
    
   
    public static DefaultTableModel leerDatosDesdeArchivo(String rutaArchivo) {
        String[] columnas = {"Regalo", "Costo", "Efecto"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String regalo = datos[0].trim();
                String costo = datos[1].trim();
                String efecto = datos[2].trim();

                // Agrega la fila al modelo del JTable
                modelo.addRow(new Object[]{regalo, costo, efecto});
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modelo;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        carro = new javax.swing.JButton();
        compra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listacompra = new javax.swing.JTextArea();
        pagar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        watts = new javax.swing.JLabel();
        out = new javax.swing.JButton();
        Montototal = new javax.swing.JTextField();
        vaciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setText("TIENDA");

        tabla.setFont(new java.awt.Font("Swis721 Cn BT", 1, 12)); // NOI18N
        tabla.setForeground(new java.awt.Color(0, 153, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Baya Aranja",  new Integer(100), "+100 Relacion"},
                {"Baya Caquic",  new Integer(200), "+250  Relacion"},
                {"Poke Ball",  new Integer(300), "+400 Relacion"},
                {"Baya Zreza",  new Integer(400), "+550 Relacion"},
                {"Baya Zanama",  new Integer(500), "+700 Relacion"},
                {"Baya Ziula",  new Integer(600), "+850 Relacion"},
                {"Baya Zidra",  new Integer(700), "+1000 Relacion"},
                {"Baya Enigma ",  new Integer(800), "+1150 Relacion"},
                {"Caramelo raro",  new Integer(900), "+1300  Relacion"}
            },
            new String [] {
                "Regalo", "Costo", "Efecto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabla.setShowGrid(true);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        carro.setBackground(new java.awt.Color(0, 102, 0));
        carro.setForeground(new java.awt.Color(173, 187, 173));
        carro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/carrito.png"))); // NOI18N
        carro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carroActionPerformed(evt);
            }
        });

        compra.setForeground(new java.awt.Color(173, 187, 173));
        compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraActionPerformed(evt);
            }
        });

        jScrollPane2.setForeground(new java.awt.Color(173, 187, 173));

        listacompra.setBackground(new java.awt.Color(71, 159, 85));
        listacompra.setColumns(20);
        listacompra.setFont(new java.awt.Font("Swis721 Lt BT", 1, 12)); // NOI18N
        listacompra.setForeground(new java.awt.Color(51, 51, 51));
        listacompra.setRows(5);
        listacompra.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrito"));
        listacompra.setCaretColor(new java.awt.Color(51, 51, 0));
        listacompra.setEnabled(false);
        jScrollPane2.setViewportView(listacompra);

        pagar.setBackground(new java.awt.Color(255, 255, 204));
        pagar.setForeground(new java.awt.Color(51, 51, 51));
        pagar.setText("Pagar");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon/watts.png"))); // NOI18N

        watts.setFont(new java.awt.Font("Simplex_IV50", 1, 14)); // NOI18N
        watts.setText("0");
        watts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(161, 161, 84)));

        out.setBackground(new java.awt.Color(153, 0, 0));
        out.setText("<");
        out.setBorder(null);
        out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outActionPerformed(evt);
            }
        });

        Montototal.setBorder(javax.swing.BorderFactory.createTitledBorder("Monto Total"));

        vaciar.setBackground(new java.awt.Color(153, 102, 0));
        vaciar.setText("Vaciar Carrito");
        vaciar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(158, 158, 158)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(watts, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(vaciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Montototal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pagar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(compra, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(watts, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vaciar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(compra)
                            .addComponent(carro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Montototal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outActionPerformed
        // TODO add your handling code here:
        new Musica().Detener();
        setVisible(false);
    }//GEN-LAST:event_outActionPerformed

    private void compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraActionPerformed
       
    }//GEN-LAST:event_compraActionPerformed

    private void tablaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMousePressed
        //Encontrar numericos en el texto
         Pattern patron = Pattern.compile("\\d+");
        
        
        int filaseleccionada= this.tabla.getSelectedRow();
          obj= tabla.getValueAt(filaseleccionada, 0).toString();
          relacion=tabla.getValueAt(filaseleccionada, 2).toString();
          Matcher matcher =patron.matcher(relacion);
          
          while(matcher.find()){
              nroRelacion=matcher.group();
          }
          
          
          
          int monto=Integer.parseInt( tabla.getValueAt(filaseleccionada, 1).toString());
          compra.setText(tabla.getValueAt(filaseleccionada, 0).toString());
          montoAcumulado+=monto;
           escribirRelacionEnArchivo(nroRelacion);
    }//GEN-LAST:event_tablaMousePressed

    
    private void escribirRelacionEnArchivo(String relacion) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("temporal.txt"))) {
        String txt="Relacion:"+relacion;
        writer.write(txt);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
    private void carroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carroActionPerformed
          if(obj!=null){
        listacompra.append(obj+"\n");
          Montototal.setText(String.valueOf(montoAcumulado));}
          else{
              JOptionPane.showMessageDialog(null, "Debes Ingresar un regalo de la tienda", "Error", JOptionPane.ERROR_MESSAGE);
          }
          
          
    }//GEN-LAST:event_carroActionPerformed
 public String obtenerNroRelacion() {
        return nroRelacion;
    }
    
    
    
    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
      new Musica().Detener();
        int credito=Integer.parseInt(watts.getText());
        if(credito < montoAcumulado){
           JOptionPane.showMessageDialog(null, "No tienes los watts necesarios para comprar todo eso! ", "Fondo Insuficiente", JOptionPane.ERROR_MESSAGE);
           
       }else if(credito>= montoAcumulado){
           
           String texto=listacompra.getText();
           if(texto.isEmpty()){
               JOptionPane.showMessageDialog(null, "No has agregado nada al carro!");
           }else{
           
                    credito -= montoAcumulado;
                    watts.setText(String.valueOf(credito));
                  JOptionPane.showMessageDialog(null, "La compra se realizó exitosamente", "Compra exitosa", JOptionPane.INFORMATION_MESSAGE);

                   new Auxiliar().saveToTxt(String.valueOf(montoAcumulado), "aum.txt");


                   new ElegirPok().setVisible(true);

                  //Guardar el Inventario
                  texto=listacompra.getText();
                  String[] lineas = texto.split("\n");
                  for (String linea : lineas) {
                      Inventario.insertarFinal(linea); }

                  try {
                  // Especifica la ruta y el nombre del archivo
                  String rutaArchivo = "Inventario.txt";

                      try ( // Crea un BufferedWriter para escribir en el archivo
                              BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                          // Escribe cada Pokémon en una línea del archivo
                          for (int i = 0; i < Inventario.getSize(); i++) {
                              String pokemons = Inventario.get(i);
                              writer.write(pokemons);
                              writer.newLine(); 

                          }}
                  
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }
         setVisible(false);
           }}
        
      
    }//GEN-LAST:event_pagarActionPerformed

    private void vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarActionPerformed
        listacompra.setText("");
        montoAcumulado=0;
        Montototal.setText(String.valueOf(montoAcumulado));
    }//GEN-LAST:event_vaciarActionPerformed

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
            java.util.logging.Logger.getLogger(TiendaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiendaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiendaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiendaInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TiendaInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Montototal;
    private javax.swing.JButton carro;
    private javax.swing.JTextField compra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea listacompra;
    private javax.swing.JButton out;
    private javax.swing.JButton pagar;
    private javax.swing.JTable tabla;
    private javax.swing.JButton vaciar;
    private javax.swing.JLabel watts;
    // End of variables declaration//GEN-END:variables
class Fondo extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Images/tt.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
                    setOpaque(false);
                    
                    super.paint(g);
        }
    }}
