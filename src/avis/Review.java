package avis;

import java.util.Collection;

public class Review {
	public Review(Item itemRev, Member userAuth, float note, String commentaire) {
		this.item = itemRev;
		this.member = userAuth;
		this.note = note;
		this.commentaire = commentaire;
	}
	public Review(Member memberRev, Member userAuth, float note, String commentaire) {
		this.memberKarma = memberRev;
		this.member = userAuth;
		this.note = note;
		this.commentaire = commentaire;
	}
	private float note = 0;
	private Member member;

	public Member getMembre() {
		return member;
	}

	/**
	 * @uml.property name="commentaire"
	 */
	private String commentaire;
	private Item item;
	private Member memberKarma;
	public Item getItem() {
		return item;
	}
	public float getNote(){
		return note;
	}

	public void updateFields(float note, String commentaire) {
		this.commentaire = commentaire;
		this.note = note;
	}
	public float reviewMember(Review review){
		Member member = review.getMembre();
		member.updateReviews(review);
		
		return note;
	}
	@Override
	public String toString() {
		return "Review [note=" + note + ", member=" + member + ", commentaire="
				+ commentaire + ", item=" + item + "]";
	}
}
