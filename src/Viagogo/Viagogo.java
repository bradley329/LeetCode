package Viagogo;

import java.util.Scanner;

public class Viagogo {
  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scan = new Scanner(System.in);

    int sizeOfWorld = Integer.parseInt(scan.nextLine());
    int numberOfEvents = Integer.parseInt(scan.nextLine());
    while (numberOfEvents > 0) {
      String event = scan.nextLine();
      // TODO: you will need to parse and store the events
      numberOfEvents--;
    }

    int numberOfBuyers = Integer.parseInt(scan.nextLine());
    while (numberOfBuyers > 0) {
      String buyer = scan.nextLine();
      // TODO: you will need to parse and store the buyers
      numberOfBuyers--;
    }

    // The solution to the first sample above would be to output the following to console:
    // (Obviously, your solution will need to figure out the output and not just hard code it)
    System.out.println("2 50");
  }
}
