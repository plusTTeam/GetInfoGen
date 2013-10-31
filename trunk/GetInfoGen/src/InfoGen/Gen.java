/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InfoGen;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sun.awt.geom.AreaOp;

/**
 *
 * @author Jesus
 */
public class Gen {

    private List<String> gen;
    private List<Integer> atg; //Inicio
    private List<Integer> gt;
    private List<Integer> ag;
    private List<Integer> paradas; //Pueden ser: taa, tgg o tga
    private List<List<Par>> cadenasIntrones;
    private List<Par> intrones;
    private List<Lectura> lecturas;

    public Gen() {
        //Llenando manualmente los vectores mientras esta listo el JPL
        gen = Arrays.asList("atg","gt","ag","gt","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","gt","ag","taa");
        atg = Arrays.asList(30);
        gt = Arrays.asList(12, 32, 60);
        ag = Arrays.asList(54, 65, 76, 100);
        paradas = Arrays.asList(89, 95, 102, 123);

        lecturas = new ArrayList<>();
        cadenasIntrones = new ArrayList<>();
        intrones = new ArrayList<>();
        if (this.testGen()) {
            for (Lectura lec : lecturas) {
                System.out.println("Lectura: "+lec.ImprimirLectura());
            }
            
        } else {
            System.out.println("Gen NO Reconocido");
        }
    }

    public List<String> getGen() {
        return gen;
    }

    public void setGen(List<String> gen) {
        this.gen = gen;
    }

    public List<Integer> getAtg() {
        return atg;
    }

    public void setAtg(List<Integer> atg) {
        this.atg = atg;
    }

    public List<Integer> getGt() {
        return gt;
    }

    public void setGt(List<Integer> gt) {
        this.gt = gt;
    }

    public List<Integer> getAg() {
        return ag;
    }

    public void setAg(List<Integer> ag) {
        this.ag = ag;
    }

    public List<Integer> getParadas() {
        return paradas;
    }

    public void setParadas(List<Integer> paradas) {
        this.paradas = paradas;
    }

    public List<Par> getIntrones() {
        return intrones;
    }

    public void setIntrones(List<Par> intrones) {
        this.intrones = intrones;
    }

    private boolean testGen() {        
        if ((this.atg==null && this.atg.isEmpty()) || (this.ag==null && this.ag.isEmpty()) || (this.gt==null && this.gt.isEmpty()) || (this.paradas==null && this.paradas.isEmpty())) {
            return false;
        }
        for (Integer begin : atg) {
            Integer gtValido;
            for (Integer gtaux : gt) {
                if (gtaux > begin) {
                    gtValido = gtaux;
                    Integer agValido;
                    for (Integer agaux : ag) {
                        if (agaux > gtaux) {
                            agValido = agaux;
                            this.intrones.add(new Par(gtValido, agValido));
                        }
                    }
                }
            }
        }
        if (!intrones.isEmpty()) {
            for (Par test : intrones) {
                List<Par> intronesaux = new ArrayList<>(intrones);
                List<Par> cadenaIntronesAux = new ArrayList<>();
                cadenaIntronesAux.add(test);
                while (!intronesaux.isEmpty()) {
                    Par aux = intronesaux.get(0);
                    if (aux.getVal1() > cadenaIntronesAux.get(cadenaIntronesAux.size() - 1).getVal2()) {
                        cadenaIntronesAux.add(aux);
                    }
                    intronesaux.remove(aux);
                }
                cadenasIntrones.add(cadenaIntronesAux);
            }
            for (Integer atgaux : atg) {
                for (Integer paradasAux : paradas) {
                    for (List<Par> cadintro : cadenasIntrones) {
                        if (atgaux < cadintro.get(0).getVal1() && paradasAux > cadintro.get(cadintro.size() - 1).getVal2()) {
                            lecturas.add(new Lectura(gen, atgaux, cadintro, paradasAux));
                        }
                    }
                }
            }
        }
        if (!lecturas.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(List<Lectura> lecturas) {
        this.lecturas = lecturas;
    }    
}
