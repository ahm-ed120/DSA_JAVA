class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List{
    Node head;
    Node tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void InsertAtBeginning(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void insertAtEnd(int data){
        Node newNode = new Node (data);
        if (tail == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void insertAfterNode(int key, int data){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node newNode = new Node (data);
        Node current = head;

        while (true) {
            if (current.data == key) {
                newNode.next = current.next;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
                break;
            } else if (current.next == head){
                System.out.println("Node with value " + key + " not found");
                break;
            }
            current = current.next;

        }
    }

    public void insertBeforeNode(int key, int data){
        if (head == null){
            System.out.println("List is empty");
            return;
        }

        Node newNode = new Node (data);
        Node current = head;
        Node previous = null;

        while (true) {
            if (current.data == key) {
                if (previous == null) { 
                    newNode.next = head;
                    head = newNode;
                    tail.next = head; 
                } else {
                    newNode.next = current;
                    previous.next = newNode;
                }
                break;
            } else if (current.next == head) {
                System.out.println("Node with value " + key + " not found");
                break;
            }
            previous = current;
            current = current.next;
        }
    }

    public void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        Node previous = null;

        while (true) { 
            if (current.data == key) {
                if (previous == null){
                    if (head == tail) {
                        head = null;
                        tail = null;
                    } else {
                        head = current.next;
                        tail.next = head;
                    }
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }   
                }
                System.out.println("Node with value " + key + " deleted");
                break;
            } else if (current.next == head) {
                System.out.println("Node with value " + key + " not found");
                break;
            }
            previous = current;
            current = current.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }
}

public class CircularLinkedList{
    public static void main(String[] args) {
        List list = new List();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;
        do {
            System.out.println("\nCircular Linked List Menu:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After Node");
            System.out.println("4. Insert Before Node");
            System.out.println("5. Delete Node");
            System.out.println("6. Display List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
            case 1:
                System.out.print("Enter value to insert at beginning: ");
                int valBeg = scanner.nextInt();
                list.InsertAtBeginning(valBeg);
                break;
            case 2:
                System.out.print("Enter value to insert at end: ");
                int valEnd = scanner.nextInt();
                list.insertAtEnd(valEnd);
                break;
            case 3:
                System.out.print("Enter key after which to insert: ");
                int keyAfter = scanner.nextInt();
                System.out.print("Enter value to insert: ");
                int valAfter = scanner.nextInt();
                list.insertAfterNode(keyAfter, valAfter);
                break;
            case 4:
                System.out.print("Enter key before which to insert: ");
                int keyBefore = scanner.nextInt();
                System.out.print("Enter value to insert: ");
                int valBefore = scanner.nextInt();
                list.insertBeforeNode(keyBefore, valBefore);
                break;
            case 5:
                System.out.print("Enter value to delete: ");
                int delVal = scanner.nextInt();
                list.deleteNode(delVal);
                break;
            case 6:
                list.display();
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
       
        
    }
}