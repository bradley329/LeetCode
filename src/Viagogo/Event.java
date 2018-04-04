package Viagogo;

import java.util.ArrayList;
import java.util.List;

/**
 * The Event model
 * 
 * @author Bradley
 *
 */
public class Event {
  // assume number of events would not exceed Integer.MAX_VALUE
  private static int nextId = 0;
  private int id;
  private Coordinate location;
  // assume each event has ticket count in range 0-100
  private int ticketsCount;
  // assume ticket price in range 5-100
  private double cheapestTicketPrice = -1.0;
  private List<Double> tickets;

  public Event(Coordinate loc) {
    id = nextId++;
    location = loc;
    ticketsCount = (int) (Math.random() * 100);
    tickets = new ArrayList<>(ticketsCount);
    generateRandomTickets();
  }

  private void generateRandomTickets() {
    for (int i = 0; i < ticketsCount; i++) {
      double price = 5 + Math.random() * 95;
      tickets.add(price);
      if (cheapestTicketPrice < 0 || price < cheapestTicketPrice) {
        cheapestTicketPrice = price;
      }
    }
  }

  @Override
  public String toString() {
    return "Event: " + id + ", and cheapest ticket value is: $" + cheapestTicketPrice;
  }
}
