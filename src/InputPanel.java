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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

public class InputPanel extends JPanel{
    JLabel label;
    JTextField field;

    public InputPanel() {
        this.initComponent();
        this.setupComponent();
        this.addComponent();
        this.setuPpanel();
    }

    // másik konstruktor!!!
    // a megjelenő szöveget paraméterként kérjük 
    public InputPanel(String text) {
        this.initComponent();
        this.setupComponent();
        this.label.setText(text);        
        addComponent();
        this.setuPpanel();
    }

    private void initComponent() {
        this.label = new JLabel();
        this.field = new JTextField();
    }
    
    private void setupComponent(){
        this.label.setPreferredSize(new Dimension(200, 25));
        this.field.setPreferredSize(new Dimension(200, 25));
    }

    private void setuPpanel(){
        this.setBorder(
            new EmptyBorder(5, 10, 5, 10));
    }

    // beállítók
    public void setLabel(String text){
        this.label.setText(text);
    }
    
    public void setValue(String text){
        this.field.setText(text);
    }

    public String getValue(){
        return this.field.getText();
    }

    private void addComponent(){
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(this.label);
        this.add(this.field);
    }
}
