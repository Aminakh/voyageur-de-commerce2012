package graphe;

import java.util.ArrayList;

public class ApproximationAC {
	private ArrayList<Integer> [] tabville;
	
	public ApproximationAC ( int n){
		this.tabville = new ArrayList [n];
		for (int i = 0; i < n; i++){
			this.tabville[i] = new ArrayList<Integer>();
		}
	}
	/**
	 * @param distville : la matrice de distance entre les villes
	 */
	public void creeArbre(int [][] distville){
		int indk = 0;
		int indj = 0;
		int distmin = 999999;
		ArrayList<Integer> villechecked = new ArrayList<Integer> ();
		villechecked.add(0);
		
		while(!(villechecked.size() == this.tabville.length)){ //on veut remplir chaque case du tableau
			for(int j = 0; j < villechecked.size(); j++){
				for(int k = 0; k < this.tabville.length; k++){
					if(distville[villechecked.get(j)][k] < distmin && !villechecked.contains(k)){
						distmin = distville[villechecked.get(j)][k];
						indk = k;
						indj = j;
					}
				}
			}
			System.out.println(villechecked);
			distmin = 999999;
			if(villechecked.size() < this.tabville.length )
				villechecked.add(indk);
				this.tabville[villechecked.get(indj)].add(indk);
				this.tabville[indk].add(villechecked.get(indj));
		}
	
		for(int i = 0; i < this.tabville.length; i++){
			System.out.println(this.tabville[i]);
		}
	}
	
	
	
}
