package avis;

import java.util.LinkedList;

import exception.BadEntry;
import exception.ItemFilmAlreadyExists;
import exception.ItemBookAlreadyExists;
import exception.MemberAlreadyExists;
import exception.NotItem;
import exception.NotMember;

/**
 * @author A. Beugnard,
 * @author G. Ouvradou
 * @author B. Prou
 * @date février - mars 2011
 * @version V0.6
 */

public class SocialNetwork {

	/**
	 * @uml.property name="lesMembres"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     inverse="socialNetwork:avis.Member"
	 */
	private LinkedList<Member> lesMembres;

	/**
	 * @uml.property name="lesItems"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true"
	 *                     inverse="socialNetwork:avis.Item"
	 */
	private LinkedList<Item> lesItems;

	/**
	 * constructeur de <i>SocialNetwok</i>
	 * 
	 */
	public SocialNetwork() {
		lesMembres = new LinkedList<Member>();
		lesItems = new LinkedList<Item>();
	}

	/**
	 * Obtenir le nombre de membres du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de membres
	 */
	public int nbMembers() {
		return lesMembres.size();
	}

	/**
	 * Obtenir le nombre de films du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de films
	 */
	public int nbFilms() {
		int compteurFilms = 0;
		for (Item i : lesItems) {
			if (i instanceof Film) {
				compteurFilms++;
			}
		}
		return compteurFilms;
	}

	/**
	 * Obtenir le nombre de livres du <i>SocialNetwork</i>
	 * 
	 * @return le nombre de livres
	 */
	public int nbBooks() {
		int compteurLivres = 0;
		for (Item i : lesItems) {
			if (i instanceof Book) {
				compteurLivres++;
			}
		}
		return compteurLivres;
	}

	/**
	 * Ajouter un nouveau membre au <i>SocialNetwork</i>
	 * 
	 * @param pseudo
	 *            son pseudo
	 * @param password
	 *            son mot de passe
	 * @param profil
	 *            son profil
	 * @throws BadEntry
	 *             :
	 *             <ul>
	 *             <li>si le pseudo n'est pas instancié ou a moins de 1
	 *             caractère autre que des espaces .</li>
	 *             <li>si le password n'est pas instancié ou a moins de 4
	 *             caractères autres que des leadings or trailing blanks.</li>
	 *             <li>si le profil n'est pas instancié.</li>
	 *             </ul>
	 * <br>
	 * @throws MemberAlreadyExists
	 *             membre de même pseudo déjà présent dans le
	 *             <i>SocialNetwork</i> (même pseudo : indifférent à la casse et
	 *             aux leadings et trailings blanks)
	 */
	public void addMember(String pseudo, String password, String profil)
			throws BadEntry, MemberAlreadyExists {
		// T E S T S D E L E V E E D ' E X C E P T I O N S
		// BADENTRY()
		// Pseudo instancié - plus de 0 caractère autre que des espaces
		// Password bien instancié - plus de 4 caractères autres que des espaces
		// Profil bien instancié
		if ((pseudo == null) || (pseudo.trim().equals(""))
				|| (pseudo.trim().length() < 1)) {
			throw new BadEntry("Saisie du pseudo incorrecte.");
		}
		if ((password == null) || (password.trim().equals(""))
				|| (password.trim().length() < 4)) {
			throw new BadEntry("Saisie du mot de passe incorrecte.");
		}
		if (profil == null) {
			throw new BadEntry("Saisie du profil incorrecte.");
		}
		// MEMBERALREADYEXISTS()
		// Pseudo déjà utilisé
		if (exists(pseudo.trim())) {
			throw new MemberAlreadyExists();
		}

		// A J O U T D U M E M B R E

		lesMembres.add(new Member(pseudo, password, profil));
	}

