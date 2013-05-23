package avis;

import java.util.Collection;
import java.util.LinkedList;

public class Member extends Visiteur {
    /**
     * Obtenir une représentation textuelle d'un <i>Member</i>.
     *
     * @return la chaîne de caractères représentation textuelle d'un
     *         <i>Member</i>
     */
	
	@Override
	public String toString() {
		return "Member [review=" + review + ", pseudo="
				+ pseudo + ", password=" + password + ", profil=" + profil
				+ "]";
	}

	private Collection<Review> review;
	private String pseudo;
	private String password;
	private String profil;
	private float karma;
	
    /**
    *
    * @param pseudo
    *                  pseudo du membre
    * @param password
    *                  son password
    * @param profil
    *                  commentaire(s) sur son profil
    */

   /**
    * constructeur de <i>Member</i>
    *
    */
	public Member (String pseudo, String password, String profil){
		this.pseudo = pseudo.trim();
		this.password = password.trim();
		this.profil = profil;
		this.review = new LinkedList<Review>();
		this.karma = 2.5f;
		
	}
	
    /**
     * Retourne le pseudo d'un membre
     *
     * @return  le pseudo
     */
	
	public String getPseudo(){
		return pseudo;
	}
	
    /**
     * Retourne le password d'un membre
     *
     * @return  le password
     */
	
	public String getPassword(){
		return password;
	}

    /**
     * Parcours la liste des reviews :
     * <ul>
     *     <li>
     *          Si une review est présente, elle est mise à jour.
     *     </li>
     *      <li>
     *          Si elle ne l'est pas, elle est ajoutée.
     *      </li>
     * </ul>
     *
     * @param une_review
     */

	public void updateReviews(Review review){
		boolean existingReview = false;
		for (Review r : this.review) {
				if (r.getMembre().equals(review.getMembre())) {
					r = review;
					existingReview = true ;
				}
		}
		if (existingReview == false)
			this.review.add(review);
	}
	
	/**
	 * Calcul de la moyenne du karma
	 * 
	 * @return la moyenne attribuée au membre
	 */
	
	public float moyenneCalculation() {
		float avgMark=0 ;
		   for(Review rvw:review){
		    avgMark += rvw.getNote() ;
		   }
		   avgMark = avgMark / review.size() ;
		  
		  return avgMark ;
	}
	
	/**
	 * Ajoute (ou met à jour) une moyenne (de karma) sur un membre
	 */
	
	public void setMoyenne(float note){
		this.karma = note;
	}
	
	/**
	 * Retourne le karma du membre
	 * 
	 * @return Le karma d'un membre
	 */
	
	public float getKarma(){
		return karma;
	}
}
