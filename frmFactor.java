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

import model.Factor;
import Managers.Factormanager;

public class frmFactor extends JFrame
{


    private JLabel lblfactornumber;
    private JLabel lbltotalprice;

    private JTextField txtfactornumber;
    private JTextField txttotalprice;

    private JPanel panel;

    private JButton btnsave;

    private JRadioButton paid;
    private JRadioButton debt;
    private ButtonGroup paymentstatus;


    public frmFactor()
    {

        super("Factor");
        this.setBounds(200,100,500,500);
        this.setLayout(new FlowLayout());

        lblfactornumber=new JLabel(" شماره فاکتور ");
        lbltotalprice=new JLabel(" جمع کل مبلغ");


        paid=new JRadioButton("تسویه");
        debt=new JRadioButton("بدهی");

        paymentstatus=new ButtonGroup();
        paymentstatus.add(paid);
        paymentstatus.add(debt);


        txtfactornumber=new JTextField();
        txtfactornumber.setPreferredSize(new Dimension(190,20));
        txttotalprice=new JTextField();
        txttotalprice.setPreferredSize(new Dimension(190,20));
        txttotalprice.setText(String.valueOf(HotelFlow.totalPayment));




        panel=new JPanel();
        panel.setPreferredSize(new Dimension(350,250));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(txtfactornumber);
        panel.add(lblfactornumber);
        panel.add(txttotalprice);
        panel.add(lbltotalprice);
        panel.add(paid);
        panel.add(debt);





        btnsave=new JButton("ثبت فاکتور");
        btnsave.setPreferredSize(new Dimension(200,30));


        btnsave.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {

                String paymentstatus="";
                if(paid.isSelected())
                {
                    paymentstatus="تسویه";
                }

                else if(debt.isSelected())
                    paymentstatus="بدهی";
                else
                {
                    JOptionPane.showMessageDialog(null, "  وضعیت پرداخت را انتخاب کنید ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                String Factornumber = txtfactornumber.getText();
                String Totalprice = txttotalprice.getText();


                if(Factornumber.length()>0)
                {

                    for(int i=0;i<Factornumber.length();i++)
                    {
                        if(Factornumber.charAt(i)<'0'||Factornumber.charAt(i)>'9')
                        {

                            JOptionPane.showMessageDialog(null, "شماره فاکتور: لطفا عدد وارد کنید   ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }



                if(Totalprice.length()>0)
                {

                    for(int i=0;i<Totalprice.length();i++)
                    {
                        if(Totalprice.charAt(i)<'0'||Totalprice.charAt(i)>'9')
                        {
                            JOptionPane.showMessageDialog(null, " مبلغ کل: لطفا عدد وارد کنید   ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }


                int factornumber=Integer.parseInt(txtfactornumber.getText());
                int totalprice=Integer.parseInt(txttotalprice.getText());




                Factor f=new Factor(factornumber,totalprice,paymentstatus);


                if(f.getFactornumber()<=0 || f.getTotalprice() <= 0 || f.getPaystatus() == null)
                {
                    JOptionPane.showMessageDialog(null,"اطلاعات نامعتبر است - ثبت انجام نشد","مدیریت هتل",	JOptionPane.ERROR_MESSAGE);
                    return;

                }

                Factormanager fm=new Factormanager("factors.txt");
                fm.addFactor(f);

                JOptionPane.showMessageDialog(null,	"فاکتور ثبت شد", "مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);


            }


        });


        panel.add(btnsave);
        this.add(panel);
        this.setVisible(true);

    }

}
