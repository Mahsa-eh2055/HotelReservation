package frm;

import Managers.Equalitymanager;
import Managers.Roommanager;
import model.Customer;
import model.Equality;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class frmEquality extends JFrame {

    private JLabel lblRoomNumber;
    private JLabel lblEquality;

    private JTextField txtRoomNumber;

    private JCheckBox playRoom;
    private JCheckBox conference;
    private JCheckBox pool;
    private JCheckBox gym;
    private JCheckBox parking;
    private JCheckBox wifi;

    private JButton btnSave;
    private JPanel panel;

    private Equalitymanager equalitymanager;
    public frmEquality() {

        super("امکانات هتل");
        this.setBounds(200, 100, 500, 500);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        lblRoomNumber = new JLabel("شماره اتاق");
        lblEquality = new JLabel("امکانات و قیمت");

        txtRoomNumber = new JTextField();
        txtRoomNumber.setPreferredSize(new Dimension(150, 25));

        playRoom   = new JCheckBox("اتاق بازی (200000)");
        conference = new JCheckBox("اتاق کنفرانس (500000)");
        pool       = new JCheckBox("استخر (150000)");
        gym        = new JCheckBox("باشگاه (300000)");
        parking    = new JCheckBox("پارکینگ (50000)");
        wifi       = new JCheckBox("وای فای (200000)");

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 350));
        panel.setBackground(Color.lightGray);

        panel.add(txtRoomNumber);
        panel.add(lblRoomNumber);
        panel.add(lblEquality);

        panel.add(playRoom);
        panel.add(conference);
        panel.add(pool);
        panel.add(gym);
        panel.add(parking);
        panel.add(wifi);

        btnSave = new JButton("ثبت امکانات");
        btnSave.setPreferredSize(new Dimension(150, 30));

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String roomNumber = txtRoomNumber.getText();

                if (roomNumber.length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "شماره اتاق را وارد کنید",
                            "مدیریت هتل",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int Price = 0;
                String type = "";

                if (playRoom.isSelected()) {
                    Price += 200000;
                    type += "اتاق بازی ";
                }
                if (conference.isSelected()) {
                    Price += 500000;
                    type += "کنفرانس ";
                }
                if (pool.isSelected()) {
                    Price += 150000;
                    type += "استخر ";
                }
                if (gym.isSelected()) {
                    Price += 300000;
                    type += "باشگاه ";
                }
                if (parking.isSelected()) {
                    Price += 50000;
                    type += "پارکینگ ";
                }
                if (wifi.isSelected()) {
                    Price += 200000;
                    type += "وای فای ";
                }

                if (type.length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "حداقل یک امکان را انتخاب کنید",
                            "مدیریت هتل",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                Equality eb = new Equality(type,  String.valueOf(Price) , roomNumber);
                if (eb.getEqualityType() == null || eb.getPrice() == null || eb.getRoomNumber() == null) {
                    JOptionPane.showMessageDialog(null, "اطلاعات نامعتبر است - ثبت انجام نشد", "مدیریت هتل", JOptionPane.ERROR_MESSAGE);
                    return;

                }
                Equalitymanager em = new Equalitymanager("equality.txt");
                em.addEquality(eb);

                JOptionPane.showMessageDialog(null,
                        "اتاق" + roomNumber +
                                "\nامکانات: " + type +
                                "\nمبلغ کل: " + Price,
                        "مدیریت هتل",
                        JOptionPane.INFORMATION_MESSAGE);

                HotelFlow.equalityTypes = type;
                HotelFlow.equalityPrice += Price;

                new frmService();
                dispose();
            }
        });

        panel.add(btnSave);
        this.add(panel);
        this.setVisible(true);
    }
}