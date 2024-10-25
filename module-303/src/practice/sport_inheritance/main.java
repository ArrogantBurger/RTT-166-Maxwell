package practice.sport_inheritance;

public class main {
    public static void main(String[] args) {
        Sport team1 = new Cricket();
        Sport team2 = new Football();

        int[] team1_age = {22, 23, 25, 24, 25, 27, 19, 18, 21, 21, 23};
        int[] team2_age = {25, 24, 23, 22, 25, 19, 19, 25, 26, 25, 26};

        team1.calculateAvgAge(team1_age);
        team2.calculateAvgAge(team2_age);
    }
}
