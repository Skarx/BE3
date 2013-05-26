package avis;

import java.util.LinkedList;

public class Member extends Visiteur {
    /**
     * Obtenir une repr�sentation textuelle d'un <i>Member</i>.
     *
     * @return la cha�ne de caract�res repr�sentation textuelle d'un
     *         <i>Member</i>
     */
	
	@Override
	public String toString() {
		return "Member [review=" + review + ", pseudo="
				+ pseudo + ", password=" + password + ", profil=" + profil
				+ "]";
	}

	private LinkedList<Review> review;
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
     *          Si une review est pr�sente, elle est mise � jour.
     *     </li>
     *      <li>
     *          Si elle ne l'est pas, elle est ajout�e.
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
	 * @return la moyenne attribu�e au membre
	 */
	
	public float moyenneCalculation() {
		int size = this.review.size();
		size++;
		float avgMark=2.5f ;
		   for(Review rvw:review){
		    avgMark += rvw.getNote() ;
		   }
		   avgMark = (avgMark / (size)) ;
		  return avgMark ;
	}
	
	/**
	 * Ajoute (ou met � jour) une moyenne (de karma) sur un membre
	 */
	
	public void setMoyenne(float note){
		this.karma = note;
	}
	
	public LinkedList<Review> getReview(){
		return review;
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
