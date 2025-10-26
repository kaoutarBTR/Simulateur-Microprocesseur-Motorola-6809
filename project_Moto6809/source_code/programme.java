import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;




public class programme {





    programme(){

    }
    static int pos=64512;
    
    static Execution ext;
    static Ram ram;
    static architect cpu;
    static Rom rom;

    programme(Ram a, architect b) {
        programme.ram = a;
        programme.cpu = b;
        ;

    }


//DECLARING INSTRUCTIONS

    private final static String[] noarguments = {
            "NOP", "SWI", "RESET", "NOP", "END","INCA","INCB"
    };
    private final  static String[] oneargument = {
            "LDA", "LDB", "ADDA", "STA", "STB","ADDB", "SUBA", "SUBB","CMPA", "CMPB"
    };
    private final  static String[] oneargument2 = {
            "LDX", "LDY","LDS"
    };
    private final static String[] twoarguments = {
            "PSHS", "PULS","EXG"
    };


    static String instruction1; 

    static String adresseRegex1 = "\\$[0-9a-fA-F]{4}";
    static String adresseRegex2 = "#\\$[0-9a-fA-F]{2}";
    static String adresseRegex3 = "#\\$[0-9a-fA-F]{4}";
    static String adresseRegex4 = "\\$[0-9a-fA-F]{2}";
    static String adresseRegex5 = "\\,[X-Y]";
    static String adresseRegex6 = "[ABXY]";
    static String adresseRegex7 = "(A|B|DP),(A|B|DP)";
    static Pattern adresseRegexPat1 = Pattern.compile(adresseRegex1);
    static Pattern adresseRegexPat2 = Pattern.compile(adresseRegex2);
    static Pattern adresseRegexPat3 = Pattern.compile(adresseRegex3);
    static Pattern adresseRegexPat4 = Pattern.compile(adresseRegex4);
    static Pattern adresseRegexPat5 = Pattern.compile(adresseRegex5);
    static Pattern adresseRegexPat6 = Pattern.compile(adresseRegex6);
    static Pattern adresseRegexPat7 = Pattern.compile(adresseRegex7);

    public boolean isInstructionSyntaxCorrect(String instruction) {
             String[] Tab1 = instruction.split("\\n");
     if(Tab1[Tab1.length-1].matches("END"))
       {
        
       }
        else{
            return false;
        }

        for(String i:Tab1) {
            i=i.trim();
            String[] Tab = i.split("\\s+");

            // Check if the instruction is in any of the defined arrays
            if (isInArray(Tab[0], noarguments) && Tab.length == 1)
            {
                System.out.println("the instruction is valid");
            }
            // Check if the instruction matches the address pattern
            else if (isInArray(Tab[0], oneargument) && Tab.length == 2) 
            {
                if (    adresseRegexPat1.matcher(Tab[1]).matches() || adresseRegexPat2.matcher(Tab[1]).matches()
                        ||adresseRegexPat4.matcher(Tab[1]).matches()||adresseRegexPat5.matcher(Tab[1]).matches()  ) 
                {
                    System.out.println("the instruction is valid");
                }
                else
                {
                    System.out.println("not valid");
                    return false;
                }
            }
            else if (isInArray(Tab[0], oneargument2) && Tab.length == 2) 
            {
                if (  adresseRegexPat1.matcher(Tab[1]).matches() || adresseRegexPat3.matcher(Tab[1]).matches() )
                {
                    System.out.println("the instruction is valid");
                }
                else
                {
                    System.out.println("not valid");
                    return false;
                }
            }
            else if (  isInArray(Tab[0], twoarguments) && Tab.length == 2  ) 
            {
                if (  (adresseRegexPat6.matcher(Tab[1]).matches())||(adresseRegexPat7.matcher(Tab[1]).matches())  )
                    System.out.println("the instruction is valid");
                else
                {
                    System.out.println("not valid");
                    return false;
                }
            }
            // If neither condition is met, the syntax is incorrect
            else {
                System.out.println("not valid");
                return false;
            }

        }

        return true;
    }




