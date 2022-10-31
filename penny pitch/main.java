// Falcone, Matthew 
// 2022-10-31 (HALLOWEEN)
import java.util.Random;
class Main {
    public static void printGrid(int[][] grid) {
        for(int ctr = 0; ctr < grid.length; ctr++) {
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                System.out.print(grid[ctr][ctr2] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
      }
    public static void main(String[] args) {
        int[][] grid = 
        {{1, 1, 1, 1, 1},
         {1, 2, 2, 2, 1},
         {1, 2, 3, 2, 1},
         {1, 2, 2, 2, 1},
         {1, 1, 1, 1, 1}};
        printGrid(grid);
        int playerScore = 0;
        int cpuScore = 0;

        int numOfTosses = 2; // specify how many tosses each player gets

        for (int ctr = 0; ctr < numOfTosses; ctr++) {
            playerScore += toss(grid);
            cpuScore += toss(grid);
        }
        System.out.println("Player Score: " + playerScore);
        System.out.println("Computer Score: " + cpuScore);
        if (playerScore > cpuScore) {
            System.out.println("Player wins");
        } else if (playerScore < cpuScore) {
            System.out.println("Computer wins");
        } else if (playerScore == cpuScore) {
            System.out.println("Tie");
        }
    }
    private static int toss(int[][] grid) {
        Random r = new Random();
        return grid[r.nextInt(5)][r.nextInt(5)];
    }
}