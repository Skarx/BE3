package Test;

import avis.SocialNetwork;



/**
 * @author B. Prou
 * @date mars 2011
 * @version V0.6
 */
public class TestsInitialisation {

	public static int[] main(String[] args) {
		// TODO Auto-generated method stub

		int echec = 0;
		int test = 0;

		System.out.println("Tests  initialisation  réseau social  ");

		try {

			// un réseau social créé ne doit avoir ni membres ni items
			SocialNetwork sn = new SocialNetwork();
			test++;
			if (sn.nbMembers() != 0) {
				System.out
						.println("Erreur 1.1 :  le nombre de membres après création du réseau est non nul");
				echec++;
				System.exit(1);
			}
			test++;
			if (sn.nbBooks() != 0) {
				System.out
						.println("Erreur 1.2 : le nombre de livres après création du réseau est non nul");
				echec++;
				System.exit(1);
			}
			test++;
			if (sn.nbFilms() != 0) {
				System.out
						.println("Erreur 1.2 : le nombre de films après création du réseau est non nul");
				echec++;
				System.exit(1);
			}

			System.out.println(sn);

		} catch (Exception e) {
			System.out.println("Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		int[] tab = { echec, test - echec };
		return tab;
	}
}
