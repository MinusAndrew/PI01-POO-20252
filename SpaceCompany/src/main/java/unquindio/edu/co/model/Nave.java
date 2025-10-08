package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.NaveStatus;

import java.util.List;

public class Nave {
    private String id, name;
    private int capacidad, combustibleLvl;

    private NaveStatus naveStatus;


    private Company theCompany;
    private Mision TheMision;

    public Nave(String id, String name, int capacidad, int combustibleLvl, NaveStatus naveStatus) {
        this.id = id;
        this.name = name;
        this.capacidad = capacidad;
        this.combustibleLvl = combustibleLvl;
        this.naveStatus = naveStatus;
    }

    public void setTheCompany(Company theCompany) {
        this.theCompany = theCompany;
    }

    public void setTheMision(Mision theMision) {
        TheMision = theMision;
    }



    public int getCapacidad() {
        return capacidad;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacidad=" + capacidad +
                ", combustibleLvl=" + combustibleLvl +
                ", naveStatus=" + naveStatus +
                ", theCompany=" + theCompany.getName() +
                ", TheMision=" + TheMision +
                '}';
    }
}

