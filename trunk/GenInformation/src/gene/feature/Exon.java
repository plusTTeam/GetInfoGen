package gene.feature;

import java.util.List;

/**
 * Clase que extiende de GenePart, como implementacion especifica de que es un
 * Exon, solo implementa sus metodos de escritura para permitir el formato en
 * modo exon tanto para su DATA como para sus PARES
 */
public class Exon extends GenePart {
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Exon(Information start, Information end, List<Information> innerInfo) {
        super(start, end, innerInfo);
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
