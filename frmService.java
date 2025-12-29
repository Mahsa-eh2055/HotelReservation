package frm;

import Managers.Servicemanager;
import model.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmService extends JFrame {

    private JComboBox<String> cmbType;
    private JComboBox<String> cmbPrice;
    private JTextField txtRoom;
    private JButton btnInsert;

    private String[] services = {"خشکشویی", "نظافت", "تعمیرات", "ترانسفر"};
    private String[] prices = {"50000","100000","200000","300000"};

    public frmService() {

        super("Service");
        setBounds(200,100,500,500);
        setLayout(new FlowLayout());

        cmbType = new JComboBox<>(services);
        cmbPrice = new JComboBox<>(prices);

        txtRoom = new JTextField(15);

        btnInsert = new JButton("ثبت خدمات");

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String type = (String) cmbType.getSelectedItem();
                String price = (String) cmbPrice.getSelectedItem();
                String room = txtRoom.getText().trim();

                if (!isNumber(room)) {
                    JOptionPane.showMessageDialog(null, "شماره اتاق باید عدد باشد");
                    return;
                }

                Service s = new Service(type, price, room);

                Servicemanager sm = new Servicemanager("services.txt");
                sm.addService(s);

                JOptionPane.showMessageDialog(null,"خدمات با موفقیت ثبت شد");

                HotelFlow.servicePrice += Integer.parseInt(price);

                new frmPay();
                dispose();

                txtRoom.setText("");
            }
        });

        add(new JLabel("نوع خدمات")); add(cmbType);
        add(new JLabel("قیمت")); add(cmbPrice);
        add(new JLabel("شماره اتاق")); add(txtRoom);
        add(btnInsert);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private boolean isNumber(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        return true;
    }

}
