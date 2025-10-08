package unquindio.edu.co.model;

import unquindio.edu.co.model.enums.RolTripulante;

public class Tripulante {
    private String id, nombre;
    private int horasXp;

    private RolTripulante rolTripulante;

    private Mision theMision;
    private Company theCompany;

    public Tripulante(String id, String nombre, int horasXp, RolTripulante rolTripulante) {
        this.id = id;
        this.nombre = nombre;
        this.horasXp = horasXp;
        this.rolTripulante = rolTripulante;
    }

    public void setTheCompany(Company theCompany) {
        this.theCompany = theCompany;
    }

    public void setTheMision(Mision theMision) {
        this.theMision = theMision;
        theMision.addTripulateToMision(this);
    }

    public void setRolTripulante(RolTripulante rolTripulante) {
        this.rolTripulante = rolTripulante;
    }

    public String getId() {
        return id;
    }

    public RolTripulante getRolTripulante() {
        return rolTripulante;
    }

    @Override
    public String toString() {
        return "Tripulante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horasXp=" + horasXp +
                ", rolTripulante=" + rolTripulante +
                ", theMision=" + theMision.getId() +
                ", theCompany=" + theCompany.getName() +
                '}';
    }
}
