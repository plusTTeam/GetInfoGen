/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InfoGen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus
 */
public class Lectura {
    private List<String> gen;
    private Integer atg;
    private List<Par> intrones;
    private List<Par> exones;
    private Integer parada;
    private List<String> intrones_data;
    private List<String> exones_data;
    
    //Formato Intron [2,(5,8),(12,15),20]
    //Formato Intron Data [atg,(gtafasag),(gtaasdag),taa]
    //Formato Exon [(2,4),(9,11),(16,20)]
    //Formato Exon Data [atg,(gtafasag),(gtaasdag),taa]
    public Lectura() {
    }

    public Lectura(List<String> gen,Integer atg, List<Par> intrones, Integer parada) {
        this.atg = atg;
        this.intrones = intrones;
        this.parada = parada;
        this.gen = gen;
        this.intrones_data = new ArrayList<>();
        this.exones_data = new ArrayList<>();
        cargarData();
    }

    public Integer getAtg() {
        return atg;
    }

    public void setAtg(Integer atg) {
        this.atg = atg;
    }

    public List<Par> getIntrones() {
        return intrones;
    }

    public void setIntrones(List<Par> intrones) {
        this.intrones = intrones;
    }

    public Integer getParada() {
        return parada;
    }

    public void setParada(Integer parada) {
        this.parada = parada;
    }

    public List<String> getIntrones_data() {
        return intrones_data;
    }

    public void setIntrones_data(List<String> intrones_data) {
        this.intrones_data = intrones_data;
    }

    public List<String> getExones_data() {
        return exones_data;
    }

    public void setExones_data(List<String> exones_data) {
        this.exones_data = exones_data;
    }

    public List<String> getGen() {
        return gen;
    }

    public void setGen(List<String> gen) {
        this.gen = gen;
    }
    private void cargarData(){
        if(!gen.isEmpty() && !intrones.isEmpty()){
            for (Par intronesaux : intrones) {
               String aux = "(";
                for (int i = intronesaux.getVal1(); i <= intronesaux.getVal2(); i++) {
                    aux+=""+gen.get(i)+",";
                }
                aux = aux.substring(0, aux.length()-1);
                aux += ")";
                intrones_data.add(aux);
            }
        }
    }
    public String ImprimirLectura(){
        return gen.get(atg)+intrones_data+gen.get(parada);
    }
}
