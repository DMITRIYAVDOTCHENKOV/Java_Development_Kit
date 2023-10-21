package lekciya2.tack2;

public class Ox implements Bull{
    @Override
    public void walk() {
        System.out.println("Walks on hooves");
    }

    @Override
    public void talc() {
        System.out.println("MooOOooOOOooOOOO");
    }
}
