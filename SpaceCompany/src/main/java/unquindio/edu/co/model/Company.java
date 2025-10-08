package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.RolTripulante;

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

    public void reasignarRolTripulante(Tripulante tripulante, RolTripulante rol){
        tripulante.setRolTripulante(rol);
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

    public String searchTripulantesByRole(List<Tripulante> tripulanteList){
        String text = "";
        for (RolTripulante roles : RolTripulante.values()){
            text += "Rol: " + roles + "\n";
            for (Tripulante tripulantes : tripulanteList){
                if (tripulantes.getRolTripulante().equals(roles)){
                    text += tripulantes.toString();
                }
            }
        }

        return text;
    }

    public void listarTripulantes(List<Tripulante> tripulanteList){
        System.out.println(searchTripulantesByRole(tripulanteList));
    }

    public Nave searchNaveById(String id){
        for (Nave naves : naveList){
            String idFromNave = naves.getId();
            if (id.equals(idFromNave)){
                return naves;
            }
        }
        return null;
    }


    public void consultarTripulante(String id){
        Tripulante tripulante = searchTripulanteById(id);
        System.out.println(tripulante.toString());
    }

    public void consultarNave(String id){
       Nave nave = searchNaveById(id);
       System.out.println(nave.toString());
    }


    public void registrarNave(Nave nave){
        naveList.add(nave);
        nave.setTheCompany(this);
    }

    public void registarTripulante(Tripulante tripulante){
        tripulanteList.add(tripulante);
        tripulante.setTheCompany(this);
    }

    public void registrarMision(Mision mision){
        misionList.add(mision);
    }

    public List<Tripulante> getTripulanteList() {
        return tripulanteList;
    }

    public String getName() {
        return name;
    }
}
