package unquindio.edu.co;

import unquindio.edu.co.model.Company;
import unquindio.edu.co.model.Mision;
import unquindio.edu.co.model.Nave;
import unquindio.edu.co.model.Tripulante;
import unquindio.edu.co.model.enums.MisionRisk;
import unquindio.edu.co.model.enums.MisionStatus;
import unquindio.edu.co.model.enums.NaveStatus;
import unquindio.edu.co.model.enums.RolTripulante;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("SpaceX", "X211");
        Nave nave1 = new Nave("Win12", "Winker", 4, 100, NaveStatus.OPTIMAL);
        Tripulante tripulante1 = new Tripulante("1R727Z", "Santiago", 3000, RolTripulante.PILOTO);
        Tripulante tripulante2 = new Tripulante("2KKL3", "Kalos", 1, RolTripulante.INGENIERO);
        Mision mision1 = new Mision("Mars", "727WKL",44, MisionStatus.LIVE, MisionRisk.LOW, company, nave1);


        company.registarTripulante(tripulante1);
        company.registarTripulante(tripulante2);
        company.registrarNave(nave1);
        company.registrarMision(mision1);
        tripulante2.setTheMision(mision1);
        tripulante1.setTheMision(mision1);
        company.consultarTripulante("2KKL3");
        company.consultarNave("Win12");

        System.out.println(mision1);

        }
    }