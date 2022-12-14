// Falcone, Matthew
// Magic Square Problem Set
// 2022-10-27
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
        magic(grid, square);
        s.close();
    }
    public static void magic(int[][] grid, int square){
        Scanner s = new Scanner(System.in);
        for(int ctr = 0; ctr < grid.length; ctr++) {
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                System.out.println("Enter [" + ctr + "][" + ctr2 + "]");
                grid[ctr][ctr2] = s.nextInt();
            }
        }
        s.close();
        printGrid(grid);
        int[] Row = new int[square];
        int[] Column = new int[square];
        int Diagonal1 = 0;
        int Diagonal2 = 0;
        boolean hasRow = true;
        boolean hasColumn = true;
        boolean hasDiagonal1 = true;
        boolean hasDiagonal2 = true;

        // row
        for(int ctr = 0; ctr < grid.length; ctr++) {
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                Row[ctr] += grid[ctr][ctr2];
            }
        }
                            for(int ctr = 0; ctr < Row.length; ctr++) {
                                if (Row[0] != Row[ctr]) {
                                    hasRow = false;
                                }
                            }

        // column
        for(int ctr = 0; ctr < grid.length; ctr++) {
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                Column[ctr] += grid[ctr2][ctr];
            }
        }
                            for(int ctr = 0; ctr < Column.length; ctr++) {
                                if (Column[0] != Column[ctr]) {
                                    hasColumn = false;
                                }
                            }

        // diagonal 1
        for(int ctr = 0; ctr < grid.length; ctr++) {
            Diagonal1 += (grid[ctr][ctr]);
        }
                            for(int ctr = 0; ctr < Row.length; ctr++) {
                                if (Diagonal1 != Row[ctr] || Diagonal1 != Column[ctr]) {
                                    hasDiagonal1 = false;
                                }
                            }
                            
        // diagonal 2
        for(int ctr = (grid.length - 1); ctr >= 0; ctr--) {
            Diagonal2 += (grid[ctr][((grid.length-1)-ctr)]);
        }
                            for(int ctr = 0; ctr < Row.length; ctr++) {
                                if (Diagonal2 != Row[ctr] || Diagonal2 != Column[ctr]) {
                                    hasDiagonal2 = false;
                                }
                            }

        if (hasRow && hasColumn && hasDiagonal1 && hasDiagonal2) {
            System.out.println("This is a magic square");
        } else {
            System.out.println("This is NOT a magic square");
        }
    } 
}
