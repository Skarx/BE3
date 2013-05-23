package avis;

import java.util.Collection;
import java.util.LinkedList;

public class Member extends Visiteur {
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
	
	public Member (String pseudo, String password, String profil){
		this.pseudo = pseudo.trim();
		this.password = password.trim();
		this.profil = profil;
		this.review = new LinkedList<Review>();
		this.karma = 2.5f;
		
	}
	public String getPseudo(){
		return pseudo;
	}
	public String getPassword(){
		return password;
	}

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
	public float moyenneCalculation() {
		float avgMark=2.5f ;
		   for(Review rvw:review){
		    avgMark += rvw.getNote() ;
		   }
		   avgMark = avgMark / review.size()+1 ;
		  
		  return avgMark ;
	}
	public void setMoyenne(float note){
		this.karma = note;
	}
	public float getKarma(){
		return karma;
	}
}
