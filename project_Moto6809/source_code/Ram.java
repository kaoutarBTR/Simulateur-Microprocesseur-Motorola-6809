import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Ram {


    static Map <String,String> adr = new HashMap<String,String>();
    static TreeMap<String, String> sortedMap ;

    static JTextArea textArea = new JTextArea();
    static JScrollPane Scroll = new JScrollPane();


    private static void updateTreeMapFromMap() {
        sortedMap.clear(); // Efface le contenu actuel du TreeMap
        sortedMap.putAll(adr); // Met à jour le TreeMap avec les données de la Map
    }

    private static void updateTextArea() {

        SwingUtilities.invokeLater(() -> {

           
            textArea.setText("");

            // Parcourt le TreeMap et ajoute les éléments au JTextArea
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                textArea.append(entry.getKey() + " " + entry.getValue() + "\n");
            }

            // Scroller en haut
            textArea.setCaret(new DefaultCaret() {
                public void setSelectionVisible(boolean vis) {

                }
            });

        });

    }


    public static void reset()
    {

        for(String i:adr.keySet())
        {
            adr.replace(i,"00");
        }

        updateTreeMapFromMap();
        updateTextArea();
    }

    public static void modif(String key,String val){

        key = key.toUpperCase();
        val=val.toUpperCase();
        adr.put(key,val);
        updateTreeMapFromMap();
        updateTextArea();

    }


    public Ram(){


        for (int i = 0; i <= 1023; i++)
        {
            String hex = Integer.toHexString(i).toUpperCase();
            while (hex.length() < 4) {
                hex = "0" + hex;
            }
            adr.put(hex,"00");
        }

        sortedMap =new TreeMap<>(adr);


        for (Map.Entry<String,String>ent:sortedMap.entrySet()){
           // System.out.println(ent.getKey()+"   "+ent.getValue());
            textArea.append(ent.getKey());
            textArea.append("  ");
            textArea.append(ent.getValue());
            textArea.append("\n");
        }

    }



    public static void m() {

        Ram ram=new Ram();


        textArea.setEditable(true);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));


        Scroll.setViewportView(textArea);


        JFrame frame = new JFrame("RAM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 500);
        frame.setResizable(false);
        frame.setLocation(750,0);
        frame.getContentPane().add(Scroll);
        frame.setVisible(true);


        //mise a jour apre modification manuelle de la Ram
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateHashMap();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateHashMap();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateHashMap();
            }

            // Met à jour la HashMap en fonction du texte actuel du JTextArea
            private void updateHashMap() {
                String[] lines = textArea.getText().split("\n");
                for (String line : lines) {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        String key = parts[0].trim();
                        String val = parts[1].trim();
                        adr.put(key, val);
                    }
                }

            }
        });


    }



}