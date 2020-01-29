/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipsjuego;

import static battleshipsjuego.MiVentana.Etiquetas;
import static battleshipsjuego.MiVentana.MapaLLeno;
import static battleshipsjuego.MiVentana.jButton1;
import static battleshipsjuego.MiVentana.jButton2;
import static battleshipsjuego.MiVentana.pComp;
import static battleshipsjuego.MiVentana.pJugador;
import static battleshipsjuego.MiVentana.titulo;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Coordenada extends JLabel{
 Coordenada(String id,int x,int y){
 this.x=x;
 this.y=y;
 switch(id){
     case "Mar":this.setIcon(mar);this.addMouseListener(Marml);break;
     case "Nada":this.setIcon(mar);this.addMouseListener(Nadaml);break;
     case "Jugador":this.setIcon(mar);this.addMouseListener(Jugadorml);break;
     case "Computadora":this.setIcon(mar);this.addMouseListener(Computadoraml);break;
 }
 }   
 ImageIcon marcado=new ImageIcon("nada.jpg");
 ImageIcon jugador=new ImageIcon("barco.jpg");
 ImageIcon computadora=new ImageIcon("barco25.jpg");
 ImageIcon mar=new ImageIcon("aguamar.jfif");
 ImageIcon jugadorDerrotado=new ImageIcon("barcoMuerto.png");
 ImageIcon computadoraDerrotada=new ImageIcon("barcoMuerto2.png");
 int x;
 int y;
 static int[][] marcas;
 static int nJugadores=0;
 static int nComputadoras=0; 
 MouseListener Jugadorml=new MouseListener(){
     @Override
     public void mouseClicked(MouseEvent me2) {
     ataqueJugador();
      pJugador.setText(Integer.toString(5-nComputadoras));
     pComp.setText(Integer.toString(5-nJugadores));
     }

     @Override
     public void mousePressed(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseReleased(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseEntered(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseExited(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }
 };
  MouseListener Computadoraml=new MouseListener(){
     @Override
     public void mouseClicked(MouseEvent me1) {
     ataqueComputadora();
     pJugador.setText(Integer.toString(5-nComputadoras));
     pComp.setText(Integer.toString(5-nJugadores));

     }

     @Override
     public void mousePressed(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseReleased(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseEntered(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseExited(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }
 };
   MouseListener Nadaml=new MouseListener(){
     @Override
     public void mouseClicked(MouseEvent me4) {
     ataqueNada();
       pJugador.setText(Integer.toString(5-nComputadoras));
     pComp.setText(Integer.toString(5-nJugadores));
     }

     @Override
     public void mousePressed(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseReleased(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseEntered(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseExited(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }
 };
  MouseListener Marml=new MouseListener(){
     @Override
     public void mouseClicked(MouseEvent me5) {
     ubicacion();
     }

     @Override
     public void mousePressed(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseReleased(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseEntered(MouseEvent me) {
      //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public void mouseExited(MouseEvent me) {
     //To change body of generated methods, choose Tools | Templates.
     }
 };
  private void ubicacion(){
  if(this.isEnabled()&&nJugadores<5){
   this.setDisabledIcon(jugador);
   this.setEnabled(false);
   marcas[x][y]=1;
   nJugadores++;
  
  if(nJugadores==5){
  ubicaComputadoras();
  jButton1.setEnabled(true);
  jButton2.setEnabled(true);
  }}
  }
  private void ataqueJugador(){
  if(this.isEnabled()){
   this.setDisabledIcon(jugadorDerrotado);
   this.setEnabled(false);
   marcas[x][y]=4;
   nJugadores--;
  if(nJugadores!=0&&nComputadoras!=0){
  randomAtaque();
  }
   else{
      if(nJugadores==0){
      titulo.setText("\t\t\t\t\t\t\t\t\t Perdimos !!!");
      }
      if(nComputadoras==0){
      titulo.setText("\t\t\t\t\t\t\t\t\t Ganamos !!!");
      }
  MapaLLeno();
  }
  }
 
  }
  private void ataqueComputadora(){
  if(this.isEnabled()){
   this.setDisabledIcon(computadoraDerrotada);
   this.setEnabled(false);
   marcas[x][y]=5;
   nComputadoras--;
  if(nJugadores!=0&&nComputadoras!=0){
  randomAtaque();
  }
  else{
      if(nJugadores==0){
      titulo.setText("\t\t\t\t\t\t\t\t\t Perdimos !!!");
      }
      if(nComputadoras==0){
      titulo.setText("\t\t\t\t\t\t\t\t\t Ganamos !!!");
      }
  MapaLLeno();
  }
  }
 
  }
  private void ataqueNada(){
  if(this.isEnabled()){
   this.setDisabledIcon(marcado);
   this.setEnabled(false);
   marcas[x][y]=3;
  randomAtaque();
  }
  
  }
  private void ubicaComputadoras(){
 int a;
 int b;
 for(int i=0;i<5;i++){
  do{
  a=(int) (Math.random() *10);
  b=(int) (Math.random() *10);
  }while(marcas[a][b]!=0);
  marcas[a][b]=2;
  nComputadoras++;
  }
  }
  private void randomAtaque(){
 int at;
 int bt;
   do{
  at=(int) (Math.random() *10);
  bt=(int) (Math.random() *10);
  }while(!(MiVentana.Etiquetas[at][bt].isEnabled()));
   switch(marcas[at][bt]){
       case 0:marcas[at][bt]=3;Etiquetas[at][bt].setDisabledIcon(marcado);Etiquetas[at][bt].setEnabled(false);break;
       case 1:marcas[at][bt]=4;nJugadores--;Etiquetas[at][bt].setDisabledIcon(jugadorDerrotado);Etiquetas[at][bt].setEnabled(false);break;
       case 2:marcas[at][bt]=5;nComputadoras--;Etiquetas[at][bt].setDisabledIcon(computadoraDerrotada);Etiquetas[at][bt].setEnabled(false);break;
   }
    if(nJugadores!=0&&nComputadoras!=0){
  
  }
  else{
     if(nJugadores==0){
      titulo.setText("\t\t\t\t\t\t\t\t\t Perdimos !!!");
      }
      if(nComputadoras==0){
          
      titulo.setText("\t\t\t\t\t\t\t\t\t Ganamos !!!");
      }
  MapaLLeno();
  }
  }
  public static void llenarConCeros(){
      marcas=new int[10][10];
 nJugadores=0;
 nComputadoras=0;
  for(int i=0;i<10;i++){
     for(int j=0;j<10;j++){
     marcas[i][j]=0;
     }
  }
  }
}
