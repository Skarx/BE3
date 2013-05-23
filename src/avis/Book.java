package avis;

import java.util.LinkedList;

public class Book extends Item {
	public Book(String titre, String genre, String auteur, int nbPages) {
		this.titre = titre.trim();
		this.genre = genre;
		this.auteur = auteur;
		this.nbPages = nbPages;
		review = new LinkedList <Review>();
	}

	/**
	 * @uml.property name="titre"
	 */

	private String auteur;

	/**
	 * @uml.property name="genre"
	 */
	private String genre;

	/**
	 * @uml.property name="nbPage"
	 */
	private int nbPages;

	/**
	 * @uml.property name="avis"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="livre:avis.Avis"
	 */

	/**
	 * @uml.property name="note"
	 */


	@Override
	public String toString() {
		return "Book [ "+ super.toString() + " auteur=" + auteur + ", genre=" + genre + ", nbPages="
				+ nbPages + "]";
	}
}
