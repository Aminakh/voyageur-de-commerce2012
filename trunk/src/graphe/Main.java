package graphe;

import java.lang.management.ManagementFactory;
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
		System.out.print("seed : ");
		int seed = sc.nextInt();
		
		GenerateurVille g = new GenerateurVille(n, seed);
		
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
		PlusProcheVoisin ppv = new PlusProcheVoisin();
		DeuxOpt opt = new DeuxOpt();
		RemoveCross rmc = new RemoveCross();
		DeuxOptTaboo opttaboo = new DeuxOptTaboo();
		ApproximationAC aac = new ApproximationAC(distanceville.length);
		
		aac.creeArbre(distanceville);
		
		//Fenetre fen3 = new Fenetre(coordonneeville, distanceville, km, " ");	
		long time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();	
		ArrayList <Integer> lalgobf =  null; //algobf.calculAlgoComplet(d, km ,l , distanceville);		
		long time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();			
		int talgocbf = (int) ((time2-time1)/1000000000);
		
		System.out.println("jump");
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgoppv = ppv.calculPlusProcheVoisin(d, l, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoppv = (int) ((time2-time1)/1000000000);
		
		AlgoPseudoComplet algopseudocomp = new AlgoPseudoComplet(g.getNbville(), d, lalgoppv.get(0));

		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		ArrayList <Integer> lalgopseudocomp =null;// algopseudocomp.calculAlgoPseudoComplet(d, km ,l , distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();			
		int talgopseudocomp = (int) ((time2-time1)/1000000000);
		
		System.out.println("jump");
		
		
		
		System.out.println("jump");
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgoopt = null;//opt.calculDeuxOpt(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoopt = (int) ((time2-time1)/1000000000);
		
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgoopttaboo = opttaboo.calculDeuxOptTaboo(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoopt1 = (int) ((time2-time1)/1000000000);
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgormc = rmc.calculRMC(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgormc = (int) ((time2-time1)/1000000000);
		
		
		System.out.println("jump");
		//Fenetre fen3 = new Fenetre(coordonneeville, distanceville, lalgopseudocomp,"pseudocomp : " + "meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "s");	
		Fenetre fen1 = new Fenetre(coordonneeville, distanceville, lalgoppv, "ppv : " + "meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "s");	
		//Fenetre fen2 = new Fenetre(coordonneeville, distanceville, lalgoopt, "2optv1 : " + "meilleur trajet : " + lalgoopt + "\n temps d'execution avec "+n+" villes : " + talgoopt + "s");
		Fenetre fen4 = new Fenetre(coordonneeville, distanceville, lalgoopttaboo,"2optv2 : " + "meilleur trajet : " + lalgoopttaboo + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "s");
		Fenetre fen5 = new Fenetre(coordonneeville, distanceville, lalgormc,"rmc : " + "meilleur trajet : " + lalgormc + "\n temps d'execution avec "+n+" villes : " + talgormc + "s");

		
		g.afficheCoordonnees(coordonneeville);
		g.afficheDistanceville(coordonneeville);
		
		//System.out.println("Algo complet : \n meilleur trajet : " + lalgobf + "\n temps d'execution avec "+n+" villes : " + talgocbf + "ms");
		System.out.println("Algo pseudo complet : \n meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "s");
		System.out.println("Algo plus proche voisin : \n meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "s");
		System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopt + "\n temps d'execution avec "+n+" villes : " + talgoopt + "s");
		//System.out.println("Algo removeCross : \n meilleur trajet : " + lalgormc + "\n temps d'execution avec "+n+" villes : " + talgormc + "ms");
		//System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopt1 + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "ms");
		
	}

	

	

}
