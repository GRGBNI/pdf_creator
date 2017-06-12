package pdf1;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Pdf1 {

    private static final String FILE_NAME = "/tmp/itext.pdf";

    public static void main(String[] args) {
        writeUsingIText();
        
    }

    private static void writeUsingIText() {

        Document document = new Document();
        Scanner sc=new Scanner(System.in);
        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File("sin.pdf")));
             //data corrente
             DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
             Date date = new Date();
             System.out.println(""+dateFormat.format(date));
            
            
          
            //apertura documento
            document.open();

            Paragraph p = new Paragraph(); //creazione paragrafo
            p.add("Giorgio Bini");  //aggiuntaelementi al paragrafo
            p.setAlignment(Element.ALIGN_LEFT); //allineamento paragrafo a destra 
            document.add(p); //aggiunta del paragrafo a destra
            
            Font f2 = new Font();  //creazione font
            f2.setStyle(Font.BOLD); //tipo font
            f2.setSize(15); //dimensione font
            f2.setColor(BaseColor.YELLOW); //colore font
            
            Paragraph p2 = new Paragraph();
            p2.setFont(f2);
            p2.add("SINTECNOS"); 
            p2.setAlignment(Element.ALIGN_CENTER);
            
            document.add(p2);
            
            Font f3 = new Font();  //creazione font
            f3.setStyle(Font.ITALIC); //tipo font
            f3.setSize(8); //dimensione font
            f3.setColor(BaseColor.BLACK); //colore font
            
            Paragraph p3 = new Paragraph(); 
            p3.add(dateFormat.format(date)); //aggiunta data corrente al pdf
            p3.setAlignment(Element.ALIGN_RIGHT);
            p2.setFont(f3);
            document.add(p3);
            //aggiunta immagine al documento 
            Image img = Image.getInstance("sinte.jpg");
            img.setAlignment(Element.ALIGN_CENTER);
            document.add(img);
            
             
            System.out.println("buongiorno, per continuare premi invio");
            String s=sc.nextLine();
            
              //for(int i=0; i<=ns; i++){
            while(!s.equalsIgnoreCase(".")){
                System.out.println("inserisci stringa: ");
                 s=sc.nextLine();
                if(!s.equals(".")){
                Font cic= new Font();  //creazione font
                cic.setStyle(Font.ITALIC); //tipo font
                cic.setSize(8); //dimensione font
                cic.setColor(BaseColor.BLACK); //colore font
            
                Paragraph ciclo = new Paragraph(); //creazione paragrafo
                ciclo.setFont(cic);
                ciclo.add(s);  //aggiuntaelementi al paragrafo
                ciclo.setAlignment(Element.ALIGN_LEFT); //allineamento paragrafo a destra 
                
                document.add(ciclo); //aggiunta del paragrafo a destra
                }
                else{
                    System.out.println("fine inserimento");
                }
            }
           
           //  }
            
            
            //close
            document.close();

            System.out.println("Documento creato");

        } catch (FileNotFoundException | DocumentException e) {
        } catch (IOException e) {
        }
    }
}
            
           
            
          

            

     

