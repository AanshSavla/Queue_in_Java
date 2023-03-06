import java.util.Scanner;
class Queue{
    private int front,rear,size;
    private int queue[];
    Queue(int n){
        size = n;
        front = -1;
        rear = -1;
        queue = new int[size];
    }
    void enqueue(int val){

        if(rear == size-1){
            System.out.println("\nQueue full. Cannot enqueue\n");
        }
        else{
            if(front == -1 && rear == -1){
                front=0;
            }
            rear++;
            queue[rear] = val;
        }
    }

    void dequeue(){
        int deqVal;
        if(front == -1 && rear == -1){
            System.out.println("\nQueue empty.Cannot dequeue\n");
        }
        else if(front == rear){
            deqVal = queue[front];
            front = -1;
            rear = -1;
            System.out.println("\nDequeued value:"+deqVal+"\n");
        }
        else{
            deqVal = queue[front];
            front++;
            System.out.println("\nDequeued value:"+deqVal+"\n");
        }
    }
    void showQueue(){
        if(front == -1 && rear == -1){
            System.out.println("\nQueue empty.\n");
        }
        else{
            int i;
            for(i=front;i<=rear;i++){
                System.out.print(queue[i]+"\t");
            }
        }
    }
}

class Run{
    public static void main(String[] args){
        int o=-1,p,n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size:");
        n = input.nextInt();
        Queue q = new Queue(n);
        while(o!=4){
            System.out.println("\nMENU\n1)Enqueue\n2)Dequeue\n3)Show Queue\n4)EXIT\n");
            System.out.print("Enter o:");
            o = input.nextInt();
            switch(o){
                case 1:
                    System.out.println("Enter value to enqueue:");
                    p = input.nextInt();
                    q.enqueue(p);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.showQueue();
                    break;
                default: System.out.println("\nExit");
            }
        }


    }
}