    private boolean isInArray(String instruction, String[] array) 
    {

        return Arrays.asList(array).contains(instruction);

    }



    static void execute (String instruction)  {
         String[] lines = instruction.split("\\n");
   for (  String line : lines  ) 
       {
            processInstruction(line.trim());
        }
    }

    static void processInstruction(String instruction)  {
        programme.cpu.setJTextField5Text(instruction);
        String[] tokens = instruction.split("\\s+");
        
        if (  isOneArgumentInstruction(tokens[0])  ) {
            if (  tokens[0].matches("LDA")  ) {
                LDA(tokens[1]);
            }
            else if (tokens[0].matches("ADDA")) {
                ADDA(tokens[1]);
            }
            else if (tokens[0].matches("SUBA")) {
                SUBA(tokens[1]);
            }
            else if (tokens[0].matches("LDB")) {
                LDB(tokens[1]);
            }
            else if (tokens[0].matches("ADDB")) {
                ADDB(tokens[1]);
            }
            else if (tokens[0].matches("SUBB")) {
                SUBB(tokens[1]);
            }
            else if (tokens[0].matches("STA")) {
                STA(tokens[1]);
            }
            else if (tokens[0].matches("STB")) {
                STB(tokens[1]);
            }
        }
     else if (isOneArgument2Instruction(tokens[0])){
            if (tokens[0].matches("LDX")) {
                LDX(tokens[1]);

            }
            else if (tokens[0].matches("LDY")) {
                LDY(tokens[1]);
            }
            else if (tokens[0].matches("LDS")) {
                LDS(tokens[1]);
            }

        }
     else if (isTwoArgumentsInstruction(tokens[0])){
            if (tokens[0].matches("PSHS")) {
                PSHS(tokens[1]);

            }
            else if (tokens[0].matches("PULS")){
                PULS(tokens[1]);
            }
            else if(tokens[0].matches("EXG")) {
                EXG(tokens[1]);

            }

        }
     else if (isNoArgumentsInstruction(tokens[0])){
            if (tokens[0].matches("INCA")) {
                INCA();

            }
            else if (tokens[0].matches("INCB")) {
                INCB();

            }
        }
    }


   
    static void LDA( String index) {

        if ((index.charAt(0) == '$') && (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"B6");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;


            String A=ram.adr.get(index.substring(1));
            cpu.setJTextField6Text(A);

        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"96");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);

            String b=programme.cpu.getJTextField8Text();
            String c=b+a;
            String A=ram.adr.get(c);

