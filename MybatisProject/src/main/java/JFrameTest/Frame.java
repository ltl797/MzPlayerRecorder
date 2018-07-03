package JFrameTest;

import javax.swing.*;

/**
 * Created by LTL on 2018-07-02.
 */
public class Frame extends JFrame {

    private int canvasWidth = 1280;
    private int canvasHeight = 800;

    public Frame(String title){
        super(title);

        setSize(canvasWidth,canvasHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }
}
