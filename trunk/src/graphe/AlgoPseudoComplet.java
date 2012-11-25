package graphe;
import java.util.ArrayList;


public class AlgoPseudoComplet
{	
	private  ArrayList<Integer> meilleurtrajet; //variable dans laquelle est stockée le meilleur trajet, un nombre élevé et bidon sert de trajet
												//le pire au départ

	
	
	
	public AlgoPseudoComplet(int nombredevilles, int d, int bestofthebest)
	{
		meilleurtrajet = new ArrayList<Integer>();
		meilleurtrajet.add(9999999);
		
		}
	
	/**
	 * méthode de calcul complete de tous les trajet et retournant le meilleur
	 * elle marche de m=la facon suivante : 
	 * - v est la ville précédemment visitée, celle d'où on vient
	 * - dans l'ArrayList l on stock les indices des villes, ce qui permet de les retirer facilement lorsque
	 * l'on passe par la ville
	 * - ville le tableau de villes, c'est là que sont rangées les distances entre les différentes villes
	 * - et l'ArrayList k, dans laquelle sont rangés les trajets, avec en premiere position dans la liste la 
	 * distance parcourue
	 */
	
	public   ArrayList<Integer> calculAlgoPseudoComplet(int v, ArrayList<Integer> k, ArrayList<Integer> l, int [][] ville){
		int i = 0;
		if (l.size() == 0 &&  ville[v][k.get(1)] + k.get(0) < this.meilleurtrajet.get(0)){
			k.set(0, ville[v][k.get(1)] + k.get(0));
			k.add(k.get(1));
			System.out.println(k);
			this.meilleurtrajet = k;
			}
		else{
			while(i < l.size())	{
				if(k.get(0) + ville[l.get(i)][v] >= this.meilleurtrajet.get(0) | k.get(0) + ApproximationAC.creeArbre(ville, l, v) >= 2*this.meilleurtrajet.get(0)){
					/*System.out.println("MST : "+(k.get(0)+ApproximationAC.creeArbre(ville, l, v)));
					System.out.println("ppv : "+this.meilleurtrajet.get(0));*/
					//System.out.println(Ident.ident());
					break;
					}
				else{
				//System.out.println(k.get(0) + ville[l.get(i)][v]);
				ArrayList<Integer> nl = new ArrayList<Integer>(l);
				nl.remove(i);
				ArrayList<Integer> km = new ArrayList<Integer>(k);
				km.set(0, ville[l.get(i)][v] + k.get(0));
				km.add(l.get(i));
					calculAlgoPseudoComplet(l.get(i),km,  nl, ville);
				i++;
				}
			}
		}
		return this.meilleurtrajet;
	}




	public ArrayList<Integer> ppv (ArrayList<Integer> l, int villedep, int [][] distville){
		int [] distmin = {999999, villedep};
		int ind = 0;
		int temp = 0;
		
		for(int i = 0; i < l.size(); i++){
			for(int j = ind; j < l.size(); j++){
				if(distville[villedep][l.get(j)] < distmin[0]){ //on recherche la plus petite distance parmi toutes les distance disponibles à partir de villedep
					distmin[0] = distville[villedep][l.get(j)];
					distmin[1] = l.get(j);
					temp = j;
					}
				ind = ind + 1;
				l.remove(temp);
				l.add(temp, distmin[1]);
				System.out.println(l);

				}
		
		
		}
		return l;
	}
}


