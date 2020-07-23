package designPatterns.creational.builder.myVersion;

/**
 * @author Ross Khapilov
 * @version 1.0 20.07.2020
 */
public class Chair {
    private final int height;
    private final int weight;
    private final String style;

    public static class Builder {
        private int height;
        private int weight;
        private String style = "Default";

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder setStyle(String style) {
            this.style = style;
            return this;
        }

        public Chair build() {
            return new Chair(this);
        }
    }

    public Chair(Builder builder) {
        this.height = builder.height;
        this.weight = builder.weight;
        this.style = builder.style;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "height=" + height +
                ", weight=" + weight +
                ", style='" + style + '\'' +
                '}';
    }
}
