package frm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Reservation;
import Managers.Reservationmanager;

public class frmReservation extends JFrame
{


    private JLabel lblRoomnumber;
    private JLabel lblStartDate;
    private JLabel lblEndDate;


    private JTextField txtRoomnumber;
    private JTextField txtStartDate;
    private JTextField txtEndDate;

    private JPanel panel;

    private JButton btnsave;

    public frmReservation() {

        super("Reservation");
        this.setBounds(200, 100, 500, 500);
        this.setLayout(new FlowLayout());

        lblRoomnumber = new JLabel("شماره اتاق");
        lblStartDate = new JLabel("تاریخ شروع");
        lblEndDate = new JLabel("تاریخ پایان ");


        txtRoomnumber = new JTextField();
        txtRoomnumber.setPreferredSize(new Dimension(190, 20));
        txtStartDate = new JTextField();
        txtStartDate.setPreferredSize(new Dimension(190, 20));
        txtEndDate = new JTextField();
        txtEndDate.setPreferredSize(new Dimension(190, 20));


        panel = new JPanel();
        panel.setPreferredSize(new Dimension(350, 250));
        panel.setBackground(Color.LIGHT_GRAY);


        panel.add(txtRoomnumber);
        panel.add(lblRoomnumber);
        panel.add(txtStartDate);
        panel.add(lblStartDate);
        panel.add(txtEndDate);
        panel.add(lblEndDate);


        btnsave = new JButton("ثبت رزرو");
        btnsave.setPreferredSize(new Dimension(200, 30));


        btnsave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String roomnumber = txtRoomnumber.getText();


                if (roomnumber.length() > 0) {

                    for (int i = 0; i < roomnumber.length(); i++) {
                        if (roomnumber.charAt(i) < '0' || roomnumber.charAt(i) > '9') {

                            JOptionPane.showMessageDialog(null, "شماره اتاق: لطفا عدد وارد کنید   ", "مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }

                Reservation r = new Reservation(Integer.parseInt(txtRoomnumber.getText()), txtStartDate.getText(), txtEndDate.getText());


                if (r.getRoomNumber() <= 0 || r.getFromDate() == null || r.getToDate() == null) {
                    JOptionPane.showMessageDialog(null, "اطلاعات نامعتبر است - ثبت انجام نشد", "مدیریت هتل", JOptionPane.ERROR_MESSAGE);
                    return;

                }


                Reservationmanager rm = new Reservationmanager("reservation.txt");
                rm.addReservation(r);
                JOptionPane.showMessageDialog(null, " رزرو با موفقیت انجام شد ", "مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);


                HotelFlow.fromDate = txtStartDate.getText();
                HotelFlow.toDate = txtEndDate.getText();

                new frmEquality();
                dispose();
            }


        });


        panel.add(btnsave);
        this.add(panel);
        this.setVisible(true);

    }
}



