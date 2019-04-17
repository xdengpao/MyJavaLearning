package enumerated;

import java.util.EnumMap;

/**
 * 项目名称：thinkinjava
 * 类 名 称：使用EnumMap分发
 * 类 描 述：TODO
 * 创建时间：2019/4/17 8:45 PM
 * 创 建 人：dengpao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSORS,ROCK;
    static EnumMap<RoShamBo5,EnumMap<RoShamBo5,Outcome>> table =
            new EnumMap<>(RoShamBo5.class);
    static {
        for(RoShamBo5 it : RoShamBo5.values()){
            table.put(it,new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        }
        initRow(PAPER,Outcome.DRAW,Outcome.LOSE,Outcome.WIN);
        initRow(SCISSORS,Outcome.WIN,Outcome.DRAW,Outcome.LOSE);
        initRow(ROCK,Outcome.LOSE,Outcome.WIN,Outcome.DRAW);
    }
    static void initRow(RoShamBo5 it, Outcome vPAPER,Outcome vSCISSORS,Outcome vROCK){
        EnumMap<RoShamBo5 ,Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER,vPAPER);
        row.put(RoShamBo5.SCISSORS,vSCISSORS);
        row.put(RoShamBo5.ROCK,vROCK);
    }
    public Outcome compete(RoShamBo5 it){
        return table.get(this).get(it);
    }
    public static void main(String[] args){
        RoShamBo.play(RoShamBo5.class,20);
    }

}
