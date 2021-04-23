/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queueadt;

/**
 *
 * @author Kiki Ashun
 */
public class Josephus {

    public static void main(String[] args) {
        /**Array that holds the number which counts the seating position to be eliminated at index 0 
        and the number of seating positions*/
        int[] group ={3,7};
        int position = group[0];
        int count = group[1];

        //Method to display the 
        printJosephusPositions(count, position);
    }

    public static void printJosephusPositions(int count, int position) {
        QueueADT<Integer> queue = new QueueADT<>();
        //Adds the positions to the queue
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }

        while(!queue.isEmpty()) {
            // The eliminated position counted from 1.
            for (int i = 1; i <= position; i++) {
                //Removing positions from the queue
                int eliminatedPosition = queue.dequeue();

                //Prints the eliminated position i.e. the seat that falls under the position
                if (i == position) {
                    System.out.print(eliminatedPosition + " ");
                    break;
                }

                //Adds the non eliminated position to the queue 
                queue.enqueue(eliminatedPosition);
            }
        }
    }

}
