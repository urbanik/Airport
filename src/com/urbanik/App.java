package com.urbanik;

import com.urbanik.core.Airport;
import com.urbanik.dto.AirplaneDto;
import com.urbanik.dto.AirplaneInSystemDto;
import com.urbanik.dto.RunwayDto;
import com.urbanik.entity.AirplaneInSystemByCode;
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
    private JButton changePriorityButton;
    private JButton printRunwaysButton;
    private JButton stopDemand;
    private JButton searchAriplaneOnRunway;
    private JButton departure;
    private JButton searchAirplane;
    private JButton savetoFile;
    private JButton loadFromFile;
    private JTextField runwayId;
    private JButton addPlane;
    private JTextField manufacturerTextfield;
    private JTextField typeTextField;
    private JTextField airplaneCodeTextField;
    private JTextField priorityTextField;
    private JTextField minRunwayLengthTextField;
    private JTable table;
    private JButton nRunways;
    private JTextField nOfRunwaysByTypeGenerated;
    private JTextField nOfPlanesGenerated;
    private JButton generateNAirPlanesButton;
    private JButton makePlanesDemandRunwayButton;
    private JButton arrivalOfAirplanesButton;
    private JTextArea textArea;

    private static Airport airport;

    public App() {
        planeArrivalInformationInputButton.addActionListener(new ActionListener() { // 1
            @Override
            public void actionPerformed(ActionEvent e) {

                AirplaneInSystemDto dto = new AirplaneInSystemDto(airplaneCode.getText());
                dto = airport.planeArrived(dto);
                if(dto != null) {
                    JOptionPane.showMessageDialog(null, "Plane arrived: \n" + dto.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Plane has arrived or plane with this code does not exist!");
                }

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
                //testPairingHeap.test();
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
        runwayDemand.addActionListener(new ActionListener() { // 2
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneInSystemDto dto = new AirplaneInSystemDto(airplaneCode.getText());
                dto = airport.demandRunway(dto);
                if(dto != null) {
                    JOptionPane.showMessageDialog(null, "Plane demanded runway: \n" + dto.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Plane has not arrived or plane with this code does not exist!");
                }
            }
        });
        printWaitingAirplanes.addActionListener(new ActionListener() { // 6
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";
                for (AirplaneInSystemDto adto : airport.getWaitingAirplanes()) {
                    s += adto.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, s);
            }
        });
        searchAirplane.addActionListener(new ActionListener() { // 3
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneInSystemDto dto = new AirplaneInSystemDto(airplaneCode.getText());
                dto = airport.getWaitingAirplaneByCode(dto);
                if(dto != null) {
                    JOptionPane.showMessageDialog(null, "Airplane found: \n" + dto.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Plane with this code is not waiting for runway or does not exist!");
                }
            }
        });
        searchAriplaneOnRunway.addActionListener(new ActionListener() { // 4
            @Override
            public void actionPerformed(ActionEvent e) {
                RunwayDto runwayDto = new RunwayDto(Integer.parseInt(runwayId.getText()));
                if(runwayDto != null) {
                String s = "";

                AirplaneInSystemDto airplaneInSystemDto;
                String text = airplaneCode.getText();
                if(!airplaneCode.getText().equals("Airplane code")){
                    airplaneInSystemDto = new AirplaneInSystemDto(airplaneCode.getText());
                }else{
                    airplaneInSystemDto = null;
                }
                if(airport.getWaitingAirplanesOnRunwayGroup(runwayDto, airplaneInSystemDto) == null){
                    JOptionPane.showMessageDialog(null, "Plane with given code not found!");
                    return;
                }
                for (AirplaneInSystemDto apisdto : airport.getWaitingAirplanesOnRunwayGroup(runwayDto, airplaneInSystemDto)) {
                    s += apisdto.toString() + "\n";
                }

                    JOptionPane.showMessageDialog(null, "Airplane found: \n" + s);
                }else{
                    JOptionPane.showMessageDialog(null, "Runway with given id not found!");
                }
            }
        });
        departure.addActionListener(new ActionListener() { // 5
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneInSystemDto dto = new AirplaneInSystemDto(airplaneCode.getText());
               // dto = airport.getNextPlaneAfterDepartureOfOne(dto);
                if(dto != null) {
                    JOptionPane.showMessageDialog(null, "Next airplane got runway: \n" + dto.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "No more planes waiting in queue!");
                }
            }
        });
        printRunwaysButton.addActionListener(new ActionListener() { // 9
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";
                for (RunwayDto rw : airport.getHisory()) {
                    s += rw.toString() + "\n";
                    for (AirplaneInSystemDto apisd : rw.getHistory()) {
                        s += apisd.toString() + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, s);
            }
        });
        changePriorityButton.addActionListener(new ActionListener() { // 8
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneInSystemDto dto = new AirplaneInSystemDto(airplaneCode.getText());
                int prio = Integer.parseInt(priority.getText());
                if(airport.changePriorityOfPlane(dto, prio)) {
                    JOptionPane.showMessageDialog(null, "Plane priority changed!");
                }else{

                }
            }
        });
        stopDemand.addActionListener(new ActionListener() { // 10
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneInSystemDto dto = new AirplaneInSystemDto(airplaneCode.getText());
                if(airport.stopRunwayDemand(dto)) {
                    JOptionPane.showMessageDialog(null, "Plane priority changed!");
                }else{

                }
            }
        });
        addPlane.addActionListener(new ActionListener() { // add airplane
            @Override
            public void actionPerformed(ActionEvent e) {
                AirplaneDto dto = new AirplaneDto(manufacturerTextfield.getText(), typeTextField.getText(), airplaneCodeTextField.getText(), Integer.parseInt(minRunwayLengthTextField.getText()), Integer.parseInt(priorityTextField.getText()));
                if(airport.addPlane(dto)) {
                    JOptionPane.showMessageDialog(null, "Plane registered!");
                }else{
                    JOptionPane.showMessageDialog(null, "This code is not unique!");
                }
            }
        });
        nRunways.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airport.generateRunways(Integer.parseInt(nOfRunwaysByTypeGenerated.getText()));
            }
        });
        generateNAirPlanesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airport.generatePlanes(Integer.parseInt(nOfPlanesGenerated.getText()));
            }
        });
        makePlanesDemandRunwayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airport.makePlanesDemandRunway();
            }
        });
        arrivalOfAirplanesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                airport.makePlanesArrive();
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
