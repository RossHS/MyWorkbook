package javaCore.GUI.swing.fileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.io.File;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class FileIconView extends FileView {
    private FileFilter filter;
    private Icon icon;

    /**
     * Constructs a FileIconView.
     *
     * @param aFilter     a file filter--all files that this filter accepts will be shown with the icon.
     * @param anIcon--the icon shown with all accepted files.
     */
    public FileIconView(FileFilter aFilter, Icon anIcon) {
        filter = aFilter;
        icon = anIcon;
    }

    public Icon getIcon(File f) {
        if (!f.isDirectory() && filter.accept(f)) return icon;
        else return null;
    }
}