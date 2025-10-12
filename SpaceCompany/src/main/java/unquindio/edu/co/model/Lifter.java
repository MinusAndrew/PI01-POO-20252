package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.ShipStatus;

public class Lifter extends Ship {
    private int maxLiftCapacity;
    public Lifter(String id, String name, int capacidad, int combustibleLvl, ShipStatus shipStatus, int maxLiftCapacity) {
        super(id, name, capacidad, combustibleLvl, shipStatus);
        this.maxLiftCapacity = maxLiftCapacity;
    }
}
