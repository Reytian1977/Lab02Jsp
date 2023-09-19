package cabrera.lab02jsp.mesmodels;

public interface IEvaluationContext {
    public void Ajouter(Evaluation evaluation);
    public void Supprimer(int numero);
    public void Modifier(Evaluation evaluation);
    public Evaluation rechercher(int numero);
}
