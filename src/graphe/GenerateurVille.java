package graphe;
import java.util.Random;

public class GenerateurVille {
	private  int nbville; //nombre de villes
	private  int [][] ville;
	private int seed;
	
	
	
	public GenerateurVille(int nombredevilles, int seed){
		this.nbville = nombredevilles;
		this.ville = new int [nombredevilles][nombredevilles];
		this.seed = seed;
	}
	
	
	//getter setter
	public int getNbville()
	{
		return nbville;
	}


	public int[][] getVille()
	{
		return ville;
	}


	/**
	 * crée une premier tableau dans lequel on stock les numéros des villes et leurs coordonnées pour ensuite calculer un nouveau
	 * tableau avec leur éloignement
	 */ 
	
	public int [][] genereCoordonnees(){
		int [][] tab = new int [this.getNbville()][3];
		Random generateur = new Random(this.seed);
		
		/**
		 * dans la premiere case on range l'indice de la ville, c'est à dire le numéro permettant de la représenter
		 * dans la deuxieme case on range son abscisse
		 * dans la troisieme case on range son ordonnée
		 * ou l'inverse peut importe
		 * la valeur maximale pour l'indice et l'ordonnée est fixée à 999 pour avoir des valeurs raisonnables
		 */
		for(int i = 0; i < tab.length; i++){
			int abcisse = 1+generateur.nextInt(999);
			int ordonnee = 1+generateur.nextInt(999);
			tab[i][0] = i;
			tab[i][1] = abcisse;
			tab[i][2] = ordonnee;
			
		}
		return tab;
	}
	
	
	/**
	 * calcul l'éloignement entre les villes contenues dans le tableau précédemment créé et le range dans un nouveau tableau
	 */
	
	public  int [][] calculDistanceVille (int[] [] tab){
		for (int i = 0; i < this.getNbville(); i++){
			for (int j = 0; j < this.getNbville(); j++){
				if(i==j){this.getVille()[i][j] = 999999;}
				else{
				this.getVille()[i][j] = Math.abs(tab[i][1] - tab[j][1]) + Math.abs(tab[i][2] - tab[j][2]);
				}
			}
		}
		return this.getVille();		
	}
	


// méthode d'affichage de l'abscisse et de l'ordonnée des villes
	//totalement inutile
/*public void afficheCoordonnees(int [][] tab){
	for (int i = 0; i < tab.length; i++){
		System.out.print("ville n° " +tab[i][0]);
		System.out.print(" abscisse : " + tab[i][1]);
		System.out.println(" ordonnée : " + tab[i][2]);
		System.out.println("***************");
	}	
}

	//méthode d'affichage du tableau de la distance entre les villes, utile pour verifer le meilleur trajet
	// si le nombre ville est faible
public void afficheDistanceville(int ville[][]){
	for (int i = 0; i < this.getVille().length; i++){
		System.out.print("\t" + i+"");}
	System.out.print("\n");
	System.out.print("\n");
		
	for (int i = 0; i < this.getVille().length; i++){
		System.out.print(i + "\t");
			for (int j = 0; j < this.getVille().length; j++){
			System.out.print(this.getVille()[i][j] + "\t");
			}
		System.out.println("");
		}
}
*/
}

