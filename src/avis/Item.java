package avis;


import java.util.LinkedList;

public abstract class Item {

	/**
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)"
	 *                     inverse="item:avis.SocialNetwork"
	 */

	protected LinkedList<Review> review;
	protected float note;
	protected String titre;

	/**
	 * Getter of the property <tt>avis</tt>
	 * 
	 * @return Returns the avis.
	 * @uml.property name="avis"
	 */
	// return la liste d'avis
	public LinkedList<Review> getAvis() {
		return review;
	}

	/**
	 * Obtient le titre de l'Item
	 * 
	 * @return le titre
	 */

	public String getTitre() {
		return titre;
	}

	/**
	 * Renvoi la moyenne de toutes les notes attribu�es � un Item.
	 * 
	 * @return la moyenne
	 */

	public float getMoyenne() {
		return note;
	}

	/**
	 * Ajoute un avis sur une review
	 */

	public void ajoutAvis(Review r) {
		review.add(r);
	}

	/**
	 * Ajoute (ou met � jour) une moyenne sur un Item
	 */

	public void setMoyenne(float note) {
		this.note = note;
	}

	/**
	 * Calcul de la moyenne des notes
	 * 
	 * @return la moyenne attribu�e � l'Item
	 */

	public float moyenneCalculation() {
		float[] note = { 0, 0 };
		if (review.size() != 0) {
			for (Review rvw : review) {
				note[0] += rvw.getNote() * rvw.getMembre().getKarma();
				;
				note[1] += rvw.getMembre().getKarma();
			}
		}
		return note[0] / note[1];
	}

	/**
	 * Obtenir une repr�sentation textuelle d'un <i>Item</i>.
	 * 
	 * @return la cha�ne de caract�res repr�sentation textuelle d'un <i>Item</i>
	 */

	@Override
	public String toString() {
		return "note=" + note + ", titre=" + titre;
	}
}
