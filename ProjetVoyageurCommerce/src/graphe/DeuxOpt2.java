package graphe;

import java.util.ArrayList;


public class DeuxOpt2
{
	public ArrayList<Integer> calculDeuxOpt2(ArrayList<Integer> l, int [][] coordville, int [][] distville){
		ArrayList<Integer> chemin = new ArrayList<Integer>(l);
		int distemp;

for (int i=2; i<l.size()-2; i++)
	{
		for (int j = 3; j<l.size()-1; j++)
		{
			System.out.println("      i : "+i + " j : " + j);
		if (j!=i+1 & j!=i-1)
		{
			if (distville[l.get(i)][l.get(i+1)]+distville[l.get(j)][l.get(j+1)]>distville[l.get(i)][l.get(j)]+distville[l.get(i+1)][l.get(j+1)])
		{
			distemp = chemin.get(i+1);
			chemin.set(i+1, chemin.get(j));
			chemin.set(j, distemp);
		}
		}
		}
	
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