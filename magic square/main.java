import java.util.*;
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
        Scanner s = new Scanner(System.in);
        System.out.println("Enter square (e.g. 4 for a 4x4 grid)");
        int square = s.nextInt();
        int[][] grid = new int[square][square];
        magic(grid);
    }
    public static void magic(int[][] grid, int targetSum) {
        Scanner s = new Scanner(System.in);
        for(int ctr = 0; ctr < grid.length; ctr++) {
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                System.out.println("Enter [" + ctr + "][" + ctr2 + "]");
                grid[ctr][ctr2] = s.nextInt();
            }
        }
        printGrid(grid);
        int sum;
        int targetSum;
        // declaring our parameters
        boolean hasRow = false;
        boolean hasColumn = false; 
        boolean hasDiagonal1 = false; 
        boolean hasDiagonal2 = false;

        // find out if sums of all rows is targetSum
        for(int ctr = 0; ctr < grid.length; ctr++) {
            sum = 0;
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                sum += grid[ctr][ctr2];
                targetSum += grid[ctr][ctr2];
            }
        }
        // find out if sums of all columns is targetSum
        for(int ctr = 0; ctr < grid.length; ctr++) {
            sum = 0;
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                sum += grid[ctr2][ctr];
            }
            if (sum == targetSum) {
                hasColumn = true;
            } else if (sum != targetSum) {
                hasColumn = false;
                break;
            }
        }
        // find out if sums of all diagonals is targetSum
        sum = 0;
        for(int ctr = 0; ctr < grid.length; ctr++) {
            sum += (grid[ctr][ctr]);
        }
        if (sum == targetSum) {
            hasDiagonal1 = true;
        } else if (sum != targetSum) {
            hasDiagonal1 = false; 
        }
        sum = 0;
        for(int ctr = (grid.length - 1); ctr >= 0; ctr--) {
            sum += (grid[ctr][((grid.length-1)-ctr)]);
        }
        if (sum == targetSum) {
            hasDiagonal2 = true;
        } else if (sum != targetSum) {
            hasDiagonal2 = false; 
        }
        
        if (hasRow && hasColumn && hasDiagonal1 && hasDiagonal2) {
            System.out.println("This is a magic square");
        } else {
            System.out.println("This is NOT a magic square");
        }
    } 
}
