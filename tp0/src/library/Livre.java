package library;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Scanner;

public class Livre implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre;
	private Vector<String> auteurs;
	private String ISBN;
	private double prix;

	public Livre() {
	};

	public Livre(String titre_, Vector<String> auteurs_, String ISBN_, double prix_) {
		this.titre = new String(titre_);
		this.auteurs = new Vector<String>();
		for (String element : auteurs_)
			this.auteurs.add(element);
		this.setISBN(new String(ISBN_));
		this.prix = prix_;
	}

	public Livre(Livre livre) {
		this.titre = new String(livre.titre);
		this.auteurs = new Vector<String>();
		for (String element : livre.auteurs)
			this.auteurs.add(element);
		this.setISBN(new String(livre.getISBN()));
		this.prix = livre.prix;
	}

	public String toString() {
		String listeAuteurs = " ";
		for (String element : this.auteurs)
			listeAuteurs = listeAuteurs + element + " ";
		return "-----> Titre : " + this.titre + "; Les auteurs :" + listeAuteurs + "; ISBN : " + this.getISBN()
				+ "; Prix : " + this.prix + "\n";

	}

	public String getTitre() {
		return this.titre;
	}

	public Enumeration<String> getAuteurs() {
		return this.auteurs.elements();
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void modifier_auteur() {
		System.out.println("Entrer votre choix \n");
		System.out.println(" 1 : pour ajouter un auteur au livre\n 2 : pour modifier un auteur d'un livre\n");
		Scanner clavier = new Scanner(System.in);
		int choix = clavier.nextInt();
		String name_;
		switch (choix) {
		case 1:
			System.out.println("Donner le nom de l'auteur a ajouter \n");
			name_ = clavier.next();
			this.auteurs.add(name_);
			break;
		case 2:
			System.out.println("Donner le nom de l'auteur a modifier \n");
			name_ = clavier.next();
			this.auteurs.remove(name_);
			System.out.println("Donner le nouveau nom \n");
			name_ = clavier.next();
			this.auteurs.add(name_);
			break;
		default:
			System.out.println("Choix incorrect !");

		}
	}

	public void modifier_livre() {

		System.out.println("Entrer votre choix (modifier livre) \n");
		System.out.println(
				" 1 : pour modifier le titre\n " + "2 : pour modifier le prix\n " + "3 : pour modifier les auteurs\n");
		Scanner clavier = new Scanner(System.in);
			int choix = clavier.nextInt();

			switch (choix) {
			case 1:
				String titre_;
				System.out.println("Entrer le nouveau titre\n");
				titre_ = clavier.next();
				this.titre = titre_;
				break;
			case 2:
				double prix_;
				System.out.println("Entrerle nouveau prix\n");
				prix_ = clavier.nextDouble();
				this.prix = prix_;
				break;
			case 3:
				this.modifier_auteur();
				break;
			default:
				System.out.println("Choix incorrect\n");
			}
		
		
	}

}
