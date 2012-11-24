package graphe;

import java.util.ArrayList;

public class RemoveCross
{


public ArrayList<Integer> calculRMC(ArrayList<Integer> l, int [][] coordville, int [][] distville){
	ArrayList<Integer> chemin = new ArrayList<Integer>(l);
	int distemp;
	int i = 1;
	int j = 2;
while (i < chemin.size() - 2){
	while (j < chemin.size() - 1){
		System.out.println("i : "+chemin.get(i) + " i+1 : "+chemin.get(i+1)+" j : "+chemin.get(j)+" j+1 : "+chemin.get(j+1));

		//if (i == j){j = i+1;} //pour éviter de vérifier trois villes consecutives
		if (detecteCroisement(chemin, coordville, i , j)){	//si un croisement est détecté on inverse les arètes
			distemp = chemin.get(i+1);
			chemin.set(i+1, chemin.get(j));
			chemin.set(j, distemp);
			System.out.println(chemin);
			i=2;
			j=1;
			}
		j++;
		
	}
	i++;
	j=1;
}

return calculDistance(chemin, distville);	
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
	System.out.println(l.size());
	for(int i = 1 ; i < l.size()-1; i++){
		System.out.println(i);

		som += distville[l.get(i)][l.get(i+1)];
	}
	
	l.set(0, som );
	
	return l;
	
	
}

}