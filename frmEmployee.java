package frm;

import Managers.Employeemanager;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmEmployee extends JFrame {

    private JLabel lblPersonnel;
    private JLabel lblName;
    private JLabel lblRole;
    private JLabel lblShift;

    private JTextField txtPersonnel;
    private JTextField txtName;

    private JComboBox<String> cmbRole;
    private JComboBox<String> cmbShift;

    private JButton btnInsert;
    private JPanel panel;

    private String[] roles = {"پذیرش", "خدمات", "سرپرست"};
    private String[] shifts = {"صبح", "عصر", "شب"};

    public frmEmployee() {

        super("کارمند");
        this.setBounds(200, 100, 500, 500);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblPersonnel = new JLabel("کد پرسنلی");
        lblName = new JLabel("نام");
        lblRole = new JLabel("نقش");
        lblShift = new JLabel("شیفت");

        txtPersonnel = new JTextField();
        txtPersonnel.setPreferredSize(new Dimension(150, 25));

        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(150, 25));

        cmbRole = new JComboBox<>(roles);
        cmbShift = new JComboBox<>(shifts);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(450, 300));
        panel.setBackground(Color.lightGray);

        panel.add(txtPersonnel);
        panel.add(lblPersonnel);

        panel.add(txtName);
        panel.add(lblName);

        panel.add(cmbRole);
        panel.add(lblRole);

        panel.add(cmbShift);
        panel.add(lblShift);

        btnInsert = new JButton("ثبت کارمند");
        btnInsert.setPreferredSize(new Dimension(150, 30));

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String personnel = txtPersonnel.getText();
                String name = txtName.getText();
                String role = (String) cmbRole.getSelectedItem();
                String shift = (String) cmbShift.getSelectedItem();

                if (personnel.length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "کد پرسنلی را وارد کنید",
                            "مدیریت هتل",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                for (int i = 0; i < personnel.length(); i++) {
                    char c = personnel.charAt(i);
                    if (c < '0' || c > '9') {
                        JOptionPane.showMessageDialog(null,
                                "کد پرسنلی باید عدد باشد",
                                "مدیریت هتل",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (name.length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "نام را وارد کنید",
                            "مدیریت هتل",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                for (int i = 0; i < name.length(); i++) {
                    char c = name.charAt(i);
                    if (c >= '0' && c <= '9') {
                        JOptionPane.showMessageDialog(null,
                                "نام باید شامل حروف باشد",
                                "مدیریت هتل",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                int personnelCode = Integer.parseInt(personnel);

                Employee emp = new Employee(personnelCode, name, role, shift);
                Employeemanager em = new Employeemanager("employees.txt");
                em.addEmployee(emp);

                JOptionPane.showMessageDialog(null,
                        "کارمند با موفقیت ثبت شد",
                        "مدیریت هتل",
                        JOptionPane.INFORMATION_MESSAGE);

                txtPersonnel.setText("");
                txtName.setText("");
            }
        });

        panel.add(btnInsert);
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new frmEmployee();
    }
}