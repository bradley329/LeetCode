import java.util.ArrayList;
import java.util.List;

class Parent {
  private int a;

  Parent(int a) {
    this.a = a;
  }

  void sayHello() {
    System.out.println("parent say hello to you!");
  }

  @Override
  public String toString() {
    return Integer.toString(a);
  }
}


class Child extends Parent {
  Child(int a) {
    super(a);
  }

  @Override
  void sayHello() {
    System.out.println("child say hello to you!");
  }
}


public class Main {
  @SuppressWarnings("unused")
  public static void main(String[] args) {
    // List<Integer> ll = new ArrayList<>();
    // ll.add(3);
    // System.out.println(ll.get(0));
    // System.out.println("Hello World!");
    // parent obj = new child(3);
    // // obj.sayHello();
    // String string = null;
    // if (string == null) {
    // System.out.println("shi null");
    // }
    List<Parent> parents = new ArrayList<>();
    parents.add(new Parent(2));
    parents.add(new Parent(3));
    parents.add(new Parent(5));
    System.out.println(parents);
  }
}
