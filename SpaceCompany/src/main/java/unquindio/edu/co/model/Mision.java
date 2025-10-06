package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.MisionRisk;
import unquindio.edu.co.model.enums.MisionStatus;

import java.util.ArrayList;
import java.util.List;

public class Mision {
    private String destino;
    private int duracionPrevista;

    private MisionStatus misionStatus;
    private MisionRisk misionRisk;

    private Company theCompany;
    private Nave theNave;

    private List<Tripulante> tripulanteMisionList;

    public Mision(String destino, int duracionPrevista, MisionStatus misionStatus, MisionRisk misionRisk, Nave theNave) {
        this.destino = destino;
        this.duracionPrevista = duracionPrevista;
        this.misionStatus = misionStatus;
        this.misionRisk = misionRisk;
        this.theNave = theNave;
        this.tripulanteMisionList = new ArrayList<>();
    }




}
