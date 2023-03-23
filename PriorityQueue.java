import java.util.*;
class PriorityQueue{
    Node head;
    class Node{
        int prior;
        char data;
        Node next;
        Node(int p,char c){
            data = c;
            prior = p;
            next = null;
        }
    }

    void insertion(int p,char c){
        Node newnode = new Node(p,c);
        if(head == null){
            head = newnode;
        }
        else{
            Node temp,prev;
            temp = head;
            prev = head;
            while(temp!=null && temp.prior<=newnode.prior){
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                prev.next = newnode;
            }
            else if(temp == head){
                newnode.next = head;
                head = newnode;
            }
            else{
                newnode.next = temp;
                prev.next = newnode;
            }
        }
    }

    void deletion(){
        if(head == null){
            System.out.println("Empty Priority Queue\n");
        }
        else{
            Node temp;
            System.out.println("Latest process:"+head.data+"\n");
            temp = head.next;
            head.next = null;
            head = temp;
        }

    }
    void showQueue(){
        Node temp;
        if(head == null){
            System.out.println("Empty Priority Queue\n");
        }
        else{
           temp = head;
            while(temp!=null){
                System.out.println(temp.data+" "+temp.prior+"\n");
                temp = temp.next;
            }
        }

    }
}

class Run{
    public static void main(String[] args){
        int o=-1,p;
        char c;
        PriorityQueue pq = new PriorityQueue();
        Scanner input = new Scanner(System.in);
        while(o!=4){
            System.out.print("\nMENU\n");
            System.out.println("\n1)Insertion\n2)Deletion\n3)Show Queue\n4)EXIT\n");
            System.out.println("Enter option:");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("Enter priority:");
                    p = input.nextInt();
                    System.out.println("Enter char:");
                    c = input.next().charAt(0);
                    pq.insertion(p,c);
                    break;
                case 2:
                    pq.deletion();
                    break;
                case 3:
                    pq.showQueue();
                    break;
                default:
                break;

            }
        }
    }
}
