package cabrera.lab02jsp.mesmodels;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EvaluationDbContext implements IEvaluationContext {
    //liste
    private static List<Evaluation> listeEvalutions = new ArrayList<>()
    {
        {
            add(new Evaluation(1, "Nom1", "Prenom1", "example1@mail.com", "0123456781", 'M', "Note1", new GregorianCalendar(2023, Calendar.SEPTEMBER, 1), "Commentaire 1"));
            add(new Evaluation(2, "Nom2", "Prenom2", "example2@mail.com", "0123456782", 'F', "Note2", new GregorianCalendar(2023, Calendar.SEPTEMBER, 2), "Commentaire 2"));
            add(new Evaluation(3, "Nom3", "Prenom3", "example3@mail.com", "0123456783", 'M', "Note3", new GregorianCalendar(2023, Calendar.SEPTEMBER, 3), "Commentaire 3"));
            add(new Evaluation(4, "Nom4", "Prenom4", "example4@mail.com", "0123456784", 'F', "Note4", new GregorianCalendar(2023, Calendar.SEPTEMBER, 4), "Commentaire 4"));
            add(new Evaluation(5, "Nom5", "Prenom5", "example5@mail.com", "0123456785", 'M', "Note5", new GregorianCalendar(2023, Calendar.SEPTEMBER, 5), "Commentaire 5"));
            add(new Evaluation(6, "Nom6", "Prenom6", "example6@mail.com", "0123456786", 'F', "Note6", new GregorianCalendar(2023, Calendar.SEPTEMBER, 6), "Commentaire 6"));
            add(new Evaluation(7, "Nom7", "Prenom7", "example7@mail.com", "0123456787", 'M', "Note7", new GregorianCalendar(2023, Calendar.SEPTEMBER, 7), "Commentaire 7"));
            add(new Evaluation(8, "Nom8", "Prenom8", "example8@mail.com", "0123456788", 'F', "Note8", new GregorianCalendar(2023, Calendar.SEPTEMBER, 8), "Commentaire 8"));
            add(new Evaluation(9, "Nom9", "Prenom9", "example9@mail.com", "0123456789", 'M', "Note9", new GregorianCalendar(2023, Calendar.SEPTEMBER, 9), "Commentaire 9"));
            add(new Evaluation(10, "Nom10", "Prenom10", "example10@mail.com", "0123456790", 'F', "Note10", new GregorianCalendar(2023, Calendar.SEPTEMBER, 10), "Commentaire 10"));
        }
    };

    public static List<EvaluationViewModel> getListeEvalutions() {
        List<EvaluationViewModel> liste = new ArrayList<>();
        for (Evaluation evaluation : listeEvalutions) {
            liste.add(evaluation.mapper());
        }
        return liste;
    }

    @Override
    public void Ajouter(Evaluation evaluation) {
        listeEvalutions.add(evaluation);
    }

    @Override
    public void Supprimer(int numero) {
        listeEvalutions.removeIf((e)->e.getNumero()==numero);
    }

    @Override
    public void Modifier(Evaluation evaluation) {
        Evaluation e = this.rechercher(evaluation.getNumero());
        e.setNumero(evaluation.getNumero());
        e.setNom(evaluation.getNom());
        e.setPrenom(evaluation.getPrenom());
        e.setCourriel(evaluation.getCourriel());
        e.setTelephone(evaluation.getTelephone());
        e.setSexe(evaluation.getSexe());
        e.setDateEvaluation(evaluation.getDateEvaluation());
        e.setNote(evaluation.getNote());
        e.setCommentaires(evaluation.getCommentaires());
    }

    public Evaluation rechercher(int numero) {
        Evaluation evaluation;
        evaluation = EvaluationDbContext.listeEvalutions.stream().filter((a)->a.getNumero()==numero).findFirst().get();
        return evaluation;
    }
}
