package graphe;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

import vue.Fenetre;


public class Main
{
	public static void main(String[] args){
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		TimerUpdate t = new TimerUpdate();
		es.execute(t);
		
		/**
		 * saisie par l'utilisateur du nombre de villes
		 */
		//String s = JOptionPane.showInputDialog("nombre de villes : ");
		//int n = Integer.valueOf(s);
		//System.out.print(n);
		
		/**
		 * saisie par l'utilisateur du seed
		 */
		//s = JOptionPane.showInputDialog("seed : ");
		//int seed = Integer.valueOf(s);
		//GenerateurVille g = new GenerateurVille(n, seed);
	/*	GenerateurVille g = new GenerateurVille(1, 1);
		
		
		
		/**
		 * declaration des variables
		 
		//tableau contenant les coordonnées des villes
		int [][] coordonneeville;
		//tableau contant les distances entre les villes
		int [][] distanceville;
		/**
		 * on génere les coordonnées et calcule les distances
		 
		coordonneeville = g.genereCoordonnees();
		distanceville = g.calculDistanceVille(coordonneeville);*/
		
		Fenetre fen = new Fenetre();
		t.addObserver(fen);

		//Fenetre fen = new Fenetre(coordonneeville, ResultatCalcul.getRes(), "complet : " + "meilleur trajet : " + ResultatCalcul.getRes() + "\n temps d'execution avec "+n+" villes : " + "s");
		/**
		 * on instancie les différentes classes contant les algos
		 *
		BruteForce algobf = new BruteForce(g.getNbville(), 0);
		PlusProcheVoisin ppv = new PlusProcheVoisin();
		DeuxOpt2 opt = new DeuxOpt2();
		RemoveCross rmc = new RemoveCross();
		DeuxOptTaboo opttaboo = new DeuxOptTaboo();
		
		/**
		 * on initialise une ArrayList bidon pour ne pas avoir à le refaire pour chaque algo
		 *
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < g.getNbville(); i++){
			l.add(i);
			}
		
		
		/**
		 * calcule du plus proche voisin
		 *
		long time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgoppv = ppv.calculPlusProcheVoisin(l, distanceville);			
		long time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoppv = (int) ((time2-time1)/1000000000);
		
		ArrayList<Integer> km = new ArrayList<Integer> ();
		km.add(0);
		km.add(lalgoppv.get(1));
		
			
		l = new ArrayList<Integer>(lalgoppv);
		l.remove(0);
		l.remove(0);
		l.remove(l.size()-1);
		
		
		
		
		/**
		 * calcul avec le brute force
		 *
		//Fenetre fen3 = new Fenetre(coordonneeville, distanceville, km, " ");	
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();	
		//algobf.calculAlgoComplet(lalgoppv.get(1), km ,l , distanceville);		
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();			
		int talgocbf = (int) ((time2-time1)/1000000000);
		
		System.out.println("jump");
		
		
		/**
		 * calcul du backtrack
		 *
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		
		ArrayList <Integer> lalgopseudocomp = new ArrayList<Integer>();
		
		BackTrack algopseudocomp = new BackTrack();
		algopseudocomp.setMeilleurTrajet(lalgopseudocomp);

		//Fenetre fen7 = new Fenetre(coordonneeville, ResultatCalcul.getRes(), "pseudo complet : " + "meilleur trajet : " + ResultatCalcul.getRes() + "\n temps d'execution avec "+n+" villes : " + "s");
		
		//on ajoute la fenetre comme observer pour qu'elle s'update toutes les 10ms
		t.addObserver(fen);
		
		//algopseudocomp.calculAlgoPseudoComplet(lalgoppv.get(1), km ,l , distanceville);		
		System.out.println(ResultatCalcul.getRes());
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();			
		int talgopseudocomp = (int) ((time2-time1)/1000000000);
		
		
		/**
		 * calcul du recuit
		 *
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgorecuit = RecuitSimule.calculRecuit(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();	
		int talgorecuit = (int) ((time2-time1)/1000000000);
		
		System.out.println("jump");
		
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		//ArrayList <Integer> lalgormc = rmc.calculRMC(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgormc = (int) ((time2-time1)/1000000000);
		

		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgoopt = opt.calculDeuxOpt(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoopt = (int) ((time2-time1)/1000000000);

		
		/**
		 * calcul de 2-opt avec taboo
		 *
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();	
		//on déclare l'ArrayList qui va contenir le résultat du calcul
		ArrayList<Integer> l1 = new ArrayList<Integer>(lalgoppv);
		//on déclare la fenetre
		//Fenetre fen2 = new Fenetre(coordonneeville, l1, "2optv1 : " + "meilleur trajet : " + l1 + "\n temps d'execution avec "+n+" villes : " + talgoopt + "s");
		//on ajoute la fenetre comme observer pour qu'elle s'update toutes les 10ms
		//t.addObserver(fen2);
		//on lance l'algo pour le calcul
		opttaboo.calculDeuxOptTaboo(l1, coordonneeville, distanceville);	
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoopt1 = (int) ((time2-time1)/1000000000);
		
		
		System.out.println("jump");
		//Fenetre fen3 = new Fenetre(coordonneeville, distanceville, lalgopseudocomp,"pseudocomp : " + "meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "s");	
		//Fenetre fen1 = new Fenetre(coordonneeville, lalgoppv, "ppv : " + "meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "s");	
		//Fenetre fen4 = new Fenetre(coordonneeville, distanceville, lalgoopttaboo,"2opt taboo : " + "meilleur trajet : " + lalgoopttaboo + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "s");
		//2
		//Fenetre fen5 = new Fenetre(coordonneeville, lalgorecuit,"recuit : " + "meilleur trajet : " + lalgorecuit + "\n temps d'execution avec "+n+" villes : " + talgorecuit + "s");

		
		
		//System.out.println("Algo complet : \n meilleur trajet : " + lalgobf + "\n temps d'execution avec "+n+" villes : " + talgocbf + "ms");
		//System.out.println("Algo pseudo complet : \n meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "s");
		//System.out.println("Algo plus proche voisin : \n meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "s");
		//System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopt + "\n temps d'execution avec "+n+" villes : " + talgoopt + "s");
		//System.out.println("Algo removeCross : \n meilleur trajet : " + lalgormc + "\n temps d'execution avec "+n+" villes : " + talgormc + "s");
		//System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopttaboo + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "s");
		
	}



	

	*/
	}

}
