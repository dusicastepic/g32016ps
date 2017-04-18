/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import dbb.DBBroker;
import domen.Radnik;
import domen.Ucinak;
import domen.VrstaPosla;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Kontroler {

    private static Kontroler instance;
    DBBroker dbb;

    private Kontroler() {
        dbb = new DBBroker();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ArrayList<VrstaPosla> vratiListeVrstiPosla() {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<VrstaPosla> listeVP = dbb.vratiListeVP();
        dbb.zatvoriKonekciju();
        return listeVP;
    }

    public ArrayList<Radnik> vratiListuRadnika() {
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        ArrayList<Radnik> listaRdnika = dbb.vratiListuRadnika();
        dbb.zatvoriKonekciju();
        return listaRdnika;
    }

//    public int vratiIndeks() {
//        return dbb.vratiIndeks();
//    }
//
//    public boolean dodajListuucinaka(ArrayList<Ucinak> listaUcinaka)     {
//        boolean uspesno=false;
//        dbb.ucitajDrajver();
//        dbb.otvoriKonekciju();
//        int indeks=vratiIndeks();
//        indeks++;
//        try {
//            for (Ucinak u : listaUcinaka) {
//                dbb.unesiListuUcinaka(u, indeks);
//                indeks++;
//            }
//            dbb.commit();
//            uspesno=true;
//
//        } catch (SQLException se) {
//            dbb.rollback();
//            uspesno= false;
//        }
//
//        dbb.zatvoriKonekciju();
//        return uspesno;
//    }
    public boolean obrisiSve() {
        boolean uspesno = false;
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        try {
            dbb.obrisiSve();
            dbb.commit();
            uspesno = true;
        } catch (Exception e) {
            dbb.rollback();
            uspesno = false;
        }
        dbb.zatvoriKonekciju();
        return uspesno;
    }

    public boolean sacuvajListu(ArrayList<Ucinak> listaUcinaka) {
        boolean uspesno=false;
        dbb.ucitajDrajver();
        dbb.otvoriKonekciju();
        int id=dbb.vratiID();
        try {
            for (Ucinak u : listaUcinaka) {
                dbb.sacuvajUcinak(u,id);
                id++;
            }
            dbb.commit();
            uspesno=true;
        } catch (SQLException e) {
            dbb.rollback();
            uspesno=false;
        }
        dbb.zatvoriKonekciju();
        return uspesno;
    }

}
