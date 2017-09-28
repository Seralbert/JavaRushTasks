package com.javarush.task.task35.task3513;

/**
 * Created by USER-PC on 20.09.2017.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency>{
private int numberOfEmptyTiles;
private int score;
private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {

        if(this == o) return 0;
        if(this.numberOfEmptyTiles > o.numberOfEmptyTiles) return 1;
        if(this.numberOfEmptyTiles < o.numberOfEmptyTiles) return -1;

        if(this.numberOfEmptyTiles == o.numberOfEmptyTiles) {
            if(this.score>o.score)return 1;
            if(this.score<o.score)return -1;
        }

        return 0;
        /*if(this == o) return 0;
        if(this.numberOfEmptyTiles == o.numberOfEmptyTiles)return this.score>o.score?1:-1;

        return this.numberOfEmptyTiles > o.numberOfEmptyTiles?1:-1;*/
    }
}
