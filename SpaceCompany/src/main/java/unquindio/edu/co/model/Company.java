package unquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name, id;
    private List<Nave> naveList;
    private List<Mision> misionList;
    private List<Tripulante> tripulanteList;

    public Company(String name, String id) {
        this.name = name;
        this.id = id;
        this.naveList = new ArrayList<>();
        this.misionList = new ArrayList<>();
        this.tripulanteList = new ArrayList<>();
    }

    public Tripulante searchTripulanteById(String id){
        for (Tripulante tripulantes : tripulanteList){
            String idFromTripulante = tripulantes.getId();
            if (id.equals(idFromTripulante)){
                return tripulantes;
            }
        }
        return null;
    }

    public void consultarTripulante(String id){
        Tripulante tripulante = searchTripulanteById(id);
        System.out.println(tripulante.toString());
    }


    public void registrarNave(Nave nave){
        naveList.add(nave);
    }

    public void registarTripulante(Tripulante tripulante){
        tripulanteList.add(tripulante);
    }

    public void registrarMision(Mision mision){
        misionList.add(mision);
    }




}
