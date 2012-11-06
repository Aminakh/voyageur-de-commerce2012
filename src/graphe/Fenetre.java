package graphe;
import java.util.ArrayList;

import javax.swing.JFrame;
 
public class Fenetre extends JFrame {

   public Fenetre(int [][] cv, int [][] v, ArrayList<Integer> l, String s){      
	
	  
      this.setTitle("Villes");
      this.setSize(600, 600);
      this.setLocationRelativeTo(null);               
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setContentPane(new Panneau(cv, v, l, s));
      this.setVisible(true);
      
     
      
   }

    
}