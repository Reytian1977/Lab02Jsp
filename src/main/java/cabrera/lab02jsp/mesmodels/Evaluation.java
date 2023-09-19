package cabrera.lab02jsp.mesmodels;

import jakarta.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Evaluation {
    //Propietes
    private int numero;
    private String nom;
    private String prenom;
    private String courriel;
    private String telephone;
    private char sexe;
    private String note;
    private Calendar dateEvaluation;
    private String commentaires;

    //Methodes d'accès

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Calendar getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Calendar dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    //Construteurs
    public Evaluation(int numero, String nom, String prenom, String courriel, String telephone, char sexe, String note, Calendar dateEvaluation, String commentaires) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
        this.sexe = sexe;
        this.note = note;
        this.dateEvaluation = dateEvaluation;
        this.commentaires = commentaires;
    }

    public Evaluation() {
    }

    //Methodes
    private static Calendar converDate(String strDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try{
            Date parseDate = dateFormat.parse(strDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(parseDate);
            return cal;
        }catch (ParseException e){
            e.printStackTrace();;
        }
        return null;
    }

    //Methode Mapper
    public static Evaluation mapper(HttpServletRequest request){
        int numero = Integer.parseInt(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String courriel = request.getParameter("courriel");
        String telephone = request.getParameter("telephone");
        char sexe = request.getParameter("sexe").charAt(0);
        String note = request.getParameter("note");
        Calendar dateEvaluation = converDate(request.getParameter("dateEvaluation"));
        String commentaire = request.getParameter("comentaire");

        return new Evaluation(numero, nom, prenom, courriel, telephone, sexe, note, dateEvaluation, commentaire);
    }
}
