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


}
