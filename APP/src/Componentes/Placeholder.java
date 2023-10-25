package Componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Placeholder {
    private String placeholder;

    public void geralConfig(JTextField textCamp, String placeholder) {
        this.placeholder = placeholder;
        textCamp.setForeground(Color.GRAY);
        textCamp.setText(placeholder);


        textCamp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textCamp.getText().equals(placeholder)) {
                    System.out.println("dei foco");
                    System.out.println(textCamp.getText());
                    textCamp.setText("");
                    System.out.println(textCamp.getText());
                    textCamp.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textCamp.getText().isEmpty()) {
                    textCamp.setText(placeholder);
                    System.out.println(textCamp.getText());
                    textCamp.setForeground(Color.GRAY);
                }
            }
        });
    }
}
