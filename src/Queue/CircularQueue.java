package Queue;

public class CircularQueue {
    int[] arr;
    int front,rear,capacity;
    CircularQueue(int capacity){
        this.capacity=capacity;
        arr=new int[capacity];
        front=0;
        rear=0;
    }
    void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        arr[rear] = value;
        rear = (rear+1)%capacity;
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;}
            int value = arr[front];
            front=(front+1)%capacity;
            return value;
        }
        void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        int i=front;
        while(i!=rear){
            System.out.println(arr[i]+ " ");
            i=(i+1)%capacity;
        }
            System.out.println();
        }

    boolean isFull(){
        return (rear+1)%capacity==front;
    }
    boolean isEmpty(){
        return front==rear;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5); // usable size = 4

        System.out.println("=== Enqueue Operations ===");
        cq.enqueue(10); cq.display();
        cq.enqueue(20); cq.display();
        cq.enqueue(30); cq.display();
        cq.enqueue(40); cq.display();

        System.out.println("\n=== Dequeue Operations ===");
        cq.dequeue(); cq.display();
        cq.dequeue(); cq.display();

        System.out.println("\n=== Enqueue After Wrap Around ===");
        cq.enqueue(50); cq.display();
        cq.enqueue(60); cq.display(); // wraps around

        System.out.println("\n=== Final Queue State ===");
        cq.display();
    }



}
