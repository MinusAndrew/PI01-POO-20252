package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.ShipStatus;

public class Launcher extends Ship {
    private int launchCounter;

    public Launcher(String id, String name, int capacity, int combustibleLvl, ShipStatus shipStatus) {
        super(id, name, capacity, combustibleLvl, shipStatus);
        this.launchCounter = 0;
    }

    public void countLaunch(){
        launchCounter++;
    }
}
