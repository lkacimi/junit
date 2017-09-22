/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pancake;

/**
 *
 * @author lkacimi
 */
public class Pancake {
    private boolean face;

   

    public void setFace(boolean face) {
        this.face = face;
    }
   
    public boolean isHappy() {
        return this.face;
    }
     
    public boolean isUpset(){
        return !this.isHappy();
    }
}
