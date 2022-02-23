package betalen;

public enum Briefgeld
{
    TIEN(10),
    TWINTIG(20),
    VIJFTIG(50);

    private int waarde;


    Briefgeld(int waarde) {
        this.waarde = waarde;
    }

    public int getWaarde() {
        return waarde;
    }
}
