package graphe;

import java.util.ArrayList;

public class DeuxOpt {
		
	public ArrayList<Integer> calculDeuxOpt(ArrayList<Integer> l, int [][] coordville, int [][] distville){
		ArrayList<Integer> chemin = new ArrayList<Integer>(l);
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("dsfdsf");
		int distemp;
		int i = 2; //la case 0 est la distance totale et la case 1 est le point de départ, que l'on ne doit pas changer
 		int j = 2;	// pour ne pas avoir trois villes consecutives
 		boolean bool = true;
 	while (i  < l.size() -2 && bool == true)
 	{
		while(j  < l.size() - 1 && bool == true)
		{
			if(i == j){j = i+1;}
					
			if((distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)])
			< 
			(distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)])){
			
			System.out.println(chemin);
			
			distemp = chemin.get(i+1);
			chemin.set(i+1, chemin.get(j));
			chemin.set(j, distemp);
			i = 2;		//on retourne au début du parcours si un chemin plus court est trouvé pour vérifier qu'un aute chemin plus court n'a pas été créé ailleurs
			j = 2;
			}
			j++;
		}
		i++;
		j = 2;
	}
 	return chemin;
}

	public ArrayList<Integer> calculDistance(ArrayList<Integer> chemin, int[][] distville){
		int som = 0;
		
		ArrayList<Integer> l = new ArrayList<Integer>(chemin);
		for(int i = 1 ; i < l.size()-1; i++){
			som += distville[l.get(i)][l.get(i+1)];
		}
		
		l.set(0, som );
		
		return l;
		
		
	}
	
}
	
