package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.NaveStatus;

public class Lanzadera extends Nave{
    private int despeges;



    public Lanzadera(String id, String name, int capacidad, int combustibleLvl, NaveStatus naveStatus) {
        super(id, name, capacidad, combustibleLvl, naveStatus);

    }
}
