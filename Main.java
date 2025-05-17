import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
    // Generate Database
        ArrayList<Couple> database = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int x1 = (int) (Math.random() * 10);
            int x2 = (int) (Math.random() * 10);
            int x3 = (int) (Math.random() * 10);
            int x4 = (int) (Math.random() * 10);
            int x5 = (int) (Math.random() * 10);
            int x6 = (int) (Math.random() * 10);
            double y = Math.random() * 100;
            Individue ind = new Individue(x1, x2, x3, x4, x5, x6);
            Couple couple = new Couple(ind, y);
            database.add(couple);
        }

    // Generate Population
        ArrayList<Individue> population = new ArrayList<>();
        for (int i = 0; i < Const.N; i++) {
            int x1 = (int) (Math.random() * 10);
            int x2 = (int) (Math.random() * 10);
            int x3 = (int) (Math.random() * 10);
            int x4 = (int) (Math.random() * 10);
            int x5 = (int) (Math.random() * 10);
            int x6 = (int) (Math.random() * 10);
            Individue ind = new Individue(x1, x2, x3, x4, x5, x6);
            population.add(ind);
        }

        // print population with fitness
        System.out.println("*********** Population ***********");
        for (Individue ind : population) {
            double fitness = ind.calcule_fitness(database, ind);
            System.out.println("Individue: " + ind.x1 + " " + ind.x2 + " " + ind.x3 + " " + ind.x4 + " " + ind.x5 + " " + ind.x6 + ", Fitness: " + fitness);
        }


        ArrayList<Couple> individue_associer_a_poids = new ArrayList<>();
        for (int i = 0; i < Const.N; i++) {
            individue_associer_a_poids.add(population.get(i).associer_Poids_a_Individue(population.get(i), Const.N-i));
        }
        // print individue_associer_a_poids
        System.out.println("\n\n\n*********** Individues associes a poids ***********");
        for (Couple couple : individue_associer_a_poids) {
            System.out.println("Individue: " + couple.X.x1 + " " + couple.X.x2 + " " + couple.X.x3 + " " + couple.X.x4 + " " + couple.X.x5 + " " + couple.X.x6 + ", Poids: " + couple.y);
        }


        // Assoocier La probabilite de selection a chaque individu
        double somme = 0;
        for (Couple couple : individue_associer_a_poids){
            somme += couple.y;
        }
        for (Couple couple : individue_associer_a_poids){
            Couple.probabilite_selection(couple,somme);
        }

        // Print probabilite de selection
        System.out.println("\n\n\n*********** Probabilite de selection ***********");
        for (Couple couple : individue_associer_a_poids) {
            System.out.println("Individue: " + couple.X.x1 + " " + couple.X.x2 + " " + couple.X.x3 + " " + couple.X.x4 + " " + couple.X.x5 + " " + couple.X.x6 + ", Probabilite de selection: " + couple.y);
        }

        // Sélection de Davis
        ArrayList<Individue> individue_selectionnes = new ArrayList<>();
        for (Couple couple : individue_associer_a_poids) {
            int k = (int) couple.y;
            if (k == 0){
                individue_selectionnes.add(couple.X);
            }
            for (int i = 0 ; i < k ; i++){
                individue_selectionnes.add(couple.X);
            }

            if (individue_selectionnes.size()==Const.N)
                break;;
        }


        // Print individue_selectionnes
        System.out.println("\n\n\n*********** Individues selectionnes ***********");
        for (Individue ind : individue_selectionnes) {
            System.out.println("Individue: " + ind.x1 + " " + ind.x2 + " " + ind.x3 + " " + ind.x4 + " " + ind.x5 + " " + ind.x6);
        }
    }



}
