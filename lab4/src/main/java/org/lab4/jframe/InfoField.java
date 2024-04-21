package org.lab4.jframe;

import javax.swing.*;

public class InfoField extends JPanel {
    private int width;
    private int height;

    private int valueTextWidth = 150;
    private String fieldText;
    private JLabel valueText;

    public InfoField(int posX, int posY, int width, int height, String fieldText) {
        this.width = width;
        this.height = height;
        this.fieldText = fieldText;

        setBounds(posX, posY, width + valueTextWidth, height);

        setLayout(null);

        addField();

        setVisible(true);
    }

    public void updateValue(int value) {
        valueText.setText(Integer.toString(value));
    }

    private void addField() {
        JLabel text = new JLabel();
        text.setText(fieldText);
        text.setVerticalAlignment(JLabel.TOP);
        text.setHorizontalAlignment(JLabel.LEFT);
        text.setBounds(0, 0, width, height);
        text.setOpaque(false);
        add(text);

        valueText = new JLabel();
        valueText.setText("0");
        valueText.setVerticalAlignment(JLabel.TOP);
        valueText.setHorizontalAlignment(JLabel.LEFT);
        valueText.setBounds(width, 0, valueTextWidth, height);
        valueText.setOpaque(false);
        add(valueText);
    }
}
