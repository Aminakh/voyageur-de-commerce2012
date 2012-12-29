package graphe;

import java.util.ArrayList;

public class BruteForce {

	/**
	 * variable dans laquelle est stockée le meilleur trajet, un nombre élevé et
	 * bidon sert de trajet le pire au départ
	 */

	public BruteForce(int nombredevilles, int d) {
		ResultatCalcul.clearRes();
		ResultatCalcul.getRes().add(999999);

	}

	/*
	 * méthode de calcul complete de tous les trajet et retournant le meilleur
	 * elle marche de ma facon suivante : - v est la ville précédemment visitée,
	 * celle d'où on vient - dans l'ArrayList l on stock les indices des villes,
	 * ce qui permet de les retirer facilement lorsque l'on passe par la ville -
	 * ville le tableau de villes, c'est là que sont rangées les distances entre
	 * les différentes villes - et l'ArrayList k, dans laquelle sont rangés les
	 * trajets, avec en premiere position dans la liste la distance parcourue
	 */

	public ArrayList<Integer> calculAlgoComplet(int v, ArrayList<Integer> k,
			ArrayList<Integer> l, int[][] ville) {
		if (l.size() == 0) {
			k.set(0, ville[v][k.get(1)] + k.get(0));
			k.add(k.get(1));
			//System.out.println(k);
			ResultatCalcul.setRes(k);
			if (k.get(0) < ResultatCalcul.getRes().get(0)) {
				ResultatCalcul.setRes(k);
			}
		} else {
			for (int i = 0; i < l.size(); i++) {
				ArrayList<Integer> nl = new ArrayList<Integer>(l);
				nl.remove(i);
				ArrayList<Integer> km = new ArrayList<Integer>(k);
				km.set(0, ville[l.get(i)][v] + k.get(0));
				km.add(l.get(i));

				calculAlgoComplet(l.get(i), km, nl, ville);
			}
		}
		return ResultatCalcul.getRes();
	}
}
