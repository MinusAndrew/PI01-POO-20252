package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.CrewmanRole;

public class Crewman {
    private String id, name;
    private int XpHours;

    private CrewmanRole crewmanRole;

    private Mission theMission;
    private Company theCompany;

    public Crewman(String id, String name, int XpHours, CrewmanRole crewmanRole) {
        this.id = id;
        this.name = name;
        this.XpHours = XpHours;
        this.crewmanRole = crewmanRole;
    }

    public void setTheCompany(Company theCompany) {
        this.theCompany = theCompany;
    }

    public void setTheMission(Mission theMission) {
        this.theMission = theMission;
        theMission.addCrewmanToMission(this);
    }

    public void setCrewmanRole(CrewmanRole crewmanRole) {
        this.crewmanRole = crewmanRole;
    }

    public String getId() {
        return id;
    }

    public CrewmanRole getCrewmanRole() {
        return crewmanRole;
    }

    @Override
    public String toString() {
        return "Tripulante{" +
                "id='" + id + '\'' +
                ", nombre='" + name + '\'' +
                ", horasXp=" + XpHours +
                ", rolTripulante=" + crewmanRole +
                //", theMision=" + theMission.getId() +
                ", theCompany=" + theCompany.getName() +
                '}';
    }
}
