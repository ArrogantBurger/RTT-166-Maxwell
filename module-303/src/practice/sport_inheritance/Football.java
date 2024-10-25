package practice.sport_inheritance;

public class Football implements Sport{

    public int[] playerIDs;

    public Football(){
        playerIDs = new int[11];
        for (int i = 0; i < playerIDs.length; i++){
            playerIDs[i] = 1;
        }
        System.out.println("A new football team has been formed.");
    }

    @Override
    public void calculateAvgAge(int[] age) {
        double totalAge = 0;
        for (int i = 0; i < age.length; i++){
            totalAge += age[i];
        }
        double averageAge = totalAge / age.length;
        System.out.print("The average age of the team is ");
        System.out.printf("%.2f\n", averageAge);
    }

    @Override
    public void retirePlayer(int id) {
        if (playerIDs[id] == 1){
            playerIDs[id] = -1;
            System.out.println("Player with id: "  + id + " has retired.");
        } else if (playerIDs[id] == -1){
            System.out.println("Player has already retired.");
        } else {
            System.out.println("Invalid retirement.");
        }
    }

    void playerTransfer(int fee, int id) {
        if (playerIDs[id] == 1){
            playerIDs[id] = -1;
            System.out.println("Player with id: "  + id + " has transferred with a fee of " + fee + ".");
        }
    }
}
