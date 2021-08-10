package flujoMexPue;


import flujoMexPue.FlujoMaximo;
import flujoMexPue.Arbol;
import flujoMexPue.Algoritmo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import flujoMexPue.Pintar;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Jose Perez
 */
public class Mapa extends javax.swing.JFrame {
    
   
    
    Pintar pintar =new Pintar();
   Arbol arboles = new Arbol();    
   public static void R_repaint(int tope, Arbol arboles){
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if(arboles.getmAdyacencia(j, k) == 1)
                     Pintar.pintarLinea(jPanel1.getGraphics(),arboles.getCordeX(j),arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k),arboles.getmCoeficiente(j, k));
            }
        }
        for (int j = 0; j < tope; j++) 
            Pintar.pintarCirculo(jPanel1.getGraphics(), arboles.getCordeX(j),arboles.getCordeY(j),String.valueOf(arboles.getNombre(j)));
                
   }
 
public static int ingresarNodoOrigen(String nodoOrige, String noExiste,int tope){
    int nodoOrigen = 0;
        try{
            nodoOrigen = Integer.parseInt(JOptionPane.showInputDialog(""+nodoOrige));   
            if(nodoOrigen>=tope){  
                  JOptionPane.showMessageDialog(null,""+noExiste+"\nNo Existe el nodo, ingrese otro ");
                  nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste, tope);
            }
        }catch(Exception ex){
            nodoOrigen = ingresarNodoOrigen(nodoOrige,noExiste,tope);
        }
        return nodoOrigen;
}          
 public  int ingresarTamano(String tama){        
        int tamano = 0;
        try{
            tamano = Integer.parseInt(JOptionPane.showInputDialog(""+tama));
            if(tamano<1){ JOptionPane.showMessageDialog(null,"peso no valido");
               tamano = ingresarTamano(tama);
            }
        }catch(Exception ex){
            tamano = ingresarTamano(tama);
        }
        return tamano;
    }
 public boolean clicDerechoSobreNodo(int xxx,int yyy){ 
     for (int j = 0; j < tope; j++) {
            if((xxx+5) > arboles.getCordeX(j) && xxx < (arboles.getCordeX(j)+16) && (yyy+5) > arboles.getCordeY(j) && yyy<(arboles.getCordeY(j)+16) ) {
                                       
               if(n==0){
                   id = j;
                   R_repaint(tope,arboles);
                   Pintar.clickSobreNodo(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.BLUE);       
                   n++;                   
               }
               else{ 
                   id2=j;                   
                   n++;
                   Pintar.clickSobreNodo(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.BLUE);       
                   if(id==id2){
                       n=0;
                       Pintar.pintarCirculo(jPanel1.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id),String.valueOf(arboles.getNombre(id)));
                       id=-1;
                       id2=-1;
                   }
               } 
               nn=0;
                return true;              
            }
         }
     return false;
 }  
 public void clicIzqSobreNodo(int xxx, int yyy){
            for (int j = 0; j <tope; j++) {
              if((xxx+2) > arboles.getCordeX(j) && xxx < (arboles.getCordeX(j)+13) && (yyy+2) > arboles.getCordeY(j) && yyy<(arboles.getCordeY(j)+13) ) {
                if(nn==0){
                   permanente =j; 
                   R_repaint(tope, arboles);                   
               }
               else{ nodoFin = j;}
                nn++;
                n=0;
                id =-1;
                Pintar.clickSobreNodo(jPanel1.getGraphics(), arboles.getCordeX(j), arboles.getCordeY(j), null,Color.GREEN);  
                   break;
               }
           
            }
            
     
 }
 int i;
 //
 public void R_repaint(){
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < i; k++) {
                if(arboles.getmAdyacencia(j, k) == 1)
                Pintar.pintarLinea(Mapa.jPanel1.getGraphics(),arboles.getCordeX(j),arboles.getCordeY(j), arboles.getCordeX(k), arboles.getCordeY(k),arboles.getmCoeficiente(j, k));
            }
        }
        for (int j = 0; j < i; j++) {
            Pintar.pintarCirculo(Mapa.jPanel1.getGraphics(), arboles.getCordeX(j),arboles.getCordeY(j),String.valueOf(arboles.getNombre(j)));
           
       }
   }
 //
 

