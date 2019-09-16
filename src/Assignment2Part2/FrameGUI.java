/*
    Author: Stuart Larsen
    Date: 5/10/2019
    Course: Algorithms Winter 2019
    Assignment: 2 Part 2
    Instructor: Fatma Serce
    Synopsis: This program generates a UI with several buttons and an input. The user is able to set a data size, choose
              between a sorted or random list of data (based on the size), and then able to run 1 of 7 sorting algorithms
              and see the speed at which the data was sorted. Finally, a file is created with the list of sorted data
 */

package Assignment2Part2;

import Sort.Sort;
import edu.princeton.cs.algs4.StopwatchCPU;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGUI
{

    public static void main(String[] args)
    {
        GUIApp app = new GUIApp(); // Object to pass back user options via the GUI


        // Create JFrame UI
        JFrame frame = new JFrame();
        frame.setTitle("Sorting App");
        frame.setSize(450, 450);


        // Create all buttons and se their location on the frame
        JButton sortedButton = new JButton("Sorted");
        sortedButton.setBounds(100, 100, 100, 40);

        JButton randomButton = new JButton("Random");
        randomButton.setBounds(200, 100, 100, 40);

        JButton setSizeButton = new JButton("Set n");
        setSizeButton.setBounds(250, 50, 75, 30);

        JButton selectionSortButton = new JButton("Selection");
        selectionSortButton.setBounds(100, 150, 75, 40);

        JButton insertionSortButton = new JButton("Insertion");
        insertionSortButton.setBounds(200, 150, 75, 40);

        JButton shellSortButton = new JButton("Shell");
        shellSortButton.setBounds(100, 200, 75, 40);

        JButton bubbleSortButton = new JButton("Bubble");
        bubbleSortButton.setBounds(200, 200, 75, 40);

        JButton mergeSortButton = new JButton("Merge");
        mergeSortButton.setBounds(100, 250, 75 ,40);

        JButton quickSortButton = new JButton("Quick");
        quickSortButton.setBounds(100, 250, 75, 40);

        JButton heapSortButton = new JButton("Heap");
        heapSortButton.setBounds(100, 300, 75, 40);


        // Create all labels and dispaly on them on the UI
        JLabel label = new JLabel();
        label.setText("Enter data size: ");
        label.setBounds(10, 10, 100, 100);

        JLabel nValueLabel = new JLabel();
        nValueLabel.setBounds(350, 10, 200, 100);

        JLabel timerLabel = new JLabel();
        timerLabel.setBounds(100, 350, 100, 40);

        JTextField textField = new JTextField();
        textField.setBounds(110, 50, 130, 30);





        // Action listeners for all buttons
        setSizeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String n = textField.getText();
                nValueLabel.setText("n = " + n);
                int size = Integer.parseInt(n);
                app.dataSize = size;

            }
        });


        sortedButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                app.userSelection = "sorted";
                app.listOfNums = app.generateSortedNumbers(app.dataSize); // Creates a list of sorted numbers
            }
        });

        randomButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                app.userSelection = "random";
                app.listOfNums = app.generateRandomNumbers(app.dataSize); // Creates list of random numbers
            }
        });

        // All sorting algorithm buttons run the sortAndTimeData method and then generate a file with the sorted list of numbers
        selectionSortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String algorithm = "selectionSort";
                sortAndTimeData(timerLabel, algorithm, app.listOfNums);
                app.generateFile(app.listOfNums, app.dataSize);
            }
        });

        insertionSortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String algorithm = "insertionSort";
                sortAndTimeData(timerLabel, algorithm, app.listOfNums);
                app.generateFile(app.listOfNums, app.dataSize);
            }
        });

        shellSortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String algorithm = "shellSort";
                sortAndTimeData(timerLabel, algorithm, app.listOfNums);
                app.generateFile(app.listOfNums, app.dataSize);
            }
        });

        bubbleSortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String algorithm = "bubbleSort";
                sortAndTimeData(timerLabel, algorithm, app.listOfNums);
                app.generateFile(app.listOfNums, app.dataSize);
            }
        });

        mergeSortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String algorithm = "mergeSort";
                sortAndTimeData(timerLabel, algorithm, app.listOfNums);
                app.generateFile(app.listOfNums, app.dataSize);
            }
        });

        quickSortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String algorithm = "quickSort";
                sortAndTimeData(timerLabel, algorithm, app.listOfNums);
                app.generateFile(app.listOfNums, app.dataSize);
            }
        });

        heapSortButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String algorithm = "heapSort";
                sortAndTimeData(timerLabel, algorithm, app.listOfNums);
                app.generateFile(app.listOfNums, app.dataSize);

            }
        });

        // Adding buttons and labels to the frame
        frame.add(sortedButton);
        frame.add(randomButton);
        frame.add(nValueLabel);
        frame.add(timerLabel);
        frame.add(textField);
        frame.add(label);
        frame.add(setSizeButton);
        frame.add(selectionSortButton);
        frame.add(insertionSortButton);
        frame.add(shellSortButton);
        frame.add(bubbleSortButton);
        frame.add(mergeSortButton);
        frame.add(quickSortButton);
        frame.add(heapSortButton);


        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Takes in a parameter of what sorting algorithm the user chose, sorts the data, then displays the duration of how long
    // the sort took
    private static void sortAndTimeData(JLabel timerLabel, String algorithm, Comparable[] listOfNums)
    {
        StopwatchCPU timer = new StopwatchCPU();
        double startTime = timer.elapsedTime();
        switch(algorithm)
        {
            case "selectionSort":
                Sort.selectionSort(listOfNums);
                break;
            case "insertionSort":
                Sort.insertionSort(listOfNums);
                break;
            case "shellSort":
                Sort.shellSort(listOfNums);
                break;
            case "bubbleSort":
                Sort.bubbleSort(listOfNums);
                break;
            case "mergeSort":
                Sort.mergeSort(listOfNums, 0, listOfNums.length - 1);
                break;
            case "quickSort":
                Sort.quickSort(listOfNums, 0, listOfNums.length - 1);
                break;
            case "heapSort":
                Sort.heapSort(listOfNums);
                break;
        }
        double endTime = timer.elapsedTime();
        double totalTime = endTime - startTime;
        timerLabel.setText(Double.toString(totalTime));
    }
}
