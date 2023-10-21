package lekciya2.tack2;

public class Main {
    private static class Minotaurus implements Human, Bull {

        @Override
        public void walk() {
            System.out.println("Walks on two legs");
        }

        @Override
        public void talc() {
            System.out.println("Asks you a riddle");
        }
    }

    public static void main(String[] args) {
        Bull minos1 = new Minotaurus();
        Human minos2 = new Minotaurus();
        Minotaurus minos = new Minotaurus();
        Man man1 = new Man();
        Ox ox1 = new Ox();
        Human man2 = new Man();
        Bull ox2 = new Ox();
    }
}
