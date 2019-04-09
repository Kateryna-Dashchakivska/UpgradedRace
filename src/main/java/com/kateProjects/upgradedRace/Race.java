import java.util.Arrays;
import java.util.Comparator;

public class Race {

    static final int defaultTotalNumberOfCars = 10;
    static final int defaultTotalDuration = 20;
    static final int defaultTotalWinners = 3;
    static final int minNumberOfCars = 2;
    static final int minDuration = 1;

//    static int totalNumberOfCars;
//    static int totalDuration;
//    static int totalWinners;

    static int startDistance = 0;
    static RaceCar[] cars;

    public static boolean startRace(int totalNumberOfCars, int totalDuration, int totalWinners) {

        if (totalNumberOfCars < minNumberOfCars) {
            System.out.println("Error! Number of cars must be grater than or equal " + minNumberOfCars);
            return false;
        }

        if (totalDuration < minDuration){
            System.out.println("Error! Duration of the race must be grater than or equal " + minDuration);
            return false;
        }

        if (totalWinners > totalNumberOfCars) {
            System.out.println("Error! Total winners must be less than or equal total number of cars");
            return false;
        }

         cars = new RaceCar[totalNumberOfCars];
        for (int i = 0; i < totalNumberOfCars; i++) {
            RaceCar carThread = new RaceCar();
            carThread.setName("Car" + (i + 1));
            carThread.setDuration(totalDuration);
//            carThread.setDistance(startDistance);
            cars[i] = carThread;
            carThread.start();
        }

        for(int i = 0; i < totalNumberOfCars; i++) {
            try {
                cars[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        sortCarsAsc(cars);
        Arrays.sort(cars);
        printWinners(totalWinners, totalDuration);
        return true;
    }

    public static void startRace() {

        cars = new RaceCar[defaultTotalNumberOfCars];
        for (int i = 0; i < defaultTotalNumberOfCars; i++) {
            RaceCar carThread = new RaceCar();
            carThread.setName("Car" + (i + 1));
            carThread.setDuration(defaultTotalDuration);
            carThread.setDistance(startDistance);
            cars[i] = carThread;
            carThread.start();
        }

        for(int i = 0; i < defaultTotalNumberOfCars; i++) {
            try {
                cars[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        sortCarsAsc(cars);
        Arrays.sort(cars);
        printWinners(defaultTotalWinners, defaultTotalDuration);
    }

    public static void printWinners(int winners, int duration) {
        System.out.println("\nThe race is FINISHED!!!\n");
        System.out.println("Total time: " + duration + "seconds");
        System.out.println("\nTop " + winners + " WINNERS:\n");

        for (int i = 0; i < winners; i++) {
            System.out.println(cars[i].getName() + " has passed the distance: " + cars[i].getDistance() + "m!" + " It takes: " +(i + 1) + " place!");
        }
    }

//    public static RaceCar[] sortCarsAsc (RaceCar[] raceCars) {
//        Arrays.sort(raceCars, new Comparator<RaceCar>() {
//            public int compare(RaceCar car1, RaceCar car2) {
//                if (car1.getDistance() > car2.getDistance())
//                    return -1;
//                if (car1.getDistance() < car2.getDistance())
//                    return 1;
//                return 0;
//            }
//        });
//        return raceCars;
//    }
//public static RaceCar[] sortCarsAsc (RaceCar[] raceCars) {
//    Arrays.sort(raceCars);
//}
}