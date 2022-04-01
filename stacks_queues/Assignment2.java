package com.stacks_queues;

import java.util.ArrayList;

public class Assignment2 {
    ArrayList<String> fruit=  new ArrayList<String>();
    ArrayList<String> q =  new ArrayList<String>();

    public class Stack {

        public void push(String node) {
            //new node is added
            fruit.add(node);
        }

        public String pop() {
            //if stack is not empty
            if(!isEmpty()) {
                //value of last item in array is given to a variable "value"
                String value = fruit.get(fruit.size()-1);
                //then last item of array is popped
                fruit.remove(fruit.size()-1);
                //value is returned
                return value;
            }
            else {
                System.out.println("There is nothing to pop");
                return null;
            }
        }

        public boolean isEmpty() {
            return fruit.size()==0;
        }

        public void printStack() {
            System.out.println("(stack top)");
            //print from last to bottom
            for(int i=0;i<fruit.size();i++){
                System.out.println(fruit.get(i));
            }
            System.out.println("(stack bottom)\n");

        }

        public Stack() {
            //int i = fruit.size;

        }

    }

    public class Queue{


        public void enqueue(String node) {
            q.add(node);
        }


        public String dequeue() {
            //if queue is empty do nothing
            if(q.isEmpty()){
                System.out.println("There is nothing to dequeue");
                return null;
            }
            //if queue has items, return the first to get in the queue and remove it from queue
            else {
                String value = q.get(0);
                q.remove(0);
                return value;
            }
        }
        public boolean isEmpty() {
            return q.size()==0;
        }

        public void printQueue() {
            //print from last to first index
            System.out.print("(last on queue)");
            for (int i=q.size()-1;i>=0;i--){
                System.out.print(q.get(i)+", ");
            }
            System.out.print("(first on queue)\n");
        }

        public Queue() {

        }
    }
    //tester class
    public Assignment2() {
        //custom test for [a,b,c] stack
//        Stack fruit= new Stack();
//        fruit.push("a");
//        fruit.push("b");
//        fruit.push("c");
//        fruit.printStack();

        Stack fruit= new Stack();
        fruit.pop();
        fruit.push("Apple");
        fruit.push("Banana");
        fruit.pop();
        fruit.push("Canned Yams");
        fruit.push("Durian");
        fruit.printStack();
        fruit.pop();
        fruit.pop();
        fruit.printStack();

        Queue q = new Queue();
        q.enqueue("Job 1");
        q.enqueue("Job 2");
        q.enqueue("Job 3");
        q.printQueue();
        q.dequeue();
        q.dequeue();
        q.printQueue();

    }


    public static void main(String[] args) {
        new Assignment2();

    }
}
