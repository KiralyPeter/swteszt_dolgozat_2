/*
* File: InputPanel.java
* Author: Király Péter
* Copyright: 2023, Király Péter
* Group: Szoft-1-2-E
* Date: 2023-05-23
* Github: https://github.com/KiralyPeter/swteszt_dolgozat_2.git
* Licenc: GNU GPL
*/

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

    InputPanel megmunkaltHossz;
    InputPanel fordulatonkentiElotolas;
    InputPanel foorsoFordulatszam;
    InputPanel megmunkalasiIdo;
    JPanel buttoPanel;
    JButton calcButton;


    public MainFrame() {
        this.initComponent();
        this.addComponent();
        this.hadleEvent();
        this.setFrame();
    }

    private void initComponent(){
        this.megmunkaltHossz = new InputPanel("Hossz: (mm)");
        this.fordulatonkentiElotolas = new InputPanel("Előtolás (mm)");
        this.foorsoFordulatszam = new InputPanel ("Fordulatszám (1/m):");
        this.buttoPanel = new JPanel();
        this.megmunkalasiIdo = new InputPanel("Megmunkálási idő (perc):");
        this.calcButton = new JButton("Számít");
    }

    private void addComponent(){
        this.add(this.megmunkaltHossz);
        this.add(this.fordulatonkentiElotolas);
        this.add(this.foorsoFordulatszam);
        this.add(this.buttoPanel);
        this.add(this.megmunkalasiIdo);
        this.buttoPanel.add(this.calcButton);
    }

    private void hadleEvent(){
        this.calcButton.addActionListener( e -> {
            startCalc();
        }); //névtelen függvény
    }

    private void startCalc(){
        String hosszStr = this.megmunkaltHossz.getValue();
        if(!this.checkInput(hosszStr)){
            JOptionPane.showMessageDialog(this, "Csak számjegy!");
            return; // hogy ne számoljon 
        }
        double hossz = Double.parseDouble(hosszStr);
        
        String elotolasStr = this.fordulatonkentiElotolas.getValue();
        if(!this.checkInput(elotolasStr)){
            JOptionPane.showMessageDialog(this, "Csak számjegy!");
            return; // hogy ne számoljon 
        }
        double elotolas = Double.parseDouble(elotolasStr);

        String fordulatszamStr = this.foorsoFordulatszam.getValue();
        if(!this.checkInput(fordulatszamStr)){
            JOptionPane.showMessageDialog(this, "Csak számjegy!");
            return; // hogy ne számoljon 
        }
        double fordulaszam = Double.parseDouble(fordulatszamStr);

        Double ido = this.calcTime(hossz, elotolas, fordulaszam);
        this.megmunkalasiIdo.setValue(ido.toString());        
        
    }

    public double calcTime(double lenght, double elotolas, double rotation){   
        double time = lenght / (elotolas * rotation);
        return time;
        
    }

    public boolean checkInput(String input){
        boolean ok = false;
        if(input.matches("[0-9.]+")){
            ok = true;
        }
        return ok;
    }

    private void setFrame() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        // this.setSize(300, 200);
        this.setVisible(true);
    }
    
}
