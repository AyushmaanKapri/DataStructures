package Queue;

public class queue {
    int size;
    int front;
    int rear;
    int capacity;
    int[] arr;
    queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
        void enqueue(int value){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = value;
            size++;
        }
        int dequeue(int value){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        front++;
        size--;
        return value;
        }
        boolean isFull(){
            return size==capacity;
        }
        boolean isEmpty(){
        return size==0;
        }

}
