package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private final int width;
    private final int height;
    private boolean continues;
    private Updatable updatable;
    private Random rng;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        rng = new Random();
        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        createApple();
        
        addActionListener(this);
        setInitialDelay(2000);

    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm() {
        return worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }
    
    public Apple getApple() {
        return apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        
        worm.move();
        
        int x = worm.getX();
        int y = worm.getY();
        
        if(worm.runsInto(apple)) {
            worm.grow();
            createApple();
        }
        else if(worm.runsIntoItself()) {
            continues = false;
        }
        else if(x > width - 1 || x < 0 || y > height - 1 || y < 0) {
            continues = false;
        }
        
        updatable.update();
        setDelay(1000 / worm.getLength());
    }

    private void createApple() {
        int x = rng.nextInt(width);
        int y = rng.nextInt(height);
            
        for(Piece i : worm.getPieces()) {
            if(i.getX() == x && i.getY() == y) {
                x = rng.nextInt(width);
                y = rng.nextInt(height);
            }
        }
        
        setApple(new Apple(x, y));
    }
}
