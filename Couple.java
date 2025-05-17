import java.util.ArrayList;

public class Couple {
    Individue X;
    double y;

    public Couple(Individue X, double y) {
        this.X = X;
        this.y = y;
    }

    public static void probabilite_selection(Couple individue_associer_a_poids, double somme) {
        individue_associer_a_poids.y = (individue_associer_a_poids.y / (somme /Const.N)) ;
    }
}
