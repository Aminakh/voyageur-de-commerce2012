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
	public void calculDeuxOptTaboo(ArrayList<Integer> chemin, int [][] coordville, int [][] distville){
		ArrayList<String> temp = new ArrayList<String>();
		
		int size = chemin.size();
		
		temp.add("");
		int distemp;
		int k = 0;
		int i = 1; //la case 0 est la distance totale et la case 1 est le point de départ, que l'on ne doit pas changer
		int j = 2;	// pour ne pas avoir trois villes consecutives
 		//boolean bool = true;
 	while (i  < size -2/* && k < 200000*/)
 	{
		while(j  < size - 1 /*&& k < 200000*/ )
		{	
			if(i == j){j = i+1;}
				if(		
					((distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)])
					< 
					(distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)])) | detecteCroisement(chemin, coordville, i , j)  & !detecteCroisement(chemin, coordville, i+1 , j)){
					
					if(!existeDansTaboo((String.valueOf(chemin.get(i)) + " " + String.valueOf(chemin.get(i+1)) + " " + String.valueOf(chemin.get(j)) + " " + String.valueOf(chemin.get(j+1))), temp)){
					
					//System.out.println((String.valueOf(chemin.get(i)) + " " + String.valueOf(chemin.get(i+1)) + " " + String.valueOf(chemin.get(j)) + " " + String.valueOf(chemin.get(j+1))));
					//5812
						k++;
				//	System.out.println(k);
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
 	chemin = calculDistance(chemin, distville);
}
	
	public boolean existeDansTaboo(String s, ArrayList<String> temp) {
		boolean bool = true;
		boolean bowl = true;
		if(temp.contains(s)){
			bool = false;
			}
		
			if(temp.size() < 500 && bool == true){
				temp.add(s);
			}
			else if (bool == true){
				temp.remove(0);
				temp.add(s);
			}
			/*else{
				System.out.println(this.taboo.size());
				if(this.taboo.contains(s)){
						bowl = false;
					}
				else{this.taboo.add(s);}}*/
			
		return bool == false;
		
	}
	
	public boolean detecteCroisement(ArrayList<Integer> l, int[][] coordville, int i, int j){
		boolean bool = false;
		//System.out.println("droite entre : " + l.get(i) + " et " + l.get(i+1));
		if(coordville[l.get(i+1)][1] != coordville[l.get(i)][1]){
			//calcul du coefficient directeur de la premiere droite
		double a1 = (double)(coordville[l.get(i+1)][2]-coordville[l.get(i)][2]) / (double)(coordville[l.get(i+1)][1]-coordville[l.get(i)][1]);
		double b1 = (double)(coordville[l.get(i)][2]) - (double)(a1*coordville[l.get(i)][1]);
		
		if (coordville[l.get(j+1)][1] != coordville[l.get(j)][1]){
			//calcul du coefficient directeur de la deuxieme droite
		double a2 = (double)(coordville[l.get(j+1)][2]-coordville[l.get(j)][2]) / (double)(coordville[l.get(j+1)][1]-coordville[l.get(j)][1]);
		double b2 = (double)(coordville[l.get(j+1)][2]) - (double)(a2*coordville[l.get(j+1)][1]);
		
		if (a1 != a2){
			//calcul des coordonées du point d'intersection
		double x = (double)(b2 - b1) / (double)(a1 - a2);
		double y = (a1*x + b1);
		
		if (x != 0 & appartientFigure(l, i,j, coordville, x, y )){ //on vérifie que le point d'intersection appartient bien aux segments et pas seulement aux droites
			 
		 bool = true;
		 }
		}
		}
		}
		return bool;
	}

	public boolean appartientFigure(ArrayList<Integer> l, int i, int j, int [][] coordville, double x,double y){
		boolean bool = false;
		//System.out.println("x : " + x + " y : " + y + " x1 : " + coordville[l.get(i)][1] + " x2 : " + coordville[l.get(i+1)][1] +" x3 : " + coordville[l.get(j)][1] +" x4 : " + coordville[l.get(j+1)][1]);
		if(x < Math.max(coordville[l.get(i)][1], coordville[l.get(i+1)][1]) && x > Math.min(coordville[l.get(i)][1], coordville[l.get(i+1)][1])
			&& x < Math.max(coordville[l.get(j)][1], coordville[l.get(j+1)][1]) && x > Math.min(coordville[l.get(j)][1], coordville[l.get(j+1)][1])){
			if(y < Math.max(coordville[l.get(i)][2], coordville[l.get(i+1)][2]) && y > Math.min(coordville[l.get(i)][2], coordville[l.get(i+1)][2])
					&& y < Math.max(coordville[l.get(j)][2], coordville[l.get(j+1)][2]) && y > Math.min(coordville[l.get(j)][2], coordville[l.get(j+1)][2])){	
			bool = true;
		}
		}
		
		return bool;
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