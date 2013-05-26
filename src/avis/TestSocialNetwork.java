/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avis;

/**
 * 
 * @author HvP
 */
public class TestSocialNetwork {

	static public void main(String[] ars) {
		int[] result = { 0, 0 };
		int[] total = { 0, 0 };
		String[] test = { "test", "test" };
		result = TestsInitialisation.main(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("TestsInitialisation : " + result[0] + "echec et "
				+ result[1] + "succes");
		result = TestsAddMember.main(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("TestsAddMember : " + result[0] + "echec et "
				+ result[1] + "succes");
		result = TestsAddItemBook.main(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("TestsAddItemBook : " + result[0] + "echec et "
				+ result[1] + "succes");
		result = TestsReviewItemBook.maina(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("TestsReviewItemBook : " + result[0] + "echec et "
				+ result[1] + "succes");
		result = TestAddItemFilm.main(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("TestsAddItemFilm : " + result[0] + "echec et "
				+ result[1] + "succes");
		result = TestReviewItemFilm.main(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("TestsReviewItemFilm : " + result[0] + "echec et "
				+ result[1] + "succes");
		result = TestConsultItems.main(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("ConsultItem : " + result[0] + "echec et "
				+ result[1] + "succes");
		result = TestsReviewOpinion.maina(test);
		total[0] += result[0];
		total[1] += result[1];
		System.out.println("ReviewOpinion : " + result[0] + "echec et "
				+ result[1] + "succes");
		System.out.println("Total des tests : " + total[0] + "echec et "
				+ total[1] + "succes");
	}
}
