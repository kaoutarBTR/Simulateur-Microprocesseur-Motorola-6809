import javax.swing.*;
import java.awt.*;

public class architect extends javax.swing.JFrame {
	static String pwd = System.getProperty("user.dir");
    public architect() {
        initComponents();
    }
    public void setJTextField6Text(String newText) {
        jTextField6.setText(newText);
    }
    public void setJTextField2Text(String newText) {
        jTextField2.setText(newText);
    }

    public void setJTextField3Text(String newText) {
        jTextField3.setText(newText);
    }

    public void setJTextField4Text(String newText) {
        jTextField4.setText(newText);
    }

    public void setJTextField5Text(String newText) {
        jTextField5.setText(newText);
    }

    public void setJTextField7Text(String newText) {
        jTextField7.setText(newText);
    }

    public void setJTextField8Text(String newText) {
        jTextField8.setText(newText);
    }

    public void setJTextField9Text(String newText) {
        jTextField9.setText(newText);
    }

    public void setJTextField10Text(String newText) {
        jTextField10.setText(newText);
    }

    public void setJTextField11Text(String newText) {
        jTextField11.setText(newText);
    }
    
    public String getJTextField2Text() {
        return jTextField2.getText();
    }
    public String getJTextField3Text() {
        return jTextField3.getText();
    }
    public String getJTextField4Text() {
        return jTextField4.getText();
    }
    public String getJTextField5Text() {
        return jTextField5.getText();
    }
    public String getJTextField6Text() {
        return jTextField6.getText();
    }
    public String getJTextField7Text() {
        return jTextField7.getText();
    }
    public String getJTextField8Text() {
        return jTextField8.getText();
    }
    public String getJTextField9Text() {
        return jTextField9.getText();
    }
    public String getJTextField10Text() {
        return jTextField10.getText();
    }
    public String getJTextField11Text() {
        return jTextField11.getText();
    }
    

  
    @SuppressWarnings("unchecked")                         
    public void initComponents() {

        jPanel1 = new JPanel();
        jLabel9 = new JLabel();
        jLabel2 = new JLabel();
        jTextField2 = new JTextField();
        jTextField7 = new JTextField();
        jLabel3 = new JLabel();
        jTextField8 = new JTextField();
        jTextField3 = new JTextField();
        jLabel5 = new JLabel();
        jLabel4 = new JLabel();
        jLabel6 = new JLabel();
        jTextField4 = new JTextField();
        jLabel7 = new JLabel();
        jTextField5 = new JTextField();
        jLabel10 = new JLabel();
        jTextField10 = new JTextField();
        jTextField9 = new JTextField();
        jLabel11 = new JLabel();
        jLabel8 = new JLabel();
        jTextField6 = new JTextField();
        jLabel1 = new JLabel();
        jTextField11 = new JTextField();
        jTextField2 = new JTextField("0000");//PC
        jTextField2.setEditable(false);
        jTextField7 = new JTextField("00");//B
        jTextField7.setEditable(false);
        jTextField8 = new JTextField("00");//DP
        jTextField8.setEditable(false);
        jTextField3 = new JTextField("0000");//X
        jTextField3.setEditable(false);
        jTextField4 = new JTextField("0000");//U
        jTextField4.setEditable(false);
        jTextField5 = new JTextField("");//Instruction
        jTextField5.setEditable(false);
        jTextField10 = new JTextField("0000");//S
        jTextField10.setEditable(false);
        jTextField9 = new JTextField("0000100");//flags
        jTextField9.setEditable(false);
        jTextField6 = new JTextField("00");//A
        jTextField6.setEditable(false);
        jTextField11 = new JTextField("0000");//Y
        jTextField11.setEditable(false);







        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new Color(193, 193, 193));

        jLabel9.setBackground(new Color(255, 255, 255));
        jLabel9.setFont(new Font("Segoe UI", 0, 14));  
        jLabel9.setForeground(new Color(153, 153, 153));
        jLabel9.setText("Architecture interne du 6809");
        jLabel9.setOpaque(true);

        jLabel2.setFont(new Font("Segoe UI", 1, 24)); 
        jLabel2.setText("S");
        
        jLabel3.setFont(new Font("Segoe UI", 1, 24)); 
        jLabel3.setText("PC");

        jLabel5.setFont(new Font("Segoe UI", 1, 24)); 
        jLabel5.setText("DP");

        jLabel4.setFont(new Font("Segoe UI", 1, 22)); 
        jLabel4.setText("U");

        jLabel6.setFont(new Font("Segoe UI", 1, 24)); 
        jLabel6.setText("A");

        jLabel7.setFont(new Font("Segoe UI", 1, 24)); 
        jLabel7.setText("B");

        jLabel10.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("X");

        jLabel11.setFont(new Font("Segoe UI", 1, 24)); 
        jLabel11.setText("Y");

        jLabel8.setFont(new Font("Segoe UI", 1, 14)); 
        jLabel8.setText("EFHINZVC");
        
        jLabel1.setBackground(new Color(102, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(pwd+"/images/ual.jpg")); // NOI18N
        jLabel1.setText("");
        
        
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(9, 9, 9))))
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(196, 196, 196)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(334, 334, 334)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

                                    

    static void reset() {
    	 jTextField2.setText("0000");//PC
         jTextField7.setText("00");//B
         jTextField8.setText("00");//DP
         jTextField3.setText("0000");//X
         jTextField4.setText("0000");//U
         jTextField5.setText("");//Instruction
         jTextField10.setText("0000");//S
         jTextField9.setText("0000100");//flags
         jTextField6.setText("00");//A
         jTextField11.setText("0000");//Y
    }
    public static void march() {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(architect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(architect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(architect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(architect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

       
    }

    // Variables declaration - do not modify                     
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private static JTextField jTextField10;
    private static JTextField jTextField11;
    private static JTextField jTextField2;
    private static JTextField jTextField3;
    private static JTextField jTextField4;
    private static JTextField jTextField5;
    private static JTextField jTextField6;
    private static JTextField jTextField7;
    private static JTextField jTextField8;
    private static JTextField jTextField9;
                      
}