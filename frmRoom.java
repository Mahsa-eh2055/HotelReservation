package frm;

import Managers.Hotelmanager;
import Managers.Roommanager;
import model.Hotel;
import model.Room;
import model.Roomstatus;
import model.Roomtype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmRoom extends JFrame {

    private JComboBox<String> cmbHotel;
    private JComboBox<String> cmbRoomType;

    private JTextArea txtArea;
    private JTextField txtRoomNumber;

    private JRadioButton rbtnEmpty;
    private JRadioButton rbtnCleaning;
    private JRadioButton rbtnRepair;

    private JButton btnShow;
    private JButton btnReserve;
    private JButton btnChangeStatus;

    private Hotelmanager hotelmanager;
    private Roommanager roommanager;

    public frmRoom() {

        super("مدیریت اتاق‌ها");
        this.setBounds(200, 100, 500, 500);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hotelmanager = new Hotelmanager();
        roommanager = new Roommanager("rooms.txt");

        cmbHotel = new JComboBox<>();
        for (Hotel h : hotelmanager.getHotels()) {
            cmbHotel.addItem(h.getName());
        }

        cmbRoomType = new JComboBox<>();
        cmbRoomType.addItem(Roomtype.SINGLE.toString());
        cmbRoomType.addItem(Roomtype.DOUBLE.toString());

        txtArea = new JTextArea(10, 40);
        txtArea.setEditable(false);

        txtRoomNumber = new JTextField();
        txtRoomNumber.setPreferredSize(new Dimension(80, 25));

        rbtnEmpty = new JRadioButton("Empty");
        rbtnCleaning = new JRadioButton("Cleaning");
        rbtnRepair = new JRadioButton("Repair");

        ButtonGroup group = new ButtonGroup();
        group.add(rbtnEmpty);
        group.add(rbtnCleaning);
        group.add(rbtnRepair);

        btnShow = new JButton("نمایش اتاق‌های خالی");
        btnReserve = new JButton("رزرو اتاق");
        btnChangeStatus = new JButton("تغییر وضعیت");

        add(new JLabel("هتل"));
        add(cmbHotel);

        add(new JLabel("نوع اتاق"));
        add(cmbRoomType);

        add(new JScrollPane(txtArea));

        add(btnShow);
        add(btnReserve);

        add(new JLabel("شماره اتاق"));
        add(txtRoomNumber);

        add(rbtnEmpty);
        add(rbtnCleaning);
        add(rbtnRepair);

        add(btnChangeStatus);

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmptyRooms();
            }
        });

        btnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reserveRoom();
            }
        });

        btnChangeStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String roomStr = txtRoomNumber.getText();
                if (roomStr.length() == 0) {
                    JOptionPane.showMessageDialog(null, "شماره اتاق را وارد کنید");
                    return;
                }

                int roomNumber;
                try {
                    roomNumber = Integer.parseInt(roomStr);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "شماره اتاق نامعتبر است");
                    return;
                }

                String hotelName = (String) cmbHotel.getSelectedItem();
                Room found = null;

                List<Room> rooms = roommanager.getAllRooms();
                for (Room r : rooms) {
                    if (r.getHotelName().equals(hotelName)
                            && r.getRoomNumber() == roomNumber) {
                        found = r;
                        break;
                    }
                }

                if (found == null) {
                    JOptionPane.showMessageDialog(null, "اتاق پیدا نشد");
                    return;
                }

                if (rbtnEmpty.isSelected())
                    found.setStatus(Roomstatus.EMPTY);
                else if (rbtnCleaning.isSelected())
                    found.setStatus(Roomstatus.CLEANING);
                else if (rbtnRepair.isSelected())
                    found.setStatus(Roomstatus.REPAIR);
                else {
                    JOptionPane.showMessageDialog(null, "وضعیت را انتخاب کنید");
                    return;
                }

                roommanager.updateRoom(found);
                JOptionPane.showMessageDialog(null, "وضعیت اتاق تغییر کرد");
                showEmptyRooms();
            }
        });

        this.setVisible(true);
    }

    private void showEmptyRooms() {
        txtArea.setText("");

        String hotelName = (String) cmbHotel.getSelectedItem();
        String roomType = (String) cmbRoomType.getSelectedItem();

        List<Room> rooms = roommanager.findEmptyRooms(hotelName, roomType);

        if (rooms.size() == 0) {
            txtArea.setText("اتاق خالی وجود ندارد");
            return;
        }

        for (Room r : rooms) {
            txtArea.append("طبقه: " + r.getFloorNumber()
                    + "  اتاق: " + r.getRoomNumber()
                    + "  قیمت: " + r.getPrice() + "\n"); // اضافه کردن قیمت
        }
    }

    private void reserveRoom() {
        String hotelName = (String) cmbHotel.getSelectedItem();
        String roomType = (String) cmbRoomType.getSelectedItem();

        List<Room> rooms = roommanager.findEmptyRooms(hotelName, roomType);

        if (rooms.size() == 0) {
            JOptionPane.showMessageDialog(null, "اتاقی برای رزرو نیست");
            return;
        }

        Room r = rooms.get(0);
        r.setStatus(Roomstatus.FULL);
        roommanager.updateRoom(r);

        JOptionPane.showMessageDialog(null,
                "اتاق " + r.getRoomNumber() + " رزرو شد");

        HotelFlow.hotelName = hotelName;
        HotelFlow.roomNumber = r.getRoomNumber();
        HotelFlow.equalityPrice = r.getPrice();

        new frmReservation();
        dispose();
    }

}