	/**
	 * Ajouter un nouvel item de film au <i>SocialNetwork</i>
	 * 
	 * @param pseudo
	 *            le pseudo du membre
	 * @param password
	 *            le password du membre
	 * @param titre
	 *            le titre du film
	 * @param genre
	 *            son genre (aventure, policier, etc.)
	 * @param realisateur
	 *            le réalisateur
	 * @param scenariste
	 *            le scénariste
	 * @param duree
	 *            sa durée en minutes
	 * 
	 * @throws BadEntry
	 *             :
	 *             <ul>
	 *             <li>si le pseudo n'est pas instancié ou a moins de 1
	 *             caractère autre que des espaces .</li>
	 *             <li>si le password n'est pas instancié ou a moins de 4
	 *             caractères autres que des leadings or trailing blanks.</li>
	 *             <li>si le titre n'est pas instancié ou a moins de 1 caractère
	 *             autre que des espaces.</li>
	 *             <li>si le genre n'est pas instancié.</li>
	 *             <li>si le réalisateur n'est pas instancié.</li>
	 *             <li>si le scénariste n'est pas instancié.</li>
	 *             <li>si la durée n'est pas positive.</li>
	 *             </ul>
	 * <br>
	 * @throws NotMember
	 *             : si le pseudo n'est pas celui d'un membre ou si le pseudo et
	 *             le password ne correspondent pas.
	 * @throws ItemFilmAlreadyExists
	 *             : item film de même titre déjà présent (même titre :
	 *             indifférent à la casse et aux leadings et trailings blanks)
	 * 
	 */
	public void addItemFilm(String pseudo, String password, String titre,
			String genre, String realisateur, String scenariste, int duree)
			throws BadEntry, NotMember, ItemFilmAlreadyExists {
		// T E S T S D E L E V E E D ' E X C E P T I O N S
		// BADENTRY()
		// Pseudo bien instancié et plus de 0 caractère autre que des espaces
		// Password bien instancié et plus de 4 caractères autre que des espaces
		// Titre bien instancié et plus de 0 caractère autre que des espaces
		// Genre, scenariste et realisateur non instancié
		// Durée nulle ou inférieure
		if ((pseudo == null) || (pseudo.trim().equals(""))
				|| (pseudo.trim().length() < 1)) {
			throw new BadEntry("Saisie du pseudo incorrecte.");
		}
		if ((password == null) || (password.trim().equals(""))
				|| (password.trim().length() < 4)) {
			throw new BadEntry("Saisie du mot de passe incorrecte.");
		}
		if ((titre == null) || (titre.trim().equals(""))
				|| (titre.trim().length() < 1)) {
			throw new BadEntry("Saisie du titre incorrecte.");
		}
		if (genre == null) {
			throw new BadEntry("Saisie du genre incorrecte.");
		}
		if (realisateur == null) {
			throw new BadEntry("Saisie du realisateur incorrecte.");
		}
		if (scenariste == null) {
			throw new BadEntry("Saisie du scenariste incorrecte.");
		}
		if (duree <= 0) {
			throw new BadEntry("Saisie de la durée incorrecte.");
		}

		// NOTMEMEBER()
		// Le membre n'existe pas en base
		Member user = isMember(pseudo, password);
		if (user == null) {
			throw new NotMember(
					"Pas de correspondances trouvées entre utilisateurs et mots de passe.");
		}
		// ITEMALREADYEXISTS()
		// Le film existe déja en base (ignore la casse)
		if (isFilm(titre) != null) {
			throw new ItemFilmAlreadyExists();
		}

		// A J O U T D U F I L M
		Film nouveau = new Film(titre, duree, genre, realisateur, scenariste);
		lesItems.add(nouveau);
	}

