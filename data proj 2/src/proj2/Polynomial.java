package proj2;

public class Polynomial {

    private Node firstNode;

    // constructor
    public Polynomial(){
        firstNode = null;
    }

    // copy constructor
    Polynomial(Polynomial otherPoly){
        this.firstNode = null;
        Node currentNode = otherPoly.firstNode;

        while (currentNode != null) {
            insert(currentNode.getCoefficient(), currentNode.getExponent());
            currentNode = currentNode.getNextNode();
        }
    }

    Polynomial(String poly){
        int coefficient;
        int exponent;
        // split string into sections on + sign
        String[] parts = poly.split("\\+");
        for (String part : parts) {
            part = part.trim();
            //get integer and coefficient from each section of the string
            if(part.startsWith("x^")){
                String[] firstSection = part.split("x\\^");
                coefficient = Integer.parseInt(firstSection[0]);
                exponent = Integer.parseInt(firstSection[1]);
            } else if(part.startsWith("x")){
                String[] secondSection = part.split("x");
                coefficient = Integer.parseInt(secondSection[0]);
                exponent = 1;
            } else {
                coefficient = Integer.parseInt(part);
                exponent = 0;
            }
            insert(coefficient, exponent);
        }
    }

    public void print(){
        System.out.println(this);
    }

    // insert
    public void insert(int coefficient, int exponent){
        //create new node
        Node newNode = new Node(coefficient, exponent);
        // if list is empty or has a smaller exponent at the first node, insert at the beginning
        // maintain descending order of exponents while inserting nodes
        if(firstNode == null || firstNode.getExponent() < exponent){
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            // go through the list until the next node exponent is the same or less than the new exponent
            while (currentNode.getNextNode() != null && currentNode.getNextNode().getExponent() > exponent) {
                currentNode = currentNode.getNextNode();
            }
            // if the exponents are the same, add the coefficients together
            if (currentNode.getNextNode() != null && currentNode.getNextNode().getExponent() == exponent){
                currentNode.getNextNode().setCoefficient(currentNode.getNextNode().getCoefficient() + coefficient);
            } else {
                // if no similar node exists, new node is inserted between current and next node
                newNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(newNode);
            }
        }
    }

    // add
    public static Polynomial add(Polynomial poly1, Polynomial poly2){
        //create poly to store the sum
        Polynomial newPoly = new Polynomial();
        Node p1 = poly1.firstNode;
        Node p2 = poly2.firstNode;

        while (p1 != null || p2 != null){
            // if p1 is null, add remaining terms from p2
            if(p1 == null){
                newPoly.insert(p2.getCoefficient(), p2.getExponent());
                p2 = p2.getNextNode();
            } else if (p2 == null){
                // if p2 is null, add remaining terms from p1
                newPoly.insert(p1.getCoefficient(), p1.getExponent());
                p1 = p1.getNextNode();
            } else if (p1.getExponent() > p2.getExponent()){
                // compare exponents to maintain descending order
                newPoly.insert(p1.getCoefficient(), p1.getExponent());
                p1 = p1.getNextNode();
            } else if(p1.getExponent() < p2.getExponent()){
                // compare exponents to maintain descending order
                newPoly.insert(p2.getCoefficient(), p2.getExponent());
                p2 = p2.getNextNode();
            } else {
                // if both terms have the same exponent, combine them and add to new poly
                newPoly.insert(p1.getCoefficient() + p2.getCoefficient(), p1.getExponent());
                p1 = p1.getNextNode();
                p2 = p2.getNextNode();
            }
        }
        return newPoly;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // start from the beginning of the linked list
        Node currentNode = firstNode;
        // run until all the nodes are processed
        while (currentNode != null){
            if (currentNode.getExponent() > 1){
                // if there is an exponent, format it with x^
                sb.append(currentNode.getCoefficient()).append("x^").append(currentNode.getExponent());
            } else if (currentNode.getExponent() == 1){
                // if exponent is equal to 1, just add the coefficient and x
                sb.append(currentNode.getCoefficient()).append("x");
            } else {
                // if no exponent, just add the coefficient
                sb.append(currentNode.getCoefficient());
            }
            // add plus sign between terms
            if (currentNode.getNextNode() != null){
                sb.append(" + ");
            }
            // move to the next node
            currentNode = currentNode.getNextNode();
        }
        return sb.toString();
    }
}
