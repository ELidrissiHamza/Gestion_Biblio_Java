package library;

import java.util.Vector;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Scanner;

public class Bibliotheque implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maxLivre;// le nombre maximale des livres
	private Vector<Livre> livres;// l'ensemble des livres
	// constructeur

	public Bibliotheque(int maxLivre) {
		this.maxLivre = maxLivre;
		this.livres = new Vector<Livre>();

	}

	public Vector<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Vector<Livre> livres) {
		this.livres = livres;
	}

	// la capacite de la bibliotheque
	public int capacite() {
		return this.maxLivre;
	}

	// ajouter un livre a une bibliotheque
	public boolean ajouteLivre(Livre l) {
		if (this.size() < this.capacite()) {
			this.livres.add(l);
			return true;
		}
		return false;
	}

	// size de la bibliotheque
	public int size() {
		return this.livres.size();
	}

	// surcharge de la methode toString
	public String toString() {
		
		String listLivres = " size du bibliotheque: " + this.size() + "\n capacite du bibliotheque :" + this.capacite() + " \n Liste des livres : \n";
		for (Livre element : this.livres)
			listLivres = listLivres + element.toString() + "  \n";
		return listLivres;
	}

	public Vector<String> Cherche(String auteur) {
		Vector<String> v = new Vector<String>();
		for (Livre elem : this.livres) {
			for (Enumeration<String> autheurs = elem.getAuteurs(); autheurs.hasMoreElements();) {
				String autheur = (String) autheurs.nextElement();
				if (autheur.contains(auteur))
					v.add(elem.getTitre());
			}
		}
		return v;
	}

	public void supprimerLivre(String isbn) {
		boolean ver = true;
		for (Livre elem : this.livres) {
			if (elem.getISBN().equals(isbn)) {
				if (this.livres.remove(elem))
					System.out.println("Livre supprimer avec succes");
				ver = false;
				break;
			}
		}
		if (ver)
			System.out.println("Livre n existe pas !!");

	}

	public void afficherLivre(String isbn) {
		boolean ver = true;
		for (Livre elem : this.livres) {
			if (elem.getISBN().equals(isbn)) {
				System.out.println(elem);
				ver = false;
			}
		}
		if (ver)
			System.out.println("Livre n existe pas !!");
	}
	
	public void Modifier_livre_biblio(String isbn) {
		boolean ver = true;
		for (Livre elem : this.livres) {
			if (elem.getISBN().equals(isbn)) {
				elem.modifier_livre();
				ver = false;
			}
		}
		if (ver)
			System.out.println("Livre n existe pas !!");
	}

	public void ecriture() {

		try {
			ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream("data.txt"));
			// FileOutputStream os =new FileOutputStream("data.txt");
			// ObjectOutputStream data = new ObjectOutputStream(os);
			try {
				data.writeObject(this);
				System.out.println("Object serialise ");
				data.flush();
			} finally {
				data.close();
				System.out.println("Fermeture du fichier ");

			}
		} catch (Exception e) {
			System.out.println("Erreur de l'ecriture " + e);
		}
	}

	public void lecture() {
		Bibliotheque b;
		try {
			ObjectInputStream data = new ObjectInputStream(new FileInputStream("data.txt"));
			try {
				b = (Bibliotheque) data.readObject();
				System.out.println("Object deserialise ");
				// this.livres=b.livres;
				this.livres = b.livres;
				this.maxLivre = b.maxLivre;
				// System.out.println(this.toString());
			} finally {

				data.close();
				System.out.println("Fermeture du fichier ");
			}
		} catch (Exception e) {
			System.out.println("Erreur de lecture!!! " + e);
		}
	}

	public void ajouterAuteur(Vector<String> v, int nbauteurs) {
		Scanner clavier = new Scanner(System.in);
			String nom;
			for (int i = 0; i < nbauteurs; i++) {
				System.out.println("Donner le nom de l'auteur numero " + (i + 1));
				nom = clavier.nextLine();
				v.add(nom);
			}
		}
	
	

	public int desirialier_ou_personnaliser() {
		this.header();
		Scanner clavier = new Scanner(System.in);
			int nb,cap;
		
			System.out.println(
					" Entrer 1 : pour deserialiser la bibliotheque \n Entrer 2 : pour personnaliser votre bibliotheque \n Entrer 3 : pour quitter\n");
			nb = clavier.nextInt();
			switch (nb) {
			case 1:
				this.lecture();
				break;
			case 2:
				System.out.println("Entrer la capacite d'une bibliotheque ");
				cap = clavier.nextInt();
				Bibliotheque b = new Bibliotheque(cap);
				this.livres = b.livres;
				this.maxLivre = b.maxLivre;
				break;
			default:System.out.println("Choix incorrect !\n");	
			}
		
			return nb;
	}

	
	public void header()
	{
		System.out.println("\nBienvenue a l'application de gestion de bibliotheque \n\n");
	}
	
	public void menu() {

		int choix=this.desirialier_ou_personnaliser();
		if((choix!=1 )&&(choix!=2) )
		{
			System.out.println("Choix incorrect !!!");return;
		}

		String isbn;
		String titre;
		int prix;
		int nbauteurs;
		Scanner clavier = new Scanner(System.in);
		do {
			System.out.println(" 1 : pour inserer un livre \n" + " 2 : pour supprimer un livre \n"
					+ " 3 : pour afficher les livres \n" + " 4 : pour afficher les inforations d un livre \n"
					+ " 5 : pour serialiser\n" + " 6 : pour modifier un livre\n" + " 7 : pour quitter le menue:\n");
			System.out.println("Entrer votre choix (Menue principale) :");

			choix = clavier.nextInt();
			switch (choix) {
			case 1:
				System.out.println("Donner ISBN du livre ");
				isbn = clavier.next();
				System.out.println("Donner le titre du livre ");
				titre = clavier.next();

				System.out.println("Donner Le prix du livre ");
				prix = clavier.nextInt();
				Vector<String> v = new Vector<String>();
				System.out.println("Donner le nombre d'auteurs de ce livre");
				nbauteurs = clavier.nextInt();
				this.ajouterAuteur(v, nbauteurs);
				Livre liv = new Livre(titre, v, isbn, prix);
				this.ajouteLivre(liv);

				break;
			case 2:
				System.out.println("Donner ISBN du livre a supprimer ");
				isbn = clavier.next();
				this.supprimerLivre(isbn);
				break;
			case 3:
				System.out.println(this.toString());
				break;
			case 4:
				System.out.println("Donner ISBN du livre a afficher ");
				isbn = clavier.next();
				this.afficherLivre(isbn);
				break;
			case 5:
				this.ecriture();
				break;
			case 6:
				System.out.println("Donner ISBN du livre a modifier ");
				isbn = clavier.next();
				this.Modifier_livre_biblio(isbn);
				break;
			case 7:System.out.println("FIN");	
			default:
				System.out.println("Entrer un choix correct !!");
			}
		} while (choix != 7);
	}
		
		

	

}
