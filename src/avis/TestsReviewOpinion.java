package avis;

import exception.BadEntry;
import exception.NotItem;
import exception.NotMember;

public class TestsReviewOpinion {
	public static void main(String[] args) {
		maina(null);
	}

	public static int[] maina(String[] args) {
		// Initialisation des variables
		float moyenne = 0.0f;
		int i = 0;
		int echec = 0;
		int test = 0;

		System.out.println("Test review sur un livre");

		// Création d'un nouveau SocialNetwork
		SocialNetwork sn = new SocialNetwork();

		// Ajout d'un membre correct pour effectuer les tests
		try {
			sn.addMember("bob1", "bob1", "bob");
			sn.addMember("bob2", "bob2", "bob");
			sn.addMember("bob3", "bob2", "bob");
			sn.addMember("bob4", "bob4", "bob");
			sn.addItemBook("bob1", "bob1", "L'art de la guerre", "Receuil", "Sun Tzu", 42);
			sn.addItemFilm("bob1", "bob1", "Shaun of the dead", "Humour", "Simon pegg et j'sais plus qui", "dunno", 190);
			sn.reviewItemBook("bob1", "bob1", "l'art de la guerre", 4.0f, "Cool !");
			sn.reviewItemFilm("bob2", "bob2", "Shaun of the dead", 4.0f, "Cool !");
			
		} catch (Exception e) {
			System.out.println("Exception non prévue : " + e);
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un membre non instancié
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			
		
		} catch (Exception e) {
			System.out.println("Erreur 8.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		
		int[] tab = { echec, test - echec };
		return tab;
	}
}
