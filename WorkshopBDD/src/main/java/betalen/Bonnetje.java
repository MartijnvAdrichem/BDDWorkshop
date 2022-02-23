package betalen;

import java.util.HashMap;

public class Bonnetje {

    private boolean isSucces;
    private int opgenomenBedrag;
    private HashMap<Briefgeld, Integer> ontvangenBriefjes;
    private String foutmelding;

    public Bonnetje(int opgenomenBedrag, HashMap<Briefgeld, Integer> ontvangenBriefjes) {
        this.isSucces = isSucces;
        this.opgenomenBedrag = opgenomenBedrag;
        this.ontvangenBriefjes = ontvangenBriefjes;
        this.foutmelding = foutmelding;
    }

    public Bonnetje(String foutmelding) {
        this.isSucces = false;
        this.opgenomenBedrag = 0;
        this.ontvangenBriefjes = new HashMap<>();
        this.foutmelding = foutmelding;
    }


    public HashMap<Briefgeld, Integer> getOntvangenBriefjes() {
        return ontvangenBriefjes;
    }

    public int getOpgenomenBedrag() {
        return opgenomenBedrag;
    }

    public boolean isSucces() {
        return isSucces;
    }

    public String getFoutmelding() {
        return foutmelding;
    }
}
