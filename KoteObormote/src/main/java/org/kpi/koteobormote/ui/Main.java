package org.kpi.koteobormote.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.kpi.koteobormote.core.data.ObjectToParse;
import org.kpi.koteobormote.core.util.Util;

import com.google.gson.Gson;

public class Main {

    private static void createAndShowGUI() {
        JFrame application = new JFrame("Kote abormote");
        JButton connect = new JButton();
        final JLabel responce = new JLabel();
        connect.setText("Connect");
        application.getContentPane().add(BorderLayout.NORTH, connect);
        application.getContentPane().add(BorderLayout.CENTER, responce);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(300, 300);
        connect.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String message = Util.retrieveMessage();
                Gson gson = new Gson();
                ObjectToParse json = gson.fromJson(message, ObjectToParse.class);
                responce.setText(json.getString());
            }

        });
        application.setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
}
