package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.NaveStatus;

public class Cargero extends Nave {
    private int cargaMax;
    public Cargero(String id, String name, int capacidad, int combustibleLvl, NaveStatus naveStatus, int cargaMax) {
        super(id, name, capacidad, combustibleLvl, naveStatus);
        this.cargaMax = cargaMax;
    }
}
