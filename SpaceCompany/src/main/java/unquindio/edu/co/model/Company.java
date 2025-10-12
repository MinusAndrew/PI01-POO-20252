package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.CrewmanRole;

import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void cliShipRegister(){
        System.out.println();

    }


    public void cliCheckShip(){





    }

    public void cliDeleteShip(){





    }

    public void cliRegisterCrewman(){



    }

    public void cliCheckCrewman(){


    }

    public void cliRegisterMission(){





    }

    public void cliAssignToMission(){




    }

    public void listRegisteredShips(List<Ship> shipList){
        String registeredShips = "";
        for (Ship thisShip : shipList){
            registeredShips += thisShip.toString();
        }
        System.out.println(registeredShips);
    }

    public void deleteShip(String id, List<Ship> shipList){
        for (Ship thisShip : shipList){
            if (thisShip.getId().equals(id)){
                if (thisShip.getIsInMission()){
                    System.out.println("The Ship can't be Removed cuz it is in Mission ID:" + thisShip.getTheMission().getId());
                }
            }
            else {
                shipList.remove(thisShip);
                System.out.println("The Ship ID: " + thisShip.getId() + " Has been removed.");
                break;
            }
        }
    }

    public void mainMenu(){
        int mainSelect = -1;
        System.out.println("Select Thingy idunno: ");
        Scanner scan = new Scanner(System.in);
        while (mainSelect == -1){
            mainSelect = scan.nextInt();
        }
        switch (mainSelect){
            case (1):
                cliShipRegister();
                break;
            case (2):
                cliCheckShip();
                break;
            case (3):
                listRegisteredShips(getShipList());
                break;
            case (4):
                cliDeleteShip();
                break;
            case (5):
                cliRegisterCrewman();
                break;
            case (6):
                cliCheckCrewman();
                break;
            case (7):
                listCrewmanByRole(getCrewmanList());
                break;
            case (8):
                cliRegisterMission();
                break;
            case (9):
                cliAssignToMission();
                break;
        }
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

    public void listCrewmanByRole(List<Crewman> crewmanList){
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

    public List<Mission> getMissionList() {
        return missionList;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public String getName() {
        return name;
    }
}
