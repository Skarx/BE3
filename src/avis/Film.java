package avis;

import java.util.Collection;
import java.util.LinkedList;

public class Film extends Item {

	/**
	 * @uml.property name="avis"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="film:avis.Avis"
	 */
	
    /**
     * @param titre
     *              son titre
     * @param duree
     *              la durée du film
     * @param genre
     *              son genre
     * @param realisateur
     *              le nom du réalisateur
     * @param scenariste
     *              le nom du scénariste
     */
	
    /**
     * constructeur de <i>Film</i>
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


	/**
	 * Obtenir une représentation textuelle d'un <i>Livre</i>.
	 * 
	 * @return la chaîne de caractères représentation textuelle du
	 *         <i>Livre</i>
	 */
	
	@Override
	public String toString() {
		return "Film [ " + super.toString() + "genre=" + genre + ", realisateur=" + realisateur
				+ ", scenariste=" + scenariste + ", duree=" + duree + "]";
	}
}
