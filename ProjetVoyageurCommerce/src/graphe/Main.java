package graphe;

import java.util.ArrayList;
import java.util.Scanner;


public class Main
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("nombre de villes : ");
		int n = sc.nextInt();
		System.out.print("ville de départ : ");
		int d = sc.nextInt();
		
		GenerateurVille g = new GenerateurVille(n);
		
		int [][] coordonneeville;
		int [][] distanceville;
		coordonneeville = g.genereCoordonnees();
		distanceville = g.calculDistanceVille(coordonneeville);
		
	
		
		ArrayList<Integer> km = new ArrayList<Integer> ();
		km.add(0);
		km.add(d);
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < g.getNbville(); i++){
			l.add(i);
			}
			l.remove(d);
			
		
		
		
		
		BruteForce algobf = new BruteForce(g.getNbville(), d);
		AlgoPseudoComplet algopseudocomp = new AlgoPseudoComplet(g.getNbville(), d);
		PlusProcheVoisin ppv = new PlusProcheVoisin();
		DeuxOpt opt = new DeuxOpt();
		RemoveCross rmc = new RemoveCross();
		DeuxOpt2 opt2 = new DeuxOpt2();
		
		Fenetre fen3 = new Fenetre(coordonneeville, distanceville, km, " ");	
		long time1 = System.currentTimeMillis(); 		
		ArrayList <Integer> lalgobf =  null; //algobf.calculAlgoComplet(d, km ,l , distanceville);		
		long time2 = System.currentTimeMillis();		
		int talgocbf = (int) (time2-time1);
		
		System.out.println("jump");
		
		time1 = System.currentTimeMillis(); 
		ArrayList <Integer> lalgopseudocomp = null; //algopseudocomp.calculAlgoPseudoComplet(d, km ,l , distanceville);			
		time2 = System.currentTimeMillis();		
		int talgopseudocomp = (int) (time2-time1);
		
		System.out.println("jump");
		
		time1 = System.currentTimeMillis(); 		
		ArrayList <Integer> lalgoppv = ppv.calculPlusProcheVoisin(d, l, distanceville);			
		time2 = System.currentTimeMillis();	
		int talgoppv = (int) (time2-time1);
		
		
		System.out.println("jump");
		
		time1 = System.currentTimeMillis(); 		
		ArrayList <Integer> lalgoopt = opt.calculDeuxOpt(lalgoppv, coordonneeville, distanceville);			
		time2 = System.currentTimeMillis();	
		int talgoopt = (int) (time2-time1);
		
		time1 = System.currentTimeMillis(); 		
		ArrayList <Integer> lalgormc = rmc.calculRMC(lalgoopt, coordonneeville, distanceville);			
		time2 = System.currentTimeMillis();	
		int talgormc = (int) (time2-time1);
		
		time1 = System.currentTimeMillis(); 		
		ArrayList <Integer> lalgoopt1 = null;//opt2.calculDeuxOpt2(lalgormc, coordonneeville, distanceville);			
		time2 = System.currentTimeMillis();	
		int talgoopt1 = (int) (time2-time1);
		
		
		
		System.out.println("jump");
		//Fenetre fen3 = new Fenetre(coordonneeville, distanceville, lalgopseudocomp,"pseudocomp : " + "meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "ms");	
		Fenetre fen1 = new Fenetre(coordonneeville, distanceville, lalgoppv, "ppv : " + "meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "ms");	
		Fenetre fen2 = new Fenetre(coordonneeville, distanceville, lalgoopt, "2optv1 : " + "meilleur trajet : " + lalgoopt + "\n temps d'execution avec "+n+" villes : " + talgoopt + "ms");
		//Fenetre fen4 = new Fenetre(coordonneeville, distanceville, lalgoopt1,"2optv2 : " + "meilleur trajet : " + lalgoopt1 + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "ms");
		
		g.afficheCoordonnees(coordonneeville);
		g.afficheDistanceville(coordonneeville);
		
		System.out.println("Algo complet : \n meilleur trajet : " + lalgobf + "\n temps d'execution avec "+n+" villes : " + talgocbf + "ms");
		System.out.println("Algo pseudo complet : \n meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "ms");
		System.out.println("Algo plus proche voisin : \n meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "ms");
		System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopt + "\n temps d'execution avec "+n+" villes : " + talgoopt + "ms");
		//System.out.println("Algo removeCross : \n meilleur trajet : " + lalgormc + "\n temps d'execution avec "+n+" villes : " + talgormc + "ms");
		//System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopt1 + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "ms");
		
	}

	

	

}
