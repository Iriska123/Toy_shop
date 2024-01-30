package ru.finaltask.gb;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class MainToys {
    public static void main(String[] args) {

        ArrayList<Toys> toys = addToys();
        Queue<Toys> queue = new LinkedList<>();

        for(int i = 0; i <= 9; i++){
            play(toys,queue);
        }

        for(int i = 0; i <=5;i++){
            getPrizeToy(queue);
        }
    }

    static ArrayList<Toys> addToys(){
        ArrayList<Toys> toys = new ArrayList<>();
        toys.add(new Toys(1,"doll",1));
        toys.add(new Toys(2,"car",2));
        toys.add(new Toys(3,"rabbit",5));
        toys.add(new Toys(4,"bear",3));
        toys.add(new Toys(5,"dog",4)) ;
        toys.add(new Toys(6,"cat",7));
        toys.add(new Toys(7,"cat",6));
        toys.add(new Toys(8,"cat",8));
        toys.add(new Toys(9,"cat",15));
        toys.add(new Toys(10,"cat",11));
        toys.add(new Toys(11,"fish",25));
        return toys;
    }

    public static void play (ArrayList<Toys> toys, Queue<Toys> queue){

        double totalWeight = 0;

        for (Toys item : toys) {
            totalWeight += item.getWeight();
//            System.out.println(totalWeight);
        }
        Random rand = new Random();
        double randomNumber = rand.nextDouble() * totalWeight;

        Toys prizeToy = null;

        for (Toys toy : toys) {
            if (randomNumber < toy.getWeight()) {
                prizeToy = toy;
//                System.out.println(prizeToy + " prize");
                break;
            }
            randomNumber -= toy.getWeight();
        }

        if(prizeToy != null){
            queue.add(prizeToy);
            toys.remove(prizeToy);
        } else {
            System.out.println("Игрушки закончились");
        }

}
    public static void getPrizeToy(Queue<Toys> queue) {

        for(int i = 0; i < queue.size(); i++){
            if (queue.size() > 0) {
//                System.out.println(queue.size());
                Toys prizeToy = queue.remove();
//                System.out.println(prizeToy);

                try(PrintWriter printWriter = new PrintWriter(new FileWriter("toys.txt", true))){
                    printWriter.append(prizeToy.toString() + "\n");
                } catch (IOException e){
                    e.getMessage();
                }
            }
        }
    }
}


