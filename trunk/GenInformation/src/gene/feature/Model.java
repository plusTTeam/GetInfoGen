package gene.feature;

/**
 * Interfaz DESCRIPTORA de los valores NECESARIOS para comprobar que un gen o
 * una parte del mismo sean validos
 */
public interface Model {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public final int maxIntron = 10000000;
    public final int minIntron = 60;
    public final int maxExon = 6000;
    public final int minExon = 10;
    //---------------------------------------
    public static final String ATG = "atg";
    public static final String GT = "gt";
    public static final String AG = "ag";
    //---------------------------------------
    public static final int TAA = 0;
    public static final int TAG = 1;
    public static final int TGA = 2;
    public static final String[] stops = {"taa", "tag", "tga"};
    //---------------------------------------
    public static final String allowCharacters = "agtc";
    //  </editor-fold>
}
