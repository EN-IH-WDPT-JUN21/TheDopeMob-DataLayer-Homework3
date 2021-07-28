/*
package com.ironhack.opportunity;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

 public class Opportunity extends JDialog {

        private final JPanel contentPanel = new JPanel();
        private final JTextField textField;
        private final JTextField textField_1;
        private final JTextField textField_3;
        private final JTextField textField_4;


        public static void main(String[] args, int id) {
            try {
                Opportunity dialog = new Opportunity(id);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public Opportunity(Integer id) {
            ContactManager Cm = new ContactManager();

            setBounds(100, 100, 498, 282);
            getContentPane().setLayout(new BorderLayout());
            contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            getContentPane().add(contentPanel, BorderLayout.CENTER);
            contentPanel.setLayout(null);

            textField = new JTextField();
            textField.setEnabled(false);
            textField.setText(id.toString());
            textField.setBounds(97, 11, 116, 20);
            contentPanel.add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setBounds(97, 37, 116, 20);
            contentPanel.add(textField_1);
            textField_1.setColumns(10);

            textField_3 = new JTextField();
            textField_3.setBounds(97, 89, 116, 20);
            contentPanel.add(textField_3);
            textField_3.setColumns(10);

            textField_4 = new JTextField();
            textField_4.setBounds(97, 113, 375, 87);
            contentPanel.add(textField_4);
            textField_4.setColumns(10);

            JLabel lblNewLabel = new JLabel("Customer ID");
            lblNewLabel.setBounds(10, 14, 77, 14);
            contentPanel.add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("Date");
            lblNewLabel_1.setBounds(10, 40, 46, 14);
            contentPanel.add(lblNewLabel_1);

            JLabel lblNewLabel_2 = new JLabel("Contact Type");
            lblNewLabel_2.setBounds(10, 67, 77, 14);
            contentPanel.add(lblNewLabel_2);

            JLabel lblNewLabel_3 = new JLabel("City");
            lblNewLabel_3.setBounds(10, 92, 77, 14);
            contentPanel.add(lblNewLabel_3);

            JLabel lblNewLabel_4 = new JLabel("Description");
            lblNewLabel_4.setBounds(10, 116, 64, 14);
            contentPanel.add(lblNewLabel_4);

            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Name");
            comboBox.addItem("Telephone");
            comboBox.addItem("E-Mail");
            comboBox.addItem("Company Name");
            comboBox.setBounds(97, 64, 116, 20);
            contentPanel.add(comboBox);

            {
                JPanel buttonPane = new JPanel();
                buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
                getContentPane().add(buttonPane, BorderLayout.SOUTH);
                {
                    JButton okButton = new JButton("OK");
                    okButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            String[] dates = textField_1.getText().split("-");
                            int year = Integer.parseInt(dates[0]) - 1900;
                            int month = Integer.parseInt(dates[1]) - 1;
                            int day = Integer.parseInt(dates[2]);
                            Date d = new Date(year, month, day);
                            ContactManager contact = new ContactManager(Integer
                                    .parseInt(textField.getText()), d, comboBox
                                    .getSelectedItem().toString(), textField_3
                                    .getText(), textField_4.getText());
                            Cm.addContact(contact);
                            dispose();
                        }
                    });
                    okButton.setActionCommand("OK");
                    buttonPane.add(okButton);
                    getRootPane().setDefaultButton(okButton);
                }
                {
                    JButton cancelButton = new JButton("Abort");
                    cancelButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            dispose();
                        }
                    });
                    cancelButton.setActionCommand("Cancel");
                    buttonPane.add(cancelButton);

                }
            }
        }
    }
*/
