package Tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Grid {

  private final Cellule[][] grid;

  private Grid(Cellule[][] grid) {
    this.grid = grid;
  }

  public static Grid of(int[][] grid) {
    verifyGrid(grid);

    Cellule[][] cellules = new Cellule[9][9];
    List<List<Cellule>> rows = new ArrayList<>();
    List<List<Cellule>> colonnes = new ArrayList<>();
    List<List<Cellule>> carres = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      rows.add(new ArrayList<Cellule>());
      colonnes.add(new ArrayList<Cellule>());
      carres.add(new ArrayList<Cellule>());
    }

    Cellule lastCellule = null;
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        Cellule cellule = new Cellule(grid[row][column]);
        cellules[row][column] = cellule;

        rows.get(row).add(cellule);
        colonnes.get(column).add(cellule);
        carres.get((row / 3) * 3 + column / 3).add(cellule);

        if (lastCellule != null) {
          lastCellule.setNextCellule(cellule);
        }

        lastCellule = cellule;
      }
    }

    for (int i = 0; i < 9; i++) {
      List<Cellule> row = rows.get(i);
      for (Cellule cellule : row) {
        List<Cellule> rowNeighbors = new ArrayList<>(row);
        rowNeighbors.remove(cellule);

        cellule.setLigneVoisin(rowNeighbors);
      }

      List<Cellule> column = colonnes.get(i);
      for (Cellule cellule : column) {
        List<Cellule> columnNeighbors = new ArrayList<>(column);
        columnNeighbors.remove(cellule);

        cellule.setColonneVoisin(columnNeighbors);
      }

      List<Cellule> box = carres.get(i);
      for (Cellule cellule : box) {
        List<Cellule> boxNeighbors = new ArrayList<>(box);
        boxNeighbors.remove(cellule);

        cellule.setRegionVoisin(boxNeighbors);
      }
    }

    return new Grid(cellules);
  }


  public static Grid emptyGrid() {
    int[][] emptyGrid = new int[9][9];
    return Grid.of(emptyGrid);
  }

  private static void verifyGrid(int[][] grid) {
    if(grid == null)
      throw new IllegalArgumentException("grid must not be null");
    
    if(grid.length != 9)
      throw new IllegalArgumentException("grid must have nine rows");

    for (int[] row : grid) {
      if (row.length != 9) {
        throw new IllegalArgumentException("grid must have nine columns");
      }

      for (int value : row) {
        if (value < 0 || value > 9) {
          throw new IllegalArgumentException("grid must contain values from 0-9");
        }
      }
    }
  }


  public int getSize() {
    return grid.length;
  }


  public Cellule getCell(int row, int column) {
    return grid[row][column];
  }


  public boolean isValidValueForCell(Cellule cellule, int value) {
    return isValidInRow(cellule, value) && isValidInColumn(cellule, value) && isValidInBox(cellule, value);
  }

  private boolean isValidInRow(Cellule cellule, int value) {
    return !getRowValuesOf(cellule).contains(value);
  }

  private boolean isValidInColumn(Cellule cellule, int value) {
    return !getColumnValuesOf(cellule).contains(value);
  }

  private boolean isValidInBox(Cellule cellule, int value) {
    return !getBoxValuesOf(cellule).contains(value);
  }

  private Collection<Integer> getRowValuesOf(Cellule cellule) {
    List<Integer> rowValues = new ArrayList<>();
    for (Cellule neighbor : cellule.getLigneVoisin()) rowValues.add(neighbor.getValue());
    return rowValues;
  }

  private Collection<Integer> getColumnValuesOf(Cellule cellule) {
    List<Integer> columnValues = new ArrayList<>();
    for (Cellule neighbor : cellule.getColonneVoisin()) columnValues.add(neighbor.getValue());
    return columnValues;
  }

  private Collection<Integer> getBoxValuesOf(Cellule cellule) {
    List<Integer> boxValues = new ArrayList<>();
    for (Cellule neighbor : cellule.getRegionVoisin()) boxValues.add(neighbor.getValue());
    return boxValues;
  }


  public Optional<Cellule> getFirstEmptyCell() {
    Cellule firstCellule = grid[0][0];
    if (firstCellule.isEmpty()) {
      return Optional.of(firstCellule);
    }

    return getNextEmptyCellOf(firstCellule);
  }


  public Optional<Cellule> getNextEmptyCellOf(Cellule cellule) {
    Cellule nextEmptyCellule = null;

    while ((cellule = cellule.getNextCellule()) != null) {
      if (!cellule.isEmpty()) {
        continue;
      }

      nextEmptyCellule = cellule;
      break;
    }

    return Optional.ofNullable(nextEmptyCellule);
  }


  @Override
  public String toString() {
    return StringConverter.toString(this);
  }

  public static class Cellule {
    private int value;
    private Collection<Cellule> ligneVoisin;
    private Collection<Cellule> colonneVoisin;
    private Collection<Cellule> regionVoisin;
    private Cellule nextCellule;

    public Cellule(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public boolean isEmpty() {
      return value == 0;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Collection<Cellule> getLigneVoisin() {
      return ligneVoisin;
    }

    public void setLigneVoisin(Collection<Cellule> ligneVoisin) {
      this.ligneVoisin = ligneVoisin;
    }

    public Collection<Cellule> getColonneVoisin() {
      return colonneVoisin;
    }

    public void setColonneVoisin(Collection<Cellule> colonneVoisin) {
      this.colonneVoisin = colonneVoisin;
    }


    public Collection<Cellule> getRegionVoisin() {
      return regionVoisin;
    }


    public void setRegionVoisin(Collection<Cellule> regionVoisin) {
      this.regionVoisin = regionVoisin;
    }


    public Cellule getNextCellule() {
      return nextCellule;
    }


    public void setNextCellule(Cellule nextCellule) {
      this.nextCellule = nextCellule;
    }
  }

  private static class StringConverter {
    public static String toString(Grid grid) {
      StringBuilder builder = new StringBuilder();
      int size = grid.getSize();

      printTopBorder(builder);
      for (int row = 0; row < size; row++) {
        printRowBorder(builder);
        for (int column = 0; column < size; column++) {
          printValue(builder, grid, row, column);
          printRightColumnBorder(builder, column + 1, size);
        }
        printRowBorder(builder);
        builder.append("\n");
        printBottomRowBorder(builder, row + 1, size);
      }
      printBottomBorder(builder);

      return builder.toString();
    }

    private static void printTopBorder(StringBuilder builder) {
      builder.append("╔═══╤═══╤═══╦═══╤═══╤═══╦═══╤═══╤═══╗\n");
    }

    private static void printRowBorder(StringBuilder builder) {
      builder.append("║");
    }

    private static void printValue(StringBuilder builder, Grid grid, int row, int column) {
      int value = grid.getCell(row, column).getValue();
      String output = value != 0 ? String.valueOf(value) : " ";
      builder.append(" " + output + " ");
    }

    private static void printRightColumnBorder(StringBuilder builder, int column, int size) {
      if (column == size) {
        return;
      }

      if (column % 3 == 0) {
        builder.append("║");
      } else {
        builder.append("│");
      }
    }

    private static void printBottomRowBorder(StringBuilder builder, int row, int size) {
      if (row == size) {
        return;
      }

      if (row % 3 == 0) {
        builder.append("╠═══╪═══╪═══╬═══╪═══╪═══╬═══╪═══╪═══╣\n");
      } else {
        builder.append("╟───┼───┼───╫───┼───┼───╫───┼───┼───╢\n");
      }
    }

    private static void printBottomBorder(StringBuilder builder) {
      builder.append("╚═══╧═══╧═══╩═══╧═══╧═══╩═══╧═══╧═══╝\n");
    }
  }
}
