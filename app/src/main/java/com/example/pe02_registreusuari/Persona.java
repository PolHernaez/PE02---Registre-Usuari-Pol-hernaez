package com.example.pe02_registreusuari;

import android.widget.RadioButton;

import java.io.Serial;
import java.io.Serializable;

public class Persona implements Serializable {
    private String nom;
    private String cognoms;
    private int edat;

    private boolean matriculado;
    public Persona(String nom, String cognoms, int edat, boolean matriculado) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.matriculado = matriculado;
    }

    public String getNom() { return nom; }
    public String getCognoms() { return cognoms; }
    public int getEdat() { return edat; }
    public boolean getMatriculado(){
        return matriculado;
    }
}
