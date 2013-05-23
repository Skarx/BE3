package avis;

import java.util.LinkedList;

import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

/**
 * @author B. Prou
 * @date mars 2011
 * @version V0.6
 */
public class TestsAddMember {

	public static int[] main(String[] args) {
		// TODO Auto-generated method stub

		int nbMembres = 0;
		int nbLivres = 0;
		int nbFilms = 0;
		int echec = 0;
		int test = 0;

		System.out.println("Tests  ajouter des membres au réseau social  ");

		SocialNetwork sn = new SocialNetwork();

		// tests de addMember
		nbFilms = sn.nbFilms();
		nbLivres = sn.nbBooks();

		// <=> fiche numéro 1

		// tentative d'ajout de membres avec entrées "incorrectes"

		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember(null, "qsdfgh", "");
			System.out
					.println("Erreur 3.1 :  l'ajout d'un membre dont le pseudo n'est pas instancié est accepté ");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.1 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember("  ", "qsdfgh", "");
			System.out
					.println("Erreur 3.2 :  l'ajout d'un membre dont le pseudo ne contient pas un caractère, autre que des espaces, est accepté ");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.2 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember("B", null, "");
			System.out
					.println("Erreur 3.3 :  l'ajout d'un membre dont le password n'est pas instancié est accepté ");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.3 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.3, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember("B", "  qwd  ", "");
			System.out
					.println("Erreur 3.4 :  l'ajout d'un membre dont le password ne contient pas au moins 4 caractères, autre que des espaces de début ou de fin, est accepté ");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.4 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.4, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		nbMembres = sn.nbMembers();
		try {
			sn.addMember("BBBB", "bbbb", null);
			System.out
					.println("Erreur 3.5 :  l'ajout d'un membre dont le profil n'est pas instancié est accepté ");
			echec++;
		} catch (BadEntry e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.5 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.5, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// <=> fiche numéro 2

		// ajout de 3 membres avec entrées "correctes"
		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember("Paul", "paul", "lecteur impulsif");
			sn.addMember("Antoine", "antoine", "grand amoureux de littérature");
			sn.addMember("Alice", "alice", "23 ans, sexy");
			if (sn.nbMembers() != (nbMembres + 3)) {
				System.out
						.println("Erreur 3.6 :  le nombre de membres après ajout de 3 membres n'a pas augmenté de 3");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.6, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		// tentative d'ajout de membre "existant"
		test++;
		nbMembres = sn.nbMembers();
		try {
			sn.addMember("Paul", "abcdefghij", "");
			System.out
					.println("Erreur 3.7 :  l'ajout d'un membre avec le pseudo du premier membre ajouté est accepté ");
			echec++;
		} catch (MemberAlreadyExists e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.7 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.7, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember("Alice", "abcdefghij", "");
			System.out
					.println("Erreur 3.8 :  l'ajout d'un membre avec le pseudo du dernier membre ajouté est accepté ");
			echec++;
		} catch (MemberAlreadyExists e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.8 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.8, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember("anToine", "abcdefghij", "");
			System.out
					.println("Erreur 3.9 :  l'ajout d'un membre avec un pseudo existant (avec casse différente) est accepté ");
			echec++;
		} catch (MemberAlreadyExists e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.9 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.9, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		nbMembres = sn.nbMembers();
		test++;
		try {
			sn.addMember("  Antoine  ", "abcdefghij", "");
			System.out
					.println("Erreur 3.10 :  l'ajout d'un membre avec un pseudo existant (avec leading et trailing blanks) est accepté ");
			echec++;
		} catch (MemberAlreadyExists e) {
			if (sn.nbMembers() != nbMembres) {
				System.out
						.println("Erreur 3.10 :  le nombre de membres après tentative d'ajout refusée a été modifié");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 3.10, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}

		test++;
		if (nbFilms != sn.nbFilms()) {
			System.out
					.println("Erreur 3.11 :  le nombre de films après utilisation de addMember a été modifié");
			echec++;
		}
		test++;
		if (nbLivres != sn.nbBooks()) {
			System.out
					.println("Erreur 3.12 :  le nombre de livres après utilisation de addMember a été modifié");
			echec++;
		}

		// ce n'est pas du test, mais cela peut "rassurer"...
		System.out.println(sn);
		int[] tab = { echec, test - echec };
		return tab;
	}
}
