/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author A10004020
 */
public class LeerExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Workbook workbook = null;
        
        try {
            workbook = 
                    Workbook.getWorkbook(new 
                    File("D:\\EstructurasDeDatos\\09Septiembre\\archivo.xls"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IO");
        } catch (BiffException ex) {
            JOptionPane.showMessageDialog(null, "Error diferente");
        }
        
        Sheet sheet = workbook.getSheet(1); 
        ArrayList<Escuela> escuelas = new ArrayList<Escuela>();
       
        for(int i = 3; i < sheet.getRows(); i++){
            Cell a1 = sheet.getCell(4, i);
            //System.out.print("Linea " + i + " " + a1.getContents());
            //System.out.println("");
//            for(int j = 10; j <= 16; j++){
//            
//                if(j != 14){
//                    Cell a2 = sheet.getCell(j, i);
//                    System.out.println(a2.getContents());
//                
//                
//                }
//            }
            Escuela e = new Escuela(
                    a1.getContents(),
                    calculaPromedio(i, sheet)
                    );
            
            escuelas.add(e);
//            
        }
        
        Collections.sort(escuelas, new Comparator<Escuela>() {
        @Override
            public int compare(Escuela  e1, Escuela e2)
            {
                return  e1.getPromedio().compareTo(e2.getPromedio());
            }
        });
        
        for(int j = 0;j < escuelas.size();j++){
            System.out.println("Escuela: " + escuelas.get(j).getNombre() +
                    " Promedio: " + escuelas.get(j).getPromedio());
        }
    }
    
    public static Double calculaPromedio(int i, Sheet sheet){
        
        Double p = 0.0;
        String sd = "S/D";
        
        //10,11,12,13,15,16
        
        for(int j = 10; j <= 16; j++){
            
            if(j != 14){
                Cell a1 = sheet.getCell(j, i);
                //System.out.println(a1.getContents());
                
                try{
                    p += Double.parseDouble(a1.getContents());
                }catch(NumberFormatException e){
                    p += 0; 
                }
                
   
                
            }
        }
        
        //System.out.println(p/6);
        return p/6;
        
    }
}
