package javaCore.GUI.basics.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Пример вывода изображения
 * @author Ross Khapilov
 * @version 1.0 created on 28.01.2018
 */
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = getFrame();
        });
    }
    private static JFrame getFrame(){
        JFrame frame = new JFrame();
        frame.setTitle("Image");
        frame.add(new ImageComponent());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }
    private static class ImageComponent extends JComponent{
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;

        private Image image;
        ImageComponent(){
            image = new ImageIcon("src\\javaCore\\GUI\\basics\\graphics\\356.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (image == null) return;
            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);
            g.drawImage(image,0,0,null);
//            for (int i = 0;i*imageWidth <= getWidth() ; i++) {
//                for (int j = 0; j*imageHeight <= getHeight() ; j++) {
//                    if(i + j > 0)
//                        g.copyArea(0,0,imageWidth,imageHeight,i*imageWidth,i*imageHeight);
//                }
//            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        }
    }
}
