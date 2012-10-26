package graphe;
import java.util.ArrayList;


public class PlusProcheVoisin
{

	
	
public ArrayList<Integer> calculPlusProcheVoisin(int v, ArrayList<Integer> liste, int [][] ville){
	int villedep = v; //ville de départ
	int ind = 0;	//indice de la case de l'arraylist (la ville) qui a la distance la plus courte à la ville précédente
	int max = liste.size(); 
	int [] distmin = {999999, v}; //distance bidon pour commencer
	ArrayList<Integer> l = new ArrayList<Integer>(liste);
	ArrayList<Integer> parcours = new ArrayList<Integer>();
	parcours.add(0); //on initialise la liste dans laquelle sera stockée le parcours, la première case à 0, il y aura la distance
	parcours.add(v); //dans la deuxième case, il y a la ville de départ, donnée en paramètre
	
		for(int i = 0; i < max; i++){
			for(int j = 0; j < l.size(); j++){
				if(ville[villedep][l.get(j)] < distmin[0]){ //on recherche la plus petite distance parmi toutes les distance disponibles à partir de 
					distmin[0] = ville[villedep][l.get(j)];
					distmin[1] = l.get(j);
					ind = j;
					}
				}	
		l.remove(ind);	//on enlève la ville à l'indice ind de la liste contenant les villes
		parcours.set(0, distmin[0] + parcours.get(0)); //on met à jour le parcours
		parcours.add(distmin[1]);
		distmin[0] = 999999;
		villedep = distmin[1];
	}
	//on ajoute la première ville à la fin pour revenir point de départ
	parcours.set(0, ville[parcours.get(1)] [parcours.get(parcours.size()-1)] + parcours.get(0));
	parcours.add(parcours.get(1));
	return parcours;
}



}
