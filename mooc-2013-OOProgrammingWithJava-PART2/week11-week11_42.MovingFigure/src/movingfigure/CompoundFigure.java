/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Apo
 */
public class CompoundFigure extends Figure{
    List<Figure> figures;

    public CompoundFigure() {
        super(0, 0);
        figures = new ArrayList<Figure>();
    }

    public void add(Figure f) {
        figures.add(f);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Figure i : figures) {
            i.move(dx, dy);
        }
    }
    
    @Override
    public void draw(Graphics graphics) {
        for(Figure i : figures) {
            i.draw(graphics);
        }
    }
    
}
