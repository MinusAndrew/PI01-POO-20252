package unquindio.edu.co;

import unquindio.edu.co.model.Company;
import unquindio.edu.co.model.Crewman;
import unquindio.edu.co.model.Ship;
import java.util.Scanner;
import org.apache.commons.text.RandomStringGenerator;
import unquindio.edu.co.model.enums.CrewmanRole;
import unquindio.edu.co.model.enums.ShipStatus;


public class Main {
    public static void main(String[] args) {
        int keepOn = -1;
        Company company = new Company("SpaceX", "X211");
        while (keepOn == -1){
            company.mainMenu();
            keepOn = company.getKeepRunning();
        }
    }

    public static Ship cliCreateShip(Company company){
        int capacity;
        int fuelLvl;
        String id = generateId();
        String name;
        String statusInput;

        System.out.print("Type a name: ");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();

        System.out.print("Type the max amount of Passengers of the Ship: ");
        capacity = scan.nextInt();

        System.out.print("Type the fuel level that the Ship has: ");
        fuelLvl = scan.nextInt();
        scan.nextLine();

        System.out.print("Select the status of the ship: ");
        statusInput = scan.nextLine();

        Ship ship = new Ship(id,name,capacity,fuelLvl, ShipStatus.valueOf(statusInput.toUpperCase()));
        return ship;
    }

    public static Crewman cliCreateCrewman(Company company){
        String id = generateId();
        String name;
        int hoursXp;
        Scanner scan = new Scanner(System.in);

        System.out.print("Type a name: ");
        name = scan.nextLine();
        System.out.print("Type the amount of hours the Crewman has: ");
        hoursXp = scan.nextInt();
        scan.nextLine();
        System.out.println(retriveRoles());

        System.out.print("Type a role from the list: ");

        String input = scan.nextLine();

        Crewman crewman = new Crewman(id, name, hoursXp, CrewmanRole.valueOf(input.toUpperCase()));
        return crewman;
    }

    public static String generateId(){
        RandomStringGenerator rngStrGen = new RandomStringGenerator.Builder()
                .withinRange(new char[]{'A','Z'}, new char[]{'0', '9'}).build();
        String id = rngStrGen.generate(6);
        return id;
    }

    private static String retriveRoles(){
        String text = "Role List: \n";
        for (CrewmanRole role : CrewmanRole.values() ){
            text += role.name() + "\n";
        }
        return text;
    }


    }

