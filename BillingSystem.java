import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.awt.print.Printable.*;
import javax.swing.DefaultListModel.*;
import javax.swing.table.*;
public class BillingSystem extends JFrame implements KeyListener, Printable, ActionListener
{
    JFrame load, terminal, masterupload, main, search, override, pay, cash, card, coupon, bill, report;
    JPanel opening, choice, addproduct, pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, display;
    JLabel jlab1, jlab2, jlab3, L, H1, H2, DT;
    JTextField jtfp, jtfq, jtfm, jtfu, jtfo, jtfc, pin, jtfx;
    DefaultListModel lm1, lm2, lm3, lm4, lm;
    JList jln, jlq, jlp, jla, jl;
    JScrollPane jspn, jspq, jspp, jspa;
    JButton mainwindow, masters, Payment, Report, exit, Masters, print, close;
    JTable jt;
    Font f, F;
    double price, amount, subtotal=0.0;
    double t1=0.0, t2=0.0, t3=0.0, tendered, balance, due, ppu;
    double cashsales=0.0, cardsales=0.0, couponsales=0.0, overrideamount=0.0, totalsales=0.0;
    double casht=0.0, coupont=0.0, cardt=0.0, ovno=0.0, ov=0.0, tot=0.0;
    int quantity, items=0, overridect=0;
    String product, text, descrptn, selection;
    FileWriter f1,f2, fm;
    BufferedWriter b1, b2, bm;
    String msg="";
    int X=10, Y=20;
    Date date=new Date();
    DateFormat df=DateFormat.getDateInstance(DateFormat.FULL, Locale.UK);
    DateFormat DF=DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
    String dates=df.format(date);
    String time=DF.format(date);
    public BillingSystem()
    {
        L=new JLabel("       LOADING.....");
        H1=new JLabel("NILGIRI'S");
        H2=new JLabel("At the heart of great taste. Since 1905.");
        DT=new JLabel(dates+"   "+time);
        f=new Font("Britannic Bold", Font.PLAIN, 20);
        H1.setFont(f);
        H2.setFont(f);
        L.setFont(f);
        load=new JFrame("BILLING SYSTEM");
        load.setSize(400, 200);
        load.setVisible(true);
        load.setFocusable(true);
        opening=new JPanel();
        opening.setLayout(new FlowLayout());
        load.add(opening);
        opening.setFocusable(true);
        addKeyListener(this);
        load.addKeyListener(this);
        opening.addKeyListener(this);
        opening.add(H1);
        opening.add(H2);
        opening.add(L);
        opening.add(DT);
        try
        {
            Thread.sleep(5000);
            load.setVisible(false);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        terminalframe();
    }

    public void terminalframe()
    {
        terminal=new JFrame("BILLING SYSTEM");
        terminal.setSize(450, 200);
        terminal.setVisible(true);
        choice=new JPanel();
        choice.setLayout(new FlowLayout());
        terminal.add(choice);
        choice.add(H1);
        choice.add(H2);
        mainwindow=new JButton("BILLING TERMINAL");
        masters=new JButton("MASTER PRODUCT UPLOAD");
        exit=new JButton("EXIT");
        choice.add(mainwindow);
        choice.add(masters);
        choice.add(exit);
        choice.add(DT);
        mainwindow.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    mainbutton();
                }
            });
        masters.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    masterbutton();
                }
            });
        exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    System.exit(EXIT_ON_CLOSE);
                }
            });
    }

    public void mainbutton()
    {
        terminal.setVisible(false);
        main=new JFrame("BILLING TERMINAL");
        main.setVisible(true);
        main.setSize(380,500);
        main.setFocusable(true);
        pane1=new JPanel();
        pane1.setLayout(new FlowLayout());
        main.add(pane1);
        pane1.setFocusable(true);
        L=new JLabel("BILLING TERMINAL #001");
        L.setFont(f);
        pane1.add(L);
        pane1.add(new JLabel("                     Enter Product                          "));
        pane1.add(new JLabel("Quantity"));
        jtfp= new JTextField(20);
        pane1.add(jtfp);
        pane1.add(new JLabel());
        jtfq= new JTextField(3);
        pane1.add(jtfq);
        pane1.add(new JLabel());
        jlab1=new JLabel("Amount: Rs. 0.0");
        pane1.add(jlab1);
        pane1.add(new JLabel());
        jlab2=new JLabel("  SubTotal: Rs. 0.0          ");
        pane1.add(jlab2);
        jlab3=new JLabel("Items: 0");
        pane1.add(jlab3);
        pane1.add(new JLabel("Product Details         "));
        pane1.add(new JLabel("          Quantity"));
        pane1.add(new JLabel("Price"));
        pane1.add(new JLabel("Amount"));
        lm1=new DefaultListModel();
        jln=new JList(lm1);
        jln.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lm2=new DefaultListModel();
        jlq=new JList(lm2);
        jlq.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lm3=new DefaultListModel();
        jlp=new JList(lm3);
        jlp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lm4=new DefaultListModel();
        jla=new JList(lm4);
        jla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jspn=new JScrollPane(jln);
        jspn.setPreferredSize(new Dimension(150,200));
        pane1.add(jspn);
        pane1.add(new JLabel());
        jspq=new JScrollPane(jlq);
        jspq.setPreferredSize(new Dimension(35,200));
        pane1.add(jspq);
        pane1.add(new JLabel());
        jspp=new JScrollPane(jlp);
        jspp.setPreferredSize(new Dimension(35,200));
        pane1.add(jspp);
        pane1.add(new JLabel());
        jspa=new JScrollPane(jla);
        jspa.setPreferredSize(new Dimension(35,200));
        pane1.add(jspa);
        Payment=new JButton("Payment");
        pane1.add(Payment);
        Report=new JButton("Tender Report");
        pane1.add(Report);
        exit=new JButton("Exit");
        pane1.add(exit);
        pane1.add(DT);
        pane1.add(new JLabel("Press F1 after product entry for price override"));
        try
        {
            f1=new FileWriter("Bill.txt");
            b1=new BufferedWriter(f1);
            b1.write("Description   Price   Qty.   Amount");
            b1.newLine();
            f2=new FileWriter("TenderReport.txt", true);
            b2=new BufferedWriter(f2);
            b2.newLine();
        }
        catch(Exception e)
        {
        }
        jtfp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    try
                    {
                        jtfp.setFocusable(true);
                        product=jtfp.getText();
                        FileReader f=new FileReader("ProductList.txt");
                        BufferedReader bin=new BufferedReader(f);
                        search=new JFrame("PRODUCT SEARCH");
                        search.setVisible(true);
                        search.setSize(400, 550);
                        pane2=new JPanel();
                        pane2.setLayout(new FlowLayout());
                        search.add(pane2);
                        pane2.add(H1);
                        pane2.add(H2);
                        lm=new DefaultListModel();
                        jl=new JList(lm);
                        jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        JScrollPane jsp=new JScrollPane(jl);
                        jsp.setPreferredSize(new Dimension(300,400));
                        pane2.add(jsp);
                        JButton select=new JButton("Select");
                        pane2.add(select);
                        int ct=0;
                        String pname; boolean b=false;
                        while((text=bin.readLine())!=null)
                        {   
                            StringTokenizer st=new StringTokenizer(product, "*");
                            String token; int lim=st.countTokens();
                            pname=text.substring(0, text.indexOf(';'));
                            for(int i=0;i<lim; i++)
                            {
                                token=st.nextToken();
                                int x=token.length();
                                int pl=pname.length();
                                int j=0;
                                do
                                {
                                    if(pname.substring(j, j+x).equalsIgnoreCase(token))
                                    {
                                        ct++; b=true;
                                    }
                                    j++;
                                }while(j<(pl-x));
                                if(ct==lim)
                                {
                                    lm.addElement(text);
                                    ct=0;
                                }
                            }
                        }
                        if(!b)
                        {
                            JOptionPane.showMessageDialog(null, "No such product available!");
                        }
                        select.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent ae)
                                {
                                    int idx=jl.getSelectedIndex();
                                    selection=(String)jl.getSelectedValue();
                                    jtfp.setText(selection.substring(0, selection.indexOf(';')));
                                    lm1.addElement(selection.substring(0, selection.indexOf(';')));
                                    price=Double.parseDouble(selection.substring((selection.indexOf(';')+1), selection.length()));
                                    lm3.addElement(price);
                                    search.setVisible(false);
                                }
                            });
                        jtfp.addKeyListener(new KeyAdapter() {
                                public void keyReleased(KeyEvent ke) 
                                {    
                                }

                                public void keyTyped(KeyEvent ke) 
                                {
                                    msg+=ke.getKeyChar();
                                    repaint();
                                }

                                public void keyPressed(KeyEvent ke) 
                                {
                                    int key=ke.getKeyCode();
                                    if(key==KeyEvent.VK_F1)
                                    {
                                        override=new JFrame("PRICE OVERRIDE");
                                        override.setVisible(true);
                                        override.setSize(300,150);
                                        pane3=new JPanel();
                                        override.add(pane3);
                                        pane3.add(new JLabel("Product Description: "+product+"          "));
                                        pane3.add(new JLabel("        Original price/unit: "+price+"             "));
                                        pane3.add(new JLabel("Override price: "));
                                        jtfo=new JTextField(10);
                                        pane3.add(jtfo);
                                        jtfo.addActionListener(new ActionListener(){
                                                public void actionPerformed(ActionEvent ae)
                                                {
                                                    double nprice=Double.parseDouble(jtfo.getText());
                                                    if(nprice<price)
                                                    {
                                                        JOptionPane.showMessageDialog(null, "Overriding price must be greater than product MRP!");
                                                    }
                                                    else
                                                    {
                                                        overrideamount=overrideamount+(nprice-price);
                                                        overridect=overridect+1;
                                                        lm3.removeElementAt(lm3.getSize()-1);
                                                        price=nprice;
                                                        lm3.addElement(price);
                                                        override.setVisible(false);
                                                    }
                                                }
                                            });
                                    }
                                }

                                public void paint(Graphics g)
                                {
                                    g.drawString(msg, X, Y);
                                }
                            });
                        if(selection.length()>11)
                        {
                            b1.write(selection.substring(0,11)+"   ");
                        }
                        else
                        {
                            b1.write(selection+"   ");
                        }
                        b1.write(price+"   ");
                        bin.close();
                    }
                    catch(Exception e)
                    {
                    }
                }
            });
        jtfq.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    quantity=Integer.parseInt(jtfq.getText());
                    lm2.addElement(quantity);
                    amount=price*quantity;
                    lm4.addElement(amount);
                    jlab1.setText("Amount: "+amount);
                    subtotal= subtotal+amount;
                    jlab2.setText("SubTotal: Rs. "+subtotal+"          ");
                    items=items+quantity;
                    jlab3.setText("Items: "+items);
                    try
                    {
                        b1.write(quantity+"   ");
                        b1.write(amount+"   ");
                        b1.newLine();
                    }
                    catch(Exception e)
                    {
                    }
                    jtfp.setText(null);
                    jtfq.setText(null);
                }
            });
        Payment.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    paymentbutton();
                }
            });
        Report.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    main.setVisible(false);
                    report=new JFrame("TENDER REPORT");
                    report.setVisible(true);
                    report.setSize(380,400);
                    pane8=new JPanel();
                    pane8.setLayout(new FlowLayout());
                    report.add(pane8);
                    pane8.add(H1);
                    pane8.add(H2);
                    L=new JLabel("TENDER REPORT");
                    f=new Font("Britannic Bold", Font.PLAIN, 18);
                    L.setFont(f);
                    pane8.add(L);
                    try
                    {
                        FileReader fr=new FileReader("TenderReport.txt");
                        BufferedReader br=new BufferedReader(fr);
                        String line;
                        while((line=br.readLine())!=null)
                        {
                            String type=line.substring(0, line.indexOf(':'));
                            double add=Double.parseDouble(line.substring((line.indexOf(':')+1), line.length()));
                            if(type.equals("Cash"))
                            {
                                casht+=add;
                            }
                            if(type.equals("Coupon[Sodexo/Ticket Restaurant]"))
                            {
                                coupont+=add;
                            }
                            if(type.equals("Card[Credit/Debit]"))
                            {
                                cardt+=add;
                            }
                            if(type.equals("Number of overrides"))
                            {
                                ovno+=add;
                            }
                            if(type.equals("Override Amount"))
                            {
                                ov+=add;
                            }
                            if(type.equals("Total sales"))
                            {
                                tot+=add;
                            }
                        }
                        br.close();
                    }
                    catch(Exception e)
                    {
                    }
                    String headers[]={"Transaction Type/Tender", "Amount"};
                    Object data[][]={
                            {"Cash", casht},
                            {"Coupon[Sodexo/Ticket Restaurant]", coupont},
                            {"Card[Credit/Debit]", cardt},
                            {"Number of overrides", ovno},
                            {"Override Amount", ov},
                            {"Total sales", tot}};
                    jt=new JTable(data, headers);
                    jt.setSize(350, 350);
                    jt.setRowHeight(30);
                    TableColumnModel columnModel = jt.getColumnModel();
                    columnModel.getColumn(0).setPreferredWidth(250);
                    columnModel.getColumn(1).setPreferredWidth(100);
                    pane8.add(jt);
                    print=new JButton("PRINT REPORT");
                    pane8.add(print);
                    close=new JButton("CLOSE");
                    pane8.add(close);
                    pane8.add(DT);
                    print.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae)
                            {
                                UIManager.put("swing.boldMetal", Boolean.FALSE);
                                print.addActionListener(new ActionListener(){
                                        public int print(Graphics g, PageFormat pf, int page) throws PrinterException 
                                        {
                                            if (page > 0) 
                                            {
                                                return NO_SUCH_PAGE;
                                            }
                                            Graphics2D g2d = (Graphics2D)g;
                                            g2d.translate(pf.getImageableX(), pf.getImageableY());
                                            report.printAll(g);
                                            return PAGE_EXISTS;
                                        }

                                        public void actionPerformed(ActionEvent e) {
                                            PrinterJob job = PrinterJob.getPrinterJob();
                                            boolean ok = job.printDialog();
                                            if (ok) 
                                            {
                                                try 
                                                {
                                                    job.print();
                                                } 
                                                catch (PrinterException ex) 
                                                {
                                                }
                                            }
                                        }
                                    });
                            }
                        });
                    close.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent ae)
                            {
                                report.setVisible(false);
                                mainbutton();
                            }
                        });
                }
            });
        exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    main.setVisible(false);
                    terminalframe();
                }
            });
    }

    public void masterbutton()
    {
        terminal.setVisible(false);
        masterupload=new JFrame("MASTERS PRODUCT UPLOAD");
        masterupload.setSize(380, 300);
        masterupload.setVisible(true);
        addproduct=new JPanel();
        addproduct.setLayout(new FlowLayout());
        masterupload.add(addproduct);  
        addproduct.add(H1);
        addproduct.add(H2);
        L=new JLabel("     MASTERS PRODUCT UPLOAD");
        L.setFont(f);
        addproduct.add(L);
        addproduct.add(new JLabel("Product Description"));
        jtfm=new JTextField(20);
        addproduct.add(jtfm);
        addproduct.add(new JLabel("Price per Unit"));
        jtfu=new JTextField(20);
        addproduct.add(jtfu);
        Masters=new JButton("Add Product to Masters");
        addproduct.add(Masters);
        addproduct.add(DT);
        Masters.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                { 
                    try
                    {
                        descrptn=(String)jtfm.getText();
                        ppu=Double.parseDouble(jtfu.getText()); 
                        if(descrptn==null||ppu==0)
                        {
                            JOptionPane.showMessageDialog(null, "NO INFORMATION DETECTED!");
                        }
                        else
                        {
                            fm=new FileWriter("ProductList.txt", true);
                            bm=new BufferedWriter(fm);
                            bm.newLine();
                            bm.write(descrptn+";"+ppu);
                            bm.close();
                            JOptionPane.showMessageDialog(null, "PRODUCT ADDED TO MASTERS!");
                        }
                    }
                    catch(Exception e)
                    {
                    }
                    masterupload.setVisible(false);
                    terminalframe();
                }
            });
    }

    public void paymentbutton()
    {
        try
        {
            pay=new JFrame("PAYMENT");
            pay.setVisible(true);
            pay.setSize(250,200);
            pane4=new JPanel();
            pane4.setLayout(new FlowLayout());
            pay.add(pane4);
            F=new Font("Britannic Bold", Font.PLAIN, 13);
            H1.setFont(F);
            H2.setFont(F);
            pane4.add(H1);
            pane4.add(H2);
            L=new JLabel("<html>Mode of Payment<br>Cash: F1<br>Credit/Debit Card: F2<br>Sodexo/Ticket Restaurant: F3</html>");
            L.setFont(F);
            pane4.add(L);
            JButton done=new JButton("Done");
            pane4.add(done);
            JTextArea jta=new JTextArea();
            pane4.add(jta);
            done.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent ke) 
                    {    
                    }

                    public void keyTyped(KeyEvent ke) 
                    {
                        msg+=ke.getKeyChar();
                        repaint();
                    }

                    public void keyPressed(KeyEvent ke) 
                    {
                        int key=ke.getKeyCode(); due=subtotal;
                        if(key==KeyEvent.VK_F1)
                        {
                            cash=new JFrame("CASH");
                            cash.setVisible(true);
                            cash.setSize(150,150);
                            pane5=new JPanel();
                            pane5.setLayout(new FlowLayout());
                            cash.add(pane5);
                            pane5.add(new JLabel("Amount due: "+(due-(t1+t2+t3))));
                            pane5.add(new JLabel("Amount Tendered"));
                            jtfc=new JTextField(15);
                            pane5.add(jtfc);
                            jtfc.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent ae)
                                    {
                                        t1=t1+Double.parseDouble(jtfc.getText());
                                        cash.setVisible(false);
                                    }
                                });
                        }
                        if(key==KeyEvent.VK_F2)
                        {
                            card=new JFrame("CREDIT/DEBIT CARD");
                            card.setVisible(true);
                            card.setSize(150,150);
                            pane6=new JPanel();
                            pane6.setLayout(new FlowLayout());
                            card.add(pane6);
                            t2=t2+subtotal;
                            pane6.add(new JLabel("Amount due: "+(due-(t1+t2+t3))));
                            pane6.add(new JLabel("Transaction Amount: "+t2));
                            pane6.add(new JLabel("Enter pin:"));
                            pin=new JTextField(10);
                            pane6.add(pin);
                            pin.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent ae)
                                    {
                                        boolean b=true;
                                        for(int i=0;i<(pin.getText()).length();i++)
                                        {
                                            if(!Character.isDigit((pin.getText()).charAt(i)))
                                            {
                                                b=false;
                                                break;
                                            }
                                        }
                                        if((pin.getText()).length()!=4 || b==false)
                                        {
                                            JOptionPane.showMessageDialog(null, "WRONG PIN NUMBER! PLEASE REENTER!");
                                        }
                                        else
                                        {
                                            JOptionPane.showMessageDialog(null, "TRANSACTION SUCCESSFUL!");
                                            card.setVisible(false);
                                        }
                                    }
                                });
                        }
                        if(key==KeyEvent.VK_F3)
                        {
                            coupon=new JFrame("SODEXO/TICKET RESTAURANT");
                            coupon.setVisible(true);
                            coupon.setSize(150,150);
                            pane7=new JPanel();
                            pane7.setLayout(new FlowLayout());
                            coupon.add(pane7);
                            pane7.add(new JLabel("Amount due: "+(due-(t1+t2+t3))));
                            pane7.add(new JLabel("Amount Tendered"));
                            jtfx=new JTextField(15);
                            pane7.add(jtfx);
                            jtfx.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent ae)
                                    {
                                        t3=t3+Double.parseDouble(jtfx.getText());
                                        if(t3>subtotal)
                                        {
                                            JOptionPane.showMessageDialog(null, "BALANCE CANNOT BE TENDERED FOR COUPONS! PLEASE PROVIDE CORRECT AMOUNT!");
                                            t3=t3-Double.parseDouble(jtfx.getText());
                                        }
                                        else
                                        {
                                            coupon.setVisible(false); 
                                        }
                                    }
                                });
                        }
                    }

                    public void paint(Graphics g)
                    {
                        g.drawString(msg, X, Y);
                    }
                });
            done.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae)
                    {   
                        H1.setFont(f);
                        H2.setFont(f);
                        L.setFont(f);
                        tendered=t1+t2+t3;
                        if(tendered<subtotal)
                        {
                            JOptionPane.showMessageDialog(null, "INSUFFICIENT PAYMENT!");  
                        }
                        else
                        {
                            balance=tendered-subtotal;
                            cashsales=cashsales+t1-balance;
                            cardsales=cardsales+t2;
                            couponsales=couponsales+t3;
                            totalsales=totalsales+subtotal;
                            try
                            {
                                main.setVisible(false);
                                bill=new JFrame("BILL");
                                bill.setVisible(true);
                                bill.setSize(380,500);
                                display=new JPanel();
                                display.setLayout(new FlowLayout());
                                bill.add(display);
                                display.add(H1);
                                display.add(H2);
                                display.add(new JLabel("  Product Details         "));
                                display.add(new JLabel("          Quantity"));
                                display.add(new JLabel("Price"));
                                display.add(new JLabel("Amount"));
                                display.add(jspn);
                                display.add(new JLabel());
                                display.add(jspq);
                                display.add(new JLabel());
                                display.add(jspp);
                                display.add(new JLabel());
                                display.add(jspa);
                                display.add(jlab2);
                                display.add(new JLabel("        Amount Tendered: "+tendered+"     "));
                                display.add(new JLabel("                 Balance: "+balance+"     "));
                                display.add(new JLabel("              Cash Amount: "+(t1-balance)));
                                display.add(new JLabel("          Card Amount: "+t2));
                                display.add(new JLabel("              Coupon Amount: "+t3+"          "));
                                print=new JButton("PRINT BILL");
                                display.add(print);
                                close=new JButton("CLOSE");
                                display.add(close);
                                display.add(DT);
                                print.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            UIManager.put("swing.boldMetal", Boolean.FALSE);
                                            print.addActionListener(new ActionListener(){
                                                    public int print(Graphics g, PageFormat pf, int page) throws PrinterException 
                                                    {
                                                        if (page > 0) 
                                                        {
                                                            return NO_SUCH_PAGE;
                                                        }
                                                        Graphics2D g2d = (Graphics2D)g;
                                                        g2d.translate(pf.getImageableX(), pf.getImageableY());
                                                        bill.printAll(g);
                                                        return PAGE_EXISTS;
                                                    }

                                                    public void actionPerformed(ActionEvent e) {
                                                        PrinterJob job = PrinterJob.getPrinterJob();
                                                        boolean ok = job.printDialog();
                                                        if (ok) 
                                                        {
                                                            try 
                                                            {
                                                                job.print();
                                                            } 
                                                            catch (PrinterException ex) 
                                                            {
                                                            }
                                                        }
                                                    }
                                                });
                                        }
                                    });
                                close.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent ae)
                                        {
                                            bill.setVisible(false);
                                            mainbutton();
                                        }
                                    });
                                b1.write("Total                              "+subtotal);
                                b1.newLine();
                                b1.write("Amount Tendered: "+tendered);
                                b1.newLine();
                                b1.write("        Balance: "+balance);
                                b1.newLine();
                                b1.write("    Cash Amount: "+(t1-balance));
                                b1.newLine();
                                b1.write("    Card Amount: "+t2);
                                b1.newLine();
                                b1.write("  Coupon Amount: "+t3);
                                b1.newLine();
                                b1.write("          Items: "+items);
                                b1.newLine();
                                b1.close();
                                b2.write("Cash:"+cashsales);
                                b2.newLine();
                                b2.write("Coupon[Sodexo/Ticket Restaurant]:"+couponsales);
                                b2.newLine();
                                b2.write("Card[Credit/Debit]:"+cardsales);
                                b2.newLine();
                                b2.write("Number of overrides:"+overridect);
                                b2.newLine();
                                b2.write("Override Amount:"+overrideamount);
                                b2.newLine();
                                b2.write("Total sales:"+totalsales);
                                b2.close();
                            }
                            catch(Exception e)
                            {
                            }
                            t1=0.0; t2=0.0; t3=0.0;
                            pay.setVisible(false);
                        }
                    }
                });
        }
        catch(Exception e)
        {
        }
    }

    public void keyPressed(KeyEvent ke)
    {   
    }

    public void keyReleased(KeyEvent ke)
    {
    }

    public void keyTyped(KeyEvent ke)
    {
        msg+=ke.getKeyChar();
        repaint();
    }

    public void paint(Graphics g)
    {
        g.drawString(msg, X, Y);
    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException 
    {
        return 0;
    }

    public void actionPerformed(ActionEvent e) 
    {
    }

}