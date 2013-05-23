package avis;

import java.util.Collection;
import java.util.LinkedList;

public class Film extends Item {

	/**
	 * @uml.property name="avis"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="film:avis.Avis"
	 */
	
    /**
     * Cr�er un nouvel Item de type Livre
     * 
     * @param titre
     *              son titre
     * @param duree
     *              la dur�e du film
     * @param genre
     *              son genre
     * @param realisateur
     *              le nom du r�alisateur
     * @param scenariste
     *              le nom du sc�nariste
     *
     * 
     */
	public Film (String titre, int duree, String genre, String realisateur, String scenariste){
		this.titre = titre.trim();
		this.duree = duree;
		this.genre = genre;
		this.realisateur = realisateur;
		this.scenariste = scenariste;
		review = new LinkedList <Review>();
		
	}


	/**
	 * @uml.property name="genre"
	 */
	private String genre;
	/**
	 * @uml.property name="realisateur"
	 */
	private String realisateur;
	/**
	 * @uml.property name="scenariste"
	 */
	private String scenariste;
	/**
	 * @uml.property name="duree"
	 */
	private int duree;


	@Override
	/**
	 * Obtenir une repr�sentation textuelle d'un <i>Livre</i>.
	 * 
	 * @return la cha�ne de caract�res repr�sentation textuelle du
	 *         <i>Livre</i>
	 */
	public String toString() {
		return "Film [ " + super.toString() + "genre=" + genre + ", realisateur=" + realisateur
				+ ", scenariste=" + scenariste + ", duree=" + duree + "]";
	}
}
