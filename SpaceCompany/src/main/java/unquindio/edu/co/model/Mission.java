package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.MissionRisk;
import unquindio.edu.co.model.enums.MissionStatus;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private String destination,id;
    private int estimatedTime;


    private MissionStatus missionStatus;
    private MissionRisk missionRisk;

    private Company theCompany;
    private Ship theShip;

    private List<Crewman> crewmanMisionList;

    public Mission(int estimatedTime, String destination, String id, MissionStatus missionStatus, MissionRisk missionRisk, Company TheCompany, Ship theShip) {
        this.destination = destination;
        this.id = id;
        this.estimatedTime = estimatedTime;
        this.missionStatus = missionStatus;
        this.missionRisk = missionRisk;
        this.theCompany = TheCompany;
        this.theShip = theShip;
        this.crewmanMisionList = new ArrayList<>();
        theShip.setTheMission(this);
    }

    public void addCrewmanToMission(Crewman crewman){
        int capacity = theShip.getCapacity();
        if (crewmanMisionList.size() != capacity){
            crewmanMisionList.add(crewman);
            crewman.setTheMission(this);
            System.out.println("The crewman has been added to the mission ID: " + getId());
        }
        else {
            System.out.println("can't add more than " + capacity + " ppl on the ship");
        }
    }

    public String getId() {
        return id;
    }

    public void setTheShip(Ship theShip) {
        this.theShip = theShip;
    }

    @Override
    public String toString() {
        return "Mision{" +
                "destino='" + destination + '\'' +
                ", id='" + id + '\'' +
                ", duracionPrevista=" + estimatedTime +
                ", misionStatus=" + missionStatus +
                ", misionRisk=" + missionRisk +
                ", theCompany=" + theCompany.getName() +
                ", theNave=" + theShip.getId() +
                ", tripulanteMisionList=" + crewmanMisionList +
                '}';
    }
}
