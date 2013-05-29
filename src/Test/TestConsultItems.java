package Test;

import java.util.LinkedList;

import avis.SocialNetwork;

import exception.BadEntry;

public class TestConsultItems {

	public static int[] main(String[] args) {
		
		int test = 0 ;
		int echec = 0 ;
		
	
		System.out.println("Tests : Consulter les items référencés dans ToutAvis");
		SocialNetwork sn = new SocialNetwork();

		
		// Ajouts des Utilisateurs  et des items nécessaires aux tests
		try {
			sn.addMember("ZeUser", "ZePassWord", "aBeautifulProfile");
			sn.addMember("ZeFirstUser", "pass1", "aNomalProfile");
			sn.addMember("ZeSecondUser", "pass2", "aSimpleProfile");
			sn.addMember("ZeThirdUser", "pass3", "aProfile");
			sn.addItemBook ("ZeUser", "ZePassWord", "jPod", "Roman", "Douglas Coupland", 543);
			sn.addItemFilm ("ZeUser", "ZePassWord", "Snatch", "Action", "Guy Ritchie", "unScenariste", 543);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if ((sn.nbMembers() != 4) || (sn.nbBooks() != 1) || (sn.nbFilms()!=1)) {
			System.out.println("Erreur Lors de la création des Objets du test\n Echec des Tests sur ConsultItems");
		}
		
		
		/// GESTION DES CAS D'ANOMALIE SUR consultItems
		//  Titre null
		LinkedList<String> consult = new LinkedList<String>() ;
		test++;
		try {
			consult = sn.consultItems(null);	
			System.out.println("Erreur 11.1 :  la consultation d'un item dont le nom n'est pas instancié est acceptée ");
			echec++;
		}
		catch (BadEntry e) {
			if (consult.size() != 0) {
				System.out.println("Erreur 11.1 :  La LinkedList n'a pas une taille égale à 0");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 11.1, Exception non prévue : " + e);
			e.printStackTrace();
		}
		
		//  Titre avec 2 espaces consécutifs
		test++;
		try {
			consult = sn.consultItems("    ");	
			System.out.println("Erreur 11.2 :  la consultation d'un item dont le nom n'est composé que d'espaces est acceptée");
			echec++;
		}
		catch (BadEntry e) {
			if (consult.size() != 0) {
				System.out.println("Erreur 11.2 :  La LinkedList n'a pas une taille égale à 0");
				echec++;
			}
		} catch (Exception e) {
			System.out.println("Erreur 11.2 : Exception non prévue : " + e);
			e.printStackTrace();
			echec++;
		}
		
	
	/// Retourne à TestSocialNetwork le nombre d'échecs et de réussites
	int[] tab = {echec, test - echec};
    return tab;
}


}