            cpu.setJTextField6Text(A);

        }
        else if (index.charAt(0) == '#') {/////////////////////////////////////modif

            Rom.modif(Integer.toHexString( pos),"86");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2));////////////rom
            pos++;


            String A=index.substring(2);
            cpu.setJTextField6Text(A);


        }
        else if ((index.charAt(0) == ',') && (index.length()==2)) {

            Rom.modif(Integer.toHexString( pos),"A6");////////////rom
            pos++;
            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16));
                while(s.length()!=4){
                    s = "0" + s;
                }

                String c=ram.adr.get(s);
                cpu.setJTextField6Text(c);
            }
            else if (a.charAt(0) == 'Y') {
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;
                //MODIF TO UPPERCASE
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField6Text(c);
            }

        }
        else if ((index.charAt(0) == '$') && ((index.length()==5)||(index.length()==6)||(index.length()==7))){
            System.out.println("test");

        }
    }

    static void LDB( String index) {
        if ((index.charAt(0) == '$') && (index.length()==5)) {

            Rom.modif(Integer.toHexString( pos),"F6");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;

            String A=ram.adr.get(index.substring(1));
            cpu.setJTextField7Text(A);

        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"D6");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String c=b+a;
            String A=ram.adr.get(c);

            cpu.setJTextField7Text(A);

        }else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"C6");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2));////////////rom
            pos++;
            String A = index.substring(2);
            cpu.setJTextField7Text(A);

        }
        else if ((index.charAt(0) == ',') && (index.length()==2)) {

            Rom.modif(Integer.toHexString( pos),"E6");////////////rom
            pos++;
            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField7Text(c);
            }
            else if (a.charAt(0) == 'Y') {
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }

                String c=ram.adr.get(s);
                cpu.setJTextField7Text(c);
            }

        }
    }



    static void LDX( String index) {
        if ((index.charAt(0) == '$')&& (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"BE");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String A=ram.adr.get(index.substring(1)).toString();
            cpu.setJTextField3Text(A);

        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"9E");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String c=b+a;
            String A=ram.adr.get(c);

            cpu.setJTextField3Text(A);

        } else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"8E");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2,4));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(4));////////////rom
            pos++;

            String A=index.substring(2);
            cpu.setJTextField3Text(A);

        }
        else if ((index.charAt(0) == ',') && (index.length()==2)) {

            Rom.modif(Integer.toHexString( pos),"AE");////////////rom
            pos++;
            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField3Text(c);
            }
            else if (a.charAt(0) == 'Y') {
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField3Text(c);
            }

        }



    }



    static void LDY( String index) {

        if ((index.charAt(0) == '$')&& (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"BE");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String A=ram.adr.get(index.substring(1)).toString();
            cpu.setJTextField11Text(A);

        } else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"9E");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String c=b+a;
            String A=ram.adr.get(c);

            cpu.setJTextField11Text(A);

        }else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"8E");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2,4));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(4));////////////rom
            pos++;

            String A=index.substring(2);
            cpu.setJTextField11Text(A);


        }
        else if ((index.charAt(0) == ',') && (index.length()==2)) {

            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"AE");////////////rom
            pos++;
            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField11Text(c);
            }
            else if (a.charAt(0) == 'Y') {
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField11Text(c);
            }

        }
    }


    static void LDS( String index) {

        if ((index.charAt(0) == '$')&& (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"FE");////////////rom
            pos++;

            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;

            String A=ram.adr.get(index.substring(1)).toString();
            cpu.setJTextField10Text(A);


        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"DE");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String c=b+a;
            String A=ram.adr.get(c);

            cpu.setJTextField10Text(A);

        } else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"CE");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2,4));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(4));////////////rom
            pos++;
            String A=index.substring(2);
            cpu.setJTextField10Text(A);


        }else if ((index.charAt(0) == ',') && (index.length()==2)) {

            Rom.modif(Integer.toHexString( pos),"10");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),"EE");////////////rom
            pos++;
            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField10Text(c);
            }
            else if (a.charAt(0) == 'Y') {
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString(Integer.parseInt(b,16)+Integer.parseInt(dp,16)).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                cpu.setJTextField10Text(c);
            }

        }
    }






    static void ADDA (String index) {

        if ((index.charAt(0) == '$')&& (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"BB");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String b= cpu.getJTextField6Text();
            String A=ram.adr.get(index.substring(1));


            String c=Integer.toHexString((Integer.parseInt(A,16) + Integer.parseInt(b,16))& 0xFF).toUpperCase();
            while(c.length()!=2){
                c = "0" + c;
            }

            cpu.setJTextField6Text(c);
        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"9B");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String c=b+a;
            String A=ram.adr.get(c);
            String e=cpu.getJTextField6Text();
            String d=Integer.toHexString((Integer.parseInt(A,16) + Integer.parseInt(e,16))& 0xFF).toUpperCase();

            while(d.length()!=2){
                d = "0" +d;
            }
            cpu.setJTextField6Text(d);

        } else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"8B");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2));////////////rom
            pos++;

            String A=index.substring(2);
            String b= cpu.getJTextField6Text();
            String c=Integer.toHexString((Integer.parseInt(A,16) + Integer.parseInt(b,16))& 0xFF).toUpperCase();
            while(  c.length()!=2  )
            {
                c = "0" + c;
            }

            cpu.setJTextField6Text(c);

        }
        else if (index.charAt(0) == ','){
            Rom.modif(Integer.toHexString( pos),"AB");////////////rom
            pos++;

            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);

                String d= cpu.getJTextField6Text();

                String z=Integer.toHexString((Integer.parseInt(c,16) + Integer.parseInt(d,16))& 0xFF).toUpperCase();

                while(  z.length()!=2  )
                {
                    z = "0" +z;
                }

                cpu.setJTextField6Text(z);
            }
            else if (a.charAt(0) == 'Y') {
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(  s.length()!=4  )
                {
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                String d= cpu.getJTextField6Text();

                String z=Integer.toHexString((Integer.parseInt(c,16) + Integer.parseInt(d,16))& 0xFF).toUpperCase();

                while(  z.length()!=2  )
                {
                    z = "0" +z;
                }

                cpu.setJTextField6Text(z);
            }




        }

    }

    static void ADDB (String index) {

        if ((index.charAt(0) == '$') && (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"FB");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String b= cpu.getJTextField7Text();
            String A=ram.adr.get(index.substring(1));


            String c=Integer.toHexString((Integer.parseInt(A,16) + Integer.parseInt(b,16))& 0xFF).toUpperCase();
            while(c.length()!=2){
                c = "0" + c;
            }
            cpu.setJTextField7Text(c);
        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"DB");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String c=b+a;
            String A=ram.adr.get(c);
            String e=cpu.getJTextField7Text();
            String d=Integer.toHexString((Integer.parseInt(A,16) + Integer.parseInt(e,16))& 0xFF).toUpperCase();

            while(d.length()!=2){
                d = "0" +d;
            }
            cpu.setJTextField7Text(d);

        }
        else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"CB");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2));////////////rom
            pos++;

            String A=index.substring(2);
            String b= cpu.getJTextField7Text();
            String c=Integer.toHexString((Integer.parseInt(A,16) + Integer.parseInt(b,16))& 0xFF).toUpperCase();
            while(c.length()!=2){
                c = "0" + c;
            }
            cpu.setJTextField7Text(c);

        }
        else if (index.charAt(0) == ','){
            Rom.modif(Integer.toHexString( pos),"EB");////////////rom
            pos++;

            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                String d= cpu.getJTextField7Text();
                String z=Integer.toHexString((Integer.parseInt(c,16) + Integer.parseInt(d,16))& 0xFF).toUpperCase();
                while(z.length()!=2){
                    z = "0" +z;
                }

                cpu.setJTextField7Text(z);
            }
            else if (a.charAt(0) == 'Y') {
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                String d= cpu.getJTextField7Text();

                String z=Integer.toHexString((Integer.parseInt(c,16) + Integer.parseInt(d,16))& 0xFF).toUpperCase();
                while(z.length()!=2){
                    z = "0" +z;
                }

                cpu.setJTextField7Text(z);
            }




        }

    }
