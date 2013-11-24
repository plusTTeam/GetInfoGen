package gene.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Clase que extiende de GenePart, como implementacion especifica de que es un
 * Intron, solo implementa sus metodos de escritura para permitir el formato en
 * modo exon tanto para su DATA como para sus PARES
 */
public class Intron extends GenePart {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final Pattern startPattern = Pattern.compile(Model.GT);
    public static final Pattern endPattern = Pattern.compile(Model.AG);
    
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private int endStart = 0;
    
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Intron(Information start, Information end, List<Information> innerInfo) throws Exception {
        super(start, end, innerInfo);

        endStart = innerInfo.size() - 1;

        String gt = start.info + innerInfo.get(0);
        String ag = innerInfo.get(endStart).info + end.info;

        if (!startPattern.matcher(gt).find() || !endPattern.matcher(ag).find()) {
            throw new Exception("El intron " + getPositionsInfo(true) + "[" + gt + ":" + ag + "] no es reconocido, DEBE tener la siguiente ESTRUCTURA [" + Model.GT + ":" + Model.AG + "]");
        }
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
    public Information getEnd() {
        return this.innerInfo.get(endStart);
    }
    
    //  </editor-fold>
}
