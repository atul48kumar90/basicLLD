package ShreyanshJain.DecorayprDesignPattern.dpatternpractice;

public class Farmhouse implements Pizza{
    
    @Override
    public String getDescription(){
        return "farmhouse pizza";
    }

    @Override
    public double getCost(){
        return 300.0;
    }
}
