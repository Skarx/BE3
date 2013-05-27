package avis;

import java.util.Collection;

public class Review {
	public Review(Item itemRev, Member userAuth, float note, String commentaire) {
		this.item = itemRev;
		this.member = userAuth;
		this.note = note;
		this.commentaire = commentaire;
	}
	public Review(Review rev, Member userAuth, float note, String commentaire) {
		this.member = userAuth;
		this.rev = rev;
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
	private Review rev;
	public Item getItem() {
		return item;
	}
	public float getNote(){
		return note;
	}
	// Met à jour les les champs de la review

	public void updateFields(float note, String commentaire) {
		this.commentaire = commentaire;
		this.note = note;
	}
	@Override
	public String toString() {
		return "Review [note=" + note + ", member=" + member + ", commentaire="
				+ commentaire + ", item=" + item + "]";
	}
}
