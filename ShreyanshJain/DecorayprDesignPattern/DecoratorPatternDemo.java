package ShreyanshJain.DecorayprDesignPattern;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Plain Margherita
        Pizza basicPizza = new Margerita();
        System.out.println(basicPizza.getDescription() + " -> ₹" + basicPizza.getCost());

        // Add extra cheese
        Pizza cheesePizza = new ExtraCheese(basicPizza);
        System.out.println(cheesePizza.getDescription() + " -> ₹" + cheesePizza.getCost());

        // Add mushrooms on top of cheese
        Pizza fullyLoaded = new Mushroom(cheesePizza);
        System.out.println(fullyLoaded.getDescription() + " -> ₹" + fullyLoaded.getCost());

        // Another example: Farmhouse with Jalapeno
        Pizza spicyFarmhouse = new Jalapeno(new Farmhouse());
        System.out.println(spicyFarmhouse.getDescription() + " -> ₹" + spicyFarmhouse.getCost());
    }
}

