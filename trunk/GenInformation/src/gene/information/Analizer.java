package gene.information;

import gene.feature.Exon;
import gene.feature.Gene;
import gene.feature.Information;
import gene.feature.Intron;
import gene.feature.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.MiddleWare;

/**
 * Clase enfocada en el analisis de un objeto GeneConstructor para la formacion
 * de lecturas(genes) validos, que son asociadas a una lista llamada "lectures"
 */
public class Analizer {
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">

    private GeneConstructor constructor;
    //---------------------------------------
    private List<Gene> lectures;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Analizer() {
        this.lectures = new ArrayList<>();
    }

    //---------------------------------------
    //  </editor-fold>    
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public List<Gene> getLectures() {
        return lectures;
    }

    //---------------------------------------
    public GeneConstructor getConstructor() {
        return constructor;
    }

    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    /**
     * Metodo usado para instanciar el GeneConstructor a traves del constructor
     * que recibe por parametros el MiddleWare
     */
    public void readFromMiddleWare(MiddleWare middleWare) throws Exception {
        this.constructor = new GeneConstructor(middleWare);
    }

    //---------------------------------------
    /**
     * Metodo usado para instanciar el GeneConstructor a partir de las listas
     * que se estan recibiendo, donde la data es una simple lista de String y
     * las demas son listas de Integer
     */
    public void readFromLists(List<Integer> atg, List<Integer> gt, List<Integer> ag, List<Integer> stops, List<String> data) throws Exception {
        this.constructor = new GeneConstructor();
        this.constructor.initLists(atg, gt, ag, stops, data);
        this.constructor.isCompatibleGene();
    }

