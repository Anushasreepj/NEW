package gso;

public class Grille {

    private int LARGEUR;
    private int HAUTEUR;

    public Grille(int largeur, int hauteur) {
        this.LARGEUR = largeur;
        this.HAUTEUR = hauteur;
    }

    public boolean[][] grilleSuivante(boolean[][] tab) {
        // 1. Any live cell with fewer than two live neighbours dies, as if caused by
        // underpopulation.
        // 2. Any live cell with more than three live neighbours dies, as if by
        // overcrowding.
        // 3. Any live cell with two or three live neighbours lives on to the next
        // generation.
        // 4. Any dead cell with exactly three live neighbours becomes a live cell.
        boolean[][] grille = new boolean[LARGEUR][HAUTEUR];

        for (int i = 0; i < LARGEUR; i++) {
            for (int j = 0; j < HAUTEUR; j++) {
                int nbVivantes = getNbCellulesVivantes(tab, i, j);
                if (nbVivantes < 2) {
                    // underpopulation
                    grille[i][j] = false;
                    continue;
                }
                if (nbVivantes > 3) {
                    // overcrowding
                    grille[i][j] = false;
                    continue;
                }
                // stay alive
                if (tab[i][j] && (nbVivantes == 2 || nbVivantes == 3)) {
                    grille[i][j] = true;
                    continue;
                }

                // become alive
                if (!tab[i][j] && nbVivantes == 3) {
                    grille[i][j] = true;
                    continue;
                }
            }
        }
        return grille;
    }

    public int getNbCellulesVivantes(boolean[][] tab, int x, int y) {

        int result = 0;
        // Verification nord
        if (y > 0) {
            // nord
            if (tab[x][y - 1]) {
                result++;
            }
            // nord ouest
            if (x - 1 >= 0 && tab[x - 1][y - 1]) {
                result++;
            }
            // nord est
            if (x + 1 < LARGEUR && tab[x + 1][y - 1]) {
                result++;
            }

        }

        // Verification sud
        if (y + 1 < HAUTEUR) {
            // Sud
            if (tab[x][y + 1]) {
                result++;
            }
            // sud ouest
            if (x - 1 >= 0 && tab[x - 1][y + 1]) {
                result++;
            }
            // sud est
            if (x + 1 < LARGEUR && tab[x + 1][y + 1]) {
                result++;
            }
        }

        // Vérification ouest
        if (x - 1 >= 0 && tab[x - 1][y]) {
            result++;
        }
        // Verification est
        if (x + 1 < LARGEUR && tab[x + 1][y]) {
            result++;
        }

        return result;
    }
}