package avis;


public class Review {

	private String commentaire;
	private Item item;
	private float note = 0;
	private Member member;
	private Review rev;
	
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
	public Member getMembre() {
		return member;
	}

	/**
	 * @uml.property name="commentaire"
	 */


	public Item getItem() {
		return item;
	}

	public float getNote() {
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