/////// MODIFICATION

    static void SUBA(String index) {

        if ((index.charAt(0) == '$') && (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"B0");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String b= cpu.getJTextField6Text();
            String A=ram.adr.get(index.substring(1));
            String  c=Integer.toHexString((Integer.parseInt(A,16) - Integer.parseInt(b,16))& 0xFF).toUpperCase();
            while(c.length()!=2){
                c = "0" + c;
            }
            cpu.setJTextField6Text(c);

        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"90");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String B=cpu.getJTextField6Text();
            String c=b+a;
            String A=ram.adr.get(c);
            String  d=Integer.toHexString((Integer.parseInt(A,16) - Integer.parseInt(B,16))& 0xFF).toUpperCase();
            while(d.length()!=2){
                d = "0" + d;
            }
            cpu.setJTextField6Text(d);

        } else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"80");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2));////////////rom
            pos++;
            String A=index.substring(2);
            String b= cpu.getJTextField6Text();
            String  c=Integer.toHexString((Integer.parseInt(b,16) - Integer.parseInt(A,16))& 0xFF).toUpperCase();
            while(c.length()!=2){
                c = "0" + c;
            }
            cpu.setJTextField6Text(c);
        }else if (index.charAt(0) == ','){
            Rom.modif(Integer.toHexString( pos),"A0");////////////rom
            pos++;

            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);

                String d= cpu.getJTextField6Text();

                String z=Integer.toHexString((Integer.parseInt(c,16) + Integer.parseInt(d,16))& 0xFF).toUpperCase();

                while(z.length()!=2){
                    z = "0" +z;
                }

                cpu.setJTextField6Text(z);
            }
            else if (a.charAt(0) == 'Y') {
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16) - Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                String d= cpu.getJTextField6Text();

                String z=Integer.toHexString((Integer.parseInt(c,16) - Integer.parseInt(d,16))& 0xFF).toUpperCase();

                while(z.length()!=2){
                    z = "0" +z;
                }

                cpu.setJTextField6Text(z);
            }




        }

    }
    static void SUBB(String index) {

        if ((index.charAt(0) == '$') && (index.length()==5)) {
            Rom.modif(Integer.toHexString( pos),"F0");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String b= cpu.getJTextField7Text();
            String A=ram.adr.get(index.substring(1));
            String  c=Integer.toHexString((Integer.parseInt(A,16) - Integer.parseInt(b,16))& 0xFF).toUpperCase();
            while(c.length()!=2){
                c = "0" + c;
            }
            cpu.setJTextField7Text(c);

        }else if ((index.charAt(0) == '$') && (index.length()==3)) {
            Rom.modif(Integer.toHexString( pos),"D0");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;
            String a=index.substring(1);
            String b=programme.cpu.getJTextField8Text();
            String B=cpu.getJTextField7Text();
            String c=b+a;
            String A=ram.adr.get(c);
            String  d=Integer.toHexString((Integer.parseInt(A,16) - Integer.parseInt(B,16))& 0xFF).toUpperCase();
            while(d.length()!=2){
                d = "0" + d;
            }
            cpu.setJTextField7Text(d);

        } else if (index.charAt(0) == '#') {
            Rom.modif(Integer.toHexString( pos),"C0");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(2));////////////rom
            pos++;
            String A=index.substring(2);
            String b= cpu.getJTextField7Text();
            String  c=Integer.toHexString((Integer.parseInt(b,16) - Integer.parseInt(A,16))& 0xFF).toUpperCase();
            while(c.length()!=2){
                c = "0" + c;
            }
            cpu.setJTextField7Text(c);
        }else if (index.charAt(0) == ','){
            Rom.modif(Integer.toHexString( pos),"E0");////////////rom
            pos++;

            String a=index.substring(1);
            if (a.charAt(0) == 'X') {
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String b=programme.cpu.getJTextField3Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                String d= cpu.getJTextField7Text();
                String z=Integer.toHexString((Integer.parseInt(c,16) - Integer.parseInt(d,16))& 0xFF).toUpperCase();
                while(z.length()!=2){
                    z = "0" +z;
                }

                cpu.setJTextField7Text(z);
            }
            else if (a.charAt(0) == 'Y') {
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;
                String b=programme.cpu.getJTextField11Text();
                String dp=programme.cpu.getJTextField8Text();
                String s= Integer.toHexString((Integer.parseInt(b,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                //ERREUR DE SOUSTRACTION
                while(s.length()!=4){
                    s = "0" + s;
                }
                String c=ram.adr.get(s);
                String d= cpu.getJTextField7Text();

                String z=Integer.toHexString((Integer.parseInt(c,16) - Integer.parseInt(d,16)) & 0xFF).toUpperCase();
                while(z.length()!=2){
                    z = "0" +z;
                }

                cpu.setJTextField7Text(z);
            }




        }

    }
    static void STA(String index) {
        if ((index.charAt(0) == '$') && (index.length()==5)){
            Rom.modif(Integer.toHexString( pos),"B7");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String b= cpu.getJTextField6Text();
            ram.modif(index.substring(1), b);
        }else if ((index.charAt(0) == '$') && (index.length()==3)){
            Rom.modif(Integer.toHexString( pos),"97");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;

            String dp= cpu.getJTextField8Text();
            String c=dp+index.substring(1);
            String s=cpu.getJTextField6Text();

            ram.modif(c,s);
        }else if (index.charAt(0) == ','){
            Rom.modif(Integer.toHexString( pos),"A7");////////////rom
            pos++;
            String dp= cpu.getJTextField8Text();
            String a=index.substring(1);
            if (a.charAt(0) == 'X'){
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String c=cpu.getJTextField3Text();
                String s= Integer.toHexString((Integer.parseInt(c,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String b=cpu.getJTextField6Text();
                ram.modif(s,b);

            }else if (a.charAt(0) == 'Y'){
                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String c=cpu.getJTextField11Text();
                String s= Integer.toHexString((Integer.parseInt(c,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String b=cpu.getJTextField6Text();
                ram.modif(s,b);
            }


        }



    }
    static void STB(String index) {
        if ((index.charAt(0) == '$') && (index.length()==5)){
            Rom.modif(Integer.toHexString( pos),"F7");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1,3));////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(3));////////////rom
            pos++;
            String b= cpu.getJTextField7Text();
            ram.modif(index.substring(1), b);
        }else if ((index.charAt(0) == '$') && (index.length()==3)){
            Rom.modif(Integer.toHexString( pos),"D7");////////////rom
            pos++;
            Rom.modif(Integer.toHexString( pos),index.substring(1));////////////rom
            pos++;

            String dp= cpu.getJTextField8Text();
            String c=dp+index.substring(1);
            String s=cpu.getJTextField7Text();

            ram.modif(c,s);

        }else if (index.charAt(0) == ','){
            Rom.modif(Integer.toHexString( pos),"E7");////////////rom
            pos++;

            String dp= cpu.getJTextField8Text();
            String a=index.substring(1);
            if (a.charAt(0) == 'X'){

                Rom.modif(Integer.toHexString( pos),"84");////////////rom
                pos++;
                String c=cpu.getJTextField3Text();
                String s= Integer.toHexString((Integer.parseInt(c,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String b=cpu.getJTextField7Text();
                ram.modif(s,b);


            }else if (a.charAt(0) == 'Y'){
                Rom.modif(Integer.toHexString( pos),"A4");////////////rom
                pos++;

                String c=cpu.getJTextField11Text();
                String s= Integer.toHexString((Integer.parseInt(c,16)+Integer.parseInt(dp,16))& 0xFF).toUpperCase();
                while(s.length()!=4){
                    s = "0" + s;
                }
                String b=cpu.getJTextField7Text();
                ram.modif(s,b);

            }

        }



    }
    static void PSHS(String index) {
        Rom.modif(Integer.toHexString( pos),"34");////////////rom
        pos++;
        String s=cpu.getJTextField10Text();
        if ( s != "0000") {
            if (index.charAt(0) == 'A')
            {
                Rom.modif(Integer.toHexString( pos),"02");////////////rom
                pos++;
                Integer d=Integer.parseInt(s,16)-1;
                String a=cpu.getJTextField6Text();
                String b=Integer.toHexString(d );
                while (b.length()!=4){
                    b='0'+b;
                }
                //System.out.println(b);
                ram.modif(b,a);
                cpu.setJTextField10Text(b);


            } if (index.charAt(0) == 'B')
            {
                Rom.modif(Integer.toHexString( pos),"04");////////////rom
                pos++;
                Integer d=Integer.parseInt(s,16)-1;
                String a=cpu.getJTextField7Text();
                String b=Integer.toHexString(d);
                while (b.length()!=4){
                    b='0'+b;
                }
                ram.modif(b, a);
                cpu.setJTextField10Text(b);


            }
        }


    }


    static void PULS(String index){
        Rom.modif(Integer.toHexString( pos),"35");////////////rom
        pos++;
        String s=cpu.getJTextField10Text();
        String r=ram.adr.get(s);
        String d=Integer.toHexString(Integer.parseInt(s,16)+1);
        while (d.length()!=4){
            d='0'+d;
        }
        cpu.setJTextField10Text(d);
        if (index.charAt(0) == 'A'){
            Rom.modif(Integer.toHexString( pos),"02");////////////rom
            pos++;
            cpu.setJTextField6Text(r);
        }else if (index.charAt(0) == 'B'){
            Rom.modif(Integer.toHexString( pos),"04");////////////rom
            pos++;
            cpu.setJTextField7Text(r);
        }

    }


    static void EXG (String index){
        //cpu.setJTextField8Text("test");
        Rom.modif(Integer.toHexString( pos),"1E");////////////rom
        pos++;
        if (index.charAt(0) == 'A'){
            if (index.charAt(2) == 'B') {
                Rom.modif(Integer.toHexString(pos), "89");////////////rom
                pos++;
            }
            else if (index.charAt(2) == 'D') {
                Rom.modif(Integer.toHexString(pos), "8B");////////////rom
                pos++;
            }
        }
        else if (index.charAt(0) == 'B'){
            if (index.charAt(2) == 'A') {
                Rom.modif(Integer.toHexString(pos), "98");////////////rom
                pos++;
            }
            else if (index.charAt(2) == 'D') {
                Rom.modif(Integer.toHexString(pos), "9B");////////////rom
                pos++;
            }
        }
       else if (index.charAt(0) == 'D'){
            if (index.charAt(3) == 'B') {
                Rom.modif(Integer.toHexString(pos), "B9");////////////rom
                pos++;
            }
            else if (index.charAt(3) == 'A') {
                Rom.modif(Integer.toHexString(pos), "B8");////////////rom
                pos++;
            }
        }

        String v=null;
        String c = null;
        if ((index.charAt(0) == 'A')&&(index.charAt(2) == 'B')||(index.charAt(2) == 'A')&&(index.charAt(0) == 'B')){

            String temp=cpu.getJTextField7Text();
            cpu.setJTextField7Text(cpu.getJTextField6Text());
            cpu.setJTextField6Text(temp);
        }else if ((index.charAt(0) == 'A')&&(index.charAt(2) == 'D')||(index.charAt(3) == 'A')&&(index.charAt(0) == 'D')){
            String temp=cpu.getJTextField8Text();
            cpu.setJTextField8Text(cpu.getJTextField6Text());
            cpu.setJTextField6Text(temp);


        }else if ((index.charAt(0) == 'D')&&(index.charAt(3) == 'B')||(index.charAt(2) == 'D')&&(index.charAt(0) == 'B')){

            String temp=cpu.getJTextField8Text();
            cpu.setJTextField8Text(cpu.getJTextField7Text());
            cpu.setJTextField7Text(temp);

        }

    }

    static void INCA (){
        Rom.modif(Integer.toHexString( pos),"4C");////////////rom
        pos++;

        String s= Integer.toHexString((Integer.parseInt(cpu.getJTextField6Text(),16)+1)& 0xFF).toUpperCase();
        while(s.length()!=2){
            s = "0" + s;
        }
        cpu.setJTextField6Text(s);
    }
    static void INCB (){

        Rom.modif(Integer.toHexString( pos),"5C");////////////rom
        pos++;

        String s= Integer.toHexString((Integer.parseInt(cpu.getJTextField7Text(),16)+1)& 0xFF).toUpperCase();
        while(s.length()!=2){
            s = "0" + s;
        }
        cpu.setJTextField7Text(s);

    }


    static boolean isOneArgumentInstruction(String opcode) {


        return Arrays.asList(oneargument).contains(opcode);
    }
    static boolean isOneArgument2Instruction(String opcode) {


        return Arrays.asList(oneargument2).contains(opcode);
    }
    static boolean isTwoArgumentsInstruction(String opcode) {


        return Arrays.asList(twoarguments).contains(opcode);
    }
    static boolean isNoArgumentsInstruction(String opcode) {


        return Arrays.asList(noarguments).contains(opcode);
    }





}