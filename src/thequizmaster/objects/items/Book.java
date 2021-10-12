package thequizmaster.objects.items;

import thequizmaster.entity.mob.Player;
import thequizmaster.gamestates.MainGame;
import thequizmaster.graphics.Sprite;
import thequizmaster.graphics.items.ItemsSprites;

public class Book extends Item {

    private String category;

    public static String[] categories = new String[]{
            "geography",
            "politics",
            "religion",
            "quotes",
            "history",
            "books",
            "sports",
            "film",
            "music",
            "language",
            "science"
    };


    public Book(String category, int x, int y, MainGame game) {
        super(category + " Book", getBookSprite(category), x, y, game);
        this.category = category;
    }

    public static String getRandomCategory(){
        int randomNum = random.nextInt(categories.length);
        return categories[randomNum];
    }

    public static Sprite getBookSprite(String category){
        switch(category) {
            case "geography":
                return ItemsSprites.bookSprites[0];
            case "politics":
                return ItemsSprites.bookSprites[1];
            case "religion":
                return ItemsSprites.bookSprites[2];
            case "quotes":
                return ItemsSprites.bookSprites[3];
            case "history":
                return ItemsSprites.bookSprites[4];
            case "books":
                return ItemsSprites.bookSprites[5];
            case "sports":
                return ItemsSprites.bookSprites[6];
            case "film":
                return ItemsSprites.bookSprites[7];
            case "music":
                return ItemsSprites.bookSprites[8];
            case "language":
                return ItemsSprites.bookSprites[9];
            case "science":
                return ItemsSprites.bookSprites[10];
            default:
                return ItemsSprites.bookSprites[2];
        }
    }

    public boolean use(Player player, MainGame game){
        player.increaseKnowledge(category);
        return true;
    }

}
