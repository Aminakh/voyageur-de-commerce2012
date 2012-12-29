package graphe;

import java.util.ArrayList;

public class DeuxOpt2 {
	
	private ArrayList<String> taboo = new ArrayList<String>();
	private int cpt;
	public DeuxOpt2(){
		this.taboo.add("");
		this.cpt = 0;
	}
	/** 60-2-2*/
	public ArrayList<Integer> calculDeuxOpt(ArrayList<Integer> l, int [][] coordville, int [][] distville){
		ArrayList<Integer> chemin = new ArrayList<Integer>(l);
		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("");
		int distemp;
		int i = 1; //la case 0 est la distance totale et la case 1 est le point de départ, que l'on ne doit pas changer
		int j = 2;	// pour ne pas avoir trois villes consecutives
 		//boolean bool = true;
 	while (i  < l.size() -2 /*&& this.taboo.size() < 22337*/)
 	{
		while(j  < l.size() - 1 /*&& this.taboo.size() < 22337*/)
		{	
			ArrayList<Integer> cheminbis = new ArrayList<Integer>(chemin);
			cheminbis.set(i+1, chemin.get(j));
			cheminbis.set(j, chemin.get(i+1));
			cheminbis.set(0, calculDistance(cheminbis, distville));
		/*	System.out.println("chemin : "+chemin.get(0));
			System.out.println(i);*/
			if(cheminbis.get(0) < chemin.get(0) /*|| detecteCroisement(chemin, coordville, i , j)*/){
			//	System.out.println("cheminbis : " +cheminbis.get(0));

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

	
	
	public int calculDistance(ArrayList<Integer> chemin, int[][] distville){
		int som = 0;
		
		ArrayList<Integer> l = new ArrayList<Integer>(chemin);
		for(int i = 1 ; i < l.size()-1; i++){
			//System.out.println(i);
			som += distville[l.get(i)][l.get(i+1)];
		}
		
		
		
		return som;
		
		
	}
	
}
	















/*System.out.println(" i/j  i+1/j+1 : " +(distville[chemin.get(i)][chemin.get(j)] + distville[chemin.get(i+1)][chemin.get(j+1)]));
System.out.println("i/i+1  i+1/j : "+(distville[chemin.get(i)][chemin.get(i+1)] + distville[chemin.get(j)][chemin.get(j+1)]));
System.out.println(" i/j : " +(distville[chemin.get(i)][chemin.get(j)]));
System.out.println(" i+1/j+1 : " + distville[chemin.get(i+1)][chemin.get(j+1)]);
System.out.println("i/i+1 : "+ distville[chemin.get(i)][chemin.get(i+1)]);
System.out.println("j/i+1 : " + distville[chemin.get(j)][chemin.get(j+1)]);
System.out.println("--------------------------------------");*/