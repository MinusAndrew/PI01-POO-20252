package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.CrewmanRole;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name, id;
    private List<Ship> shipList;
    private List<Mission> missionList;
    private List<Crewman> crewmanList;

    public Company(String name, String id) {
        this.name = name;
        this.id = id;
        this.shipList = new ArrayList<>();
        this.missionList = new ArrayList<>();
        this.crewmanList = new ArrayList<>();
    }

    public void reassignCrewmanRole(Crewman crewman, CrewmanRole rol){
        crewman.setCrewmanRole(rol);
    }

    public Crewman searchTripulanteById(String id){
        for (Crewman tripulantes : crewmanList){
            String idFromTripulante = tripulantes.getId();
            if (id.equals(idFromTripulante)){
                return tripulantes;
            }
        }
        return null;
    }

    public String searchCrewmanByRole(List<Crewman> crewmanList){
        String text = "";
        for (CrewmanRole roles : CrewmanRole.values()){
            text += "Rol: " + roles + "\n";
            for (Crewman tripulantes : crewmanList){
                if (tripulantes.getCrewmanRole().equals(roles)){
                    text += tripulantes.toString();
                }
            }
        }

        return text;
    }

    public void listCrewman(List<Crewman> crewmanList){
        System.out.println(searchCrewmanByRole(crewmanList));
    }

    public Ship searchShipById(String id){
        for (Ship naves : shipList){
            String idFromNave = naves.getId();
            if (id.equals(idFromNave)){
                return naves;
            }
        }
        return null;
    }


    public void checkCrewman(String id){
        Crewman crewman = searchTripulanteById(id);
        System.out.println(crewman.toString());
    }

    public void checkShip(String id){
       Ship ship = searchShipById(id);
       System.out.println(ship.toString());
    }


    public void registerShip(Ship ship){
        shipList.add(ship);
        ship.setTheCompany(this);
    }

    public void registerCrewman(Crewman crewman){
        crewmanList.add(crewman);
        crewman.setTheCompany(this);
    }

    public void registerMission(Mission mission){
        missionList.add(mission);
    }

    public List<Crewman> getCrewmanList() {
        return crewmanList;
    }

    public String getName() {
        return name;
    }
}