	/**
	 * Ajouter un nouvel item de livre au <i>SocialNetwork</i>
	 * 
	 * @param pseudo
	 *            le pseudo du membre
	 * @param password
	 *            le password du membre
	 * @param titre
	 *            le titre du livre
	 * @param genre
	 *            son genre (roman, essai, etc.)
	 * @param auteur
	 *            l'auteur
	 * @param nbPages
	 *            le nombre de pages
	 * 
	 * @throws BadEntry
	 *             :
	 *             <ul>
	 *             <li>si le pseudo n'est pas instancié ou a moins de 1
	 *             caractère autre que des espaces .</li>
	 *             <li>si le password n'est pas instancié ou a moins de 4
	 *             caractères autres que des leadings or trailing blanks.</li>
	 *             <li>si le titre n'est pas instancié ou a moins de 1 caractère
	 *             autre que des espaces.</li>
	 *             <li>si le genre n'est pas instancié.</li>
	 *             <li>si l'auteur n'est pas instancié.</li>
	 *             <li>si le nombre de pages n'est pas positif.</li>
	 *             </ul>
	 * <br>
	 * @throws NotMember
	 *             : si le pseudo n'est pas celui d'un membre ou si le pseudo et
	 *             le password ne correspondent pas.
	 * @throws ItemBookAlreadyExists
	 *             item livre de même titre déjà présent (même titre :
	 *             indifférent à la casse et aux leadings et trailings blanks)
	 * 
	 * 
	 */
	public void addItemBook(String pseudo, String password, String titre,
			String genre, String auteur, int nbPages) throws BadEntry,
			NotMember, ItemBookAlreadyExists {
		// T E S T S D E L E V E E D ' E X C E P T I O N S
		// BADENTRY()
		// Pseudo bien instancié et plus de 0 caractère autre que des espaces
		// Password bien instancié et plus de 4 caractères autre que des espaces
		// Titre bien instancié et plus de 0 caractère autre que des espaces
		// Genre et auteur non instancié
		// Nombre de pages nul ou inférieur
		if ((pseudo == null) || (pseudo.trim().equals(""))
				|| (pseudo.trim().length() < 1)) {
			throw new BadEntry("Saisie du pseudo incorrecte.");
		}
		if ((password == null) || (password.trim().equals(""))
				|| (password.trim().length() < 4)) {
			throw new BadEntry("Saisie du mot de passe incorrecte.");
		}
		if ((titre == null) || (titre.trim().equals(""))
				|| (titre.trim().length() < 1)) {
			throw new BadEntry("Saisie du titre incorrecte.");
		}
		if (genre == null) {
			throw new BadEntry("Saisie du genre incorrecte.");
		}
		if (auteur == null) {
			throw new BadEntry("Saisie de l'auteur incorrecte.");
		}
		if (nbPages <= 0) {
			throw new BadEntry("Saisie du nombre de pages incorrecte.");
		}

		// NOTMEMEBER()
		// Le membre n'existe pas en base
		Member user = null;
		user = isMember(pseudo, password);
		if (user == null) {
			throw new NotMember(
					"Pas de correspondances trouvées entre utilisateurs et mots de passe.");
		}

		// ITEMALREADYEXISTS()
		// Le Livre existe déja en base, ignore la casse et les leading et
		// trailing spaces
		if (isBook(titre) != null)
			throw new ItemBookAlreadyExists();

		// A J O U T D U L I V R E
		Book nouveau = new Book(titre, genre, auteur, nbPages);
		lesItems.add(nouveau);
	}

	/**
	 * Consulter les items du <i>SocialNetwork</i> par nom
	 * 
	 * @param nom
	 *            son nom (eg. titre d'un film, d'un livre, etc.)
	 * @throws BadEntry
	 *             : si le nom n'est pas instancié ou a moins de 1 caractère
	 *             autre que des espaces. </li>
	 * @return LinkedList <String> : la liste des représentations de tous les
	 *         items ayant ce nom Cette représentation contiendra la note de
	 *         l'item s'il a été noté. (une liste vide si aucun item ne
	 *         correspond)
	 */
	public LinkedList<String> consultItems(String nom) throws BadEntry {
		// T E S T S D E L E V E E D ' E X C E P T I O N S
		// BADENTRY()
		// Nom bien instancié et plus de 0 caractère autre que des espaces
		if ((nom == null) || (nom.trim().equals(""))
				|| (nom.trim().length() < 1)) {
			throw new BadEntry("Saisie du critère de recherche incorrecte.");
		}

		// C R E A T I O N D E L A L I S T E

		return recupString(nom);
	}

