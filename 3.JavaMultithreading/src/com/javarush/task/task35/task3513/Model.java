package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by USER-PC on 15.09.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score;
    int maxTile;
    public boolean isSaveNeeded = true;
    public Stack<Tile[][]> previousStates;
    public Stack<Integer> previousScores;

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public Model() {
        previousScores = new Stack<>();
        previousStates = new Stack<>();
        resetGameTiles();


    }
    void resetGameTiles(){
        //this.gameTiles ;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                this.gameTiles[i][j] = new Tile();
            }
        }
        score = 0; maxTile = 2;
        addTile();addTile();
    }

    private void addTile(){
        List<Tile> list = getEmptyTiles();
        if (list != null && list.size() != 0) {
            int index = (int) (list.size() * Math.random());
            list.get(index).value = (Math.random() < 0.9 ? 2 : 4);

        }
    }
    private List<Tile> getEmptyTiles(){
        List<Tile> result = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) result.add(gameTiles[i][j]);
            }
        }
        return result;
    }
    private boolean compressTiles(Tile[] tiles){
        boolean res = false;
        for (int i = 0; i < tiles.length-1; i++) {
            for (int j = 0; j < tiles.length-1; j++) {
                if(tiles[j].value==0 && tiles[j+1].value!=0){

                    tiles[j].value = tiles[j+1].value;
                    tiles[j+1].value = 0;
                    res = true;
                }
            }
        }

        return res;
    }
    private boolean mergeTiles(Tile[] tiles){
        boolean res = false;
            for (int j = 0; j < tiles.length-1; j++) {
                if(tiles[j].value != 0 && tiles[j].value==tiles[j+1].value){
                    tiles[j].value*=2;
                    tiles[j+1].value = 0;
                    score+=tiles[j].value;
                    if(maxTile<tiles[j].value)maxTile=tiles[j].value;
                    res = true;
                }
            }
            compressTiles(tiles);
            return res;

    }

    public void left(){
        if(isSaveNeeded) saveState(gameTiles);

        boolean isNotChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) & !mergeTiles(gameTiles[i])) {
                /*addTile();
                isSaveNeeded = true;*/
                isNotChanged = true;
            }
        }
        if(isNotChanged){addTile();
        isSaveNeeded = true;
        }

    }
    public void down(){
        saveState(gameTiles);
        rotate();
        left();
        rotate();rotate();rotate();
    }
    public void right(){
        saveState(gameTiles);
        rotate();rotate();
        left();
        rotate();rotate();
    }
    public void up(){
        saveState(gameTiles);
        rotate();rotate();rotate();
        left();
        rotate();
    }
    private void rotate(){

        for (int i = 0; i < (FIELD_WIDTH+1)/2; i++) {
            for (int j = 0; j < FIELD_WIDTH/2; j++) {
                Tile tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i];
                gameTiles[FIELD_WIDTH -1 - j][i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH -1 - j];
                gameTiles[FIELD_WIDTH -1 - i][FIELD_WIDTH - 1 - j]= gameTiles[j][FIELD_WIDTH -1 - i];
                gameTiles[j][FIELD_WIDTH - 1 - i] = tmp;
            }
        }
    }

    public boolean canMove(){
        //boolean answere = false;
        //if (getEmptyTiles().size()>0)return true;
        if (!getEmptyTiles().isEmpty())return true;

        for (int j = 0; j < FIELD_WIDTH; j++) {
            for (int i = 0; i < FIELD_WIDTH - 1; i++) {
                if(gameTiles[j][i].value==gameTiles[j][i+1].value)return true;
            }
        }
        for (int j = 0; j < FIELD_WIDTH; j++) {
            for (int i = 0; i < FIELD_WIDTH-1; i++) {
                if(gameTiles[i][j].value==gameTiles[i+1][j].value)return true;
            }
        }
        return false;
    }
    private void saveState(Tile[][] state){
        isSaveNeeded = false;
        previousScores.push(score);
        //Tile[][] tmp = state.clone();
        Tile[][] tmp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tmp[i][j] = new Tile(gameTiles[i][j].value);
            }
        }

        previousStates.push(tmp);
    }
    public void rollback(){
        if(!previousStates.empty()& !previousScores.empty()) {
            score = previousScores.pop();
            gameTiles = previousStates.pop();
        }
    }
    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0: {left();break;}
            case 1:{right();break;}
            case 2:{up();break;}
            case 3:{down();break;}
        }
    }
    public boolean hasBoardChanged(){
        Tile[][]tmpField = previousStates.peek();
        //int tmpScore = previousScores.peek();
        //if(tmpScore>score)return true;
        int prevScore = 0;
        int currScore = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                prevScore+=tmpField[i][j].value;
                currScore+=gameTiles[i][j].value;
            }
        }
        return prevScore!=currScore;
    }
    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();
        if(hasBoardChanged())moveEfficiency = new MoveEfficiency(getEmptyTiles().size(),score,move);
        else moveEfficiency = new MoveEfficiency(-1,0,move);
        rollback();

        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4,Collections.reverseOrder());
        /*queue.add(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                left();
            }
        }));*/
        //queue.add(getMoveEfficiency(() -> left()));
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));

        Move move = queue.peek().getMove();
        move.move();
    }
}
