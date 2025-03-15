package proj2;

public class Polynomial {

    private Node firstNode;

    // constructor
    public Polynomial(){
        firstNode = null;
    }


    // copy constructor
    Polynomial(Polynomial otherPoly){
        Node walker = otherPoly.firstNode;

        while (walker != null) {
            add(walker.getCoefficient(), walker.getExponent());
            walker = walker.getNextNode();
        }
    }

    Polynomial(String poly){


    }

    public void print(){
        Node walker = firstNode;

        while (walker != null){
            System.out.println(walker.getCoefficient() + " " + walker.getExponent());
            walker = walker.getNextNode();

        }
    }

    // add
    public void add(int poly1, int poly2){
        // create new node
        Node newNode = new Node(poly1, poly2, firstNode);

        // link nodes together
        firstNode = newNode;
    }


}
