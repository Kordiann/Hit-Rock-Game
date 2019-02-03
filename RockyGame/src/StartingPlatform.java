import java.awt.*;

public class StartingPlatform extends Polygon{

    public static int[] polyXArray = {50, 50, -50, -50};
    public static int[] polyYArray = {-50, 50, 50, -50};

    int width = 200;
    int height = 200;

    int centerX = GameBoard.boardWidth / 2, centerY = GameBoard.boardHeight / 2;

    public StartingPlatform(){
        super(polyXArray, polyYArray, 4);
    }

    public Rectangle getBounds() { return new Rectangle(centerX, centerY, width, height); }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public int getCenterX() { return centerX; }
    public int getCenterT() { return centerY; }
}

