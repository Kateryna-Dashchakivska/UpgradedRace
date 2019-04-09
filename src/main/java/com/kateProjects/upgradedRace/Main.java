public class Main {


    public static void main(String[] args) {

        if (Race.startRace(15, 0, 5)){
            System.out.println("Race started successful.");
        } else {
            System.out.println("Race cannot be started. /n");
        }
    }
}
