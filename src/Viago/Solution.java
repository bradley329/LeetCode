package Viago;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * This is the Buyer class.
 * 
 * @author Lei Guo
 *
 */
class Buyer {
  int x, y;

  public Buyer(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


/**
 * This is the Event class.
 * 
 * @author Lei Guo
 *
 */
class Event {
  int id;
  int x, y;
  List<Integer> tickets;

  /**
   * Constructor for Event.
   * 
   * @param id
   * @param x
   * @param y
   */
  public Event(int id, int x, int y) {
    this.id = id;
    this.x = x;
    this.y = y;
    tickets = new ArrayList<>();
  }

  public void addTicket(int price) {
    tickets.add(price);
  }

  public void sortTickets() {
    Collections.sort(tickets);
  }

  public boolean isEmpty() {
    return tickets.isEmpty();
  }

  public int getMinTicket() {
    return tickets.get(0);
  }

  public int removeMinTicket() {
    return tickets.remove(0);
  }
}


/**
 * I think this is the key point of my code.
 * 
 * @author Lei Guo
 *
 */
class EventComparator implements Comparator<Event> {

  private int targetX;
  private int targetY;

  /**
   * If we are provided with the Target (the buyer), we could compute which Event is better.
   * 
   * @param targetX
   * @param targetY
   */
  public EventComparator(int targetX, int targetY) {
    this.targetX = targetX;
    this.targetY = targetY;
  }

  private int distance(int x1, int x2, int y1, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  @Override
  public int compare(Event a, Event b) {
    int distanceA = distance(a.x, targetX, a.y, targetY);
    int distanceB = distance(b.x, targetX, b.y, targetY);
    if (a.isEmpty() && b.isEmpty()) {
      return distanceA - distanceB;
    } else if (a.isEmpty()) {
      return 1;
    } else if (b.isEmpty()) {
      return -1;
    } else if (distanceA != distanceB) {
      return distanceA - distanceB;
    } else {
      int minPriceA = a.getMinTicket();
      int minPriceB = b.getMinTicket();
      if (minPriceA != minPriceB) {
        return minPriceA - minPriceB;
      } else {
        return a.id - b.id;
      }
    }
  }
}


/**
 * In this test, I used the Eclipse IDE since i was afraid that I could not finish it on time.
 * Thanks for you understanding!
 * 
 * @author Lei Guo
 *
 */
public class Solution {
  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scan = new Scanner(System.in);

    int sizeOfWorld = Integer.parseInt(scan.nextLine());
    int numberOfEvents = Integer.parseInt(scan.nextLine());
    List<Event> events = new ArrayList<>();
    while (numberOfEvents > 0) {
      String event = scan.nextLine();
      // TODO: you will need to parse and store the events
      String[] strings = event.split(" ");
      int id = Integer.parseInt(strings[0]);
      int x = Integer.parseInt(strings[1]);
      int y = Integer.parseInt(strings[2]);
      Event e = new Event(id, x, y);
      int priceTemp = 0;
      for (int i = 3; i < strings.length; i++) {
        priceTemp = Integer.parseInt(strings[i]);
        e.addTicket(priceTemp);
      }
      e.sortTickets(); // sort tickets for further retrieving minimum value;
      events.add(e);
      numberOfEvents--;
    }

    List<Buyer> buyers = new ArrayList<>();
    int numberOfBuyers = Integer.parseInt(scan.nextLine());
    while (numberOfBuyers > 0) {
      String buyer = scan.nextLine();
      // TODO: you will need to parse and store the buyers
      String[] strings = buyer.split(" ");
      int x = Integer.parseInt(strings[0]);
      int y = Integer.parseInt(strings[1]);
      Buyer b = new Buyer(x, y);
      buyers.add(b);
      numberOfBuyers--;
    }
    // The solution to the first sample above would be to output the following to console:
    // (Obviously, your solution will need to figure out the output and not just hard code it)

    // I noticed that the number of events could be zero, then for every buyer, there is no event
    // available.
    if (events.size() == 0) {
      for (int i = 0; i < buyers.size(); i++) {
        System.out.println("-1 0");
      }
    } else {
      for (Buyer buyer : buyers) {
        // this may could be improved since I sort the events each time it changed.
        Collections.sort(events, new EventComparator(buyer.x, buyer.y));
        Event event = events.get(0);
        if (event.isEmpty()) {
          System.out.println("-1 0");
        } else {
          int id = event.id;
          int min = event.getMinTicket();
          event.removeMinTicket();
          System.out.println(id + " " + min);
        }
      }
    }
    scan.close();
  }
}
