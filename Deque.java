import java.util.Scanner;
class Deque{
    int left,right,size;
    int deque[];
    Deque(int n){
        size = n;
        left = -1;
        right = -1;
        deque = new int[n];
    }
    void insert_right(int val){
        if(left == -1 && right == -1){
            left++;
            right++;
            deque[right] = val;
        }
        else if((right+1)%size == left){
            System.out.println("\nDeque full.\n");
        }
        else{
            right = (right+1)%size;
            deque[right] = val;
        }
    }
    void insert_left(int val){
        if(left == -1 && right == -1){
            left++;
            right++;
            deque[left] = val;
        }
        else if((right+1)%size == left){
            System.out.println("\nDeque full.\n");
        }
        else{
            if(left == 0){
                left = size-1;
            }
            else{
                left--;
            }
            deque[left] = val;
        }
    }
    void delete_left(){
        int d;
        if(left == -1 && right == -1){
            System.out.println("\n Deque emtpy.\n");
        }
        else if(left == right){
            d = deque[left];
            left = -1;
            right = -1;
            System.out.println("\nDequed element:"+d+"\n");
        }

        else{
            d = deque[left];
            left = (left+1)%size;
            System.out.println("\nDequed element:"+d+"\n");
        }
    }
    void delete_right(){
        int d;
        if(left == -1 && right == -1){
            System.out.println("\n Deque empty.\n");
        }
        else if(left == right){
            d = deque[right];
            left = -1;
            right = -1;
            System.out.println("\nDequed element:"+d+"\n");
        }
        else{
            d = deque[right];
            if(right == 0 ){
                right = size-1;
            }
            else{
                right--;
            }

            System.out.println("\nDequed element:"+d+"\n");
        }
    }
    void show_deque(){
        int i;
        if(left == -1 && right == -1){
            System.out.println("\nDeque emtpy.\n");
        }
        else{
            for(i=left;i!=right;i=(i+1)%size){
                System.out.print(deque[i]+"\t");
            }
            System.out.print(deque[i]+"\n");
        }
    }
}

class Run{
    public static void main(String[] args){
        int o1=-1,o2=-1,p,size;
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter size:");
        size = input.nextInt();
        Deque dq = new Deque(size);
        System.out.println("\n1)Input Restricted\n2)Output Restricted\n");
        System.out.println("Enter option:");
        o1 = input.nextInt();
        switch(o1){
            case 1:
                while(o2!=5){
                    System.out.println("\nMENU\n");
                    System.out.println("\n1)Insert Right\n2)Delete Left\n3)Delete Right\n4)Show Deque\n5)EXIT\n");
                    System.out.println("Enter option:");
                    o2 = input.nextInt();
                    switch(o2){
                        case 1:
                            System.out.println("Enter value:");
                            p = input.nextInt();
                            dq.insert_right(p);
                            break;
                        case 2:
                            dq.delete_left();
                            break;
                        case 3:
                            dq.delete_right();
                            break;
                        case 4:
                            dq.show_deque();

                    }
                }
            case 2:
                while(o2!=5){
                    System.out.println("\nMENU\n");
                    System.out.println("\n1)Insert Left\n2)Insert Right\n3)Delete Left\n4)Show Deque\n5)EXIT\n");
                    System.out.println("Enter option:");
                    o2 = input.nextInt();
                    switch(o2){
                        case 1:
                            System.out.println("Enter value:");
                            p = input.nextInt();
                            dq.insert_left(p);
                            break;
                        case 2:
                            System.out.println("Enter value:");
                            p = input.nextInt();
                            dq.insert_right(p);
                            break;
                        case 3:
                            dq.delete_left();
                            break;
                        case 4:
                            dq.show_deque();
                    }
                }


        }

    }
}