	/**
	 * Donner son opinion sur un item film. Ajoute l'opinion de ce membre sur ce
	 * film au <i>SocialNetwork</i> Si une opinion de ce membre sur ce film
	 * préexiste, elle est mise à jour avec ces nouvelles valeurs.
	 * 
	 * @param pseudo
	 *            pseudo du membre émettant l'opinion
	 * @param password
	 *            son mot de passe
	 * @param titre
	 *            titre du film concerné
	 * @param note
	 *            la note qu'il donne au film
	 * @param commentaire
	 *            ses commentaires
	 * 
	 * @throws BadEntry
	 *             :
	 *             <ul>
	 *             <li>si le pseudo n'est pas instancié ou a moins de 1
	 *             caractère autre que des espaces .</li>
	 *             <li>si le password n'est pas instancié ou a moins de 4
	 *             caractères autres que des leadings or trailing blanks.</li>
	 *             <li>si le titre n'est pas instancié ou a moins de 1 caractère
	 *             autre que des espaces.</li>
	 *             <li>si la note n'est pas comprise entre 0.0 et 5.0.</li>
	 *             <li>si le commentaire n'est pas instancié.</li>
	 *             </ul>
	 * <br>
	 * @throws NotMember
	 *             : si le pseudo n'est pas celui d'un membre ou si le pseudo et
	 *             le password ne correspondent pas.
	 * @throws NotItem
	 *             : si le titre n'est pas le titre d'un film.
	 * 
	 * @return la note moyenne des notes sur ce film
	 */
	public float reviewItemFilm(String pseudo, String password, String titre,
			float note, String commentaire) throws BadEntry, NotMember, NotItem {
		// T E S T S D E L E V E E D ' E X C E P T I O N S
		// BADENTRY()
		// Pseudo bien instancié et plus de 0 caractère autre que des espaces
		// Password bien instancié et plus de 4 caractères autre que des espaces
		// Titre bien instancié et plus de 0 caractère autre que des espaces
		// Commentaire non instancié
		// Note non comprise entre 0 et 5
		if (pseudo == null || pseudo.trim().equals("")
				|| pseudo.trim().length() < 1) {
			throw new BadEntry("Saisie du pseudo incorrecte.");
		}
		if (password == null || password.trim().equals("")
				|| password.trim().length() < 4) {
			throw new BadEntry("Saisie du mot de passe incorrecte.");
		}
		if (titre == null || titre.trim().equals("")
				|| titre.trim().length() < 1) {
			throw new BadEntry("Saisie du titre incorrecte.");
		}
		if (commentaire == null) {
			throw new BadEntry("Saisie du commentaire incorrecte.");
		}
		if (note < 0.0f || note > 5.0f) {
			throw new BadEntry("Saisie de la note incorrecte.");
		}

		// NOTMEMEBER()
		// Le membre n'existe sur le Social Network
		Member userAuth = isMember(pseudo, password);
		if (userAuth == null) {
			throw new NotMember(
					"Pas de correspondances trouvées entre utilisateurs et mots de passe.");
		}
		// NOTITEM()
		Film filmRev = isFilm(titre);
		if (filmRev == null) {
			throw new NotItem(
					"Pas de correspondances trouvées trouvée avec le titre fournit.");
		}
		// A J O U T D E L A R E V I E W
		// Mise à jour de la review si le membre a déja donné un opinion sur ce
		// livre
		// Propagation des changements effectués
		Review existingReview = isReview(filmRev, userAuth);
		// CALCUL DE LA MOYENNE RETOURNEE
		float nvMoyenne = 0;
		// dans le cadre d'une réécriture d'une review ==>
		if (existingReview != null) {
			existingReview.updateFields(note, commentaire);
			nvMoyenne = filmRev.moyenneCalculation();

		}
		// MISE A JOUR DES LINKEDLIST DE REVIEWS
		else {
			filmRev.ajoutAvis(new Review(filmRev, userAuth, note, commentaire));
			nvMoyenne = filmRev.moyenneCalculation();
		}
		filmRev.setMoyenne(nvMoyenne);
		return nvMoyenne;
	}

