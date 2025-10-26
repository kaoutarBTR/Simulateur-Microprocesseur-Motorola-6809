import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Rom{


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

            // Efface le contenu actuel du JTextArea
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


    public Rom(){
        for (int i = 64512; i <=65535; i++)
        {
            String hex = Integer.toHexString(i).toUpperCase();
            while (hex.length() < 4) {
                hex = "0" + hex;
            }
            adr.put(hex,"$$");
        }

        sortedMap =new TreeMap<>(adr);


        for (Map.Entry<String,String>ent:sortedMap.entrySet()){
            //System.out.println(ent.getKey()+"   "+ent.getValue());
            textArea.append(ent.getKey());
            textArea.append("  ");
            textArea.append(ent.getValue());
            textArea.append("\n");
        }

    }

    public void mrom() {

        Rom rom = new Rom();

        textArea.setEditable(false);
        //textArea.setBackground(new Color(200,200,240));
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        Scroll.setViewportView(textArea);


        JFrame frame = new JFrame("ROM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 500);
        frame.setResizable(false);
        frame.setLocation(1000,0);
        frame.getContentPane().add(Scroll);
        frame.setVisible(true);



    }
}