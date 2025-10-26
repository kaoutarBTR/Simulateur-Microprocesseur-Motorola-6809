import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Execution extends javax.swing.JFrame {

	static String pwd = System.getProperty("user.dir");
    public String mots;
    static programme P;
    static int K=0;
    public Execution(programme A) {
        Execution.P=A;
        initComponents();
        setTitle("Editeur");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    public void initComponents() {

        jButton1 = new javax.swing.JButton();//pas par pas
        jButton2 = new javax.swing.JButton();//execution
        jButton3 = new javax.swing.JButton();//reset
        
        jButton5 = new javax.swing.JButton();//exit
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1=new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setEditable(false);
        
        jButton1.setEnabled(true);
        jButton3.setEnabled(false);
        jButton3.setFont(new Font("Monospaced",Font.BOLD, 18));
        
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }};


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setIcon(new javax.swing.ImageIcon(pwd+"/images/quit2.jpg")); // NOI18N
        jButton1.setOpaque(true);
        jButton1.setPreferredSize(new java.awt.Dimension(45, 49));

        jButton2.setIcon(new javax.swing.ImageIcon(pwd+"/images/exct.jpg")); 
        jButton1.setIcon(new javax.swing.ImageIcon(pwd+"/images/pas.jpg")); 
        jButton3.setIcon(new javax.swing.ImageIcon(pwd+"/images/reset1.jpg")); // NOI18N
        jButton2.setOpaque(true);
        jButton2.setPreferredSize(new java.awt.Dimension(45, 49));
        jButton1.addActionListener(e -> {
            //uppeeerrrcase
            String mots = jTextArea1.getText().toUpperCase(); // Récupère le texte du champ de texte
            // Affiche le texte stocké

            //System.out.println(mots);
            if(P.isInstructionSyntaxCorrect(mots)) {
                jTextField1.setText("Syntax CORRECT");
                jTextField1.setForeground(new Color(50,205,50));
                jButton1.setEnabled(true);
                jButton3.setEnabled(false);

                String[] lines = mots.split("\\n");
                programme.processInstruction(lines[K].trim());


                if (lines[K].matches("END")) {
                    jButton2.setEnabled(false);
                    jButton1.setEnabled(false);
                    jButton3.setEnabled(true);
                }
                K++;
             
            }
            else
            {
                jTextField1.setText("Syntax ERROR");
                jTextField1.setForeground(new Color(255, 0, 0));
            }
        });
        jButton2.addActionListener(e -> {

            String mots = jTextArea1.getText().toUpperCase(); // Récupère le texte du champ de texte
         
            if(P.isInstructionSyntaxCorrect(mots)) {
                        jTextField1.setText("Syntax CORRECT");
                        jTextField1.setForeground(new Color(50,205,50));
                        P.execute(mots);
                        jButton2.setEnabled(false);
                        jButton1.setEnabled(false);
                        jButton3.setEnabled(true);
                }
           else {
            	
            	        jTextField1.setText("Syntax ERROR");
                        jTextField1.setForeground(new Color(255, 0, 0));
            }
        });
                
             
        jButton3.addActionListener(e -> {
                        P.cpu.reset();
                        jTextArea1.setText("");
                        jTextField1.setText("");
                        jButton1.setEnabled(true);
                        jButton3.setEnabled(false);
                        jButton2.setEnabled(true);
           
           
           
            
        });

        jButton5.addActionListener(e -> {
            
            
        	           System.exit(0);
             
         });


       
        jButton3.setOpaque(true);
        jButton3.setPreferredSize(new java.awt.Dimension(45, 49));
        jButton5.setOpaque(true);
        jButton5.setPreferredSize(new java.awt.Dimension(45, 49));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("  Mise a jour          Edition");
        jLabel9.setOpaque(true);


        jScrollPane1.setViewportView(getjTextArea1());



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        pack();
        setLocation(400,0);
        
    }

    public  void mexe() {
        new Execution(P).initComponents();


        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Execution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Execution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Execution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Execution.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    public javax.swing.JTextArea getjTextArea1() {
        return jTextArea1;
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;


}