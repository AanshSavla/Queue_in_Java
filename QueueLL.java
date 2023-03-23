import java.util.*;
class QueueLL{
    Node front,rear;
    class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }
    void enqueue(int val){
        Node newnode = new Node(val);
        if(front == null && rear == null){
            front = newnode;
            rear = newnode;
        }
        else{
            rear.next = newnode;
            rear = newnode;
        }
    }
    void dequeue(){
        if(front == null && rear == null){
            System.out.println("Empty Queue");
        }
        else if(front == rear){
            System.out.println("Dequeued Value:"+front.data+"\n");
            front = null;
            rear = null;
        }
        else{
            Node temp;
            temp = front.next;
            System.out.println("Dequeued Value:"+front.data+"\n");
            front.next = null;
            front = temp;
        }
    }
    void showQueue(){
        if(front == null && rear == null){
            System.out.println("Empty Queue\n");
        }
        else{
            Node temp;
            temp = front;
            while(temp!=rear){
                System.out.print(temp.data+"\t");
                temp = temp.next;
            }
            System.out.print(temp.data+"\n");

        }

    }
}

class Run{
    public static void main(String[] args){
        int o=-1,n;
        QueueLL qll = new QueueLL();
        Scanner input = new Scanner(System.in);
        while(o!=4){
            System.out.print("\nMENU\n");
            System.out.println("\n1)Enqueue\n2)Dequeue\n3)Show Queue\n4)EXIT\n");
            System.out.println("Enter option:");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("Enter value:");
                    n = input.nextInt();
                    qll.enqueue(n);
                    break;
                case 2:
                    qll.dequeue();
                    break;
                case 3:
                    qll.showQueue();
                    break;
                default:
                break;

            }
        }
    }
}
