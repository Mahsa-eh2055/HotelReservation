package frm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Pay;
import Managers.Paymanager;

import static frm.HotelFlow.roomNumber;

public class frmPay  extends JFrame
{


    private JLabel lblroomNumber;
    private JLabel lblPayment;
    private JLabel lblPaymentmethod;
    private JLabel lblDate;



    private JTextField txtroomNumber;
    private JTextField txtPayment;
    private JTextField txtPaymentmethod;
    private JTextField txtDate;

    private JPanel insertpanel;

    private JButton btnPay;


    private JRadioButton card;
    private JRadioButton cash;
    private ButtonGroup paykind;


    public frmPay()
    {

        super("Pay");
        this.setBounds(200,100,500,500);
        this.setLayout(new FlowLayout());

        lblroomNumber=new JLabel("شماره اتاق");
        lblPayment=new JLabel("مبلغ کل ");
        lblDate=new JLabel("تاریخ پرداخت ");



        card=new JRadioButton("کارت");
        cash=new JRadioButton("نقد");



        paykind=new ButtonGroup();
        paykind.add(card);
        paykind.add(cash);



        txtroomNumber=new JTextField();
        txtroomNumber.setPreferredSize(new Dimension(150,25));
        txtPayment=new JTextField();
        txtPayment.setPreferredSize(new Dimension(150,25));
        txtDate=new JTextField();
        txtDate.setPreferredSize(new Dimension(150,25));





        insertpanel=new JPanel();
        insertpanel.setPreferredSize(new Dimension(450,400));
        insertpanel.setBackground(Color.gray);


        insertpanel.add(txtroomNumber);
        insertpanel.add(lblroomNumber);
        insertpanel.add(txtPayment);
        insertpanel.add(lblPayment);
        insertpanel.add(txtDate);
        insertpanel.add(lblDate);
        insertpanel.add(card);
        insertpanel.add(cash);


        btnPay=new JButton("ثبت ");
        btnPay.setPreferredSize(new Dimension(150,30));


        btnPay.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String paykind="";
                if(card.isSelected())
                {
                    paykind="کارت";
                }

                else if(cash.isSelected())
                    paykind="نقدی";
                else
                {
                    JOptionPane.showMessageDialog(null, " روش پرداخت را انتخاب کنید ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int roomNumber= Integer.parseInt(txtroomNumber.getText());

                int Payment=Integer.parseInt(txtPayment.getText());
                String Paymentmethod = paykind;
                String Date=txtDate.getText();


                Pay p=new Pay(roomNumber, Payment, Paymentmethod, Date);

                if(p.getroomNumber() <= 0 ||p.getPaymentmethod() ==null|| p.getDate() == null)
                {
                    JOptionPane.showMessageDialog(null,"اطلاعات نامعتبر است - ثبت انجام نشد","مدیریت هتل",	JOptionPane.ERROR_MESSAGE);
                    return;

                }

                Paymanager pm = new Paymanager("pay.txt");
                pm.addPay(p);

                JOptionPane.showMessageDialog(null,	"پرداخت انجام شد", "مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);

                new frmFactor();
                dispose();
            }


        });



        insertpanel.add(btnPay);

        this.add(insertpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}
