package graphe;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
	private int [][] distanceville;
	private int [][] coordonneeville;
	private ArrayList<Integer> l;
	private String s;
	
   public Panneau(int [][] cv, int [][] c,ArrayList<Integer> l, String s) {
		this.distanceville = c;
		this.coordonneeville = cv;
		this.l = new ArrayList<Integer> (l);
		this.s = s;
	}

   
public void paintComponent(Graphics g){
	/*for( int i = 0; i < distanceville.length; i++){
		for( int j = 0; j < distanceville.length; j++){
			g.drawString(String.valueOf(distanceville[i][j]), i*30, j*30);
		}
	}*/
	g.drawString(s, 10, 550);
      for( int i = 0; i < coordonneeville.length; i++){
      		g.drawString(String.valueOf(i), this.coordonneeville[i][1]/2, this.coordonneeville[i][2]/2);
      }
  	for (int i=1; i<l.size()-1;i++)
  	{
  		g.drawLine(coordonneeville[l.get(i)][1]/2,coordonneeville[l.get(i)][2]/2,coordonneeville[l.get(i+1)][1]/2,coordonneeville[l.get(i+1)][2]/2);
   }          

}
}