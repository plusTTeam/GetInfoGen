package prologConection;

import java.io.IOException;
import java.util.List;

/**
 *
 * Clase TEST que instancia middleWare para comprobar el uso de JPL
 * 
 * 
 * @author Roy
 */
public class Init {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        middleWare middleObject = new middleWare();
        middleObject.init();
        middleObject.consultEverything();
        
        String Hola = middleObject.getData("Patgs");
        
        List<Integer> asd = middleObject.getAtgPositions();
        List<Integer> asd1 = middleObject.getAgPositions();
        List<Integer> asd2 = middleObject.getGtPositions();
        List<Integer> asd3 = middleObject.getParadasPositions();
        List<String> asd4 = middleObject.getGenData();
        

    }
}
