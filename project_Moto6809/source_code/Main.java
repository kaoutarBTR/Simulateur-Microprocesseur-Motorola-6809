import javax.swing.*;




public class Main {




    public static void main(String [] args) {

        Ram memory=new Ram();
        memory.m();
        Rom mem= new Rom();
        mem.mrom();

        architect cpu = new architect();
        programme p=new programme(memory, cpu);
        Execution Execution = new Execution(p);
        Execution.setVisible(true);
        Execution.setResizable(false);
        String val=Execution.mots;

        Execution.mexe();
        architect Architect = new architect();
        Architect.setVisible(true);
        Architect.march();






        
        
        
        
        
        
        
        




    }

}