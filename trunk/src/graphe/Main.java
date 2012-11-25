package graphe;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Main
{
	public static void main(String[] args){
		/*Scanner sc = new Scanner(System.in);
		System.out.print("nombre de villes : ");
		int n = sc.nextInt();
		System.out.print("ville de départ : ");
		int d = sc.nextInt();
		System.out.print("seed : ");
		int seed = sc.nextInt();
		*/
		String s = JOptionPane.showInputDialog("nombre de villes : ");
		int n = Integer.valueOf(s);
		System.out.print(n);
	
		s = JOptionPane.showInputDialog("seed : ");
		int seed = Integer.valueOf(s);
		GenerateurVille g = new GenerateurVille(n, seed);
		
		int [][] coordonneeville;
		int [][] distanceville;
		coordonneeville = g.genereCoordonnees();
		distanceville = g.calculDistanceVille(coordonneeville);
		
		BruteForce algobf = new BruteForce(g.getNbville(), 0);
		PlusProcheVoisin ppv = new PlusProcheVoisin();
		DeuxOpt2 opt = new DeuxOpt2();
		RemoveCross rmc = new RemoveCross();
		DeuxOptTaboo opttaboo = new DeuxOptTaboo();
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < g.getNbville(); i++){
			l.add(i);
			}
		
		long time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgoppv = ppv.calculPlusProcheVoisin(l, distanceville);			
		long time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoppv = (int) ((time2-time1)/1000000000);
		AlgoPseudoComplet algopseudocomp = new AlgoPseudoComplet(g.getNbville(), lalgoppv.get(1), lalgoppv.get(0));

		
		ArrayList<Integer> km = new ArrayList<Integer> ();
		km.add(0);
		km.add(lalgoppv.get(1));
		
			
		l = new ArrayList<Integer>(lalgoppv);
		l.remove(0);
		l.remove(0);
		l.remove(l.size()-1);
		
		
		
		//ApproximationAC aac = new ApproximationAC(distanceville.length);
		
		
		//Fenetre fen3 = new Fenetre(coordonneeville, distanceville, km, " ");	
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();	
		ArrayList <Integer> lalgobf =  null; //algobf.calculAlgoComplet(d, km ,l , distanceville);		
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();			
		int talgocbf = (int) ((time2-time1)/1000000000);
		
		System.out.println("jump");
		
		
		
		int a = 0;
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
		//ArrayList <Integer> lalgopseudocomp = algopseudocomp.calculAlgoPseudoComplet(lalgoppv.get(1), km ,l , distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();			
		int talgopseudocomp = (int) ((time2-time1)/1000000000);
		
		System.out.println("jump");
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		//ArrayList <Integer> lalgorecuit = RecuitSimule.calculRecuit(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();	
		int talgorecuit = (int) ((time2-time1)/1000000000);
		
		System.out.println("jump");
		
		
		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		//ArrayList <Integer> lalgormc = rmc.calculRMC(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgormc = (int) ((time2-time1)/1000000000);
		

		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		//ArrayList <Integer> lalgoopt = opt.calculDeuxOpt(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoopt = (int) ((time2-time1)/1000000000);

		time1 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		ArrayList <Integer> lalgoopttaboo = opttaboo.calculDeuxOptTaboo(lalgoppv, coordonneeville, distanceville);			
		time2 = ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();		
		int talgoopt1 = (int) ((time2-time1)/1000000000);
		
		
		System.out.println("jump");
		//Fenetre fen3 = new Fenetre(coordonneeville, distanceville, lalgopseudocomp,"pseudocomp : " + "meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "s");	
		Fenetre fen1 = new Fenetre(coordonneeville, distanceville, lalgoppv, "ppv : " + "meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "s");	
		//Fenetre fen2 = new Fenetre(coordonneeville, distanceville, lalgoopt, "2optv1 : " + "meilleur trajet : " + lalgoopt + "\n temps d'execution avec "+n+" villes : " + talgoopt + "s");
		Fenetre fen4 = new Fenetre(coordonneeville, distanceville, lalgoopttaboo,"2opt taboo : " + "meilleur trajet : " + lalgoopttaboo + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "s");
		//Fenetre fen5 = new Fenetre(coordonneeville, distanceville, lalgorecuit,"recuit : " + "meilleur trajet : " + lalgorecuit + "\n temps d'execution avec "+n+" villes : " + talgorecuit + "s");

		
		g.afficheCoordonnees(coordonneeville);
		g.afficheDistanceville(coordonneeville);
		
		//System.out.println("Algo complet : \n meilleur trajet : " + lalgobf + "\n temps d'execution avec "+n+" villes : " + talgocbf + "ms");
		//System.out.println("Algo pseudo complet : \n meilleur trajet : " + lalgopseudocomp + "\n temps d'execution avec "+n+" villes : " + talgopseudocomp + "s");
		System.out.println("Algo plus proche voisin : \n meilleur trajet : " + lalgoppv + "\n temps d'execution avec "+n+" villes : " + talgoppv + "s");
		//System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopt + "\n temps d'execution avec "+n+" villes : " + talgoopt + "s");
		//System.out.println("Algo removeCross : \n meilleur trajet : " + lalgormc + "\n temps d'execution avec "+n+" villes : " + talgormc + "s");
		//System.out.println("Algo 2-opt : \n meilleur trajet : " + lalgoopttaboo + "\n temps d'execution avec "+n+" villes : " + talgoopt1 + "s");
		
	}



	

	

}
