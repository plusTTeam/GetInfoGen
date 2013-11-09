package util;

import gene.information.Analizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenInformation {

    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            
             MiddleWare middle = new MiddleWare();
             middle.init(args[0]);
             middle.consultEverything();
             
            
            List<String> data = new ArrayList<>(Arrays.asList(
        /*j/i*/      //0     1     2     3     4     5     6     7     8     9    10     11    12   13    14    15     16   17
        /*0*/        "atg", "gt", "ag", "gt", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag",
        /*1*/        "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag",
        /*2*/        "ag", "ag", "ag", "ag", "ag", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag",
        /*3*/        "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag",
        /*4*/        "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag",
        /*5*/        "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag",
        /*6*/        "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag",
        /*7*/        "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag",
        /*8*/        "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag",
        /*9*/        "gt", "ag", "gt", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*10*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*11*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*12*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*13*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*14*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*15*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*16*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*17*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*18*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*19*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*20*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*21*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*22*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*23*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag",
       /*24*/        "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag",
       /*25*/        "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "taa", "ag", "gt", "ag", "taa", "ag"));
            //cada linea 4 grupos de 4 + 1 grupo de 2 = 18
            //hay 26 lineas * 18 = 468
            //formula posicion i+(j*18) mientras i < 18 && j < 26
            
            List<Integer> atg = new ArrayList<>(Arrays.asList(0));
            List<Integer> gt = new ArrayList<>(Arrays.asList(42, 60, 160, 182));
            List<Integer> ag = new ArrayList<>(Arrays.asList(54, 71, 121, 185, 389));
            List<Integer> stops = new ArrayList<>(Arrays.asList(260, 444, 466));

            Analizer analizer = new Analizer();
            analizer.readFromMiddleWare(middle);
            //analizer.readFromLists(atg, gt, ag, stops, data);

            analizer.constructLectures(false);
            System.out.println(analizer.toString());
        } else {
            throw new ArrayIndexOutOfBoundsException("Debe enviar por parametros algun archivo a evaluar\nEjemplo: genes/predictor/p_genes.pl");
        }
    }
}
