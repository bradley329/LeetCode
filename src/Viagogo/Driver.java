package Viagogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SortbyManDistToTarget implements Comparator<Coordinate> {

  private Coordinate target;

  public SortbyManDistToTarget(Coordinate target) {
    this.target = target;
  }

  @Override
  public int compare(Coordinate a, Coordinate b) {
    return Coordinate.distance(a, target) - Coordinate.distance(b, target);
  }

}


public class Driver {
  private static Map<Coordinate, Event> generateEvents() {
    Map<Coordinate, Event> coordToEvents = new HashMap<Coordinate, Event>();
    // assume event count in the range 1-100
    int eventCount = (int) (Math.random() * 100) + 1;

    for (int i = 0; i < eventCount; i++) {
      Coordinate coordinate;
      int x = 0;
      int y = 0;

      do {
        x = (int) (Math.random() * 20) - 10;
        y = (int) (Math.random() * 20) - 10;
        coordinate = new Coordinate(x, y);
      } while (coordToEvents.containsKey(coordinate));
      coordToEvents.put(coordinate, new Event(coordinate));
    }

    return coordToEvents;
  }

  private static Coordinate parseInput() {
    Coordinate coordinate = null;
    try (Scanner scan = new Scanner(System.in)) {
      String str;
      while (scan.hasNextLine() && !((str = scan.nextLine().trim()).equals("exit"))) {
        String[] s = str.split(",");
        if (s.length != 2) {
          System.err.println("Please give coordinates with x and y.");
          System.exit(1);
        }

        int x = 100;
        int y = 100;
        try {
          x = Integer.parseInt(s[0]);
          y = Integer.parseInt(s[1]);
        } catch (NumberFormatException e) {
          System.err.println("Caught NumberFormatException: ");
          System.err.println(e);
          System.exit(1);
        }

        if (x > 10 || x < -10 || y > 10 || y < -10) {
          System.err.println("Coordinates should be in the range of (-10, 10).");
          System.exit(1);
        }
        coordinate = new Coordinate(x, y);
        return coordinate;
      }
    }

    System.err.println("Invalid coordinates, exiting...");
    System.exit(1);
    return null;
  }

  public static void main(String[] args) {
    System.out.println("Generating random number of events...");
    Map<Coordinate, Event> coordToEvents = generateEvents();
    System.out.println("Please input coordinates in range (-10, 10), delimited with ','");
    Coordinate target = parseInput();
    List<Coordinate> coordinates = new ArrayList<>(coordToEvents.size());
    for (Coordinate coordinate : coordToEvents.keySet()) {
      coordinates.add(coordinate);
    }
    Collections.sort(coordinates, new SortbyManDistToTarget(target));
    int closestEventCount = 5;
    for (Coordinate coordinate : coordinates) {
      if (closestEventCount > 0) {
        Event event = coordToEvents.get(coordinate);
        System.out.println(
            event.toString() + ", Manhatta Distance: " + Coordinate.distance(target, coordinate));
        closestEventCount--;
      } else {
        break;
      }
    }
    System.exit(0);
  }
}
