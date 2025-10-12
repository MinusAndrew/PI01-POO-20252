package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.ShipStatus;

public class Ship {
    private String id, name;
    private int capacity, fuelLvl;

    private ShipStatus shipStatus;


    private Company theCompany;
    private Mission theMission;

    public Ship(String id, String name, int capacity, int fuelLvl, ShipStatus shipStatus) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.fuelLvl = fuelLvl;
        this.shipStatus = shipStatus;
    }

    public void setTheCompany(Company theCompany) {
        this.theCompany = theCompany;
    }

    public void setTheMission(Mission theMission) {
        this.theMission = theMission;
    }



    public int getCapacity() {
        return capacity;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacidad=" + capacity +
                ", combustibleLvl=" + fuelLvl +
                ", naveStatus=" + shipStatus +
                ", theCompany=" + theCompany.getName() +
                ", TheMision=" + theMission +
                '}';
    }
}

