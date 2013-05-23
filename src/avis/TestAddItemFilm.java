package avis;

import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.NotMember;

public class TestAddItemFilm {
	public static int[] main(String[] args) {
		int nbFilms = 0;
		int test = 0 ;
		int echec = 0 ;
		
		System.out.println("Tests  ajouter des Films dans ToutAvis");
		
		SocialNetwork sn = new SocialNetwork();
		
		// Ajouts des Utilisateurs necessaires au Tests
		try {
			sn.addMember("ZeUser", "ZePassWord", "aBeautifulProfile");
			sn.addMember("ZeFirstUser", "ZePassWord", "aBeautifulProfile");
			sn.addMember("ZeSecondUser", "APassWord", "aBeautifulProfile");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (sn.nbMembers() != 3){
			System.out.println("Erreur Lors de la création des Membres : Interruption des Test sur AddItemFilm");
		}
			
		
		
		
		/// GESTION DES CAS D'ANOMALIE SUR addItemFilm.
		
		//  Pseudo null
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm (null, "ZePassWord", "Mirrors", "long", "unRealisateur", "unScenariste", 1000);	
			System.out.println("Erreur 7.1 :  l'ajout d'un film dont le pseudo n'est pas instancié est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.1 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.1, Exception non prévue : " + e);
			e.printStackTrace();
		}
		
		//  Pseudo avec 2 espaces consécutifs
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("  ", "ZePassWord", "Mirrors", "TresLongfilm", "unRealisateur", "unScenariste", 1000);	
			System.out.println("Erreur 7.2 :  l'ajout d'un film le pseudo ne contient pas un caractère, autre que des espaces, est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.2 : le nombre de films après tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}			
		catch (Exception e) {
			System.out.println("Erreur 7.2, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Password non instancié
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeUser", null, "Mirrors", "TresLongfilm", "unRealisateur", "unScenariste", 1000);	
			System.out.println("Erreur 7.3 :  l'ajout d'un film dont le password n'est pas instancié est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.3 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.3, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Password non conforme
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeUser", "Ze  ", "Mirrors", "TresLongfilm", "unRealisateur", "unScenariste", 1000);	
			System.out.println("Erreur 7.4 :  l'ajout d'un film dont le password n'est pas assez long est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.4 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.4, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Titre non instancié
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeUser", "ZePassWord", null, "TresLongfilm", "unRealisateur", "unScenariste", 1000);	
			System.out.println("Erreur 7.5 :  l'ajout d'un film dont le Titre n'est pas instancié est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.5 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.5, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Titre pas assez long
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeUser", "ZePassWord", "  ", "TresLongfilm", "unRealisateur", "unScenariste", 1000);	
			System.out.println("Erreur 7.6 :  l'ajout d'un film dont le Titre n'est pas assez long est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.6 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.6, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Genre non instancié
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeUser", "ZePassWord", "Mirrors", null, "unRealisateur", "unScenariste", 1000);	
			System.out.println("Erreur 7.7 :  l'ajout d'un film dont le genre n'est pas instancié est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.7 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.7, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Réalisateur non instancié
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeUser", "ZePassWord", "Mirrors", "TresLongfilm", null, "unScenariste", 1000);	
			System.out.println("Erreur 7.8 :  l'ajout d'un film dont le réalisateur n'est pas instancié est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.8 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.8, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Scénariste non instancié
				nbFilms = sn.nbFilms();
				test++;
				try {
					sn.addItemFilm ("ZeUser", "ZePassWord", "Mirrors", "TresLongfilm", "unRealisateur", null, 1000);	
					System.out.println("Erreur 7.8 :  l'ajout d'un film dont le scénariste n'est pas instancié est accepté ");
					echec++;
				}
				catch (BadEntry e) {
					if (sn.nbFilms() != nbFilms){
						System.out.println("Erreur 7.8 :  le nombre de films après une tentative d'ajout refusée a été modifié");
						echec ++;
					}
				}
				catch (Exception e) {
					System.out.println("Erreur 7.8, Exception non prévue : " + e);
					e.printStackTrace();
					echec++;
				}
				
				
		// Durée non Positive
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeUser", "ZePassWord", "Mirrors", "TresLongfilm", "unRealisateur", "unScenariste", -1);	
			System.out.println("Erreur 7.9 :  l'ajout d'un film contenant aucune durée est accepté ");
			echec++;
		}
		catch (BadEntry e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 7.9 :  le nombre de films après une tentative d'ajout refusée a été modifié");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 7.9, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		
		
		
		
		/// TEST DE FONCTIONNEMENT DE LA METHODE addItemFilm.
		
		/// Levée de NotMember à l'ajout d'un film par ZeThirdUser
		
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeFirstUser", "ZePassWord", "Mirrors", "TresLongfilm", "unRealisateur", "unScenariste", 1000);
			sn.addItemFilm ("ZeSecondUser", "APassWord", "Snatch", "Thriller", "Guy Ritchie","unaScenarista", 365);
			if (sn.nbFilms()!= (nbFilms + 2)) {
				System.out.println("Erreur 8.1 :  le nombre de membres après ajout de 2 films n'a pas augmenté de 2");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 8.1, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Ajout d'un film par un utilisateur non référencé
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeThirdUser", "ZePassWord", "unTitreBateau", "unGenreBateau", "unRealisateurBateau", "unScenaristeBateau", 30);
			System.out.println("Erreur 8.2 :  l'ajout d'un film par un utilisateur qui n'est pas membre est permise");
			echec++;
		}
		catch (NotMember e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 8.2 : Le nombre de films a changé alors que l'ajout n'est pas permis");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 8.2, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}

		// Ajout d'un film par un utilisateur avec mauvais mot de passe
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeFirstUser", "Ze_WRONG_PassWord", "unTitreBateau", "unGenreBateau", "unRealisateur", "unScenariste", 30);
			System.out.println("Erreur 8.3 :  l'ajout d'un film par un utilisateur avec un mauavais mot de passe est permise");
			echec++;
		}
		catch (NotMember e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 8.3 : Le nombre de films a changé alors que l'ajout n'est pas permis");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 8.3, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
	
		/// Levée de ItemFilmAlreadyExists
		//  Ajout d'un film au titre existant (Premier film)
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeSecondUser", "APassWord", "Mirrors", "unGenreBateau", "unRealisateur", "unScenariste", 1001);
			System.out.println("Erreur 8.4 :  l'ajout d'un film déja existant en début est permise");
			echec++;
		}
		catch (ItemFilmAlreadyExists e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 8.4 : Le nombre de films a changé alors que l'ajout n'est pas permis");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 8.4, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Ajout d'un film au titre existant (Dernier film)
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeFirstUser", "ZePassWord", "Snatch", "Thriller", "Guy Ritchie", "unScenariste", 365);
			System.out.println("Erreur 8.5 :  l'ajout d'un film déja existant en fin est permise");
			echec++;
		}
		catch (ItemFilmAlreadyExists e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 8.5 : Le nombre de films a changé alors que l'ajout n'est pas permis");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 8.5, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Ajout d'un film à la casse différente
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeFirstUser", "ZePassWord", "Snatch", "Thriller", "Guy Ritchie", "unScenariste", 365);
			System.out.println("Erreur 8.6 :  l'ajout d'un film déja existant avec une casse différente est permise");
			echec++;
		}
		catch (ItemFilmAlreadyExists e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 8.6 : Le nombre de films a changé alors que l'ajout n'est pas permis");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 8.6, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		// Ajout d'un film avec des blancs 
		nbFilms = sn.nbFilms();
		test++;
		try {
			sn.addItemFilm ("ZeFirstUser", "ZePassWord", "  Snatch  ", "Thriller", "Guy Ritchie", "unScenariste", 365);
			System.out.println("Erreur 8.7 :  l'ajout d'un film déja existant avec des leadings ou trailing blanks est permise");
			echec++;
		}
		catch (ItemFilmAlreadyExists e) {
			if (sn.nbFilms() != nbFilms){
				System.out.println("Erreur 8.7 : Le nombre de films a changé alors que l'ajout n'est pas permis");
				echec ++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 8.7, Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
		/// Retour à TestSocialNetwork le nombre d'échecs et de réussites
		int[] tab = {echec, test - echec};
        return tab;

	}

}

