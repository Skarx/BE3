package Test;

import avis.SocialNetwork;
import exception.BadEntry;
import exception.NotItem;
import exception.NotMember;

public class TestReviewItemFilm {
	
	public static int[] main(String[] args) {
		
		int test = 0 ;
		int echec = 0 ;
		int indiceFilm = 0 ;
		float moyenne = 0.0f ;
		
		System.out.println("Tests : noter les Films référencés dans ToutAvis");
		SocialNetwork sn = new SocialNetwork();

		
		// Ajouts des Utilisateurs  et des Films nécessaires aux tests
		try {
			sn.addMember("ZeUser", "ZePassWord", "aBeautifulProfile");
			sn.addMember("ZeFirstUser", "pass1", "aNomalProfile");
			sn.addMember("ZeSecondUser", "pass2", "aSimpleProfile");
			sn.addMember("ZeThirdUser", "pass3", "aProfile");
			sn.addItemFilm ("ZeUser", "ZePassWord", "Snatch", "Action", "Guy Ritchie", "unScenariste", 543);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if ((sn.nbMembers() != 4) || (sn.nbFilms() != 1)) {
			System.out.println("Erreur Lors de la création des Objets du test\n Echec des Tests sur ReviewItemFilm");
		}
		
		
		
		/// GESTION DES CAS D'ANOMALIE SUR ReviewItemFilm
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		
		//  Pseudo null
		test ++;
		try {
			moyenne = sn.reviewItemFilm(null, "ZePassWord", "Film" + indiceFilm, (float)5.0 , "C'est beau on dirait du veau");
			System.out.println("Erreur 9.1 :  La notation d'un film par un utilisateur au pseudo non instancié est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.1 : La moyenne a changée alors que l'ajout de note n'est pas permis");
				echec++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.1, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++ ;
		}
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		//  Pseudo trop court
		test ++;
		try {
			moyenne = sn.reviewItemFilm("  ", "ZePassWord", "Film" + indiceFilm, (float)5.0 , "C'est beau on dirait du veau");
			System.out.println("Erreur 9.2 :  La notation d'un film par un utilisateur au pseudo trop court est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.2 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.2, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
			
		}
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		//  Password non instancié
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeUser", null, "Film" + indiceFilm, (float)5.0 , "C'est beau on dirait du veau");
			System.out.println("Erreur 9.3 :  La notation d'un film par un utilisateur au mot de passe null est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.3 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.3, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		//  Password trop court
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeUser", "  :(  ", "Film" + indiceFilm , (float)5.0 , "C'est beau on dirait du veau");
			System.out.println("Erreur 9.4 :  La notation d'un film par un utilisateur au mot de passe trop court est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.4 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.4, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		//  Mauvais film
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeUser", "ZePassWord", "   ", (float)5.0, "C'est beau on dirait du veau");
			System.out.println("Erreur 9.5 :  La notation d'un film au nom incorrect (blanc) est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.5 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.5, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		//  note < 0.0
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeUser", "ZePassWord", "Film" + indiceFilm , (float)-1.0 , "C'est beau on dirait du veau");
			System.out.println("Erreur 9.6 :  La notation d'un film avec une note de -1 est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.6 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.6, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		//  Note > 5.0 
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeUser", "ZePassWord", "Film" + indiceFilm , (float)5.1 , "C'est beau on dirait du veau");
			System.out.println("Erreur 9.7 :  La notation d'un film par un utilisateur a une note de 5,1 est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.7 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.7, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		//  Commentaire Null
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeUser", "ZePassWord", "Film" + indiceFilm , (float)5.0 , null);
			System.out.println("Erreur 9.8 :  La notation d'un film sans commentaire est possible");
			echec ++;
		} 
		catch (BadEntry e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 9.8 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 9.8, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		
		
		
		/// TEST DE FONCTIONNEMENT DE LA METHODE ReviewItemFilm.
		
		/// Utilisation des utilisateurs ZeFistUser, ZeSecondUser et ZeThirdUser et du film Snatch
		test ++;
		
		try {
			sn.reviewItemFilm("ZeFirstUser", "pass1", "Snatch", (float)5.0 , "c'est beau");
			sn.reviewItemFilm("ZeSecondUser", "pass2", "Snatch", (float)1.0 , "c'est pas beau");
			moyenne = sn.reviewItemFilm("ZeThirdUser", "pass3", "Snatch", (float)1.5 , "c'est très beau");
			if (moyenne != 2.5f){
				echec ++;
				System.out.println("Erreur 10.1 : La moyenne n'est pas correctement mise à jour après plusieurs avis");
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 10.1, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}

		/// Levée de NotMember à l'ajout de ZeWRONGUser
		// Ajout du film necessaire au prochain test
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		// Membre Incorrect
		test ++;
		try {
			moyenne = 0 ;
			moyenne = sn.reviewItemFilm("ZeWRONGUser", "ZePassWord", "Film" + indiceFilm, (float)5.0 , "C'est beau, on dirait du veau");
			System.out.println("Erreur 10.2 :  La notation d'un film par un utilisateur non référencé est possible");
			echec ++;
		} 
		catch (NotMember e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 10.2 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 10.2, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		/// Levée de NotMember avec ZeWRONGPassword
		try{
			sn.addItemFilm ("ZeUser", "ZePassWord", "Film" + (++indiceFilm), "Action", "Guy Ritchie", "unScenariste", 543);
		}catch(Exception e){
			System.out.println("Exception non prévue : " + e);
            e.printStackTrace();
		}
		// password Incorrect
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeUser", "ZeWRONGPassWord", "Film" + indiceFilm, (float)5.0 , "C'est beau, on dirait du veau");
			System.out.println("Erreur 10.3 :  La notation d'un film par un utilisateur non référencé est possible");
			echec ++;
		} 
		catch (NotMember e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 10.3 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 10.3, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		/// Test de la prise en compte d'un commentaire identique au Dernier
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeThirdUser", "pass3", "Snatch", (float)1.5 , "c'est très beau");
			if (moyenne != 2.5f){
				System.out.println("Erreur 10.4 : L'avis n'a pas été pris en compte alors que l'ajout était permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 10.4, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		/// Test de la prise en compte d'un commentaire identique au Premier
		/// Test de la prise en compte d'un commentaire identique au Dernier
		test ++;
		try {
			moyenne = sn.reviewItemFilm("ZeFirstUser", "pass1", "Snatch", (float)5.0 , "c'est beau");
			if (moyenne != 2.5f){
				System.out.println("Erreur 10.5 : L'avis n'a pas été pris en compte alors que l'ajout était permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 10.5, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}
		
		/// Levée de NotItem si mauvais Titre 
		//  Mauvais film
		test ++;
		try {
			moyenne = 0 ;
			moyenne = sn.reviewItemFilm("ZeUser", "ZePassWord", "WRONG_Film" , (float)5.0 , "C'est beau on dirait du veau");
			System.out.println("Erreur 10.6 :  La notation d'un film n'existant pas en base est possible");
			echec ++;
		} 
		catch (NotItem e) {
			if (moyenne != 0.0f){
				System.out.println("Erreur 10.6 : L'avis a été pris en compte alors que l'ajout n'est pas permis");
				echec ++;
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur 10.6, Exception non prévue : " + e);
			e.printStackTrace();
			echec ++;
		}

		
		
		/// Retour à TestSocialNetwork le nombre d'échecs et de réussites
		int[] tab = {echec, test - echec};
        return tab;
	}

}

	

