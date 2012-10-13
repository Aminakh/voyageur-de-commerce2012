package graphe;

import java.util.ArrayList;

public class DeuxOpt {

	
	
	public ArrayList<Integer> calculDeuxOpt(ArrayList<Integer> l, int [][] coordville, int [][] distville){
		ArrayList<Integer> chemin = new ArrayList<Integer>(l);
		int distemp;
		int i = 2; //la case 0 est la distance totale et la case 1 est le point de départ, que l'on ne doit pas changer
 		int j = 2;	// pour ne pas avoir trois villes consecutives
 		
 	while (i  < l.size() -2 )
 	{
		while(j  < l.size() - 1)
		{
			if(i == j){j = i+1;}
			//System.out.println("i : " + i + " j : " + j);
			//on vérifie si un chemin plus court entre deux paires de ville n'existe pas
			if(
					(distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)])
					< 
					(distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)]))
			{
				System.out.println(" i/j  i+1/j+1 : " +(distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)]));
				System.out.println("i/i+1  i+1/j : "+(distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)]));
				System.out.println(" i/j : " +(distville[chemin.get(i)][chemin.get(j)]));
				System.out.println(" i+1/j+1 : " + distville[chemin.get(i+1)][chemin.get(j+1)]);
				System.out.println("i/i+1 : "+ distville[chemin.get(i)][chemin.get(i+1)]);
				System.out.println("j/i+1 : " + distville[chemin.get(j)][chemin.get(j+1)]);
				System.out.println("--------------------------------------");
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
	
	return calculDistance(chemin, distville);
	}
	
	public ArrayList<Integer> calculDistance(ArrayList<Integer> chemin, int[][] distville){
		int som = 0;
		
		ArrayList<Integer> l = new ArrayList<Integer>(chemin);
		System.out.println(l.size());
		for(int i = 1 ; i < l.size()-1; i++){
			System.out.println(i);

			som += distville[l.get(i)][l.get(i+1)];
		}
		
		l.set(0, som );
		
		return l;
		
		
	}
	
}
	

//distemp = chemin.get(0) - distville[chemin.get(i)][chemin.get(i+1)] - distville[chemin.get(j)][chemin.get(j+1)];
//a = distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)];
//int b = distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)];
//System.out.println("i : " + i + " j : " +j);
//System.out.println("chemin : " + chemin.get(0) + " base : " + b + " à comparer : " + a + " i : " + i + " j : " + j);