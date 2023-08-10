import java.util.Arrays;
class Main {

    public static int[] nationalTeam(int[][] teams) {
        int[] nationalTeam;

        nationalTeam = teams[0];
        for (int i = 1; i < teams.length; i++) {
            nationalTeam = merge(nationalTeam, teams[i]);
        }
        return nationalTeam;
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] a3 = new int[10];

        int i = 0, j = 0;
        for (int k = 0; k < a3.length; k++) {

            if (i > a1.length - 1) {
                int a = a2[j];
                a3[k] = a;
                j++;
            } else if (j > a2.length - 1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else if (a1[i] > a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            } else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }
        }
        return a3;
    }

    public static void main(String[] args) {

        int[] team1 = new int[] { 45, 31, 24, 22, 20, 17, 14, 13, 12, 10 };
        int[] team2 = new int[] { 31, 18, 15, 12, 10, 8, 6, 4, 2, 1 };
        int[] team3 = new int[] { 51, 30, 10, 9, 8, 7, 6, 5, 2, 1 };
        int[][] regionalTeams = new int[][] { team1, team2, team3 };
        int[] result = nationalTeam(regionalTeams);
        System.out.println(Arrays.toString(result));
    }
}