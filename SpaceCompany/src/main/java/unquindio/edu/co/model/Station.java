package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.ShipStatus;

import java.util.ArrayList;
import java.util.List;

public class Station extends Ship {

    private List<String> modulos;

    public Station(String id, String name, int capacity, int fuelLvl, ShipStatus shipStatus) {
        super(id, name, capacity, fuelLvl, shipStatus);
        this.modulos = new ArrayList<>();
    }




}
