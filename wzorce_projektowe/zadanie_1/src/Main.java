import models.Pizza;
import models.enums.Base;
import models.enums.Ingredient;
import models.enums.SaucePlacement;
import models.enums.Size;

public class Main {
    public static void main(String[] args) {

        try {
            Pizza regularPizza = new Pizza.Builder(Size.SMALL, Base.TOMATO)
                    .addIngredient(Ingredient.CHEESE)
                    .addIngredient(Ingredient.HAM)
                    .build();
            System.out.println(regularPizza);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Pizza calzonePizza = new Pizza.Builder(Size.MEDIUM, Base.CREAM)
                    .addIngredient(Ingredient.CHEESE)
                    .addIngredient(Ingredient.HAM)
                    .addIngredient(Ingredient.ONION)
                    .makeCalzone(SaucePlacement.OUTSIDE)
                    .build();
            System.out.println(calzonePizza);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Pizza noIngredientsPizza = new Pizza.Builder(Size.LARGE, Base.CREAM)
                    .build();
            System.out.println(noIngredientsPizza);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
