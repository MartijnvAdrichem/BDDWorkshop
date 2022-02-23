import betalen.Briefgeld;
import betalen.GeldAutomaat;
import betalen.Rekening;
import io.cucumber.java.Before;
import io.cucumber.java.nl.Als;
import io.cucumber.java.nl.Dan;
import io.cucumber.java.nl.En;
import io.cucumber.java.nl.Gegeven;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GeldOpnemenSteps {

    private GeldOpnemenContext context;

    @Before
    public void Before() {
        context = new GeldOpnemenContext();
    }

    @Gegeven("een rekening met een saldo van {int} euro en een pincode van {int}")
    public void eenRekeningMetEenSaldoVanEuroEnEenPincodeVan(int saldo, int pincode) {
        context.rekening = new Rekening(pincode, saldo);
    }


    @Gegeven("een geldautomaat met een voorraad van {int} euro")
    public void eenGeldautomaatMetEenVoorraadVanEuro(int bedrag) {
        context.geldAutomaat = new GeldAutomaat(bedrag);
    }


    @Als("de klant {int} euro opneemt bij de geldautomaat en pincode {int} invoert")
    public void deKlantBedragEuroOpneemtBijDeGeldautomaatEnPincodeInvoert(int bedrag, int pincode) {

        var rekening = context.rekening;
        var geldAutomaat = context.geldAutomaat;

        context.resultaat = geldAutomaat.neemGeldOp(rekening, bedrag, pincode);
    }

    @Dan("krijgt de klant de volgende briefjes geld:")
    public void krijgtDeKlantDeVolgendeBriefjesGeld(Map<String, Integer> briefjes) {

        var gekregenBriefjes = context.resultaat.getOntvangenBriefjes();

        Assert.assertEquals(briefjes.get("briefjesVan10"), gekregenBriefjes.get(Briefgeld.TIEN));
        Assert.assertEquals(briefjes.get("briefjesVan20"), gekregenBriefjes.get(Briefgeld.TWINTIG));
        Assert.assertEquals(briefjes.get("briefjesVan50"), gekregenBriefjes.get(Briefgeld.VIJFTIG));

    }

    @Dan("wordt de foutmelding {string} getoond")
    public void wordtDeFoutmeldingGetoond(String foutmelding) {
       Assert.assertEquals(foutmelding, context.resultaat.getFoutmelding());
    }
}
