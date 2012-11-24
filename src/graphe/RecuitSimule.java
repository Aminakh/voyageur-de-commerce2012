package graphe;

import java.util.ArrayList;

public class RecuitSimule {
	
	/** 60-2-2*/
	public static ArrayList<Integer> calculRecuit(ArrayList<Integer> l, int [][] coordville, int [][] distville){
		ArrayList<Integer> chemin = new ArrayList<Integer>(l);
		
		int i = 1; //la case 0 est la distance totale et la case 1 est le point de départ, que l'on ne doit pas changer
		int j = 2;	// pour ne pas avoir trois villes consecutives
		double p = 0;
		int nbit = 0;
		int a = 0;
 	while (i  < l.size() -2 )
 	{
		while(j  < l.size() - 1 )
		{	
			ArrayList<Integer> cheminbis = new ArrayList<Integer>(chemin);
			cheminbis.set(i+1, chemin.get(j));
			cheminbis.set(j, chemin.get(i+1));
			cheminbis.set(0, calculDistance(cheminbis, distville));
			//System.out.println("chemin : "+chemin.get(0));
			if(nbit == 1000){
				p += 0.01;
				nbit = 0;
			}
			
			if(p >= 1)
				p = 0;
			
			nbit ++;
			if((double)(cheminbis.get(0)) < (double)((1+p)*chemin.get(0)) /*|| detecteCroisement(chemin, coordville, i , j)*/){
				System.out.println("chemin bis : "+(double)(cheminbis.get(0)));
				System.out.println((double)((1+p)*chemin.get(0)));
				chemin.clear();
				chemin.addAll(cheminbis);
				i = 1;		//on retourne au début du parcours si un chemin plus court est trouvé pour vérifier qu'un aute chemin plus court n'a pas été créé ailleurs
				j = 2;
					
				}
			j++;
		}
		i++;
		j = 2;
	}
 	return chemin;
}
	
	
	
	public static int calculDistance(ArrayList<Integer> chemin, int[][] distville){
		int som = 0;
		ArrayList<Integer> l = new ArrayList<Integer>(chemin);
		for(int i = 1 ; i < l.size()-1; i++){
			som += distville[l.get(i)][l.get(i+1)];
		}
		return som;
		
		
	}
	
}
