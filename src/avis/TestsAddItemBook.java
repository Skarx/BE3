/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avis;

import java.util.LinkedList;

import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

/**
 * 
 * @author HvP
 */
public class TestsAddItemBook {

	public static int[] main(String[] args) {
		// Initialisation des variables
		int nbLivres = 0;
		int test = 0;
		int echec = 0;
		int nbFilms = 0;
		int nbMembers = 0;
		System.out.println("Test ajouter un livre");

		// Création d'un nouveau SocialNetwork
		SocialNetwork sn = new SocialNetwork();

		// Ajout d'un membre correct pour effectuer les tests
		try {
			sn.addMember("bob", "bob1", "bob");
		} catch (Exception e) {
			System.out.println("Exception imprévue");
		}
		nbLivres = sn.nbBooks();
		nbMembers = sn.nbMembers();
		// Tentative d'ajout d'un membre contenant que des espaces
		test++;
		try {
			sn.addItemBook("       ", "bob1", "bob", "bob", "bob", 42);
			System.out
					.println("Erreur 1.1 : Le livre est accepté sans utilisateur valide (espaces)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.1 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();
		// Tentative d'ajout de livre avec un membre non instancié
		test++;

		try {
			sn.addItemBook(null, "bob1", "bob", "bob", "bob", 42);
			System.out
					.println("Erreur 1.2 : Le livre est accepté sans utilisateur valide (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.2 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();
		// Tentative d'ajout de livre avec un membre non existant
		test++;
		try {
			sn.addItemBook("Alice", "bob1", "bob", "bob", "bob", 42);
			System.out
					.println("Erreur 1.3 : Le livre est accepté sans utilisateur valide (non existant)");
			echec++;
		} catch (NotMember e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.3 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.3, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();
		// Tentative d'ajout avec password incorrect
		test++;
		try {
			sn.addItemBook("bob", "azerty", "bob", "bob", "bob", 42);
			System.out
					.println("Erreur 1.4 : Le livre est accepté avec un password incorrect");
			echec++;
		} catch (NotMember e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.4 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.4, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();

		// Tentative d'ajout avec password incorrect (< 4)
		test++;
		try {
			sn.addItemBook("bob", "bob", "bob", "bob", "bob", 42);
			System.out
					.println("Erreur 1.5 : Le livre est accepté avec un password incorrect (<4)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.5 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.5, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		nbLivres = sn.nbBooks();

		// Tentative d'ajout avec password incorrect (non instancié)
		test++;
		try {
			sn.addItemBook("bob", null, "bob", "bob", "bob", 42);
			System.out
					.println("Erreur 1.6 : Le livre est accepté avec un password incorrect (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.6 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.6, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		nbLivres = sn.nbBooks();

		// Ajout d'un livre avec titre incorrect
		test++;
		try {
			sn.addItemBook("bob", "bob1", null, "bob", "bob", 42);
			System.out
					.println("Erreur 1.7 : Le livre est accepté avec un titre incorrect (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.7 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.7, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();

		// Ajout d'un livre avec titre contenant des espaces
		test++;
		try {
			sn.addItemBook("bob", "bob1", "       ", "bob", "bob", 42);
			System.out
					.println("Erreur 1.8 : Le livre est accepté avec un titre incorrect (espaces)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.8 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.8, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();
		// Ajout d'un livre avec genre incorrect
		test++;
		try {
			sn.addItemBook("bob", "bob1", "bob", null, "bob", 42);
			System.out
					.println("Erreur 1.9 : Le livre est accepté avec un genre incorrect (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.9 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.9, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();

		// Ajout d'un livre avec auteur incorrect
		test++;
		try {
			sn.addItemBook("bob", "bob1", "bob", "bob", null, 42);
			System.out
					.println("Erreur 1.10 : Le livre est accepté avec un auteur incorrect (non instancié)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.10 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.10, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		nbLivres = sn.nbBooks();

		// Ajout d'un livre avec nbpage = 0
		test++;
		try {
			sn.addItemBook("bob", "bob1", "bob", "bob", "bob", 0);
			System.out
					.println("Erreur 1.11 : Le livre est accepté avec un nbpage incorrect (=0)");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur 1.11 : Le nombre de livre a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.11, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		/* Création d'un livre correct et tentative de création de doublon */
		test++;
		try {
			sn.addItemBook("bob", "bob1", "bob", "bob", "bob", 42);
		} catch (Exception e) {
			System.out.println("Erreur 1.12, Exception non prévue : " + e);
			e.printStackTrace();
		}

		nbLivres = sn.nbBooks();
		test++;
		try {
			sn.addItemBook("bob", "bob1", "bob", "bob", "bob", 42);
			System.out.println("Erreur 1.12 : un doublon a été créé");
			echec++;
		} catch (ItemBookAlreadyExists e) {
			if (sn.nbBooks() != nbLivres) {
				System.out.println("Erreur : 1.12 : Un doublon a été créé");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.12, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		nbLivres = sn.nbBooks();
		// Tentative de création d'un livre avec la casse différente
		try {
			sn.addItemBook("bob", "bob1", "BOB", "bob", "bob", 42);
			System.out
					.println("Erreur : 1.13 : Un doublon a été créé (avec casse différente)");
			echec++;
		} catch (ItemBookAlreadyExists e) {
			if (sn.nbBooks() != nbLivres) {
				System.out
						.println("Erreur : 1.13 : Un doublon a été créé (avec casse différente)");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 1.13, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		test++;
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Erreur 1.14 :  le nombre de films après utilisation de AddItemBook a été modifié");
			echec++;
		}
		test++;
		if (nbMembers != sn.nbMembers()) {
			System.out
					.println("Erreur 1.15 :  le nombre de membres après utilisation de AddItemBook a été modifié");
			echec++;
		}
		System.out.println(sn);
		System.out.println("Fin de TestAddItemBook");

		int[] tab = { echec, test - echec };
		return tab;
	}
}
