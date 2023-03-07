import java.util.Scanner;
class CircularQueue{
    private int front,rear,size;
    private int cqueue[];
    CircularQueue(int n){
        size = n;
        front = -1;
        rear = -1;
        cqueue = new int[n];
    }

    void enqueue(int val){
        if(front == -1 && rear == -1){
            front++;
            rear++;
            cqueue[rear] = val;
        }
        else if((rear+1)%size == front){
            System.out.println("\nCircular Queue Full!.Cannot enqueue.\n");
        }
        else{
            rear = (rear+1)%size;
            cqueue[rear] = val;
        }
    }
    void dequeue(){
        int d;
        if(front == -1 && rear == -1){
            System.out.println("\nQueue Empty!Cannot dequeue.\n");
        }
        else if(front == rear){
           d = cqueue[front];
           front = -1;
           rear = -1;
           System.out.println("Dequeued element:"+d+"\n");
        }
        else{
            d = cqueue[front];
            front = (front+1)%size;
            System.out.println("Dequeued element:"+d+"\n");
        }
    }
    void showQueue(){
        int i;
        if(front == -1 && rear == -1){
            System.out.println("\nQueue Empty!\n");
        }
        else{
            for(i=front;i!=rear;i=(i+1)%size){
                System.out.print(cqueue[i]+"\t");
            }
            System.out.print(cqueue[i]+"\n");
        }

    }
}
class Run{
    public static void main(String[] args){
        int o=-1,p,n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size:");
        n = input.nextInt();
        CircularQueue q = new CircularQueue(n);
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
