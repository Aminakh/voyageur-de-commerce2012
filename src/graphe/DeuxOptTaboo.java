package graphe;

import java.util.ArrayList;

public class DeuxOptTaboo {
	
	private ArrayList<String> taboo = new ArrayList<String>();
	private int cpt;
	public DeuxOptTaboo(){
		this.taboo.add("");
		this.cpt = 0;
	}
	/** 60-2-2*/
	public ArrayList<Integer> calculDeuxOptTaboo(ArrayList<Integer> l, int [][] coordville, int [][] distville){
		ArrayList<Integer> chemin = new ArrayList<Integer>(l);
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("");
		int distemp;
		int i = 1; //la case 0 est la distance totale et la case 1 est le point de départ, que l'on ne doit pas changer
		int j = 2;	// pour ne pas avoir trois villes consecutives
 		boolean bool = true;
 	while (i  < l.size() -2 /*&& this.taboo.size() <= 10000*/)
 	{
		while(j  < l.size() - 1 /*&& this.taboo.size() <= 10000*/)
		{	
			if(i == j){j = i+1;}
				if(		
					(distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)])
					< 
					(distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)])){
					
					if(!existeDansTaboo((String.valueOf(chemin.get(i)) + " " + String.valueOf(chemin.get(i+1)) + " " + String.valueOf(chemin.get(j)) + " " + String.valueOf(chemin.get(j+1))), temp)){
					
					//System.out.println((String.valueOf(chemin.get(i)) + " " + String.valueOf(chemin.get(i+1)) + " " + String.valueOf(chemin.get(j)) + " " + String.valueOf(chemin.get(j+1))));
					//5812
					distemp = chemin.get(i+1);
					chemin.set(i+1, chemin.get(j));
					chemin.set(j, distemp);
					i = 1;		//on retourne au début du parcours si un chemin plus court est trouvé pour vérifier qu'un aute chemin plus court n'a pas été créé ailleurs
					j = 2;
					}
				}
			j++;
		}
		i++;
		j = 2;
	}
 	return calculDistance(chemin, distville);
}
	
	public boolean existeDansTaboo(String s, ArrayList<String> temp) {
		boolean bool = true;
		boolean bowl = true;
		if(temp.contains(s)){
			bool = false;
			}
		
			if(temp.size() < 50 && bool == true){
				temp.add(s);
			}
			else if (bool == true){
				temp.remove(0);
				temp.add(s);
			}
			else{
				System.out.println(this.taboo.size());
				if(this.taboo.contains(s)){
						bowl = false;
					}
				else{this.taboo.add(s);}}
			
		return bowl == false;
		
	}
	

	public ArrayList<Integer> calculDistance(ArrayList<Integer> chemin, int[][] distville){
		int som = 0;
		
		ArrayList<Integer> l = new ArrayList<Integer>(chemin);
		for(int i = 1 ; i < l.size()-1; i++){
			//System.out.println(i);
			som += distville[l.get(i)][l.get(i+1)];
		}
		
		l.set(0, som );
		
		return l;
		
		
	}
	
}
	















/*System.out.println(" i/j  i+1/j+1 : " +(distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)]));
System.out.println("i/i+1  i+1/j : "+(distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)]));
System.out.println(" i/j : " +(distville[chemin.get(i)][chemin.get(j)]));
System.out.println(" i+1/j+1 : " + distville[chemin.get(i+1)][chemin.get(j+1)]);
System.out.println("i/i+1 : "+ distville[chemin.get(i)][chemin.get(i+1)]);
System.out.println("j/i+1 : " + distville[chemin.get(j)][chemin.get(j+1)]);
System.out.println("--------------------------------------");*/