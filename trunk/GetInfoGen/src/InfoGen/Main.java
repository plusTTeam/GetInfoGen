package InfoGen;

import prologConection.middleWare;

public class Main {
    private static Gen gig;
    public static void main(String [ ] args){
        gig = new Gen();
        middleWare middle = new middleWare();
        middle.init("C:/p_genes.pl");
        middle.consultEverything();        
        gig.setAg(middle.getAgPositions());
        gig.setAtg(middle.getAtgPositions());
        gig.setGen(middle.getGenData());
        gig.setGt(middle.getGtPositions());
        gig.setParadas(middle.getParadasPositions());
         /*
        gig.setGen(Arrays.asList("atg", "gt", "ag", "gt", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa", "ag", "gt", "ag", "taa"));
        gig.setAtg(Arrays.asList(0));
        gig.setGt(Arrays.asList(11,95));
        gig.setAg(Arrays.asList(80,150));
        gig.setParadas(Arrays.asList(200));
        */
        gig.consultGen();
    }
}