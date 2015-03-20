package Perfomance;

public class Perfomance {

    public static void main(String[] args) {
        // Declaration variables
        double groundRoll, totalToClear, headwind = 0, tailwind = 0, runwayConditionIncrease;
        char windDirection, runwayCondition;

        // Lecture des donnees
        System.out.println("*** Takeoff perfomance calculator ***");

        do {
            System.out.print("Please enter the ground roll distance: ");
            groundRoll = Clavier.lireInt();
        } while (groundRoll <= 0);

        do {
            System.out.print("Please enter total to clear 50 ft distance: ");
            totalToClear = Clavier.lireInt();
        } while (totalToClear <= 0);

        do {
            System.out.print("Headwind or tailwind Captain ? (H for Headwind / T for tailwinds): ");
            windDirection = Clavier.lireChar();
        } while (windDirection != 'H' && windDirection != 'h' && windDirection != 'T' && windDirection != 't');

        System.out.print("Wind speed please: ");
        if (windDirection == 'H') {
            headwind = Clavier.lireInt();
        } else if (windDirection == 'T') {
            tailwind = Clavier.lireInt();
        }

        do {
            System.out.print("Runway conditon please ( Grass(G) / Dry(D) / Grass and Dry (B) ): ");
            runwayCondition = Clavier.lireChar();
        } while (runwayCondition != 'G' && runwayCondition != 'g'
                && runwayCondition != 'D' && runwayCondition != 'd'
                && runwayCondition != 'B' && runwayCondition != 'b');

        // Traitement des donnees
        if ((windDirection == 'H' || windDirection == 'h') && (headwind >= 9)) {
            for (int h = 0; h < headwind; h += 9) {
                groundRoll = groundRoll - (groundRoll * 0.1);
                totalToClear = totalToClear - (totalToClear * 0.1);
            }
        } else if ((windDirection == 'T' || windDirection == 't') && (tailwind >= 10)) {
            for (int t = 0; t < tailwind; t += 2) {
                groundRoll = groundRoll - (groundRoll * 0.1);
                totalToClear = totalToClear - (totalToClear * 0.1);
            }
        }

        if (runwayCondition != 'G' || runwayCondition != 'g'
                || runwayCondition != 'D' || runwayCondition != 'd'
                || runwayCondition != 'B' || runwayCondition != 'b') {
            runwayConditionIncrease = groundRoll * 0.15;
            groundRoll = groundRoll + runwayConditionIncrease;
            totalToClear = totalToClear + runwayConditionIncrease;
        }

        // Affichage des resultats
        System.out.println("GroundRoll -> " + groundRoll);
        System.out.println("totalToClear -> " + totalToClear);
    }
}
