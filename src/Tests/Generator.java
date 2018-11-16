package Tests;

import java.util.Random;

/**
 * A Generator to generate random Sudoku {@link Grid} instances.
 */
public class Generator {
  private Solver solver;

  /**
   * Constructs a new Generator instance.
   */
  public Generator() {
    this.solver = new Solver();
  }

  /**
   * Generates a random {@link Grid} instance with the given number of empty {@link Grid.Cellule}s.
   * <br><br>
   * Note: The complexity for a human player increases with an higher amount of empty {@link Grid.Cellule}s.
   * @param numberOfEmptyCells the number of empty {@link Grid.Cellule}s
   * @return a randomly filled Sudoku {@link Grid} with the given number of empty {@link Grid.Cellule}s
   */
  public Grid generate(int numberOfEmptyCells) {
    Grid grid = generate();

    eraseCells(grid, numberOfEmptyCells);

    return grid;
  }

  private void eraseCells(Grid grid, int numberOfEmptyCells) {
    Random random = new Random();
    for (int i = 0; i < numberOfEmptyCells; i++) {
      int randomRow = random.nextInt(9);
      int randomColumn = random.nextInt(9);

      Grid.Cellule cellule = grid.getCell(randomRow, randomColumn);
      if (!cellule.isEmpty()) {
        cellule.setValue(0);
      } else {
        i--;
      }
    }
  }

  private Grid generate() {
    Grid grid = Grid.emptyGrid();

    solver.solve(grid);

    return grid;
  }
}
