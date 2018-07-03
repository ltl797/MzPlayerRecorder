package JFrameTest;

import javax.swing.*;

/**
 * Created by LTL on 2018-07-03.
 */
public class Mz {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mz");
        frame.setContentPane(new Mz().canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JTabbedPane tabbedPane1;
    private JPanel topTab;
    private JPanel canvas;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;

    private int canvasWidth = 1280;
    private int canvasHeight = 800;



    public void showPanel(){
        Frame jf = new Frame("MzPlayer");
        jf.setSize(canvasWidth,canvasHeight);
        this.tabbedPane1.setSize(canvasWidth-10,canvasHeight-5);
        jf.setContentPane(this.tabbedPane1);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setResizable(false);
        jf.setVisible(true);
    }
}
