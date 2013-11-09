package gene.information;

import gene.feature.Information;
import java.util.ArrayList;
import java.util.List;
import util.MiddleWare;

/**
 * Clase para manegar la construccion de genes(lecturas) posibles usando las
 * listas de inicios(atg), paradas(stops), y intrones (gt,ag) como indices
 * referentes a sus valores en la lista de informacion(geneData)
 */
public class GeneConstructor {
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">

    private List<Integer> atg;
    private List<Integer> gt;
    private List<Integer> ag;
    private List<Integer> stops; //Pueden ser: taa, tag o tga
    //---------------------------------------
    private List<Information> geneData;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    /**
     * Constructor usado para crear el objeto con las listas ya llenas de
     * acuerdo a los valores que llegan por parametros
     */
    public GeneConstructor(List<Integer> atg, List<Integer> gt, List<Integer> ag, List<Integer> stops, List<Information> geneData) {
        this.atg = atg;
        this.gt = gt;
        this.ag = ag;
        this.stops = stops;
        this.geneData = geneData;

        isCompatibleGene();
    }

    //---------------------------------------
    /**
     * Constructor usado para llenar las listas de uso interno a traves de un
     * objeto de la clase MiddleWare ya instanciado y probado, de donde solo se
     * obtendran los valores que este devuelve como entrada para generar las
     * listas internas
     */
    public GeneConstructor(MiddleWare middleWare) throws Exception {
        this.initLists(middleWare.getAtgPositions(),
                middleWare.getGtPositions(),
                middleWare.getAgPositions(),
                middleWare.getAgPositions(),
                middleWare.getGenData());

        this.isCompatibleGene();
    }

    //---------------------------------------
    /**
     * Constructor solo debe ser usado si el objeto que se esta creando esta en
     * otra clase del mismo paquete pues, el objetivo seria poder instanciar
     * luego todas sus listas a traves del metodo initLists
     */
    public GeneConstructor() {
    }

    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public List<Integer> getAtg() {
        return atg;
    }

    //---------------------------------------
    public List<Integer> getGt() {
        return gt;
    }

    //---------------------------------------
    public List<Integer> getAg() {
        return ag;
    }

    //---------------------------------------
    public List<Integer> getStops() {
        return stops;
    }

    //---------------------------------------
    public int lastData() {
        return geneData.size() - 1;
    }

    //---------------------------------------
    public Information getData(int i) {
        return this.geneData.get(i);
    }

    //---------------------------------------
    public List<Information> getGeneData() {
        return geneData;
    }

    //---------------------------------------
    public List<Information> getInnerInfo(int from, int to) {
        return geneData.subList(from, to);
    }
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    /**
     * Verificaciones de casos especificos para la compatibilidad de un gen
     */
    public boolean isCompatibleGene() {

        if ((this.atg.isEmpty() || this.stops.isEmpty()) && (this.gt.isEmpty() || this.ag.isEmpty())) {
            return false;
        }

        if (!this.gt.isEmpty() && !this.ag.isEmpty()) {
            if (this.atg.isEmpty()) {
                this.atg.add(new Integer(0));
            }
            if (this.stops.isEmpty()) {
                this.stops.add(new Integer(geneData.size() - 1));
            }
        }

        return true;
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Package Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Package Methods">
    /**
     * Metodo usado para instanciar las listas a traves de listas de Integers
     * para los indices, y una lista de Strings para la data, solo es posible
     * usarlo si se esta en el mismo paquete que esta clase, por lo que se
     * recomienda usar en lugar de esto los constructores
     */
    void initLists(List<Integer> atg, List<Integer> gt, List<Integer> ag, List<Integer> stops, List<String> data) throws Exception {
        this.atg = atg;
        this.gt = gt;
        this.ag = ag;
        this.stops = stops;
        this.geneData = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            Information info = new Information(new Integer(i), data.get(i));
            this.geneData.add(info);
        }
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public String toString() {
        String out = "";
        String aux;
        
        aux = "ATG\t= [";
        for (Integer index : atg) {
            aux += ", " + index;
        }
        aux = aux.replaceFirst(", ", "");
        aux += "]";
        
        out += aux + "\n";
        
        aux = "GT\t= [";
        for (Integer index : gt) {
            aux += ", " + index;
        }
        aux = aux.replaceFirst(", ", "");
        aux += "]";
        
        out += aux + "\n";
        
        aux = "AG\t= [";
        for (Integer index : ag) {
            aux += ", " + index;
        }
        aux = aux.replaceFirst(", ", "");
        aux += "]";
        
        out += aux + "\n";
        
        aux = "STOPS\t= [";
        for (Integer index : stops) {
            aux += ", " + index;
        }
        aux = aux.replaceFirst(", ", "");
        aux += "]";
        
        out += aux + "\n";
        return out;
    }
    //  </editor-fold>
}
