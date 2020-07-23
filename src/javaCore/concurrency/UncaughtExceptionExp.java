package javaCore.concurrency;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Метод run () потока исполнения не может генерировать никаких проверяемых исключений, но может быть прерван
 * непроверяемым исключением. В этом случае поток исполнения уничтожается. Но такой конструкции catch, куда может
 * распространиться исключение, не существует. Вместо этого, перед тем, как поток исполнения прекратит
 * свое существование, исключение передается обработчику необрабатываемых исключений. Такой обработчик должен
 * относиться к классу, реализующему интерфейс Thread.UncaughtExceptionHandler. У этого интерфейса имеется
 * единственный метод:
 * void uncaughtException(Thread t, Throwable e)
 * Этот обработчик можно установить в любом
 * потоке исполнения с помощью метода setUncaughtExceptionHandler().
 *
 * @author Ross Khapilov
 * @version 1.0 04.09.2018
 */
public class UncaughtExceptionExp {
    public static void main(final String args[]) throws Exception {
        Thread.UncaughtExceptionHandler handler =
                new StackWindow("Show Exception Stack", 400, 200);
        Thread.setDefaultUncaughtExceptionHandler(handler);
        new Thread(() -> System.out.println(1 / 0)).start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Press Enter for next exception");
        br.readLine();
        new Thread(() -> System.out.println(args[0])).start();
        System.out.print("Press Enter to end");
        br.readLine();
        System.exit(0);
    }
}

class StackWindow extends JFrame implements Thread.UncaughtExceptionHandler {
    private JTextArea textArea;

    public StackWindow(String title, final int width, final int height) {
        super(title);
        setSize(width, height);
        textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        textArea.setEditable(false);
        getContentPane().add(pane);
    }

    public void uncaughtException(Thread t, Throwable e) {
        addStackInfo(e);
    }

    public void addStackInfo(final Throwable t) {
        EventQueue.invokeLater(() -> {
            // Bring window to foreground
            setVisible(true);
            toFront();
            // Convert stack dump to string
            StringWriter sw = new StringWriter();
            PrintWriter out = new PrintWriter(sw);
            t.printStackTrace(out);
            // Add string to end of text area
            textArea.append(sw.toString());
        });
    }
}
