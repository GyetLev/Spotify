/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beadando;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Levi
 */
public class Playlist {
    ArrayList<Zeneszamok> zene = new ArrayList();
    ArrayList<Zeneszamok> lejatszasiLista = new ArrayList();
    
    public void playlistKeszites(){
        
        BufferedReader br = null;
        File file = new File("playlist.txt");
       try{	
           br = new BufferedReader(new FileReader(file));		

	   String contentLine;
           String[] lines;
	   while (br.ready()) {
	      contentLine = br.readLine();
              lines = contentLine.split(";");
              zene.add(new Zeneszamok(lines[0], lines[1], lines[2], lines[3]));
           }           
       }catch (IOException ioe){
	   ioe.printStackTrace();
       } 
       finally{
            try{
	      if (br != null){
		 br.close();
              }
            }catch (IOException ioe){
                System.out.println(ioe.getMessage());
            }
	}       
    }
    
    public void kiir(){
        
        
        for(Zeneszamok lista: zene){
           lista.kiirat();
        }
    }
    
    public void randomkiir(){
        
        ArrayList<Zeneszamok>randomzene = new ArrayList();
        randomzene = (ArrayList<Zeneszamok>) zene.clone();
        
        Random veletlenszam = new Random();
        for (int i = 0; i < 30; i++) {
            int szam = veletlenszam.nextInt(randomzene.size());
            randomzene.get(szam).kiirat();
            randomzene.remove(szam);
        }        
    }  
    
    public void bekeres(){
        
        eloadokiir();
        System.out.println("\nAdj meg egy nevet:");
        Scanner beker = new Scanner(System.in);
        String eloado = beker.nextLine();
        boolean vaneloado = false;
        for(Zeneszamok lista: zene){
            if(lista.getEloado().equalsIgnoreCase(eloado)){
                lista.kiirat();
                vaneloado = true;
            }
        }        
        if(!vaneloado){
            System.out.println("Nincs ilyen eloado!");
        }
    }
    
    public void eloadokiir(){
        
        ArrayList<String>eloadok = new ArrayList();
        for (Zeneszamok zeneszamok : zene){
            if(!eloadok.contains(zeneszamok.getEloado())){           
                eloadok.add(zeneszamok.getEloado());
            }
        }
        Collections.sort(eloadok);
        System.out.println("Eladok nevei:\n");
        for (int i = 0; i < eloadok.size(); i++) {
            System.out.println(eloadok.get(i));
        }
    }
    
    public void stiluskiir(){
        
        ArrayList<String>stilusok = new ArrayList();
        for (Zeneszamok zeneszamok : zene) {
            if(!stilusok.contains(zeneszamok.getStilus())){
                stilusok.add(zeneszamok.getStilus());
            }            
        }
        Collections.sort(stilusok);        
        System.out.println("Stilusok:\n");
        for (int i = 0; i < stilusok.size(); i++) {
            System.out.println(stilusok.get(i));            
        }
    }
    public void playlistLetrehozas(){
        
        System.out.println("Valassz az alabbi sorszamok kozul, amelyiket faljba kivanod irni:\n");
        for (int i = 0; i < zene.size(); i++) {
            System.out.println((i+1) + ". " + zene.get(i));
        }
        System.out.println("Kilepeshez nyomj 0-t");
        
        int bekertszam = 0;
        do{
            try {
                Scanner bekerszam = new Scanner(System.in);
                bekertszam = bekerszam.nextInt();
                if(bekertszam < 0 || bekertszam > zene.size()){
                    System.out.println("Ez a szam nem letezik.");
                }else if(bekertszam == 0){
                    break; 
                }else{
                    System.out.println("A bekert zene:\n" + zene.get(bekertszam-1));
                lejatszasiLista.add(zene.get(bekertszam-1)); 
                }
            } catch (Exception e) {
                System.out.println("Nem szám lett megadva!");
            }
            System.out.println("Kilepeshez nyomj 0-t");
        }while(bekertszam != 0);  
        fajlbair();
    }
    
    public void fajlbair(){
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("lejatszasilista.txt")));
            for (Zeneszamok listak : lejatszasiLista) {
                bw.write(listak.toString());
            }
            bw.close();
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }        
    }
}