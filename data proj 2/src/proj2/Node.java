package proj2;

public class Node {

    private int coefficient;
    private int exponent;
    private Node nextNode;

    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.nextNode = null;
    }

    public Node(int coefficient, int exponent, Node nextNode) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.nextNode = nextNode;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getExponent(){
        return exponent;
    }

    public void setNextNode(Node next){
        this.nextNode = next;
    }

    public Node getNextNode() {
        return nextNode;
    }

    // find out if we are at the end of the linked list
    public boolean isLastElement(){
        return this.nextNode == null;
    }

//    public String toString(){
//        if(this.exponent == 0){
//            return
//        }
//    }
}
