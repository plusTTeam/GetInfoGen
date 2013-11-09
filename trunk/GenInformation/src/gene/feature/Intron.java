package gene.feature;

import java.util.List;

/**
 * Clase que extiende de GenePart, como implementacion especifica de que es un
 * Intron, solo implementa sus metodos de escritura para permitir el formato en
 * modo exon tanto para su DATA como para sus PARES
 */
public class Intron extends GenePart {

    private int endStart = 0;
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Intron(Information start, Information end, List<Information> innerInfo) throws Exception {
        super(start, end, innerInfo);
        
        endStart = innerInfo.size() - 1;
        
        String gt = start.info + innerInfo.get(0);
        String ag = innerInfo.get(endStart).info + end.info;
        
        if (!gt.equalsIgnoreCase(Model.GT) || !ag.equalsIgnoreCase(Model.AG))
            throw new Exception("El intron no es reconocido, DEBE comenzar por \"" + Model.GT + "\" y terminar por \"" + Model.AG + "\"");
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public String getStringInfo(boolean intron) {
        String out = "(";
        out += this.toString();
        out += ")";
        return out;
    }

    //---------------------------------------
    @Override
    public String getPositionsInfo(boolean intron) {
        String out = "(";

        out += start.position.toString() + ",";
        out += getEnd().position.toString();

        out += ")";
        return out;
    }
    
    //---------------------------------------
    @Override
    public Information getEnd(){
        return this.innerInfo.get(endStart);
    }
    //  </editor-fold>
}
