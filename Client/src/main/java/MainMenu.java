import io.grpc.examples.coffee_maker.BrewType;
import io.grpc.examples.oven.OvenSetting;
import io.grpc.examples.oven.OvenStatus;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    private static final String APP_TITLE = "Smart Home";
    private static final int MAX_LUMINOSITY = 1000;
    private static final int MIN_LUMINOSITY = 250;
    private static final int INITIAL_LUMINOSITY = 1000;

    private JPanel panel1;
    private JPanel SmartLightPanel;
    private JPanel SmartHeatingPanel;
    private JPanel SmartCoffeeMakerPanel;
    private JPanel SmartOvenPanel;
    private JButton toggleLightOnOffButton;
    private JButton toggleHeatingOnOffButton;
    private JPanel CoffeeControlPanel;
    private JRadioButton fullCarafeRBtn;
    private JRadioButton singleCupRBtn;
    private JRadioButton halfCarafeRBtn;
    private JButton beginBrewingBtn;
    private JRadioButton grillRadioButton;
    private JRadioButton fanAssistedRadioButton;
    private JRadioButton unassistedRadioButton;
    private JSlider tempSlider;
    private JSlider ovenTempSlider;
    private JSlider ovenTimeSlider;
    private JButton beginCookingButton;
    private JProgressBar brewingProgressBar;
    private JSpinner spinner1;
    private JLabel lightStatusLbl;
    private JLabel currentLumins;
    private JLabel heatingStatusTxt;
    private JLabel tempLbl;
    private JLabel ovenTimerlbl;
    private JLabel ovenCurrentTemp;
    private JLabel ovenTempSetting;
    private JTextField coffeeOutput;
    private JTextField heatingOutput;
    private JTextField lightsOutput;
    private JTextField ovenOutput;
    public ButtonGroup coffeeSettings;



    public MainMenu(){
        super(APP_TITLE);
        panel1.setPreferredSize(new Dimension(830,350));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        setupLighting();
        setupCoffeeMachine();
        setupHeating();
        setupOven();
    }

    private void setupCoffeeMachine(){
        beginBrewingBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    main.coffeeMakerClient.beginBrewing(output -> coffeeOutput.setText(output), progress -> updateCoffeeProgress(progress));
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    coffeeOutput.setText("Could not connect to service");
                }
            }
        });

        singleCupRBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (singleCupRBtn.isSelected()) {
                        String response = main.coffeeMakerClient.setBrewingType(BrewType.type.SINGLE_CUP);
                        coffeeOutput.setText(response);
                    }
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    coffeeOutput.setText("Could not connect to service");
                }
            }
        });

        halfCarafeRBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (halfCarafeRBtn.isSelected()) {
                        String response = main.coffeeMakerClient.setBrewingType(BrewType.type.HALF_CARAFE);
                        coffeeOutput.setText(response);
                    }
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    coffeeOutput.setText("Could not connect to service");
                }
            }
        });

        fullCarafeRBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fullCarafeRBtn.isSelected()) {
                        String response = main.coffeeMakerClient.setBrewingType(BrewType.type.CARAFE);
                        coffeeOutput.setText(response);
                    }
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    coffeeOutput.setText("Could not connect to service");
                }
            }
        });
    }

    private void setupLighting(){
        ((JSpinner.DefaultEditor)spinner1.getEditor()).getTextField().setEditable(false);
        spinner1.setValue(INITIAL_LUMINOSITY);

        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                try{
                    if(!main.lightClient.isStreamActive()){
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    @Override
                                    public void run() {
                                        //ends the stream after 10 seconds
                                        try {
                                            main.lightClient.endStream();
                                            lightsOutput.setText(main.lightClient.getLightsStatus());
                                        } catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                                            lightsOutput.setText("Could not connect to service");
                                            lightStatusLbl.setText("Light Status: Off");
                                        }
                                    }
                                },
                                10000
                        );
                    }
                    main.lightClient.changeLuminosity((int)spinner1.getValue(), (value) -> lightsOutput.setText(value));
                    currentLumins.setText("Current Luminosity: " + spinner1.getValue());
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    lightsOutput.setText("Could not connect to service");
                    lightStatusLbl.setText("Light Status: Off");
                }
            }
        });
        toggleLightOnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String status = main.lightClient.toggleLights();
                    if (status.contains("on")) {
                        lightStatusLbl.setText("Light Status: On");
                    } else {
                        lightStatusLbl.setText("Light Status: Off");
                    }
                    lightsOutput.setText(status);
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    lightsOutput.setText("Could not connect to service");
                    lightStatusLbl.setText("Light Status: Off");
                }
            }
        });
    }

    public void setupHeating(){
        toggleHeatingOnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String response = main.heatingClient.toggleHeatingSystemStatus();
                    if (response.contains("on")) {
                        heatingStatusTxt.setText("Heating is currently on");
                    } else {
                        heatingStatusTxt.setText("Heating is currently off");
                    }
                    heatingOutput.setText(response);
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    heatingOutput.setText("Could not connect to service");
                    heatingStatusTxt.setText("Heating is currently off");
                }
            }
        });
        //tempSlider.setValue((int)main.heatingClient.getSystemTempSetting());
        tempSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                try {
                    main.heatingClient.changeSystemTempSettings(tempSlider.getValue());
                    int temp = main.heatingClient.getSystemTempSetting();
                    tempSlider.setValue(temp);
                    tempLbl.setText("Temp Setting " + temp + " degrees");
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    heatingOutput.setText("Could not connect to service");
                    heatingStatusTxt.setText("Heating is currently off");
                }
            }
        });
    }

    public void setupOven(){
        grillRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String response = main.ovenClient.changeSetting(OvenSetting.Setting.GRILL);
                    ovenOutput.setText(response);
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    ovenOutput.setText("Could not connect to service");
                }
            }
        });
        fanAssistedRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String response = main.ovenClient.changeSetting(OvenSetting.Setting.FAN_ASSISTED);
                    ovenOutput.setText(response);
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    ovenOutput.setText("Could not connect to service");
                }
            }
        });
        unassistedRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String response = main.ovenClient.changeSetting(OvenSetting.Setting.UNASSISTED);
                    ovenOutput.setText(response);
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    ovenOutput.setText("Could not connect to service");
                }
            }
        });
        ovenTempSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                try {
                    String response = main.ovenClient.setTemp(ovenTempSlider.getValue());
                    if (response != null) {
                        ovenOutput.setText(response);
                        ovenTempSetting.setText("Temp Setting: " + ovenTempSlider.getValue() + " Degrees");
                    }
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    ovenOutput.setText("Could not connect to service");
                }
            }
        });

        ovenTimeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                try {
                    String response = main.ovenClient.setTimer(ovenTimeSlider.getValue());
                    if (response != null) {
                        ovenOutput.setText(response);
                        ovenTimerlbl.setText("Temp Setting: " + ovenTimeSlider.getValue() + " Mins");
                    }
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    ovenOutput.setText("Could not connect to service");
                }
            }
        });

        beginCookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    main.ovenClient.startCooking(status -> updateOvenStatus(status));
                }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
                    ovenOutput.setText("Could not connect to service");
                }
            }
        });
    }

    public void updateCoffeeProgress(double progress){
        brewingProgressBar.setValue((int) progress);
        brewingProgressBar.setString("Brewing Progress " + (int)progress + "%");
    }

    public void updateOvenStatus(OvenStatus currentStatus){
        try {
            if (currentStatus.getStatus().equals(OvenStatus.Status.PRE_HEAT)) {
                ovenOutput.setText("Oven is currently preheating, cooking will begin soon");
                ovenCurrentTemp.setText("Current Temp: " + (int) currentStatus.getCurrentTemp() + " Degrees");
            } else {
                ovenTimeSlider.setValue(currentStatus.getRemainingTime());
                ovenTimerlbl.setText("Timer in mins: " + currentStatus.getRemainingTime());
                ovenCurrentTemp.setText("Current Temp: " + (int) currentStatus.getCurrentTemp() + " Degrees");
                ovenOutput.setText("Oven is: " + currentStatus.getStatus());
                if(currentStatus.getStatus().equals(OvenStatus.Status.OFF)){
                    //if off check connection is still active, if not exception is thrown to be caught by try catch
                    ovenTempSlider.setValue(0);
                    ovenTempSetting.setText("Temp Setting: 0 Degrees");
                    main.ovenClient.getCurrentStatus();
                }
            }
        }catch (java.lang.NullPointerException | io.grpc.StatusRuntimeException e){
            ovenOutput.setText("Could not connect to service");
        }
    }
}