package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.CrewmanRole;
import unquindio.edu.co.model.enums.MissionRisk;
import unquindio.edu.co.model.enums.MissionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static unquindio.edu.co.Main.*;

public class Company {
    int KeepRunning = -1;

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
        System.out.print("Type the ID of the Ship u want to search: ");
        input = scan.nextLine();
        Ship ship = searchShipById(input);
        System.out.println(ship);
    }

    public void cliDeleteShip(){
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.print("Type the ID of the Ship u want to delete: ");
        input = scan.nextLine();
        Ship ship = searchShipById(input);
        deleteShip(ship, input);
    }

    public void cliCheckCrewman(){
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.print("Type the ID of the crewman u want to check: ");
        input = scan.nextLine();
        Crewman crewman = searchCrewmanById(input);
        System.out.println(crewman.toString());
    }

    public void cliRegisterMission(){
        int estimatedTime;
        String id = generateId();
        String destination;
        String inputRisk;
        String inputStatus;
        String idShip;
        Scanner scan = new Scanner(System.in);

        System.out.print("Type the estimated time the mission will take in days: ");
        estimatedTime = scan.nextInt();
        scan.nextLine();

        System.out.print("Type the destination: ");
        destination = scan.nextLine();

        System.out.println(retriveRiskMission());
        System.out.print("Type the risk lvl of the mission: ");
        inputRisk = scan.nextLine();

        System.out.println(retriveStatusMission());
        System.out.print("Type the status of the mission: ");
        inputStatus = scan.nextLine();


        System.out.print("Type the id of the ship u want to put in the mission: ");
        idShip = scan.nextLine();

        Mission mission = new Mission(estimatedTime, destination, id, MissionStatus.valueOf(inputStatus.toUpperCase()), MissionRisk.valueOf(inputRisk.toUpperCase()), this, searchShipById(idShip));
        registerMission(mission);
        System.out.println(mission);
    }

    public void cliAssignToMission(){
        char option;
        Scanner scan = new Scanner(System.in);
        String idMissionInput;
        String idCrewman;
        String idShip;
        Ship ship;
        Crewman crewman;
        System.out.print("Type the id of the Mission u wanna assign resources to: ");
        idMissionInput = scan.nextLine();

        Mission mission = searchMissionById(idMissionInput);

        System.out.print("Type the id of the Crewman u want to add to the Mission: ");
        idCrewman = scan.nextLine();
        crewman = searchCrewmanById(idCrewman);
        mission.addCrewmanToMission(crewman);


        System.out.println("Do u want to change the ship assigned to the mission?: ");
        option = scan.next().toLowerCase().charAt(0);
        if (option == 'y'){
            System.out.print("Type the id of the ship that u want the mission to have: ");
            idShip = scan.nextLine();
            ship = searchShipById(idShip);
            ship.setTheMission(mission);
            mission.setTheShip(ship);
        }
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




    private static String retriveStatusMission(){
        String text = "Status List: \n";
        for (MissionStatus status : MissionStatus.values() ){
            text += status.name() + "\n";
        }
        return text;
    }


    private static String retriveRiskMission(){
        String text = "Risk Level List: \n";
        for (MissionRisk risk : MissionRisk.values() ){
            text += risk.name() + "\n";
        }
        return text;
    }

    public void reassignCrewmanRole(Crewman crewman, CrewmanRole rol){
        crewman.setCrewmanRole(rol);
    }

    public Crewman searchTripulanteById(String id){
        for (Crewman crewman : crewmanList){
            String idFromCrewman = crewman.getId();
            if (id.equals(idFromCrewman)){
                return crewman;
            }
        }
        return null;
    }

    public String enlistCrewmanByRole(List<Crewman> crewmanList){
        String text = "";
        for (CrewmanRole roles : CrewmanRole.values()){
            text += "Rol: " + roles + "\n";
            for (Crewman crewman : crewmanList){
                if (crewman.getCrewmanRole().equals(roles)){
                    text += crewman.toString();
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

    public Mission searchMissionById(String id){
        for (Mission mission : getMissionList()){
            String idFromNave = mission.getId();
            if (id.equals(idFromNave)){
                return mission;
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

    public int getKeepRunning() {
        return KeepRunning;
    }

    public void mainMenu(){
        int mainSelect = -1;
        System.out.println("THE " + getName().toUpperCase() + " COMPANY MANAGEMENT SOFTWARE!");
        System.out.println("Select one of the following actions: ");
        String wallOfOptions = """
                1. Register a ship\s
                2. Check a Ship by ID
                3. List Registered Ships
                4. Delete a Ship
                5. Register a Crewman
                6. Check crewman by ID
                7. List crewman by role
                8. Register mission
                9. Assign resources to mission""";
        System.out.println(wallOfOptions);
        System.out.print("Type the Option u want to access: ");
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
}
