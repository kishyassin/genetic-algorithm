import java.util.List;

public class Individue {
    int x1,x2,x3,x4,x5,x6;

    public Individue(int x1, int x2, int x3, int x4, int x5, int x6) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.x6 = x6;
    }
    public int produit_x_w(Individue X){
        int somme = this.x1 * X.x1 + this.x2 * X.x2 + this.x3 * X.x3 + this.x4 * X.x4 + this.x5 * X.x5 + this.x6 * X.x6;
        return somme;
    }

    public double calcule_fitness(List<Couple> database , Individue ind) {
        double somme_wx_moins_y = 0;
        for (Couple couple : database) {
            Individue X = couple.X;
            somme_wx_moins_y += ind.produit_x_w(X) - couple.y;
        }
        return Math.abs(somme_wx_moins_y/database.size());
    }

    public Couple associer_Poids_a_Individue(Individue ind, int ordre_individu) {
        double poids = Math.pow((ordre_individu) , Const.ALPHA);
        return new Couple(ind, poids);
    }
}
