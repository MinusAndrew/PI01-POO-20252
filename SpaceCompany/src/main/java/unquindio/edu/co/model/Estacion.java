package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.ShipStatus;

import java.util.ArrayList;
import java.util.List;

public class Estacion extends Ship {

    private List<String> modulos;

    public Estacion(String id, String name, int capacidad, int combustibleLvl, ShipStatus shipStatus) {
        super(id, name, capacidad, combustibleLvl, shipStatus);
        this.modulos = new ArrayList<>();
    }




}
