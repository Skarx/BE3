/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;



import avis.SocialNetwork;
import exception.BadEntry;
import exception.NotItem;
import exception.NotMember;

/**
 * 
 * @author HvP
 */
public class TestsReviewItemBook {

	public static void main(String[] args) {
		maina(null);
	}

	public static int[] maina(String[] args) {
		// Initialisation des variables
		float moyenne = 0.0f;
		int i = 0;
		int echec = 0;
		int test = 0;
		int nbFilms = 0;

		int nbMembers = 0;
		System.out.println("Test review sur un livre");

		// Création d'un nouveau SocialNetwork
		SocialNetwork sn = new SocialNetwork();

		// Ajout d'un membre correct pour effectuer les tests
		try {
			sn.addMember("bob", "bob1", "bob");
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception non prévue : " + e);
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un membre non instancié
		test++;
		try {
			moyenne = sn.reviewItemBook(null, "bob1", "livre" + i, 4.0f, "bob");
			System.out
					.println("Erreur 3.1 : La review est acceptée sans utilisateur valide (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.1 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		// Tentative d'ajout de review avec membre contenant des espaces
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println(" Exception non prévue : " + e);
			e.printStackTrace();
		}

		// FIN NOUVEAU LIVRE

		test++;
		try {
			moyenne = sn.reviewItemBook("      ", "bob1", "livre" + i, 4.0f,
					"bob");
			System.out
					.println("Erreur 3.2 : La review est acceptée sans utilisateur valide (espaces)");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.2 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");
		}

		// FIN NOUVEAU LIVRE

		// Tentative d'ajout de review avec un membre incorrect
		test++;
		try {
			moyenne = sn.reviewItemBook("Alice", "bob1", "livre" + i, 4.0f,
					"bob");
			System.out
					.println("Erreur 3.3 : La review est acceptée sans utilisateur valide (inexistant)");
			echec++;
		} catch (NotMember e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.3 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.3, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE

		// Tentative d'ajout de review avec un password trop court
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", "mdp", "livre" + i, 4.0f, "bob");
			System.out
					.println("Erreur 3.4 : La review est acceptée sans password valide (trop court)");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.4 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.4, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un password null
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", null, "livre" + i, 4.0f, "bob");
			System.out
					.println("Erreur 3.5 : La review est acceptée sans password valide (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.5 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.5, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un password incorrect
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", "Alice", "livre" + i, 4.0f,
					"bob");
			System.out
					.println("Erreur 3.6 : La review est acceptée avec un mauvais password");
			echec++;
		} catch (NotMember e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.6 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.6, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un livre null
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", "bob1", null, 4.0f, "bob");
			System.out
					.println("Erreur 3.7 : La review est acceptée avec un livre null");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.7 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.7, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un livre null
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", "bob1", "        ", 4.0f, "bob");
			System.out
					.println("Erreur 3.8 : La review est acceptée avec un livre contenant que des espaces");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.8 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.8, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un livre non existnant
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", "bob1", "azerty", 4.0f, "bob");
			System.out
					.println("Erreur 3.9 : La review est acceptée avec un livre inexistant");
			echec++;
		} catch (NotItem e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.9 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.9, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec une note < à 0
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", "bob1", "livre" + i, -4.0f,
					"bob");
			System.out
					.println("Erreur 3.10 : La review est acceptée sans note valide (<0)");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.10 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.10, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec une note > à 5
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn
					.reviewItemBook("bob", "bob1", "livre" + i, 5.1f, "bob");
			System.out
					.println("Erreur 3.11 : La review est acceptée sans note valide (>5)");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.11 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.11, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un commentaire null
		// NOUVEAU LIVRE
		i++;
		try {
			sn.addItemBook("bob", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		// FIN NOUVEAU LIVRE
		test++;
		try {
			moyenne = sn.reviewItemBook("bob", "bob1", "livre" + i, 4.0f, null);
			System.out
					.println("Erreur 3.12 : La review est acceptée sans commentaires (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (moyenne != 0.0f) {
				System.out
						.println("Erreur 3.12 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.12, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// /////////////// Ajout d'un 2eme membre et test de 2 notes de suite
		i++;
		// Ajout d'un membre correct pour effectuer les tests
		try {
			sn.addMember("bob2", "bob1", "bob");
			sn.addItemBook("bob2", "bob1", "livre" + i, "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Exception imprévue");

		}
		nbMembers = sn.nbMembers();
		test++;
		try {
			moyenne = sn
					.reviewItemBook("bob", "bob1", "livre" + i, 4.0f, "bob");
		} catch (Exception e) {
			System.out
					.println("Erreur 3.13 Exception non prévue sur utilisation normale" + e);

		}
		try {
			moyenne = sn
					.reviewItemBook("bob2", "bob1", "livre" + i, 2.0f, "bob");
		} catch (Exception e) {
			System.out.println("Exception non prévue");
		}
		test++;
		if (moyenne != 3.0f) {
			System.out
					.println("Erreur 3.14 : La moyenne des deux notes est éronnée");
			echec++;
		}
		test++;
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Erreur 3.15 :  le nombre de films après utilisation de ReviewItemBook a été modifié");
			echec++;
		}
		test++;
		if (nbMembers != sn.nbMembers()) {
			System.out
					.println("Erreur 3.17 :  le nombre de Membres après utilisation de ReviewItemBook a été modifié");
			echec++;
		}
		int[] tab = { echec, test - echec };
		return tab;
	}
}