public class Imagen extends javax.swing.JPanel {
 
public Imagen() {
this.setSize(600, 600); 
}

public void paint(Graphics grafico) {
    Dimension height = getSize(); 
ImageIcon Img = new ImageIcon(getClass().getResource("/imagenes/distrito-puebla.jpg")); 
grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
setOpaque(false);
super.paintComponent(grafico);
}
}
    public Mapa() {
        initComponents();
        
    }
    
    public Mapa(Pintar pinta , Arbol arbol ,int ii) {
        initComponents();
        i=ii;
        this.pintar =pinta;
       this.arboles=arbol;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        n1 = new javax.swing.JTextField();
        n2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jmapa = new javax.swing.JLabel();
        jtacumulado = new javax.swing.JTextField();
        fm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 610, 61, 60);

        jButton1.setText("Calcula Minimo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 630, 101, 23);

        jButton3.setText("Flujo Maximo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(630, 620, 95, 23);

        jButton5.setText("Eliminar Nodo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(530, 630, 97, 23);
        getContentPane().add(n1);
        n1.setBounds(100, 630, 70, 20);
        getContentPane().add(n2);
        n2.setBounds(220, 630, 80, 20);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jmapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jmapaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jmapa, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jmapa, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 850, 590);
        getContentPane().add(jtacumulado);
        jtacumulado.setBounds(440, 630, 70, 20);

        fm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmActionPerformed(evt);
            }
        });
        getContentPane().add(fm);
        fm.setBounds(740, 620, 70, 20);

        jLabel1.setText("Valor inicial");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 610, 60, 14);

        jLabel2.setText("Valor final");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 610, 60, 14);

        jLabel3.setText("Valor agregado");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 670, 80, 14);

        jButton4.setText("Eliminar Arista");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(530, 660, 99, 23);

        jButton6.setText("Eliminar Aristas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(640, 660, 105, 23);

        jButton7.setText("Eliminar Todo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(760, 660, 95, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Flujo maximo
        if(n1.getText().equals("") || n2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Faltan datos");
        }else{
            FlujoMaximo m =new FlujoMaximo();
            int x=Integer.parseInt(n1.getText());
            int y=Integer.parseInt(n2.getText());
            String flujo;
            
            int fm2=m.fordFulkerson(m.mati(tope, arboles, 2, tope) , x, y, tope);
            
            fm.setText(""+fm2+"");
            JOptionPane.showMessageDialog(null,fm2);
            n1.setText(null);
            n2.setText(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // calcula minimo
        if(tope>=2){
            permanente =  ingresarNodoOrigen("Ingrese Nodo Origen","nodo Origen No existe",tope);
            nodoFin =  ingresarNodoOrigen("Ingrese Nodo Destino","nodo destion No existe",tope);
            Algoritmo c = new Algoritmo(arboles,tope,permanente,nodoFin);
            c.camino();
            jtacumulado.setText(""+c.getAcumulado());
            JOptionPane.showInputDialog(null,"El valor de flujo máximo es ", JOptionPane.QUESTION_MESSAGE + c.getAcumulado());

        }
        else JOptionPane.showMessageDialog(null,"nodos insuficientes ");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Iniciar

        Imagen Imagen = new Imagen();
        jPanel1.add(Imagen);
        //jPanel1.repaint();
        jPanel1.paint(jPanel1.getGraphics());
        n=0;
        id=-1;
        id2=-1;

        int Matriz[][]={    {0,0,0,0,1,0,0,0,1,0,0,0,1,1,0,1,0,0,0,0,0,0},
            {0,0,0,0,1,1,0,1,1,0,1,1,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,1,1,0,0,0,1},
            {1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
            {0,1,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,0,0,1,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0},
            {0,1,0,1,0,1,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,1,0,0,0,1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0},
            {1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0},
            {1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0},
            {1,1,0,0,1,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1},
            {0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1},
            {0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1},
            {0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,1,1,0,1,0}
        };

        int coe[][]={     {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };

        int xx1[]={245,190,325,248,175,215,259,194,215,310,238,245,295,355,272,260,290,315,350,275,305,260};
        int yy1[]={500,370,335,233,475,350,140,315,415,270,335,370,400,465,335,445,210,223,170,100,200,200};
        int nom[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        aristaMayor=600;
        for (int j = 0; j < 22; j++) {
            arboles.setCordeX(j, xx1[j]);
            arboles.setCordeY(j, yy1[j]);
            arboles.setNombre(j, nom[j]);

        }
        for (int j = 0; j < 22; j++) {
            for (int k = 0; k < 22; k++) {
                arboles.setmAdyacencia(j,k, Matriz[j][k]);
                arboles.setmCoeficiente(j, k, coe[j][k]);
            }
        }
        tope=22;
        R_repaint(tope,arboles);

    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:

        int xxx, yyy;
        xxx=evt.getX();
        yyy=evt.getY();
        if(evt.isMetaDown()){
            clicIzqSobreNodo(xxx, yyy );
            if(nn==2){
                nn=0;
                Algoritmo c = new Algoritmo(arboles,tope,permanente, nodoFin);
                c.camino();
                JOptionPane.showMessageDialog(null,c.getAcumulado());

            }
        }
        else{
            if(!clicDerechoSobreNodo(xxx,yyy)){
                if(tope<100){
                    arboles.setCordeX(tope,xxx);
                    arboles.setCordeY(tope,yyy);
                    arboles.setNombre(tope, tope);
                    Pintar.pintarCirculo(jPanel1.getGraphics(),arboles.getCordeX(tope), arboles.getCordeY(tope),String.valueOf(arboles.getNombre(tope)));
                    tope++;
                }
                else JOptionPane.showMessageDialog(null,"Maximo de nodos");
            }
            if(n==2 ){
                n=0;
                int  ta = ingresarTamano("Ingrese peso");
                if(aristaMayor < ta) aristaMayor=ta;
                arboles.setmAdyacencia(id2, id, 1);
                arboles.setmAdyacencia(id, id2, 1);
                arboles.setmCoeficiente(id2, id,ta );
                arboles.setmCoeficiente(id, id2, ta);
                Pintar.pintarLinea(jPanel1.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id), arboles.getCordeX(id2), arboles.getCordeY(id2), ta);
                Pintar.pintarCirculo(jPanel1.getGraphics(),arboles.getCordeX(id), arboles.getCordeY(id),String.valueOf(arboles.getNombre(id)));
                Pintar.pintarCirculo(jPanel1.getGraphics(),arboles.getCordeX(id2), arboles.getCordeY(id2),String.valueOf(arboles.getNombre(id2)));
                id=-1;
                id2=-1;
            }
        }

    }//GEN-LAST:event_jPanel1MousePressed

    private void jmapaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmapaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmapaMousePressed

    private void fmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:Eliminar nodo
        int Eliminar= ingresarNodoOrigen("Ingrese Nodo a Eliminar ","El Nodo No existe",tope);
        if(Eliminar<=tope && Eliminar>=0 && tope>0){
            for (int j = 0; j < tope; j++) {
                for (int k = 0; k < tope; k++){
                    if(j==Eliminar ||k==Eliminar){
                        arboles.setmAdyacencia(j, k, -1);
                    }
                }
            }
            for (int l = 0; l < tope-1; l++) {
                for (int m = 0; m < tope; m++) {
                    if(arboles.getmAdyacencia(l, m)==-1){
                        arboles.setmAdyacencia(l, m,arboles.getmAdyacencia(l+1, m));
                        arboles.setmAdyacencia(l+1, m,-1);
                        arboles.setmCoeficiente(l, m,arboles.getmCoeficiente(l+1, m));
                    }
                }
            }
            for (int l = 0; l < tope; l++) {
                for (int m = 0; m < tope-1; m++) {

                    if(arboles.getmAdyacencia(l, m)==-1){
                        arboles.setmAdyacencia(l, m,arboles.getmAdyacencia(l, m+1));
                        arboles.setmAdyacencia(l, m+1,-1);
                        arboles.setmCoeficiente(l, m,arboles.getmCoeficiente(l, m+1));

                    }
                }
            }

            arboles.setCordeX(Eliminar,-10);
            arboles.setCordeY(Eliminar,-10);
            arboles.setNombre(Eliminar, -10);
            for (int j = 0; j < tope; j++) {
                for (int k = 0; k < tope-1; k++) {
                    if(arboles.getCordeX(k)==-10){
                        arboles.setCordeX(k, arboles.getCordeX(k+1));
                        arboles.setCordeX(k+1, -10);
                        arboles.setCordeY(k, arboles.getCordeY(k+1));
                        arboles.setCordeY(k+1, -10);
                        arboles.setNombre(k, arboles.getNombre(k+1));
                        arboles.setNombre(k+1,-10);
                    }
                }
            }
            for (int j = 0; j < tope; j++)
            arboles.setNombre(j,j);

            for (int j = 0; j < tope+1; j++) {
                for (int k = 0; k < tope+1; k++) {
                    if( arboles.getmAdyacencia(j, k)!=-1)
                    arboles.setmAdyacencia(j, k, arboles.getmAdyacencia(j, k));
                    else
                    arboles.setmAdyacencia(j, k, 0);
                    if(arboles.getmCoeficiente(j, k) !=-10)
                    arboles.setmCoeficiente(j, k, arboles.getmCoeficiente(j, k));
                    else
                    arboles.setmCoeficiente(j, k, 0);
                }
            }
            tope--;
            jPanel1.paint(jPanel1.getGraphics());
            R_repaint(tope,arboles);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:Eliminar arista

        if(tope>=2){

            int x;int y;int ta;
            if(n1.getText().length()<1 || n2.getText().length()<1 )
            JOptionPane.showMessageDialog(null,"Faltan datos ");
            else{
                x=Integer.parseInt(n1.getText());
                y=Integer.parseInt(n2.getText());

                if(x==y)
                JOptionPane.showMessageDialog(null,"Debe ingresar un nodo diferente a : "+y);
                else if(x<0 || x>=tope || y<0 || y>=tope){
                    JOptionPane.showMessageDialog(null,"Nodos No validos ");
                }else{
                    arboles.setmAdyacencia(x, y, 0);
                    arboles.setmAdyacencia(y, x, 0);
                    arboles.setmCoeficiente(x, y, 0);
                    arboles.setmCoeficiente(y, x, 0);
                    n1.setText(null);
                    n2.setText(null);
                    Mapa.jPanel1.paint(Mapa.jPanel1.getGraphics());

                    R_repaint();

                }
            }

        }
        else{
            JOptionPane.showMessageDialog(null,"No Hay Nodos Enlazados");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:Eliminar arista
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                arboles.setmAdyacencia(j, k, 0);
                arboles.setmAdyacencia(k, j, 0);
                arboles.setmCoeficiente(j, k, 0);
                arboles.setmCoeficiente(k, j, 0);
            }
        }
        jPanel1.paint(jPanel1.getGraphics());
        R_repaint(tope,arboles);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:Eliminar todo

        for (int j = 0; j < tope; j++) {
            arboles.setCordeX(j,0);
            arboles.setCordeY(j,0);
            arboles.setNombre(j,0);
        }
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                arboles.setmAdyacencia(j, k, 0);
                arboles.setmCoeficiente(j, k, 0);
            }
        }
        tope=00;
        jPanel1.repaint();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
                                        

    FlujoMaximo m =new FlujoMaximo();
    
   
    private void n1KeyReleased(java.awt.event.KeyEvent evt) {                               
        // TODO add your handling code here:
        String tem = new String(n1.getText());
        StringBuffer tem2= new StringBuffer();
        for (int j = 0; j < tem.length(); j++) {
            if(Character.isDigit(tem.charAt(j))){
                tem2.append(tem.charAt(j));
            }
        }
        n1.setText(""+tem2);
    }                              

    private void n2KeyReleased(java.awt.event.KeyEvent evt) {                               
        // TODO add your handling code here:
        String tem = new String(n2.getText());
        StringBuffer tem2= new StringBuffer();
        for (int j = 0; j < tem.length(); j++) {
            if(Character.isDigit(tem.charAt(j))){
                tem2.append(tem.charAt(j));
            }
        }
        n2.setText(""+tem2);    
    }                                                                      
                                       

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
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mapa().setVisible(true);
                
            }
        });
    }
    private int tope=0;// lleva el # de nodos creado 
    private int nodoFin;
    private int permanente;
    int n=0,nn=0,id,id2;// permite controlar que se halla dado click sobre un nodo
    private int aristaMayor;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jmapa;
    private javax.swing.JTextField jtacumulado;
    private javax.swing.JTextField n1;
    private javax.swing.JTextField n2;
    // End of variables declaration//GEN-END:variables
}
