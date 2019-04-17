package enumerated;


public enum SecurityCategory {
    STOCK(Security.Stock.class),BOND(Security.Bond.class);
    Security[] values;
    SecurityCategory(Class<? extends Security> kind){
        values = kind.getEnumConstants();
    }
    interface Security{
        enum Stock implements Security{SHORT,LONG,MARGIN}
        enum Bond implements Security{MUNICIPAL,JUNK}
    }
   // public Security randomSelection(){
       // return Enums.Random(values);
   // }
}
