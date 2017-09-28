package com.javarush.task.task21.task2113;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Admin on 01.07.2017.
 */
public class Hippodrome {
    private List<Horse> horses;// = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    static Hippodrome game;

    void run(){
        for (int i = 0; i < 100; i++) {

            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    void print(){
        for (Horse h : horses){h.print();}
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
    void move(){
        for (Horse h : horses){h.move();}
    }

    public Horse getWinner(){
        double maxDistance = 0.0;
        Horse winner = null;
        for (Horse h : horses){
            if(h.getDistance()>maxDistance){
                maxDistance = h.getDistance();
                winner = h;}
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+"!");
    }

    public static void main(String[] args) {

        game = new Hippodrome(null);
        Horse  h1 = new Horse("Skarlett", 3 , 0);
        Horse  h2 = new Horse("Bagira", 3 , 0);
        Horse  h3 = new Horse("СамПридумай", 3 , 0);

        game.horses = new ArrayList<>();
        game.horses.add(h1);
        game.horses.add(h2);
        game.horses.add(h3);

        /*for (Horse h : game.getHorses()){
            System.out.println(h.getName());
        }*/

        game.run();
        game.printWinner();
    }
}
