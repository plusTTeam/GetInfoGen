package gene.feature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase descriptora de la informacion en cada lugar de un gen, usada solo
 * para asociar una data a una posicion del gen y para validar que sea permitida
 */
public class Information {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final Pattern lexicalMatcher = Pattern.compile("[^" + Model.allowCharacters + "]+");
    //  </editor-fold>
    //---------------------------Public Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    public Integer position;
    //---------------------------------------
    public String info;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Information(Integer position, String info) throws Exception{
        this.position = position;
        this.info = info;
        Matcher matcher = lexicalMatcher.matcher(info);
        if(matcher.find())
            throw new Exception("El o los caracteres \"" + matcher.group() + "\""
                    + "no corresponden a un estructura valida de gen");
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public String getInfo() {
        return info;
    }

    //---------------------------------------
    public Integer getPosition() {
        return position;
    }

    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public String toString() {
        return info;
    }
    //---------------------------------------
    //  </editor-fold>
}
