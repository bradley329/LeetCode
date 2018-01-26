

class parent {
    private int a;
    parent(int a) {
        this.a = a;
    }

    void sayHello() {
        System.out.println("parent say hello to you!");
    }
}

class child extends parent {
    child(int a) {
        super(a);
    }

    @Override
    void sayHello() {
        System.out.println("child say hello to you!");
    }
}

public class Main {
    public static void main(String[] args) {
//        List<Integer> ll = new ArrayList<>();
//        ll.add(3);
//        System.out.println(ll.get(0));
//        System.out.println("Hello World!");
        parent obj = new child(3);
        obj.sayHello();
    }
}
