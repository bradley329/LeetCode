package Viagogo;

/**
 * The Coordinate model
 * 
 * @author Bradley
 *
 */
public class Coordinate {
  private int x;
  private int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static int distance(Coordinate c1, Coordinate c2) {
    return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + x;
    result = 31 * result + y;
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (other == null) {
      return false;
    }

    if (getClass() != other.getClass()) {
      return false;
    }

    Coordinate otherCoordinate = (Coordinate) other;
    return x == otherCoordinate.x && y == otherCoordinate.y;
  }
}
