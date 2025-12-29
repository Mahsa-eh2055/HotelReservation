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

import model.Customer;
import Managers.Customermanager;

public class frmCustomer extends JFrame {

    private JLabel lblfirstName;
    private JLabel lbllastName;
    private JLabel lblnationalcode;
    private JLabel lblphonenumber;

    private JTextField txtfirstName;
    private JTextField txtlastName;
    private JTextField txtnationalcode;
    private JTextField txtphonenumber;

    private JPanel insertpanel;

    private JButton btnInsertCustomer;

    public frmCustomer() {

        super("Customer");
        this.setBounds(200, 100, 500, 500);
        this.setLayout(new FlowLayout());

        lblfirstName = new JLabel(" نام مسافر");
        lbllastName = new JLabel("نام خانوادگی");
        lblnationalcode = new JLabel("کدملی مسافر");
        lblphonenumber = new JLabel("شماره تماس");


        txtfirstName = new JTextField();
        txtfirstName.setPreferredSize(new Dimension(150, 25));
        txtlastName = new JTextField();
        txtlastName.setPreferredSize(new Dimension(150, 25));
        txtnationalcode = new JTextField();
        txtnationalcode.setPreferredSize(new Dimension(150, 25));
        txtphonenumber = new JTextField();
        txtphonenumber.setPreferredSize(new Dimension(150, 25));


        insertpanel = new JPanel();
        insertpanel.setPreferredSize(new Dimension(350, 200));
        insertpanel.setBackground(Color.gray);

        insertpanel.add(txtfirstName);
        insertpanel.add(lblfirstName);
        insertpanel.add(txtlastName);
        insertpanel.add(lbllastName);
        insertpanel.add(txtnationalcode);
        insertpanel.add(lblnationalcode);
        insertpanel.add(txtphonenumber);
        insertpanel.add(lblphonenumber);

        btnInsertCustomer = new JButton("ثبت مسافر");
        btnInsertCustomer.setPreferredSize(new Dimension(150, 30));


        btnInsertCustomer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = txtfirstName.getText();
                String lastname = txtlastName.getText();
                String nationalcode = txtnationalcode.getText();
                String phonenumber = txtphonenumber.getText();


                Customer c = new Customer(firstname, lastname, nationalcode, phonenumber);


                if (c.getFirstName() == null || c.getLastName() == null || c.getNationalcode() == null || c.getPhonenumber() == null) {
                    JOptionPane.showMessageDialog(null, "اطلاعات نامعتبر است - ثبت انجام نشد", "مدیریت هتل", JOptionPane.ERROR_MESSAGE);
                    return;

                }


                Customermanager cm = new Customermanager("customers.txt");
                cm.addCustomer(c);
                JOptionPane.showMessageDialog(
                        null, "اطلاعات مسافر ثبت گردید", "مدیریت هتل",
                        JOptionPane.INFORMATION_MESSAGE);

                HotelFlow.customer = c;
                new frmRoom();
                dispose();
            }
        });


        insertpanel.add(btnInsertCustomer);

        this.add(insertpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