	/**
	 * Donner son opinion sur un item livre. Ajoute l'opinion de ce membre sur
	 * ce livre au <i>SocialNetwork</i> Si une opinion de ce membre sur ce livre
	 * préexiste, elle est mise à jour avec ces nouvelles valeurs.
	 * 
	 * @param pseudo
	 *            pseudo du membre émettant l'opinion
	 * @param password
	 *            son mot de passe
	 * @param titre
	 *            titre du livre concerné
	 * @param note
	 *            la note qu'il donne au livre
	 * @param commentaire
	 *            ses commentaires
	 * 
	 * @throws BadEntry
	 *             :
	 *             <ul>
	 *             <li>si le pseudo n'est pas instancié ou a moins de 1
	 *             caractère autre que des espaces .</li>
	 *             <li>si le password n'est pas instancié ou a moins de 4
	 *             caractères autres que des leadings or trailing blanks.</li>
	 *             <li>si le titre n'est pas instancié ou a moins de 1 caractère
	 *             autre que des espaces.</li>
	 *             <li>si la note n'est pas comprise entre 0.0 et 5.0.</li>
	 *             <li>si le commentaire n'est pas instancié.</li>
	 *             </ul>
	 * <br>
	 * @throws NotMember
	 *             : si le pseudo n'est pas celui d'un membre ou si le pseudo et
	 *             le password ne correspondent pas.
	 * @throws NotItem
	 *             : si le titre n'est pas le titre d'un livre.
	 * 
	 * @return la note moyenne des notes sur ce livre
	 */
	public float reviewItemBook(String pseudo, String password, String titre,
			float note, String commentaire) throws BadEntry, NotMember, NotItem {
		// T E S T S D E L E V E E D ' E X C E P T I O N S
		// BADENTRY()
		// Pseudo bien instancié et plus de 0 caractère autre que des espaces
		// Password bien instancié et plus de 4 caractères autre que des espaces
		// Titre bien instancié et plus de 0 caractère autre que des espaces
		// Commentaire non instancié
		// Note non comprise entre 0 et 5
		if (pseudo == null || pseudo.trim().equals("")
				|| pseudo.trim().length() < 1) {
			throw new BadEntry("Saisie du pseudo incorrecte.");
		}
		if (password == null || password.trim().equals("")
				|| password.trim().length() < 4) {
			throw new BadEntry("Saisie du mot de passe incorrecte.");
		}
		if (titre == null || titre.trim().equals("")
				|| titre.trim().length() < 1) {
			throw new BadEntry("Saisie du titre incorrecte.");
		}
		if (commentaire == null) {
			throw new BadEntry("Saisie du commentaire incorrecte.");
		}
		if (note < 0.0f || note > 5.0f) {
			throw new BadEntry("Saisie de la note incorrecte.");
		}

		// NOTMEMEBER()
		// Le membre n'existe sur le Social Network
		Member userAuth = isMember(pseudo, password);
		if (userAuth == null) {
			throw new NotMember(
					"Pas de correspondances trouvées entre utilisateurs et mots de passe.");
		}
		// NOTITEM()
		// le book n'est pas trouvé dans les items gérés par le SociaNetwork
		Book bookRev = isBook(titre);
		if (bookRev == null) {
			throw new NotItem(
					"Pas de correspondances trouvées trouvée avec le titre fournit.");
		}
		// A J O U T D E L A R E V I E W
		// Mise à jour de la review si le membre a déja donné un opinion sur ce
		// livre
		// Propagation des changements effectués
		Review existingReview = isReview(bookRev, userAuth);
		// CALCUL DE LA MOYENNE RETOURNEE
		float nvMoyenne = 0;
		// dans le cadre d'une réécriture d'une review ==>
		if (existingReview != null) {
			nvMoyenne = bookRev.moyenneCalculation();

		}

		// MISE A JOUR DES LINKEDLIST DE REVIEWS
		else {
			bookRev.ajoutAvis(new Review(bookRev, userAuth, note, commentaire));
			nvMoyenne = bookRev.moyenneCalculation();
		}
		bookRev.setMoyenne(nvMoyenne);
		return nvMoyenne;

		// //////////////////////////////

	}

