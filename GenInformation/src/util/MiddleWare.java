package util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Queue;
import jpl.Query;

/**
 * Basicamente encargado de: Invocar a prolog Y usando p_genes, gen_prueba y
 * soportes_p_intrones
 *
 * obtener los resultados con el metodo {Query}.oneSolution.get("{Nombre de la
 * variable}")
 */
public class MiddleWare {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final int G = 0;
    public static final int ATG = 1;
    public static final int GT = 2;
    public static final int AG = 3;
    public static final int STOPS = 4;
    //---------------------------------------
    private static final String[] textTypes = {"G", "Patgs", "Pgt", "Pag", "Ppar", "Pint", "Pint", "Gen", "R"};
    //---------------------------------------
    private static final String prologConsult = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
    private static final String regexCleaner = "[^\\d\\w ]";
    //  </editor-fold>

    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    /**
     * Define el archivo matriz -> p_genes.pl Y busca
     */
    public void consultEverything() {
        //Obteniendo los valores...
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);
        System.out.println("G = " + q2.oneSolution().get("G"));
        System.out.println("Patgs = " + q2.oneSolution().get("Patgs"));
        System.out.println("Pgt = " + q2.oneSolution().get("Pgt"));
        System.out.println("Pag = " + q2.oneSolution().get("Pag"));
        System.out.println("Pint = " + q2.oneSolution().get("Pint"));
        System.out.println("Gen = " + q2.oneSolution().get("Gen"));
        System.out.println("R = " + q2.oneSolution().get("R"));

    }

    //---------------------------------------
    public String getData(String Var) {
        Query query = new Query(prologConsult);
        System.out.println("G = " + query.oneSolution().get(Var));
        return query.oneSolution().get(Var).toString();
    }

    //---------------------------------------
    public void init(String URLdelPL) {
        //Abriendo el archivo
        String testConsult = "consult('" + URLdelPL + "')";
        Query query = new Query(testConsult);
        System.out.println(testConsult + " " + (query.hasSolution() ? "succeeded" : "failed"));
    }

    //---------------------------------------
    /**
     * Metodo que REEMPLAZA los otros usados para obtener las listas de las 
     * posiciones, recibe un entero que determina que lista se desea consultar
     * donde ese entero debe ser una de las CONSTANTES PUBLICAS de la clase
     * MiddleWare<br/>
     * <br/>
     * Ejemplo:<br/>
     * getPositions(MiddleWare.ATG);<br/>
     * El resultado a esta consulta serian todas las listas de ATG que devuelva
     * prolog
     */
    public Queue<List<Integer>> getPositions(int type) {
        Query query = new Query(prologConsult);

        Queue<List<Integer>> positions = new ArrayDeque<>();

        for (Hashtable solution : query.allSolutions()) {
            List<Integer> pos = new ArrayList<>();
            String Cadena = solution.get(textTypes[type]).toString();
            Cadena = Cadena.replaceAll(regexCleaner, "");
            
            if (Cadena.length() > 1) {
                String[] vector = Cadena.split(" ");
                for (int j = 0; j < vector.length; j++) {
                    pos.add(Integer.parseInt(vector[j]));
                }
            }
            
            positions.add(pos);
        }
        
        return positions;
    }

    //---------------------------------------
    public List<Integer> getAtgPositions() {
        Query q2 = new Query(prologConsult);

        Hashtable[] ss4 = q2.allSolutions();
        List<Integer> AtgPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Patgs").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll(regexCleaner, "");
            if (Cadena.length() > 1) {
                String[] vector = Cadena.split(" ");
                for (int j = 0; j < vector.length; j++) {
                    AtgPositions.add(Integer.parseInt(vector[j]));
                }
                return AtgPositions;
            }
        }
        return new ArrayList<>();
    }

    //---------------------------------------
    public List<Integer> getGtPositions() {
        Query q2 = new Query(prologConsult);

        Hashtable[] ss4 = q2.allSolutions();
        List<Integer> GtPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Pgt").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll(regexCleaner, "");
            if (Cadena.length() > 1) {
                String[] vector = Cadena.split(" ");
                for (int j = 0; j < vector.length; j++) {
                    GtPositions.add(Integer.parseInt(vector[j]));
                }
                return GtPositions;
            }
        }
        return new ArrayList<>();
    }

    //---------------------------------------
    public List<Integer> getAgPositions() {
        Query q2 = new Query(prologConsult);

        Hashtable[] ss4 = q2.allSolutions();
        List<Integer> AgPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Pag").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll(regexCleaner, "");
            if (Cadena.length() > 1) {
                String[] vector = Cadena.split(" ");
                for (int j = 0; j < vector.length; j++) {
                    AgPositions.add(Integer.parseInt(vector[j]));
                }
                return AgPositions;
            }
        }
        return new ArrayList<>();
    }

    //---------------------------------------
    public List<Integer> getParadasPositions() {
        Query q2 = new Query(prologConsult);

        Hashtable[] ss4 = q2.allSolutions();
        List<Integer> ParadasPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Ppar").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll(regexCleaner, "");
            if (Cadena.length() > 1) {
                String[] vector = Cadena.split(" ");
                for (int j = 0; j < vector.length; j++) {
                    ParadasPositions.add(Integer.parseInt(vector[j]));
                }
                return ParadasPositions;
            }
        }
        return new ArrayList<>();
    }

    //---------------------------------------
    public List<String> getGenData() {
        Query q2 = new Query(prologConsult);

        Hashtable[] ss4 = q2.allSolutions();
        List<String> GenData = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("G").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll(regexCleaner, "");
            if (Cadena.length() > 1) {
                String[] vector = Cadena.split(" ");
                for (String vector1 : vector) {
                    GenData.add(vector1);
                }
                return GenData;
            }
        }
        return new ArrayList<>();

    }
    
    //---------------------------------------
    //  </editor-fold>
}
