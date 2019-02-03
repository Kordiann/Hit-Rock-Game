import java.awt.*;

public class PhotonTorpedo extends Polygon {

    private static final long serialVersionUID = 1L;

    int gBWidth = GameBoard.boardWidth;
    int gBHeight = GameBoard.boardHeight;

    private double centerX = 0, centerY = 0;

    public static int[] polyXArray = {-2, 2, 2, -2, -2};
    public static int[] polyYArray = {-2, -2, 2, 2, -2};

    private int torpedoWidth = 6, torpedoHeight = 6;

    public boolean onScreen = false;

    private double movingAngle = 0;

    private double xVelocity = 5, yVelocity = 5;

    public PhotonTorpedo(double centerX, double centerY, double movingAngle) {

        super(polyXArray, polyYArray, 5);

        this.centerX = centerX;
        this.centerY = centerY;
        this.movingAngle = movingAngle;

        this.onScreen = true;

        this.setXVelocity(this.torpedoXMoveAngle(movingAngle) * 10);
        this.setYVelocity(this.torpedoYMoveAngle(movingAngle) * 10);
    }

    public double getXCenter() { return centerX; }
    public double getYCenter() { return centerY; }

    public int getTorpedoWidth() { return torpedoWidth; }
    public int getTorpedoHeight() { return torpedoHeight; }

    public void setXCenter(double XCent) { this.centerX = XCent; }
    public void setYCenter(double YCent) { this.centerY = YCent; }

    public void changeXPos(double incAmt) { this.centerX += incAmt; }
    public void changeYPos(double incAmt) { this.centerY += incAmt; }

    public double getXVelocity() { return  xVelocity; }
    public double getYVelocity() { return  yVelocity; }

    public void setXVelocity(double xVel) { this.xVelocity = xVel; }
    public void setYVelocity(double yVel) { this.yVelocity = yVel; }

    public void setMovingAngle(double moveAngle) { this.movingAngle = moveAngle; }

    public double getMovingAngle() { return movingAngle; }

    public Rectangle getBounds() {
        return new Rectangle(getTorpedoWidth() - 6, getTorpedoHeight() - 6, getTorpedoWidth(), getTorpedoHeight());
    }

    public double torpedoXMoveAngle(double xMoveAgnle) {
        return (double) (Math.cos(xMoveAgnle * Math.PI / 180));
    }

    public double torpedoYMoveAngle(double yMoveAgnle) {
        return (double) (Math.sin(yMoveAgnle * Math.PI / 180));
    }

    public void move(){
        if(this.onScreen){

            this.changeXPos(this.getXVelocity());


            if(this.getXCenter() < 0){

                this.onScreen = false;
            } else
            if (this.getXCenter() > gBWidth){

                this.onScreen = false;
            }

            this.changeYPos(this.getYVelocity());

            if(this.getYCenter() < 0){
                this.onScreen = false;
            } else
            if (this.getYCenter() > gBHeight){
                this.onScreen = false;
            }
        }
    }
}
