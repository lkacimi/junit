/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.helper;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author lkacimi
 */
public class ImageHelper {
    /**
     * Returns an <code>Image</code> object that can then be painted 
     * on the screen.
     * the <code>url</code> argument must specify an absolute {@link URL}. 
     * The <code>name</code> argument is a specifier that is relative to 
     * the <code>url</code> argument.
     * <p>
     * This method always returns immediately, whether or not the 
     * image exists. When an applet attempts to draw the image on 
     * the screen, the data will be loaded
     * 
     * @param url an absolute URL giving the base location of the image
     * @param name the location of the image, relative to the url argument
     * @return the image at the specified url
     * @see Image
     */
    public Image getImage(URL url, String name){
        try{
            return getImage(new URL(url,name));
        }catch(MalformedURLException e){
            return null;
        }
    }

    private Image getImage(URL url) {
        return null;
    }
    
}
