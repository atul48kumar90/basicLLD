package ShreyanshJain.DecorayprDesignPattern.dpatternpractice;

public class Margerita implements Pizza{
    
    @Override
    public String getDescription(){
        return "mergerita pizza";
    }

    @Override
    public double getCost(){
        return 200.0;
    }
}
