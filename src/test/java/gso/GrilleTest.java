package gso;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GrilleTest {

    @Test
    public void getNbCellulesVivantes_tableauVide() {
        Grille grille = new Grille(2, 2);
        boolean[][] tab = new boolean[2][2];
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 1));
    }

    @Test
    public void getNbCellulesVivantes_tableauNonVide() {
        Grille grille = new Grille(2, 2);
        boolean[][] tab = new boolean[2][2];
        tab[0][0] = true;
        tab[1][0] = true;
        assertEquals(1, grille.getNbCellulesVivantes(tab, 0, 0));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 1, 0));
        assertEquals(2, grille.getNbCellulesVivantes(tab, 0, 1));
        assertEquals(2, grille.getNbCellulesVivantes(tab, 1, 1));
        tab[0][1] = true;
        assertEquals(2, grille.getNbCellulesVivantes(tab, 0, 0));
        assertEquals(2, grille.getNbCellulesVivantes(tab, 1, 0));
        assertEquals(2, grille.getNbCellulesVivantes(tab, 0, 1));
        assertEquals(3, grille.getNbCellulesVivantes(tab, 1, 1));
    }

    @Test
    public void getNbCellulesVivantes_tableauCarre() {
        Grille grille = new Grille(3, 3);
        boolean[][] tab = new boolean[3][3];
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 2, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 2, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 2));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 2));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 2, 2));

        //Cas avec un voisin
        tab[1][1] = true;
        assertEquals(1, grille.getNbCellulesVivantes(tab, 0, 0));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 1, 0));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 2, 0));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 0, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 1));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 2, 1));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 0, 2));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 1, 2));
        assertEquals(1, grille.getNbCellulesVivantes(tab, 2, 2));
        
    }

    @Test
    public void getNbCellulesVivantes_carreIncremental() {
        Grille grille = new Grille(3, 3);
        boolean[][] tab = new boolean[3][3];
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 2, 0));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 2, 1));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 0, 2));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 1, 2));
        assertEquals(0, grille.getNbCellulesVivantes(tab, 2, 2));

        //On ajoute des voisins au fur et à mesure
        tab[0][0] = true;
        assertEquals(1, grille.getNbCellulesVivantes(tab, 1, 1));
        
        tab[1][0] = true;
        assertEquals(2, grille.getNbCellulesVivantes(tab, 1, 1));

        tab[2][0] = true;
        assertEquals(3, grille.getNbCellulesVivantes(tab, 1, 1));

        tab[0][1] = true;
        assertEquals(4, grille.getNbCellulesVivantes(tab, 1, 1));

        tab[2][1] = true;
        assertEquals(5, grille.getNbCellulesVivantes(tab, 1, 1));

        tab[0][2] = true;
        assertEquals(6, grille.getNbCellulesVivantes(tab, 1, 1));

        tab[1][2] = true;
        assertEquals(7, grille.getNbCellulesVivantes(tab, 1, 1));

        tab[2][2] = true;
        assertEquals(8, grille.getNbCellulesVivantes(tab, 1, 1));

        //Vérification sur les bords : la table est plein de vrai
        tab[1][1]=true;

        assertEquals(3, grille.getNbCellulesVivantes(tab,0 , 0));
        assertEquals(5, grille.getNbCellulesVivantes(tab,1 , 0));
        assertEquals(3, grille.getNbCellulesVivantes(tab,2 , 0));
        assertEquals(5, grille.getNbCellulesVivantes(tab,0 , 1));
        assertEquals(8, grille.getNbCellulesVivantes(tab,1 , 1));
        assertEquals(5, grille.getNbCellulesVivantes(tab,2 , 1));
        assertEquals(3, grille.getNbCellulesVivantes(tab,0 , 2));
        assertEquals(5, grille.getNbCellulesVivantes(tab,1 , 2));
        assertEquals(3, grille.getNbCellulesVivantes(tab,2 , 2));

    }

    @Test
    public void grilleSuivante_vide() {
        Grille grille = new Grille(3, 3);
        boolean[][] tab = new boolean[3][3];
        boolean[][] result = grille.grilleSuivante(tab);
        assertFalse(result[0][0]);
        assertFalse(result[0][1]);
        assertFalse(result[0][2]);
        assertFalse(result[1][0]);
        assertFalse(result[1][1]);
        assertFalse(result[1][2]);
        assertFalse(result[2][0]);
        assertFalse(result[2][1]);
        assertFalse(result[2][2]);
    }


    @Test
    public void grilleSimple() {
        // 2. Any live cell with more than three live neighbours dies, as if by
        // overcrowding.
        Grille grille = new Grille(3, 3);
        boolean[][] tab = new boolean[3][3];
        tab[1][0] = true;
        tab[0][1] = true;
        tab[2][1] = true;
        tab[1][2] = true;
        // Cellule du centre vivante et entourée de 4 cellules vivantes
        // .*.
        // ***
        // .*.
        tab[1][1] = true;
        boolean[][] result = grille.grilleSuivante(tab);
        // ***
        // *.*
        // ***
        assertTrue(result[0][0]);
        assertTrue(result[0][1]);
        assertTrue(result[0][2]);
        assertTrue(result[1][0]);
        assertFalse("Cellule du centre meurt", result[1][1]);
        assertTrue(result[1][2]);
        assertTrue(result[2][0]);
        assertTrue(result[2][1]);
        assertTrue(result[2][2]);
        // Un tour de plus et ça continue
        // *.*
        // ...
        // *.*
        result = grille.grilleSuivante(result);
        assertTrue(result[0][0]);
        assertFalse(result[0][1]);
        assertTrue(result[0][2]);
        assertFalse(result[1][0]);
        assertFalse(result[1][1]);
        assertFalse(result[1][2]);
        assertTrue(result[2][0]);
        assertFalse(result[2][1]);
        assertTrue(result[2][2]);
        
    }
    
    @Test
    public void smallExploder() {
        //Basé sur un cas concret : https://bitstorm.org/gameoflife/
        // .*.
        // ***
        // *.*
        // .*.
        Grille grille = new Grille(40, 40);
        boolean[][] tab = new boolean[40][40];
        tab[20][20]=true;
        tab[19][21]=true;
        tab[20][21]=true;
        tab[21][21]=true;
        tab[19][22]=true;
        tab[21][22]=true;
        tab[20][23]=true;
        boolean[][] result = grille.grilleSuivante(tab);

        //Tour 1 : résultat
        // ***
        // *.*
        // *.*
        // *.*
        // .*.
        assertFalse(result[18][19]);
        assertFalse(result[19][19]);
        assertFalse(result[20][19]);
        assertFalse(result[21][19]);
        assertFalse(result[22][19]);
        
        assertFalse(result[18][20]);
        assertFalse(result[22][20]);
        
        assertFalse(result[18][21]);
        assertFalse(result[22][21]);
        
        assertFalse(result[18][22]);
        assertFalse(result[22][22]);
        
        assertFalse(result[18][23]);
        assertFalse(result[19][23]);
        assertFalse(result[21][23]);
        assertFalse(result[22][23]);

        assertFalse(result[18][24]);
        assertFalse(result[19][24]);
        assertFalse(result[20][24]);
        assertFalse(result[21][24]);
        assertFalse(result[22][24]);
        

        assertTrue(result[19][20]);
        assertTrue(result[20][20]);
        assertTrue(result[21][20]);
        assertTrue(result[19][21]);
        assertTrue(result[21][21]);
        assertTrue(result[19][22]);
        assertTrue(result[21][22]);
        assertTrue(result[20][23]);

    }

}