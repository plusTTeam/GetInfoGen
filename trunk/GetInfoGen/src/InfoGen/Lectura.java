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

    public Lectura(List<String> gen, Integer atg, List<Par> intrones, Integer parada) {
        this.atg = atg;
        this.intrones = intrones;
        this.parada = parada;
        this.gen = gen;
        this.intrones_data = new ArrayList<>();
        this.exones_data = new ArrayList<>();
        this.exones = new ArrayList<>();
        calcularExones();
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
    private void calcularExones(){
        if(intrones!=null){
            exones.add(new Par(atg, intrones.get(0).getVal1()-1));
            for (int i = 0; i < intrones.size()-1; i++) {
                exones.add(new Par(intrones.get(i).getVal2()+1, intrones.get(i+1).getVal1()-1));
            }
            exones.add(new Par(intrones.get(intrones.size()-1).getVal2()+1, parada));
        }else{
            exones.add(new Par(atg,parada));
        }
    }
    private void cargarData() {
        if (!gen.isEmpty() && !intrones.isEmpty() && !exones.isEmpty()) {            
            for (Par intronesaux : intrones) {   
                String aux="";
                for (int i = intronesaux.getVal1(); i <= intronesaux.getVal2(); i++) {
                    aux+=""+gen.get(i);
                }
                intrones_data.add(aux) ;                
            }
             for (Par exonesaux : exones) {   
                String aux="";
                for (int i = exonesaux.getVal1(); i <= exonesaux.getVal2(); i++) {
                    aux+=""+gen.get(i);
                }
                exones_data.add(aux) ;                
            }
        }
    }

    public String ImprimirLecturaIntron() {
        String cadena = "["+atg+",";
        for (Par intronaux : intrones) {
            cadena += "("+intronaux.getVal1()+","+intronaux.getVal2()+"),";
        }
        cadena += parada+"]";
        return cadena;
    }
     public String ImprimirLecturaIntronData() {
        String cadena = "["+gen.get(atg)+",";
        for (String intronaux : intrones_data) {
            cadena += "("+intronaux+"),";
        }
        cadena += gen.get(parada)+"]";
        return cadena;
    }
     public String ImprimirLecturaExon() {
        String cadena = "[";
        for (Par exonaux : exones) {
            cadena += "("+exonaux.getVal1()+","+exonaux.getVal2()+"),";
        }
        cadena = cadena.substring(0,cadena.length()-1);
        cadena+="]";
        return cadena;
    }
     public String ImprimirLecturaExonData() {
        String cadena = "[";
        for (String exonaux : exones_data) {
            cadena += "("+exonaux+"),";
        }
        cadena = cadena.substring(0,cadena.length()-1);
        cadena+="]";
        return cadena;
    }
}
