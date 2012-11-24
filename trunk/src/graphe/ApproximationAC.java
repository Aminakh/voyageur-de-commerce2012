package graphe;

import java.util.ArrayList;

public class ApproximationAC {
	
	/**
	 * @param distville : la matrice de distance entre les villes
	 * @param list : l'ArrayList du chemin en cours de consctruction par le backtrack
	 * @return : int : la distance de l'arbre couvrant
	 */
	public static int creeArbre(int [][] distville, ArrayList<Integer> list){
		int distance = 0; //la distance à retourner que l'on va calcluler
		int indk = 0;
		int indj = 0;
		int distmin = distville[0][0];//distance minimum après parcours des villes
		/**
		 * l'arbre peut être considéré comme un tableau d'ArrayList, ou la case d'un tableau représente le noeud
		 * et l'ArrayList représente les voisins du noeud
		 * l'ordre du graphe est donné par la taille de distville
		 * on n'a cependant besoin de construire un arbre couvrant du reste du graphe
		 * l'indice du tableau représente le sommet
		 */
		//on initialise le tableau
		
		
		//on crée un nouvelle liste contenant les sommets deja vérifiés, c'est à dire ce qui sont deja voisins d'un noeud
		//le chemin deja construit par le back track n'a pas besoin d'etre vérifié
		ArrayList<Integer> checked = new ArrayList<Integer>(list);
		checked.remove(0); //on enleve la distance stockée à l'indice 0 de la liste
		
		
			
		//on peut maintenant calculer l'arbre couvrant
				
		//while(!(checked.size() == distville.length)){ 
			//on s'arrete lorsque toutes les villes ont été vérifées
			for(int j = 0; j < distville.length; j++){
				//on parcourt toutes les villes vérifiées pour trouver la distance ville vérifée-ville non vérifée la plus courte
				for(int k = 0; distville.length==checked.size(); k++){
					//on parcourt toutes les villes non vérifiées
					if(!checked.contains(k) && distville[indj][k] < distmin){
						//si la distance entre les deux villes plus courte
						distmin = distville[indj][k];
						indk = k; //on met l'indice de la ville (non vérifiée) en mémoire
						
					}
					distance += distmin; //on ajoute la distance trouvée à la distance totale
					checked.add(indk);  //on ajoute la ville indk à la liste des villes vérifiées
					distmin = distville[0][0];
					indj = j; //pareil
				}
			//}
			//on vient d'obtenir la distance ville vérifée-ville non vérifée la plus courte
			
		}
			
		return distance;
	}
}
