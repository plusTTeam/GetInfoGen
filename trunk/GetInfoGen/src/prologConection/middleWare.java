package prologConection;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import jpl.Query;

/**
 * Basicamente encargado de: Invocar a prolog Y usando p_genes, gen_prueba y
 * soportes_p_intrones
 *
 * obtener los resultados con el metodo {Query}.oneSolution.get("{Nombre de la
 * variable}")
 */
public class middleWare {

    private List<Integer> AtgPositions;
    private List<Integer> GtPositions;
    private List<Integer> AgPositions;
    private List<Integer> ParadasPositions;
    private List<String> GenData;

    /**
     * Define el archivo matriz -> p_genes.pl Y busca
     *
     */
    public void consultEverything() {
        //Obteniendo los valores...
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);

        System.out.println("G = " + q2.oneSolution().get("G"));
        System.out.println("Patgs = " + q2.oneSolution().get("Patgs"));
        System.out.println("Pgt = " + q2.oneSolution().get("Pgt    "));
        System.out.println("Pag = " + q2.oneSolution().get("Pag"));
        System.out.println("Pint = " + q2.oneSolution().get("Pint"));
        System.out.println("Gen = " + q2.oneSolution().get("Gen"));
        System.out.println("R = " + q2.oneSolution().get("R"));

    }

    public String getData(String Var) {
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);
        System.out.println("G = " + q2.oneSolution().get(Var));
        return q2.oneSolution().get(Var).toString();
    }

    public void init(String URLdelPL) {
        //Abriendo el archivo
        String t1 = "consult('"+URLdelPL+"')";
        Query q1 = new Query(t1);
        System.out.println(t1 + " " + (q1.hasSolution() ? "succeeded" : "failed"));

    }

    public List<Integer> getAtgPositions() {
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);

        Hashtable[] ss4 = q2.allSolutions();
        AtgPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Patgs").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll("[^\\dA-Za-z ]", "");
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

    public List<Integer> getGtPositions() {
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);

        Hashtable[] ss4 = q2.allSolutions();
        GtPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Pgt").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll("[^\\dA-Za-z ]", "");
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

    public List<Integer> getAgPositions() {
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);

        Hashtable[] ss4 = q2.allSolutions();
        AgPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Pag").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll("[^\\dA-Za-z ]", "");
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

    public List<Integer> getParadasPositions() {
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);

        Hashtable[] ss4 = q2.allSolutions();
        ParadasPositions = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("Ppar").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll("[^\\dA-Za-z ]", "");
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

    public List<String> getGenData() {
        String t2 = "gen(G), p_gener(G, Patgs, Pgt, Pag, Ppar, Pint, Gen, R).";
        Query q2 = new Query(t2);

        Hashtable[] ss4 = q2.allSolutions();
        GenData = new ArrayList<>();

        for (int i = 0; i < ss4.length; i++) {
            String Cadena = ss4[i].get("G").toString();
            //Regex para dejar solo numeros 
            Cadena = Cadena.replaceAll("[^\\dA-Za-z ]", "");
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
}
