package cabrera.lab02jsp.mesmodels;

import jakarta.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EvaluationViewModel {
    //Propietes
    private int numero;
    private String nom;
    private String prenom;
    private String courriel;
    private String telephone;
    private char sexe;
    private String note;
    private String dateEvaluation;
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

    public String getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(String dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    //Construteurs
    public EvaluationViewModel() {
    }

    public EvaluationViewModel(int numero, String nom, String prenom, String courriel, String telephone, char sexe, String note, String dateEvaluation, String commentaires) {
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
    public Evaluation mapper(){
        int numero = getNumero();
        String nom = getNom();
        String prenom = getPrenom();
        String courriel = getCourriel();
        String telephone = getTelephone();
        char sexe = getSexe();
        String note = getNote();
        Calendar dateEvaluation = converDate(getDateEvaluation());
        String commentaire = getCommentaires();

        return new Evaluation(numero, nom, prenom, courriel, telephone, sexe, note, dateEvaluation, commentaire);
    }
}
