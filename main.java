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
        {{16, 3, 2, 13},
         {5, 10, 11, 8}, 
         {9, 6, 7, 12},
         {4, 15, 14, 1}};
        printGrid(grid);
        int sum;
        // declaring our parameters
        boolean hasRow = false;
        boolean hasColumn = false; 
        boolean hasDiagonal = false; 

        // find out if sums of all rows is 34
        for(int ctr = 0; ctr < grid.length; ctr++) {
            sum = 0;
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                sum += grid[ctr2][ctr];
            }
            if (sum == 34) {
                hasRow = true;
            } else if (sum != 34) {
                hasRow = false;
                break;
            }
        }
        System.out.println(hasRow);

        // find out if sums of all columns is 34
        for(int ctr = 0; ctr < grid.length; ctr++) {
            sum = 0;
            for(int ctr2 = 0; ctr2 < grid.length; ctr2++) {
                sum += grid[ctr][ctr2];
            }
            if (sum == 34) {
                hasColumn = true;
            } else if (sum != 34) {
                hasColumn = false;
                break;
            }
        }
        System.out.println(hasColumn);
        sum = 0;
        // find out if sums of all diagonals is 34
        for(int ctr = 0; ctr < grid.length; ctr++) {
            sum += (grid[ctr][ctr]);
        }
        
        System.out.println(sum);
    }

    
}