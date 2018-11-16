package Tests;

import java.util.Optional;
import java.util.Random;

public class Solver {
  private static final int EMPTY = 0;
  
  private final int[] values;

  public Solver() {
    this.values = generateRandomValues();
  }


  public void solve(Grid grid) {
    boolean solvable = solve(grid, grid.getFirstEmptyCell());

    if (!solvable) {
      throw new IllegalStateException("The provided grid is not solvable.");
    }
  }

  private boolean solve(Grid grid, Optional<Grid.Cellule> cell) {
    if (!cell.isPresent()) {
      return true;
    }

    for (int value : values) {
      if (grid.isValidValueForCell(cell.get(), value)) {
        cell.get().setValue(value);
        if (solve(grid, grid.getNextEmptyCellOf(cell.get()))) return true;
        cell.get().setValue(EMPTY);
      }
    }

    return false;
  }

  private int[] generateRandomValues() {
    int[] values = { EMPTY, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    Random random = new Random();
    for (int i = 0, j = random.nextInt(9), tmp = values[j]; i < values.length;
        i++, j = random.nextInt(9), tmp = values[j]) {
      if(i == j) continue;
      
      values[j] = values[i];
      values[i] = tmp;
    }

    return values;
  }
}
