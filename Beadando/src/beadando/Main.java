/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando;

import java.util.Scanner;

/**
 *
 * @author Levi
 */
public class Main {
    
    public static void main(String[] args) {
                
        Playlist Lista = new Playlist();
        Lista.playlistKeszites();
        Scanner bekerszam = new Scanner(System.in);

        while(true){

            System.out.println("\n\nValassz az alabbi lehetosegek  kozul!\n\n"
                + "Playlist kiiratasa: 1\n"
                + "Playlist random kiiratasa: 2\n"
                + "Eloadok nevei: 3\n"
                + "Stilusok nevei: 4\n"
                + "Eloadok zeneinek kiirasa: 5\n"
                + "Zeneszam fajlbairasa: 6\n\n"
                + "Kilepes: 0");               

                try {
                    String valami = bekerszam.nextLine();
                    int bekertszam = Integer.valueOf(valami);


                    switch(bekertszam) {
                        case 1:
                            Lista.kiir();
                            break;
                        case 2:
                            Lista.randomkiir();              
                            break;
                        case 3:
                            Lista.eloadokiir();              
                            break;
                        case 4:
                            Lista.stiluskiir();              
                            break;
                        case 5:
                            Lista.bekeres();              
                            break;
                        case 6:
                            Lista.playlistLetrehozas();              
                            break;
                        case 0:
                            System.exit(0);              
                            break;
                        default:                
                            System.out.println("Rossz menupont");
                            break;
                    }
            }
            catch (Exception e) {
                System.out.println("Ez nem egy szam!");
            }
        }
                
    }    
}