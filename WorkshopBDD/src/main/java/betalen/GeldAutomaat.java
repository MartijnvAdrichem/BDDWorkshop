package betalen;

import java.util.HashMap;

public class GeldAutomaat {

    private int geldVoorraad;

    public GeldAutomaat(int saldo) {

        this.geldVoorraad = saldo;
    }


    public Bonnetje neemGeldOp(Rekening rekening, int bedrag, int ingevoerdePincode) {

        if (rekening.getPincode() != ingevoerdePincode) {
            return new Bonnetje("Pincode Onjuist");
        }

        if (bedrag > geldVoorraad) {
            return new Bonnetje("Geen voorraad");
        }

        if (bedrag == 0 || bedrag % 10 != 0)
        {
            return new Bonnetje("Onjuist gekozen bedrag");
        }

        if (bedrag > rekening.getSaldo()) {
            return new Bonnetje("Onvoldoende Saldo");
        }

        rekening.haalSaldoAf(bedrag);
        geldVoorraad -= bedrag;

        return new Bonnetje(bedrag, berekenUitgifteBriefgeld(bedrag));

    }

    private HashMap<Briefgeld, Integer> berekenUitgifteBriefgeld(int bedrag) {
        var container = new HashMap<Briefgeld, Integer>();

        if (bedrag == 0) {
            return container;
        }

        var aantalVijftig = bedrag / Briefgeld.VIJFTIG.getWaarde();
        var aantalTwintig = (bedrag % Briefgeld.VIJFTIG.getWaarde()) / Briefgeld.TWINTIG.getWaarde();

        var aantalTien = (bedrag
                % Briefgeld.VIJFTIG.getWaarde()
                % Briefgeld.TWINTIG.getWaarde())
                / Briefgeld.TIEN.getWaarde();

        container.put(Briefgeld.VIJFTIG, aantalVijftig);
        container.put(Briefgeld.TWINTIG, aantalTwintig);
        container.put(Briefgeld.TIEN, aantalTien);

        return container;
    }

    public int getVoorraad() {
        return geldVoorraad;
    }
}
