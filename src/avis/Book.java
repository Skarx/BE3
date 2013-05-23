package avis;

import java.util.LinkedList;

/**
 * @author JP. Weltzer
 * @author H. Carron
 * @date mai - juin 2013
 */

/**
 * Représentation des Items de type Book
 *
 * @param titre
 *              son titre
 * @param genre
 *              son genre
 * @param auteur
 *              le nom de l'auteur
 * @param nbPages
 *              le nombre de pages
 *
 */
public class Book extends Item {
	
    /**
     * constructeur de <i>Book</i>
     *
     */
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

	/**
	 * Obtenir une représentation textuelle d'un <i>Book</i>.
	 * 
	 * @return la chaîne de caractères représentation textuelle d'un
	 *         <i>Book</i>
	 */
	
	@Override
	public String toString() {
		return "Book [ "+ super.toString() + " auteur=" + auteur + ", genre=" + genre + ", nbPages="
				+ nbPages + "]";
	}
}
