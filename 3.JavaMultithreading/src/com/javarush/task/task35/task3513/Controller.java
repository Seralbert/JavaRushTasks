package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by USER-PC on 15.09.2017.
 */
public class Controller extends KeyAdapter{
    private static int  WINNING_TILE = 2048;

    private Model model;
    private View view;
    private Tile[][] gameTiles;

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }
    public int getScore(){
        return model.score;
    }

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public void resetGame(){
        view.isGameLost = false;
        view.isGameWon = false;

        model.score = 0;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //super.keyPressed(e);
        if(!model.canMove())view.isGameLost = true;
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:{model.up();break;}
            case KeyEvent.VK_DOWN:{model.down();break;}
            case KeyEvent.VK_LEFT:{model.left();break;}
            case KeyEvent.VK_RIGHT:{model.right();break;}
            case KeyEvent.VK_ESCAPE:{resetGame();break;}
            case KeyEvent.VK_Z:{model.rollback();break;}
            case KeyEvent.VK_R:{model.randomMove();break;}
            case KeyEvent.VK_A:{model.autoMove();break;}

        }

        if(model.maxTile==WINNING_TILE)view.isGameWon = true;
        view.repaint();
    }
}