	public float reviewOpinion(String pseudo, String password, String titre,
			String pseudonote, float note, String commentaire, String type)
			throws BadEntry, NotMember, NotItem {

		if (pseudo == null || pseudo.trim().equals("")
				|| pseudo.trim().length() < 1) {
			throw new BadEntry("Saisie du pseudo incorrecte.");
		}
		if (password == null || password.trim().equals("")
				|| password.trim().length() < 4) {
			throw new BadEntry("Saisie du mot de passe incorrecte.");
		}
		if (commentaire == null) {
			throw new BadEntry("Saisie du commentaire incorrecte.");
		}
		if (titre == null || titre.trim().equals("")
				|| titre.trim().length() < 1) {
			throw new BadEntry("Saisie du titre incorrecte.");
		}
		if (note < 0.0f || note > 5.0f) {
			throw new BadEntry("Saisie de la note incorrecte.");
		}
		// NOTMEMEBER()
		// Le membre n'existe sur le Social Network
		Member userAuth = isMember(pseudo, password);
		if (userAuth == null) {
			throw new NotMember(
					"Pas de correspondances trouvées entre utilisateurs et mots de passe.");
		}
		if ((pseudonote == null) || (pseudonote.trim().equals(""))
				|| (pseudonote.trim().length() < 1)) {
			throw new BadEntry("Saisie du pseudo incorrecte.");
		}
		if (type.trim().equalsIgnoreCase("book")
				|| type.trim().equalsIgnoreCase("livre"))
			return reviewOpinionBook(userAuth, titre, pseudonote, note,
					commentaire);
		if (type.trim().equalsIgnoreCase("film"))
			return reviewOpinionFilm(userAuth, titre, pseudonote, note,
					commentaire);
		else
			throw new BadEntry("Saisie du type incorrecte.");
	}

	private boolean exists(String m) {
		for (Member i : lesMembres) {
			if (i.getPseudo().equalsIgnoreCase(m.trim())) {
				return true;
			}
		}
		return false;
	}

	private Member isMember(String pseudo, String password) {
		for (Member i : lesMembres) {
			if (i.getPseudo().equals(pseudo)
					&& i.getPassword().equals(password)) {
				return i;
			}
		}
		return null;
	}

	private LinkedList<String> recupString(String nom) {
		LinkedList<String> listeRetournee = new LinkedList<String>();
		for (Item i : lesItems) {
			if (i.getTitre().equalsIgnoreCase(nom.trim())) {
				if (i instanceof Book) {
					Book j = (Book) i;
					listeRetournee.add(j.toString());
				} else {
					Film j = (Film) i;
					listeRetournee.add(j.toString());
				}
			}
		}
		return listeRetournee;
	}

	private Film isFilm(String titre) {
		for (Item i : lesItems) {
			if ((i instanceof Film)
					&& (i.getTitre().equalsIgnoreCase(titre.trim()))) {
				return (Film) i;
			}

		}
		return null;
	}

