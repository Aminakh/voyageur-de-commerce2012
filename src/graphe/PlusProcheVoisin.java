package graphe;
import java.util.ArrayList;


public class PlusProcheVoisin
{

	
	
public ArrayList<Integer> calculPlusProcheVoisin(int v, ArrayList<Integer> liste, int [][] distville){
	Integer indk = v;
	int villedep;
	int distmin = distville[0][0];//distance minimum après parcours des villes
	ArrayList<Integer> parcours = new ArrayList<Integer>();
	ArrayList<Integer> bestparcours = new ArrayList<Integer>();
	bestparcours.add(0);
	bestparcours.set(0, 9999999);
	parcours.add(0);
	parcours.add(v);
	for(int i = 0; i < distville.length; i++){
		villedep = i;
		ArrayList<Integer> l = new ArrayList<Integer>(liste);
		parcours = new ArrayList<Integer>();
		parcours.add(0);
		parcours.add(villedep);
		for(int j = 0; j < liste.size(); j++){
			//on parcourt toutes les villes vérifiées pour trouver la distance ville vérifée-ville non vérifée la plus courte
			for(int k = 0; k < l.size(); k++){
				//on parcourt toutes les villes non vérifiées
				if(distville[villedep][l.get(k)] < distmin){
					//si la distance entre les deux villes plus courte
					distmin = distville[villedep][l.get(k)];
					indk = l.get(k);
				}
			}
			parcours.add(indk);
			l.remove(indk);
			villedep = indk;
			parcours.set(0, parcours.get(0) + distmin);
			distmin = distville[0][0];
	}
		//on ajoute la première ville à la fin pour revenir point de départ
		parcours.set(0, distville[parcours.get(1)] [parcours.get(parcours.size()-1)] + parcours.get(0));
		System.out.println(parcours.get(0));
		if(parcours.get(0) < bestparcours.get(0))
			bestparcours = new ArrayList<Integer>(parcours);
}	
	
	bestparcours.add(bestparcours.get(1));
	return bestparcours;
}



}
