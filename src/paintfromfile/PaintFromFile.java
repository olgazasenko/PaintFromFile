/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintfromfile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olga
 */
public class PaintFromFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = null;
        try {
            String filePath = "/Users/ozasenko/Documents/NetBeansProjects/";
            in = new Scanner(new FileReader(filePath + "CountFlopsCSD/data/plot.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PaintFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        int k, n, i = 0;
        long flops, CSD;
        ArrayList<Long[]> graphFlops = new ArrayList<>();
        while (in.hasNext()) {
            k = in.nextInt(); // just to skip
            n = in.nextInt(); 
            flops = Math.round(in.nextDouble());
            CSD = in.nextLong(); // just to skip
            graphFlops.add(new Long[2]);
            graphFlops.get(i)[0] = (long)n;
            graphFlops.get(i)[1] = flops;
            i++;
        }
        plotFlops(graphFlops);
    }
    
    private static void plotFlops(ArrayList<Long[]> graphFlops){
        Paint painter = new Paint(graphFlops);
        painter.paint();
    }

}
