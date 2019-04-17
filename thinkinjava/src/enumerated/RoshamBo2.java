package enumerated;

public enum RoshamBo2 implements Competitor<RoshamBo2>{
    PAPER(Outcome.DRAW,Outcome.LOSE,Outcome.WIN),
    SCISSORS(Outcome.WIN,Outcome.DRAW, Outcome.LOSE),
    ROCK(Outcome.LOSE,Outcome.WIN,Outcome.DRAW);
    private  Outcome vPAPER,vSCISSORS,vROCK;
    RoshamBo2(Outcome paper,Outcome scissors, Outcome rock){
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }
    public Outcome compete(RoshamBo2 it){
        switch (it){
            default:
            case PAPER: return vPAPER;
            case SCISSORS: return vSCISSORS;
            case ROCK: return vROCK;
        }
    }
    public static void main(String[] args){
        RoShamBo.play(RoshamBo2.class,20);

    }



}
