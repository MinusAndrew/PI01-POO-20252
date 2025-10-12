package unquindio.edu.co;

import unquindio.edu.co.model.Company;

import java.util.Scanner;

public class Main {

    public static void registerShip(){




    }

    public static void mainMenu(){
        int mainSelect = -1;
        System.out.println("Select Thingy idunno: ");
        Scanner scan = new Scanner(System.in);
        while (mainSelect == -1){
            mainSelect = scan.nextInt();
        }
        switch (mainSelect){







        }

    }


    public static void main(String[] args) {

        Company company = new Company("SpaceX", "X211");
//        Nave nave1 = new Nave("Win12", "Winker", 4, 100, NaveStatus.OPTIMAL);
//        Tripulante tripulante1 = new Tripulante("1R727Z", "Santiago", 3000, RolTripulante.PILOTO);
//        Tripulante tripulante2 = new Tripulante("2KKL3", "Kalos", 1, RolTripulante.INGENIERO);
//        Mision mision1 = new Mision("Mars", "727WKL",44, MisionStatus.LIVE, MisionRisk.LOW, company, nave1);
//
//
//        company.registarTripulante(tripulante1);
//        company.registarTripulante(tripulante2);
//        company.registrarNave(nave1);
//        company.registrarMision(mision1);
//        tripulante2.setTheMission(mision1);
//        tripulante1.setTheMission(mision1);
//        company.consultarTripulante("2KKL3");
//        company.consultarNave("Win12");
//
//        System.out.println(mision1);
        }
    }

