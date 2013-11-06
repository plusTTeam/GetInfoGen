package gene.feature;

import java.util.List;

/**
 * Clase que extiende de GenePart, como implementacion especifica de que es un
 * Intron, solo implementa sus metodos de escritura para permitir el formato en
 * modo exon tanto para su DATA como para sus PARES
 */
public class Intron extends GenePart {

    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Intron(Information start, Information end, List<Information> innerInfo) throws Exception {
        super(start, end, innerInfo);
        
        if (!start.info.equalsIgnoreCase(Model.GT) || !end.info.equalsIgnoreCase(Model.AG))
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
        out += end.position.toString();

        out += ")";
        return out;
    }
    //  </editor-fold>
}
