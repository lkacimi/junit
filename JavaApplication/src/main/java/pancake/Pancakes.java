/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pancake;

import java.util.List;

/**
 *
 * @author lkacimi
 */
public class Pancakes {
    private List<Pancake> pancakes;

    public static int FLIPPER_SIZE;

    public Pancakes(int flipperSize) {
        Pancakes.FLIPPER_SIZE = flipperSize;
    }
    
    public List<Pancake> getPancakes() {
        return pancakes;
    }

    public void setPancakes(List<Pancake> pancakes) {
        this.pancakes = pancakes;
    }
    
    public boolean isGoal(){
        return this.getPancakes().stream().noneMatch((p) -> (p.isUpset()));
    }
    
    public boolean canBeMadeHappy(){
        
        return false;
    }
}
