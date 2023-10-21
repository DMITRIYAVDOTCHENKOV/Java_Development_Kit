package lekciya2.tack2;

public class Man implements Human {


    @Override
    public void walk() {
        System.out.println("Walks on two feet");
    }

    @Override
    public void talc() {
        System.out.println("Talks meaningful words");
    }
}
