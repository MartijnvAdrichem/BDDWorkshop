package calculator;

public class Rekenmachine {

    RekenmachineModus rekenmachineModus;

    public Rekenmachine(RekenmachineModus rekenmachineModus) {
        this.rekenmachineModus = rekenmachineModus;
    }

    public int Calculate(int a, int b) {
        if (rekenmachineModus == RekenmachineModus.PLUS) {
            return a + b;
        }

        if (rekenmachineModus == RekenmachineModus.KEER)
        {
            return a * b;
        }

        return 0;
    }

}
