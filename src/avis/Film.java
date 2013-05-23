package avis;

import java.util.Collection;
import java.util.LinkedList;

public class Film extends Item {

	/**
	 * @uml.property name="avis"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="film:avis.Avis"
	 */
	public Film (String titre, int duree, String genre, String realisateur, String scenariste){
		this.titre = titre.trim();
		this.duree = duree;
		this.genre = genre;
		this.realisateur = realisateur;
		this.scenariste = scenariste;
		review = new LinkedList <Review>();
		
	}



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
	public String toString() {
		return "Film [genre=" + genre + ", realisateur=" + realisateur
				+ ", scenariste=" + scenariste + ", duree=" + duree + "]";
	}
}
