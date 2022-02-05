package com.company;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class miniMathGame extends JFrame implements ActionListener {


    JLabel titleLabel = new JLabel("Welcome to mini math game!");
    JLabel subTitle1Label = new JLabel("---------------------------");
    JLabel subTitle2Label = new JLabel("---------------------------");
    JLabel questionLabel = new JLabel();
    JLabel numLabel1 = new JLabel("Num 1 : ");
    JLabel numLabel2 = new JLabel("Num 2 : ");
    JButton playButton = new JButton("START");
    JButton exitButton = new JButton("END");
    JTextField answerField1 = new JTextField(2);
    JTextField answerField2 = new JTextField(2);
    JTextField rightCounterField = new JTextField(7);
    JTextField wrongCounterField = new JTextField(7);
    JTextArea dataAnalyserField = new JTextArea();

    Font titleFont = new Font("Tahoma", Font.BOLD, 30);
    Font questionFont = new Font("Tahoma", Font.BOLD, 48);
    Font answerFont = new Font("Tahoma", Font.BOLD, 38);

    Random random = new Random();
    int digit1;
    int digit2;
    int correctAnswer;
    int WIN = 0;
    int LOSE = 0;


    public miniMathGame() {

        setLayout(new FlowLayout());
        add(titleLabel);
        add(subTitle1Label);
        add(questionLabel);
        add(subTitle2Label);
        add(numLabel1);
        add(answerField1);
        add(numLabel2);
        add(answerField2);
        add(rightCounterField);
        add(dataAnalyserField);
        add(wrongCounterField);
        add(playButton);
        add(exitButton);

        exitButton.setVisible(false);
        rightCounterField.setVisible(false);
        wrongCounterField.setVisible(false);
        dataAnalyserField.setVisible(false);
        questionLabel.setVisible(false);
        subTitle2Label.setVisible(false);
        numLabel1.setVisible(false);
        answerField1.setVisible(false);
        numLabel2.setVisible(false);
        answerField2.setVisible(false);

        wrongCounterField.setEditable(false);
        rightCounterField.setEditable(false);

        titleLabel.setFont(titleFont);
        subTitle1Label.setFont(questionFont);
        subTitle2Label.setFont(questionFont);
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        numLabel1.setFont(answerFont);
        numLabel2.setFont(answerFont);
        answerField1.setFont(answerFont);
        answerField2.setFont(answerFont);
        rightCounterField.setFont(answerFont);
        wrongCounterField.setFont(answerFont);
        dataAnalyserField.setFont(new Font("Tahoma", Font.BOLD, 15));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 50));
        playButton.setFont(new Font("Tahoma", Font.BOLD, 50));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 60));

        wrongCounterField.setHorizontalAlignment(JTextField.CENTER);
        rightCounterField.setHorizontalAlignment(JTextField.CENTER);

        playButton.addActionListener(this);
        answerField1.addActionListener(this);
        answerField2.addActionListener(this);
        exitButton.addActionListener(this);

        setTitle("MATH GAME");
        setSize(600, 500);
        setLocation(410, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playButton) {

            playButton.setVisible(false);
            titleLabel.setVisible(false);
            rightCounterField.setVisible(true);
            wrongCounterField.setVisible(true);
            questionLabel.setVisible(true);
            subTitle1Label.setVisible(true);
            subTitle2Label.setVisible(true);
            numLabel1.setVisible(true);
            answerField1.setVisible(true);
            answerField1.setEditable(false);
            numLabel2.setVisible(true);
            answerField2.setVisible(true);
            answerField2.setEditable(false);
            exitButton.setVisible(true);
            questionLabel.setText(setQuestion());
            answerField1.setEditable(true);
            answerField2.setEditable(true);


        }

        if (e.getSource() == exitButton) {


            dataAnalyserField.setBackground(getBackground());
            playButton.setVisible(false);
            titleLabel.setVisible(false);
            rightCounterField.setVisible(false);
            wrongCounterField.setVisible(false);
            questionLabel.setVisible(false);
            subTitle1Label.setVisible(false);
            subTitle2Label.setVisible(false);
            numLabel1.setVisible(false);
            numLabel2.setVisible(false);
            answerField1.setVisible(false);
            answerField2.setVisible(false);
            exitButton.setVisible(false);
            dataAnalyserField.setPreferredSize(new Dimension(500, 400));
            dataAnalyserField.setVisible(true);
            dataAnalyserField.setText("Game Session Data Analysed : " + "\n" + "\n"
                    + "Numbers You Got Correct : " + WIN + "\n" +
                    "Numbers You Got Wrong  : " + LOSE);
            dataAnalyserField.setEditable(false);

        }

        if (e.getSource() == answerField1 || e.getSource()==answerField2 ) {

             digit1 = Integer.parseInt(answerField1.getText());
             digit2 = Integer.parseInt(answerField2.getText());
            if (digit1+digit2 == correctAnswer) {

                WIN++;
                answerField1.setText("");
                answerField2.setText("");
                rightCounterField.setText("WIN : " + WIN + "");
            } else {
                LOSE++;
                answerField1.setText("");
                answerField2.setText("");
                wrongCounterField.setText("LOSE : " + LOSE + "");
            }
            questionLabel.setText(setQuestion());
        }
    }

    public int getRandomNumber() {
        return random.nextInt(12);

    }

    public String setQuestion() {
        correctAnswer=getRandomNumber();

        return "Select Two Numbers that upto " + correctAnswer+ " ? ";
    }

    public static void main(String[] args) {
        new miniMathGame();
    }
}