package com.urbanik;

import com.urbanik.core.Airport;
import com.urbanik.dto.AirplaneDto;
import com.urbanik.tests.TestPairingHeap;
import com.urbanik.tests.TestSplayTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class App {
    private JButton planeArrivalInformationInputButton;
    private JPanel panelMain;
    private JButton testSplay;
    private JButton testPairingHeap;
    private JTextField numberOfItemsAtStart;
    private JTextField numberOfOperations;
    private JTextField airplaneCode;
    private JButton runwayDemand;
    private JButton printWaitingAirplanes;
    private JButton addHour;
    private JLabel systemDate;
    private JTextField priority;
    private JButton a8ChangePriorityButton;
    private JButton a9PrintRunwaysButton;
    private JButton stopDemand;
    private JButton searchAriplaneOnRunway;
    private JButton departure;
    private JButton searchAirplane;
    private JButton savetoFile;
    private JButton loadFromFile;
    private JTextField runwayId;

    private static Airport airport;

    public App() {
        planeArrivalInformationInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AirplaneDto dto = new AirplaneDto(airplaneCode.getText());
                dto = airport.planeArrived(dto);
                JOptionPane.showMessageDialog(null, "Plane arrived: " + dto.toString());

            }
        });
        testSplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestSplayTree testSplayTree = new TestSplayTree(Integer.parseInt(numberOfItemsAtStart.getText()), Integer.parseInt(numberOfOperations.getText()));
                testSplayTree.test();
            }
        });
        testPairingHeap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestPairingHeap testPairingHeap = new TestPairingHeap(Integer.parseInt(numberOfItemsAtStart.getText()), Integer.parseInt(numberOfOperations.getText()));
                testPairingHeap.test();
            }
        });
        addHour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airport.addHour();
                systemDate.setText(airport.getSystemDate());
            }
        });
        panelMain.addComponentListener(new ComponentAdapter() {
        });
        runwayDemand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneDto dto = new AirplaneDto(airplaneCode.getText());
                dto = airport.demandRunway(dto);
                JOptionPane.showMessageDialog(null, "Plane demanded runway: " + dto.toString());
            }
        });
        printWaitingAirplanes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";
                for (AirplaneDto adto : airport.getWaitingAirplanes()) {
                    s += adto.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, s);
            }
        });
        searchAirplane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneDto dto = new AirplaneDto(airplaneCode.getText());
                dto = airport.getWaitingAirplaneByCode(dto);
                JOptionPane.showMessageDialog(null, "Airplane found: " + dto.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        airport = new Airport();
    }

}
