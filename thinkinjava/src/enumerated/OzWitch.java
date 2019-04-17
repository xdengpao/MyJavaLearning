package enumerated;

public enum OzWitch {
    //Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West "),
    NORTH("Glinda,the good which of the north "),
    EAST("Wiched with of "),
    SOUTH("Good by inference,but missing ");

    private String description;

    //Constructor must be package or private access;
     OzWitch(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public static void main(String[] args){
        for(OzWitch witch : OzWitch.values()){
            System.out.print(witch + ": " + witch.getDescription()+"\n");
        }
    }
}
