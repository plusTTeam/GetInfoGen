/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InfoGen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private static int maxIntron = 100000;
    private static int minIntron = 60;
    private static int maxExon = 6000;
    private static int minExon = 10;

    public Gen() {
        /*Llenando manualmente los vectores mientras esta listo el JPL
         gen = atg = 
         gt = Arrays.asList(12, 32, 60);
         ag = Arrays.asList(54, 65, 76, 100);
         paradas = Arrays.asList(89, 95, 102, 123);
         * */
        lecturas = new ArrayList<>();
        cadenasIntrones = new ArrayList<>();
        intrones = new ArrayList<>();

    }

    public void consultGen() {
        if (this.testGen()) {
            for (Lectura lec : lecturas) {
                System.out.println("Lectura Intron: " + lec.ImprimirLecturaIntron());
                System.out.println("Lectura Data Intron: " + lec.ImprimirLecturaIntronData());
                System.out.println("Lectura Exon: " + lec.ImprimirLecturaExon());
                System.out.println("Lectura Data Exon: " + lec.ImprimirLecturaExonData());
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

        if (((this.atg == null && this.atg.isEmpty()) || (this.paradas == null && this.paradas.isEmpty())) && ((this.ag == null && this.ag.isEmpty()) || (this.gt == null && this.gt.isEmpty()))) {
            return false;
        }
         //Si no exites atg pero se tiene gt y ag entonces se toma la primera posicion del gen sin importar que data tenga
        if (!gt.isEmpty() && !ag.isEmpty() && atg.isEmpty()) {
            atg.add(0);
        }
        //Si no exites paradas pero se tiene gt y ag entonces se toma la ultima posicion del gen sin importar que data tenga
        if (!gt.isEmpty() && !ag.isEmpty() && paradas.isEmpty()) {
            paradas.add(gen.size() - 1);
        }
        //Caso en el que se tienen solo Exones
        if ((ag.isEmpty() || gt.isEmpty()) && !atg.isEmpty() && !paradas.isEmpty()) {
            if( (gen.size()-1) >= minExon && (gen.size()-1) <= maxExon){
                lecturas.add(new Lectura(gen, 0, null, gen.size()-1));
            }
        }
        //Caso optimo una vez verificadas los casos se realiza el procedimiento normalmente
        if (!ag.isEmpty() && !gt.isEmpty() && !atg.isEmpty() && !paradas.isEmpty()) {
            Integer gtValido;
            for (Integer gtaux : gt) {
                gtValido = gtaux;
                Integer agValido;
                for (Integer agaux : ag) {
                    int dif = agaux - gtaux;
                    if (agaux > gtaux && dif >= minIntron && dif <= maxIntron) {
                        agValido = agaux;
                        this.intrones.add(new Par(gtValido, agValido));
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
                        int firstIntron2 = aux.getVal1();
                        int lastIntron1 = cadenaIntronesAux.get(cadenaIntronesAux.size() - 1).getVal2();
                        int dif = firstIntron2 - lastIntron1;
                        if (firstIntron2 > lastIntron1 && dif >= minExon && dif <= maxExon) {
                            cadenaIntronesAux.add(aux);
                        }
                        intronesaux.remove(aux);
                    }
                    if (cadenaIntronesAux.size() > 1) {
                        cadenasIntrones.add(cadenaIntronesAux);
                    }

                }
                for (Par p : intrones) {
                    cadenasIntrones.add(Arrays.asList(p));
                }
                for (Integer atgaux : atg) {
                    for (Integer paradasAux : paradas) {
                        for (List<Par> cadintro : cadenasIntrones) {
                            int firstValueIntron1 = cadintro.get(0).getVal1();
                            int lastaValueIntronN = cadintro.get(cadintro.size() - 1).getVal2();
                            int difBegin = firstValueIntron1 - atgaux;
                            int difEnd = paradasAux - lastaValueIntronN;
                            if ((atgaux < firstValueIntron1 && difBegin >= minExon && difBegin <= maxExon) && (paradasAux > lastaValueIntronN && difEnd >= minExon && difEnd <= maxExon)) {
                                lecturas.add(new Lectura(gen, atgaux, cadintro, paradasAux));
                            }
                        }
                    }
                }
            }
            if (!lecturas.isEmpty()) {
                return true;
            }
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
