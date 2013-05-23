package avis;

import java.util.Collection;
import java.util.LinkedList;


public abstract class Item {

	/**
	 * @uml.property name="socialNetwork"
	 * @uml.associationEnd multiplicity="(1 1)"
	 *                     inverse="item:avis.SocialNetwork"
	 */
	
	
	protected LinkedList<Review> review;

	/**
	 * Getter of the property <tt>avis</tt>
	 * 
	 * @return Returns the avis.
	 * @uml.property name="avis"
	 */
	public LinkedList<Review> getAvis() {
		return review;
	}
	protected float note;
	protected String titre;

	public String getTitre() {
		return titre;
	}
	public float getMoyenne(){
		return note;
	}
	
	/**
	 * Ajoute un avis sur une review
	 */
	public void ajoutAvis(Review r){
		review.add(r);
	}
	
	/**
	 * Ajoute (ou met à jour) une moyenne sur un Item
	 */
	public void setMoyenne(float note){
		this.note = note;
	}
	
	/**
	 * Calcul de la moyenne
	 * 
	 * @return la moyenne attribuée à l'Item
	 */
	public float moyenneCalculation() {
		float[] note = {0,0};
		  if(review.size()!=0){
		   for(Review rvw:review){
			   note[0]+=rvw.getNote()*rvw.getMembre().getKarma();;
			   note[1]+=rvw.getMembre().getKarma();
		   }
		  }
		  return  note[0]/note[1];
	}
	@Override
	/**
	 * Obtenir une représentation textuelle d'un <i>Item</i>.
	 * 
	 * @return la chaîne de caractères représentation textuelle d'un
	 *         <i>Item</i>
	 */
	public String toString() {
		return  "note=" + note + ", titre=" + titre
				;
	}
}
