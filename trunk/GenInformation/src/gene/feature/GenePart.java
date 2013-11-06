package gene.feature;

import java.util.List;
/**
 * Clase abstracta que describe la forma de cualquier parte del gen,
 * metodos abstractos solo para personalizar el formato de impresion
 */
public abstract class GenePart implements Model {
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Protected Attributes">

    protected Information start;
    protected Information end;
    //---------------------------------------
    protected List<Information> innerInfo;

    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public GenePart(Information start, Information end, List<Information> innerInfo) {
        this.start = start;
        this.end = end;
        this.innerInfo = innerInfo;
    }
    
    //---------------------------------------
    public GenePart(Information start, Information end) {
        this.start = start;
        this.end = end;
    }
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Information getStart() {
        return start;
    }
    
    //---------------------------------------
    public Information getEnd() {
        return end;
    }
    
    //---------------------------------------
    public List<Information> getInnerInfo() {
        return innerInfo;
    }
    
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public String toString() {
        String out = start.toString();
        for (Information information : innerInfo) {
            out += information.toString();
        }
        out += end.toString();
        return out;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    /**
     * Personaliza el modo de impresion de la data de una parte del gen
     */
    public abstract String getStringInfo(boolean intron);
    //---------------------------------------
    /**
     * Personaliza el modo de impresion de las posiciones de inicio y fin 
     * correspondientes a cada parte del gen
     */
    public abstract String getPositionsInfo(boolean intron);
    //  </editor-fold>
}