	private Book isBook(String titre) {
		for (Item i : lesItems) {
			if ((i instanceof Book)
					&& (i.getTitre().equalsIgnoreCase(titre.trim()))) {
				return (Book) i;
			}

		}
		return null;
	}

	private Review isReview(Item item, Member userAuth) {
		LinkedList<Review> lkrev = new LinkedList<Review>(item.getAvis());
		for (Review i : lkrev) {
			if (i.getMembre().getPseudo().equals(userAuth.getPseudo())) {
				return i;
			}
		}
		return null;
	}

	private float reviewOpinionBook(Member userAuth, String titre,
			String pseudonote, float note, String commentaire) throws NotItem,
			NotMember {
		Item itemRev = null;
		// NOTITEM()
		// le film n'est pas trouvé dans les items gérés par le SociaNetwork
		for (Item i : lesItems) {
			if (i.getTitre().equals(titre)) {
				itemRev = i;
			}
		}
		if (itemRev == null) {
			throw new NotItem(
					"Pas de correspondances trouvées trouvée avec le titre fourni.");
		}
		Member memberRev = null;
		Review temp = null;
		LinkedList<Review> lkrev = new LinkedList<Review>(itemRev.getAvis());
		/* On cherche le membre noté */
		for (Review rev : lkrev) {
			if (rev.getMembre().getPseudo().equalsIgnoreCase(pseudonote.trim())) {
				memberRev = rev.getMembre();
				temp = rev;
				break;
			}
		}
		// si il n'existe pas on throw notmember
		if (memberRev == null) {
			throw new NotMember(
					"Pas de correspondances trouvées trouvée avec le membre 'noté' fourni .");
		}
		// appel de la méthode updatereview
		memberRev.updateReviews(new Review(temp, userAuth, note, commentaire));
		// moyenne + mise à jour
		float moyenne = memberRev.moyenneCalculation();
		memberRev.setMoyenne(moyenne);
		itemRev.setMoyenne(itemRev.moyenneCalculation());
		return moyenne;
	}

	private float reviewOpinionFilm(Member userAuth, String titre,
			String pseudonote, float note, String commentaire) throws NotItem,
			NotMember {
		Item itemRev = null;
		// NOTITEM()
		// le film n'est pas trouvé dans les items gérés par le SociaNetwork
		for (Item i : lesItems) {
			if (i.getTitre().equals(titre)) {
				itemRev = i;
			}
		}
		if (itemRev == null) {
			throw new NotItem(
					"Pas de correspondances trouvées trouvée avec le titre fourni.");
		}
		Member memberRev = null;
		Review temp = null;
		LinkedList<Review> lkrev = new LinkedList<Review>(itemRev.getAvis());
		/* On cherche le membre noté */
		for (Review rev : lkrev) {
			if (rev.getMembre().getPseudo().equalsIgnoreCase(pseudonote.trim())) {
				memberRev = rev.getMembre();
				temp = rev;
				break;
			}
		}
		// si il n'existe pas on throw notmember
		if (memberRev == null) {
			throw new NotMember(
					"Pas de correspondances trouvées trouvée avec le membre 'noté' fourni .");
		}
		// appel de la méthode updatereview
		memberRev.updateReviews(new Review(temp, userAuth, note, commentaire));
		// moyenne + mise à jour
		float moyenne = memberRev.moyenneCalculation();
		memberRev.setMoyenne(moyenne);
		itemRev.setMoyenne(itemRev.moyenneCalculation());
		return moyenne;
	}

	/**
	 * Obtenir une repr�sent1ation textuelle du <i>SocialNetwork</i>.
	 * 
	 * @return la cha�ne de caract�res repr�sentation textuelle du
	 *         <i>SocialNetwork</i>
	 */

	@Override
	public String toString() {
		return "SocialNetwork [lesMembres=" + lesMembres + ", lesItems="
				+ lesItems + ", lesReviews=" + "]";
	}

}
