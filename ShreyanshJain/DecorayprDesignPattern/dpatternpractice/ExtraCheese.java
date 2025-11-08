package ShreyanshJain.DecorayprDesignPattern.dpatternpractice;

public class ExtraCheese extends ToppingDecorator{
    public ExtraCheese(Pizza pizza){
        super(pizza);
    }

    @Override
    public String getDescription(){
        return pizza.getDescription() + ", extra cheese";
    }

    @Override
    public double getCost(){
        return pizza.getCost() + 20;
    }
}
