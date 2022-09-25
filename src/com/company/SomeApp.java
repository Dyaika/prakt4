package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SomeApp extends JFrame {
    JButton buttonACMilan = new JButton("AC Milan");
    JButton buttonRealMadrid = new JButton("Real Madrid");
    JLabel resultLabel = new JLabel("Result: 0 X 0", JLabel.CENTER);
    JLabel lastScorerLabel = new JLabel("Last Scorer: N/A", JLabel.CENTER);
    Label winnerLabel = new Label("Winner: DRAW", Label.CENTER);
    int madrid = 0;
    boolean playing = true;
    int milan = 0;
    Font fnt = new Font("Times new roman", Font.BOLD,20);
    private void updateText(char x){
        if (!playing){
            return;
        }
        if (milan > 10 && milan - madrid >= 2){
            winnerLabel.setText("Winner: AC Milan");
            buttonACMilan.setBackground(Color.GREEN);
            buttonRealMadrid.setBackground(Color.RED);
            playing = false;
            return;
        } else if (madrid > 10 && madrid - milan >= 2){
            winnerLabel.setText("Winner: Real Madrid");
            buttonRealMadrid.setBackground(Color.GREEN);
            buttonACMilan.setBackground(Color.RED);
            playing = false;
            return;
        }
        if (x == 'a') {
            lastScorerLabel.setText("Last Scorer: AC Milan");
        } else {
            lastScorerLabel.setText("Last Scorer: Real Madrid");
        }
        resultLabel.setText("Result: " + milan + " X " + madrid);
    }
    public SomeApp(){
        super("What");
        setLayout(new BorderLayout());
        setSize(600,150);
        add(buttonRealMadrid, BorderLayout.EAST);
        add(buttonACMilan, BorderLayout.WEST);
        buttonRealMadrid.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(playing) {
                    madrid++;
                    updateText('r');
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        buttonACMilan.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                milan++;
                updateText('a');
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(resultLabel, BorderLayout.CENTER);
        add(lastScorerLabel, BorderLayout.SOUTH);
        add(winnerLabel, BorderLayout.NORTH);
        setVisible(true);
    }
}
