import java.io.Serializable;

public class Food implements Serializable {
    private int Id;
    private String name;
    private FoodType type;
    private CousinType cousin;
    private String description;

    Food(int id,String name,FoodType type,CousinType cousin,String description){
        Id=id;
        this.name=name;
        this.type=type;
        this.cousin=cousin;
        this.description=description;
    }
    public Integer getID(){
        return Id;}
    public String getName(){
        return name;
    }
    public FoodType getType(){
        return type;
    }
    public String getDescription(){
        return description;
    }
    public CousinType getCousin(){
        return cousin;
    }
}