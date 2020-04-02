package models;

import models.enums.*;

import java.util.LinkedList;
import java.util.List;

public class Pizza {
    private final Size size;
    private final Base base;
    private final Style style;
    private final SaucePlacement saucePlacement;
    private final List<Ingredient> ingredients;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.base = builder.base;
        this.ingredients = builder.ingredients;
        this.style = builder.style;
        this.saucePlacement = builder.saucePlacement;
    }

    public static class Builder {
        private final Size size;
        private final Base base;
        private Style style = Style.REGULAR;
        private SaucePlacement saucePlacement = null;
        private List<Ingredient> ingredients = new LinkedList<>();

        public Builder(Size size, Base base) {
            this.size = size;
            this.base = base;
        }

        public Builder makeCalzone(SaucePlacement saucePlacement) {
            this.style = Style.CALZONE;
            this.saucePlacement = saucePlacement;
            return this;
        }

        public Builder addIngredient(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Pizza build() throws NoIngredientsException {
            if (ingredients.size() == 0) {
                throw new NoIngredientsException();
            }
            return new Pizza(this);
        }

        static class NoIngredientsException extends RuntimeException {
        }
    }

    @Override
    public String toString() {
        return "Size: " + size + ", style: " + style +
                (style == Style.CALZONE ? ", sauce placement: " +  saucePlacement : "") +
                ", base: " + base +
                ", ingredients: " + ingredients;
    }
}
