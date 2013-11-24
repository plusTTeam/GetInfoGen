package util;

import gene.information.Analizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.MiddleWare;

public class GenInformation {

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            /*
             MiddleWare middle = new MiddleWare();
             middle.init(args[0]);
             middle.consultEverything();
             */
            
            List<String> data = new ArrayList<>(Arrays.asList(
        /*j/i*/      //0   1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31   32   33   34   35
        /*0*/        "a", "t", "g", "g", "t", "a", "g", "g", "t", "a", "t", "g", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a",
        /*1*/        "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g",
        /*2*/        "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g",
        /*3*/        "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g",
        /*4*/        "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g",
        /*5*/        "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g",
        /*6*/        "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "a", "t", "g", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g",
        /*7*/        "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g",
        /*8*/        "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g",
        /*9*/        "g", "t", "a", "g", "g", "t", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g",
       /*10*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g",
       /*11*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", 
       /*12*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", 
       /*13*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", 
       /*14*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", 
       /*15*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g",
       /*16*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g",
       /*17*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", 
       /*18*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", 
       /*19*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", 
       /*20*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g",
       /*21*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", 
       /*22*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", 
       /*23*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", 
       /*24*/        "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", 
       /*25*/        "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "g", "t", "a", "g", "t", "a", "a", "a", "g", "t", "a", "a", "a", "g", "g", "t", "c", "g"));
            //cada linea tiene 36 elementos
            //hay 26 lineas
            // total =>     26 * 36 = 936
            //formula posicion i+(j*36) mientras i < 36 && j < 26
            
            List<Integer> atg = new ArrayList<>(Arrays.asList(0, 9, 232));
            List<Integer> gt = new ArrayList<>(Arrays.asList(84, 116, 144, 300, 765));
            List<Integer> ag = new ArrayList<>(Arrays.asList(82, 122, 170, 574, 894));
            List<Integer> stops = new ArrayList<>(Arrays.asList(369, 616, 922));

            Analizer analizer = new Analizer();
            //analizer.readFromMiddleWare(middle);
            analizer.readFromLists(atg, gt, ag, stops, data);

            analizer.constructLectures(false);
            System.out.println(analizer.toString());
        } else {
            throw new ArrayIndexOutOfBoundsException("Debe enviar por parametros algun archivo a evaluar\nEjemplo: genes/predictor/p_genes.pl");
        }
    }
}
