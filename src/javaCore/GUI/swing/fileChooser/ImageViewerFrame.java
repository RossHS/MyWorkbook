package javaCore.GUI.swing.fileChooser;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser chooser;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            chooser.setCurrentDirectory(new File("."));

            // show file chooser dialog
            int result = chooser.showOpenDialog(ImageViewerFrame.this);

            // if image file accepted, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
                pack();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));

        // use a label to display the images
        label = new JLabel();
        add(label);

        // set up file chooser
        chooser = new JFileChooser();

        // accept all image files ending with .jpg, .jpeg, .gif
      /*
      final ExtensionFileFilter filter = new ExtensionFileFilter();
      filter.addExtension("jpg");
      filter.addExtension("jpeg");
      filter.addExtension("gif");
      filter.setDescription("Image files");
      */
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "gif");
        chooser.setFileFilter(filter);

        chooser.setAccessory(new ImagePreviewer(chooser));

        chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
    }
}
