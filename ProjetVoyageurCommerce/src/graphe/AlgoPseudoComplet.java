package graphe;
import java.util.ArrayList;


public class AlgoPseudoComplet
{	
	private  ArrayList<Integer> meilleurtrajet; //variable dans laquelle est stockée le meilleur trajet, un nombre élevé et bidon sert de trajet
												//le pire au départ

	
	
	
	public AlgoPseudoComplet(int nombredevilles, int d)
	{
		meilleurtrajet = new ArrayList<Integer>();
		meilleurtrajet.add(999999);
		
		}
	
	/* 
	 * méthode de calcul complete de tous les trajet et retournant le meilleur
	 * elle marche de ma facon suivante : 
	 * - v est la ville précédemment visitée, celle d'où on vient
	 * - dans l'ArrayList l on stock les indices des villes, ce qui permet de les retirer facilement lorsque
	 * l'on passe par la ville
	 * - ville le tableau de villes, c'est là que sont rangées les distances entre les différentes villes
	 * - et l'ArrayList k, dans laquelle sont rangés les trajets, avec en premiere position dans la liste la 
	 * distance parcourue
	 */
	
	public   ArrayList<Integer> calculAlgoPseudoComplet(int v, ArrayList<Integer> k, ArrayList<Integer> l, int [][] ville){
		int i = 0;
		if (l.size() == 0 &&  ville[v][k.get(1)] + k.get(0) < this.meilleurtrajet.get(0)){	//On vérifie que la distance entre le dernier point et le point de
																							//départ ne dépasse pas la distance minimum
			k.set(0, ville[v][k.get(1)] + k.get(0));
			k.add(k.get(1));
			System.out.println(k);
			this.meilleurtrajet = k;
			}
		else{
			while(i < l.size())	{
				if(k.get(0) + ville[l.get(i)][v] >= this.meilleurtrajet.get(0)){ //Si jamais la distance du trajet que l'on est en train de tester dépasse la 
																				 //distance minimale deja trouvée, il est inutile de continuer
					break;
					}
				ArrayList<Integer> nl = new ArrayList<Integer>(l);				 //pour le reste, comme dans BruteForce
				nl.remove(i);
				ArrayList<Integer> km = new ArrayList<Integer>(k);
				km.set(0, ville[l.get(i)][v] + k.get(0));
				km.add(l.get(i));
				
					calculAlgoPseudoComplet(l.get(i),km,  nl, ville);
				i++;
			}
		}
		return this.meilleurtrajet;
	}
}