    //---------------------------------------
    /**
     * Metodo usado para la construccion de lecturas, al llamar este metodo, se
     * analizaran las listas del GeneConstructor y se llenara la lista de
     * genes(lectures) con todas las lecturas validas, este metodo recibe un
     * boolean que indica si las combinaciones se haran usando un metodo
     * recursivo (true) o iterativo (false)
     */
    public void constructLectures(boolean recursively) throws Exception {
        if (constructor.isCompatibleGene()) {
            int last = constructor.lastData();

            if ((constructor.getGt().isEmpty() || constructor.getAg().isEmpty())) {
                //Caso especial cuando el gen completo es un solo exon
                if (last >= Model.minExon && last <= Model.maxExon) {
                    Information start = constructor.getData(0);
                    Information end = constructor.getData(last);

                    Gene gene = new Gene(start, end);
                    gene.addExon(new Exon(start, end, constructor.getInnerInfo(1, last - 1)));

                    this.lectures.add(gene);
                } else {
                    throw new Exception("El gen que se intenta analizar es incompatible");
                }
            } else {
                //en este punto, las 4 listas estan llenas y debo hacer las iteraciones
                Gene posibilities = getPosibilities();

                if (!posibilities.getIntrons().isEmpty()) {
                    ArrayDeque<ArrayDeque<Intron>> mixedIntrons = new ArrayDeque<>();

                    if (recursively) {
                        this.recursivelyMix(null, 0, 0, posibilities, 0, mixedIntrons);
                    } else {
                        mixedIntrons = this.iterativeMix(posibilities);
                    }

                    this.generateLectures(mixedIntrons);
                } else {
                    throw new Exception("El gen que se intenta analizar es incompatible");
                }
            }
        } else {
            throw new Exception("El gen que se intenta analizar es incompatible");
        }
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    /**
     * Metodo que genera todos los intrones posibles encontrados en las listas
     * del GeneConstructor y las agrega a la lista de intrones de un Gene que
     * "no sera valido" y solo sera usado para conocer TODOS los intrones
     * POSIBLES
     */
    private Gene getPosibilities() throws Exception {
        Information start = constructor.getData(constructor.getAtg().get(0));
        Information end = constructor.getData(constructor.getStops().get(constructor.getStops().size() - 1));

        Gene posibilities = new Gene(start, end);

        for (Integer iniIntron : constructor.getGt()) {
            for (Integer finIntron : constructor.getAg()) {
                finIntron = finIntron + 1;
                if (iniIntron.intValue() < finIntron.intValue()) {
                    int d = finIntron - iniIntron;
                    if (d > Model.minIntron && d < Model.maxIntron) {
                        start = constructor.getData(iniIntron);
                        end = constructor.getData(finIntron);
                        posibilities.addIntron(new Intron(start, end, constructor.getInnerInfo(iniIntron + 1, finIntron)));
                    }
                }
            }
        }

        return posibilities;
    }

    //---------------------------------------
    /**
     * Metodo ITERATIVO que mezcla los intrones posibles en una "cola" de "lista
     * de intrones" donde cada lista sera una combinacion POSIBLE para una
     * lectura, pues se valida que pueda existir un exon entre ellos y demas
     * propiedades
     */
    private ArrayDeque<ArrayDeque<Intron>> iterativeMix(Gene posibilities) {
        ArrayDeque<ArrayDeque<Intron>> mixedIntrons = new ArrayDeque<>();

        ArrayDeque<Intron> introns = new ArrayDeque<>(posibilities.getIntrons());

        while (!introns.isEmpty()) {
            ArrayDeque<Intron> possibleMix = new ArrayDeque<>();
            possibleMix.add(introns.pollFirst());

            ArrayDeque<Intron> iteratorQueue = introns.clone();

            while (!iteratorQueue.isEmpty()) {
                Intron pos = iteratorQueue.pollFirst();
                if (pos.getStart().position > possibleMix.peekLast().getStart().position
                        && pos.getEnd().position > possibleMix.peekLast().getEnd().position) {
                    int d = pos.getStart().position - possibleMix.peekLast().getEnd().position;
                    if (d >= Model.minExon && d <= Model.maxExon) {
                        possibleMix.add(pos);
                    }
                }
            }

            if (possibleMix.size() > 1) {
                mixedIntrons.add(possibleMix);
            }
        }

        if (mixedIntrons.isEmpty()) {
            for (Intron intron : introns) {
                mixedIntrons.add(new ArrayDeque<>(Arrays.asList(intron)));
            }
        }

        return mixedIntrons;
    }

    //---------------------------------------
    /**
     * Metodo RECURSIVO que mezcla los intrones posibles en una "cola" de "lista
     * de intrones" donde cada lista sera una combinacion POSIBLE para una
     * lectura, pues se valida que pueda existir un exon entre ellos y demas
     * propiedades
     * <br/><br/>
     * <h1>"AUN NO FUNCIONAL"</h1>
     * <br/><br/>
     * Nota: Este metodo se desarrollo pues, la mezcla iterativa tiene casos que
     * no puede abarcar precisamente por ser iterativa, por lo que este metodo
     * es mas eficaz y debe ser usado en lugar del iterativo
     */
    private Intron recursivelyMix(Intron last, int pos, int level, Gene posibilities, int size, ArrayDeque<ArrayDeque<Intron>> paths) {
        if (last == null) {
            level = 0;
            paths.push(new ArrayDeque<Intron>());
            paths.peek().push(recursivelyMix(posibilities.getIntron(pos), pos, level, posibilities, posibilities.getIntrons().size(), paths));
        } else {
            while (++pos < size) {
                int d = posibilities.getIntron(pos).getStart().position - last.getEnd().position;

                if (d >= Model.minExon && d <= Model.maxExon) {
                    paths.peek().push(recursivelyMix(posibilities.getIntron(pos), pos, level + 1, posibilities, size, paths));
                }
            }
        }

        return last;
    }

    //---------------------------------------
    /**
     * Metodo que mezcla todas las combinaciones con los inicios y paradas
     * validas para que sea un gen y los agrega a la lista de genes(lectures) el
     * parametro "mixedIntrons" deberia ser la salida de alguno de los metodos
     * de combinacion (recursivelyMix, iterativeMix) para mayor efectividad
     */
    private void generateLectures(ArrayDeque<ArrayDeque<Intron>> mixedIntrons) {
        while (!mixedIntrons.isEmpty()) {
            ArrayDeque<Intron> introns = mixedIntrons.poll();
            for (Integer start : constructor.getAtg()) {
                int d = introns.peekFirst().getStart().position - start;
                if (d >= Model.minExon && d <= Model.maxExon) {
                    for (Integer end : constructor.getStops()) {
                        d = end - introns.peekLast().getEnd().position;
                        if (d >= Model.minExon && d <= Model.maxExon) {
                            Gene lecture = new Gene(constructor.getData(start), constructor.getData(end));
                            lecture.setIntrons(new ArrayList<>(introns));
                            lecture.inferExons(constructor.getGeneData());
                            this.lectures.add(lecture);
                        }
                    }
                }
            }
        }
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public String toString() {
        String out = constructor.toString();

        int i = 0;
        for (Gene gene : lectures) {
            out += "\n----------------------------Lectura #" + (++i) + "----------------------------------\n";
            out += "Intrones PARES = " + gene.getPositionsInfo(true) + "\n";
            out += "Intrones DATA = " + gene.getStringInfo(true) + "\n";
            out += "----------------------------------------------------\n";
            out += "Exones PARES = " + gene.getPositionsInfo(false) + "\n";
            out += "Exones DATA = " + gene.getStringInfo(false) + "\n";
        }

        return out;
    }
    //---------------------------------------
    //  </editor-fold>
}
