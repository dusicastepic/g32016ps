/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Ucinak;
import forme.FrmGlavna;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabeleUcinak extends AbstractTableModel {

    ArrayList<Ucinak> listeUcinaka = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    String[] kolone = {"Vrsta posla", "Ime i prezime", "Broj sati", "Datum"};

    @Override
    public int getRowCount() {
        return listeUcinaka.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ucinak u = listeUcinaka.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getVrstaposla();
            case 1:
                return u.getRadnik();
            case 2:
                return u.getBrojSati();
            case 3:
                return sdf.format(u.getDatum());
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Ucinak u) {
        listeUcinaka.add(u);
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        try {
            listeUcinaka.remove(red);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException();
        }
        fireTableDataChanged();
    }

    public ArrayList<Ucinak> vratiListeucinaka() {
        return listeUcinaka;
    }
}
