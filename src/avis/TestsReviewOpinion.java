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
			sn.addMember("bob3", "bob3", "bob");
			sn.addMember("bob4", "bob4", "bob");
			sn.addItemBook("bob1", "bob1", "L'art de la guerre", "Receuil", "Sun Tzu", 42);
			sn.reviewItemBook("bob1", "bob1", "l'art de la guerre", 4.0f, "Cool !");
			
		} catch (Exception e) {
			System.out.println("Exception non prévue : " + e);
			e.printStackTrace();
		}

		// Tentative d'ajout de review avec un membre non instancié
		test++;
		try {
			moyenne = sn.reviewOpinion(null, "bob3", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.1.1 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.1.1 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.1.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("            ", "bob3", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.1.2 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.1.2 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.1.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob36", "bob3", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.1.3 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (NotMember e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.1.3 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.1.3, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", null, "L'art de la guerre", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.2.1 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.2.1 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.2.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "       ", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.2.2 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.2.2 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.2.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob4", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.2.3 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (NotMember e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.2.3 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.2.3, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", null, "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.3.1 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.3.1 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.3.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.3.2 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.3.2 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.3.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "QGBFDHDF", "bob1", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.3.3 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (NotItem e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.3.3 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.3.3, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", null, 5f, "Cool story bro");
			System.out
			.println("Erreur 5.4.1 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.4.1 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.4.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", "", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.4.2 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.4.2 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.4.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", "zsegHG", 5f, "Cool story bro");
			System.out
			.println("Erreur 5.4.3 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (NotMember e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.4.3 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.4.3, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", "bob1", -0.2f, "Cool story bro");
			System.out
			.println("Erreur 5.5.1 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.5.1 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.5.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", "bob1", 6f, "Cool story bro");
			System.out
			.println("Erreur 5.5.2 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.5.2 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.5.2, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try {
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", "bob1", 5f, null);
			System.out
			.println("Erreur 5.6.1 : Le nombre de reviewOpinion a été modifié (NoCatch)");
			echec++;
		
		} 
		catch (BadEntry e){
			if(moyenne != 0.0f)
			{
				System.out
						.println("Erreur 5.6.1 : Le nombre de reviewOpinion a été modifié");
				echec++;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur 5.6.1, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		test++;
		try{
			moyenne = sn.reviewOpinion("bob3", "bob3", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			if(moyenne != 3.75){
				echec++;
				System.out.println("Erreur 5.7, La moyenne est éronnée");
			}
			moyenne = sn.reviewOpinion("bob4", "bob4", "L'art de la guerre", "bob1", 5f, "Cool story bro");
			if(moyenne != 4.1666665f){
				echec++;
				System.out.println("Erreur 5.7, La moyenne est éronnée");
			}
		}
		catch (Exception e){
			System.out.println("Erreur 5.7, Exception non prévue : " + e);
			echec++;
			e.printStackTrace();
		}
		int[] tab = { echec, test - echec };
		return tab;
	}
}
