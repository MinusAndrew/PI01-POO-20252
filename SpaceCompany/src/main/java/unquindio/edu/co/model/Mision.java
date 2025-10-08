package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.MisionRisk;
import unquindio.edu.co.model.enums.MisionStatus;

import java.util.ArrayList;
import java.util.List;

public class Mision {
    private String destino,id;
    private int duracionPrevista;


    private MisionStatus misionStatus;
    private MisionRisk misionRisk;

    private Company theCompany;
    private Nave theNave;

    private List<Tripulante> tripulanteMisionList;

    public Mision(String destino, String id, int duracionPrevista, MisionStatus misionStatus, MisionRisk misionRisk, Company TheCompany, Nave theNave) {
        this.destino = destino;
        this.id = id;
        this.duracionPrevista = duracionPrevista;
        this.misionStatus = misionStatus;
        this.misionRisk = misionRisk;
        this.theCompany = TheCompany;
        this.theNave = theNave;
        theNave.setTheMision(this);
        this.tripulanteMisionList = new ArrayList<>();
    }

    public void addTripulateToMision(Tripulante tripulante){
        int capacity = theNave.getCapacidad();
        if (tripulanteMisionList.size() != capacity){
            tripulanteMisionList.add(tripulante);
        }
        else {
            System.out.println("can't add more than " + capacity + " ppl on the ship");
        }
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Mision{" +
                "destino='" + destino + '\'' +
                ", id='" + id + '\'' +
                ", duracionPrevista=" + duracionPrevista +
                ", misionStatus=" + misionStatus +
                ", misionRisk=" + misionRisk +
                ", theCompany=" + theCompany.getName() +
                ", theNave=" + theNave.getId() +
                ", tripulanteMisionList=" + tripulanteMisionList +
                '}';
    }
}
