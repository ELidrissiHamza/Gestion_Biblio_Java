package library;

import java.util.Vector;

public class Main {

	public static void main(String[] args)
	{/*
		Vector<String> v= new Vector<String>();
		v.add("Hamza");
		v.add("Vall");
		Livre l=new Livre("info",v,"1A",2000);
		v.add("hcn");
		v.add("mh");
		Livre l2=new Livre("php",v,"2A",1000);
		Vector<Livre> livres=new Vector<Livre>();
		livres.add(l);
		Bibliotheque b=new Bibliotheque(3);
		b.ajouteLivre(l);
		b.ajouteLivre(l2);
		System.out.println(b.toString());
		Vector<String> v2= new Vector<String>();
		v2=b.Cherche("H");
		System.out.println("--------------------------------\n");
		for(String element:v2)
			System.out.println(element);
		System.out.println("--------------------------------\n");
		Livre liv = new Livre("math",v,"E3",30000);
		System.out.println(liv);
		//b.ecriture();
		//b.lecture();*/
		Bibliotheque b=new Bibliotheque(3);
		b.menu();
		
	}
}
