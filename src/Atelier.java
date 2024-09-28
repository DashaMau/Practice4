public class Atelier {
    public static void main(String[] args) {
        Atelier.Clothes[] clothes = {
                new Atelier.TShirt(Atelier.ClothesSize.M, 1000, "синяя"),
                new Atelier.Pants(Atelier.ClothesSize.L, 2000, "черные"),
                new Atelier.Skirt(Atelier.ClothesSize.S, 1500, "красная"),
                new Atelier.Tie(Atelier.ClothesSize.M, 500, "бордовая")
        };

        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        System.out.println("--------------------");
        atelier.dressMan(clothes);
    }

    public void dressWomen(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes item : clothes) {
            if (item instanceof WomenClothing) {
                ((WomenClothing) item).dressWomen();
            }
        }
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes item : clothes) {
            if (item instanceof MenClothing) {
                ((MenClothing) item).dressMan();
            }
        }
    }

    public enum ClothesSize {
        XXS(32) {
            @Override
            public String getDescription() {
                return "Детский размер";
            }
        },
        XS(34),
        S(36),
        M(38),
        L(40);

        private final int euroSize;

        ClothesSize(int euroSize) {
            this.euroSize = euroSize;
        }

        public int getEuroSize() {
            return euroSize;
        }

        public String getDescription() {
            return "Взрослый размер";
        }
    }

    public interface MenClothing {
        void dressMan();
    }

    public interface WomenClothing {
        void dressWomen();
    }

    public abstract static class Clothes {
        protected ClothesSize size;
        protected double price;
        protected String color;

        public Clothes(ClothesSize size, double price, String color) {
            this.size = size;
            this.price = price;
            this.color = color;
        }

        public ClothesSize getSize() {
            return size;
        }

        public double getPrice() {
            return price;
        }

        public String getColor() {
            return color;
        }
    }

    public static class TShirt extends Clothes implements MenClothing, WomenClothing {
        public TShirt(ClothesSize size, double price, String color) {
            super(size, price, color);
        }

        @Override
        public void dressMan() {
            System.out.println("Одеваем мужчину в футболку размера " + size + " (" + size.getDescription() + "), " + color + " цвета, цена " + price + " рублей.");
        }

        @Override
        public void dressWomen() {
            System.out.println("Одеваем женщину в футболку размера " + size + " (" + size.getDescription() + "), " + color + " цвета, цена " + price + " рублей.");
        }
    }

    public static class Pants extends Clothes implements MenClothing, WomenClothing {
        public Pants(ClothesSize size, double price, String color) {
            super(size, price, color);
        }

        @Override
        public void dressMan() {
            System.out.println("Одеваем мужчину в штаны размера " + size + " (" + size.getDescription() + "), " + color + " цвета, цена " + price + " рублей.");
        }

        @Override
        public void dressWomen() {
            System.out.println("Одеваем женщину в штаны размера " + size + " (" + size.getDescription() + "), " + color + " цвета, цена " + price + " рублей.");
        }
    }

    public static class Skirt extends Clothes implements WomenClothing {
        public Skirt(ClothesSize size, double price, String color) {
            super(size, price, color);
        }

        @Override
        public void dressWomen() {
            System.out.println("Одеваем женщину в юбку размера " + size + " (" + size.getDescription() + "), " + color + " цвета, цена " + price + " рублей.");
        }
    }

    public static class Tie extends Clothes implements MenClothing {
        public Tie(ClothesSize size, double price, String color) {
            super(size, price, color);
        }

        @Override
        public void dressMan() {
            System.out.println("Одеваем мужчину в галстук размера " + size + " (" + size.getDescription() + "), " + color + " цвета, цена " + price + " рублей.");
        }
    }


}