import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu extends JFrame {

    private static final String APP_TITLE = "Smart Home";
    private static final int MAX_LUMINOSITY = 1000;
    private static final int MIN_LUMINOSITY = 250;

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
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JButton beginCookingButton;
    private JProgressBar progressBar1;
    private JTextArea Output;
    private JSpinner spinner1;
    private JLabel lightStatusLbl;
    private JLabel currentLumins;
    public ButtonGroup coffeeSettings;

    private int currentLuminosity = 1000;

    public MainMenu(){
        super(APP_TITLE);
        panel1.setPreferredSize(new Dimension(830,350));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        setupSpinner();
        toggleLightOnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String status = main.lightClient.toggleLights();
                if(status.contains("on")){
                    lightStatusLbl.setText("Light Status: On");
                }else{
                    lightStatusLbl.setText("Light Status: Off");
                }
            }
        });
    }

    private void setupSpinner(){
        ((JSpinner.DefaultEditor)spinner1.getEditor()).getTextField().setEditable(false);
        spinner1.setValue(currentLuminosity);

        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {

                if(!main.lightClient.isStreamActive()){
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    //ends the stream after 10 seconds
                                    main.lightClient.endStream();
                                    main.lightClient.getLightsStatus();
                                }
                            },
                            10000
                    );
                }
                main.lightClient.changeLuminosity((int)spinner1.getValue());
                currentLumins.setText("Current Luminosity: " + spinner1.getValue());
            }
        });

    }

}
