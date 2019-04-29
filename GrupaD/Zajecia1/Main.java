interface wyswietlanie{
    public void wyswietlInformacje();
}

@interface mojaAdnotacja{
    String nazwa() default "moja nazwa";
}

class Sala implements wyswietlanie{
    int liczbaOkien;
    int liczbaLawek;

    public Sala(int liczbaOkien, int liczbaLawek) {
        this.liczbaOkien = liczbaOkien;
        this.liczbaLawek = liczbaLawek;
    }


    @Override
    public void wyswietlInformacje() {

    }
}

@Deprecated
class SalaWykladowa extends Sala{

    int komputery;

    public SalaWykladowa(int liczbaOkien, int liczbaLawek, int komputery) {
        super(liczbaOkien, liczbaLawek);

        this.komputery = komputery;
    }

    @Override
    public void wyswietlInformacje(){
        System.out.println("Sala wykładowa");
    }

}

class Stolowka extends Sala{

    int talerze;

    public Stolowka(int liczbaOkien, int liczbaLawek, int talerze) {
        super(liczbaOkien, liczbaLawek);

        this.talerze = talerze;
    }

    @Override
    public void wyswietlInformacje(){
        System.out.println("Kuchnia");
    }


}


public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        SalaWykladowa salaWykladowa = new SalaWykladowa(4,15,10);
        salaWykladowa.wyswietlInformacje();

        Stolowka stolowka = new Stolowka(4,40,100);
        stolowka.wyswietlInformacje();
    }
}
