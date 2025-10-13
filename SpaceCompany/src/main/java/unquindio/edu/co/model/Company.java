package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.CrewmanRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static unquindio.edu.co.Main.*;

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


    public void cliCheckShip(){
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Type the ID of the Ship u want to search: ");
        input = scan.nextLine();
        Ship ship = searchShipById(input);
        System.out.println(ship);
    }

    public void cliDeleteShip(){
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Type the ID of the Ship u want to delete: ");
        input = scan.nextLine();
        Ship ship = searchShipById(input);
        deleteShip(ship, input);
    }

    public void cliCheckCrewman(){
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Type the ID of the Ship u want to delete: ");
        input = scan.nextLine();
        Crewman crewman = searchCrewmanById(input);
        System.out.println(crewman.toString());
    }

    public void cliRegisterMission(){
        String id = generateId();
        String destination;





        Mission mission = new Mission();



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

    public void deleteShip(Ship ship, String id){
            if (ship.getId().equals(id)){
                if (ship.getIsInMission()){
                    System.out.println("The Ship can't be Removed cuz it is in Mission ID:" + ship.getTheMission().getId());
                }
            }
            else {
                shipList.remove(ship);
                System.out.println("The Ship ID: " + ship.getId() + " Has been removed.");
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
                registerShip(cliCreateShip(this));
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
                registerCrewman(cliCreateCrewman(this));
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

    public String enlistCrewmanByRole(List<Crewman> crewmanList){
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
        System.out.println(enlistCrewmanByRole(crewmanList));
    }

    public Ship searchShipById(String id){
        for (Ship ships : getShipList()){
            String idFromNave = ships.getId();
            if (id.equals(idFromNave)){
                return ships;
            }
        }
        return null;
    }

    public Crewman searchCrewmanById(String id){
        for (Crewman crewman : getCrewmanList()){
            String idFromCrewman = crewman.getId();
            if (id.equals(idFromCrewman)){
                return crewman;
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
