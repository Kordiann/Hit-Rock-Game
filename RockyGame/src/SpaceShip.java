import java.awt.*;

public class SpaceShip extends Polygon {

    private double xVelocity = 0, yVelocity = 0;

    int gBWidth = GameBoard.boardWidth;
    int gBHeight = GameBoard.boardHeight;

    private double centerX = gBWidth /2, centerY = gBHeight/2;

    public static int[] polyXArray = {-13, 14, -13, -5, -13};
    public static int[] polyYArray = {-15, 0, 15, 0, -15};

    private  int shipWidth = 27, shipHeight = 30;

    private double uLeftXPos = getXCenter() + this.polyXArray[0], uLeftYPos = getYCenter() + this.polyYArray[0];

    private double rotationAngle = 0, movingAngle = 0;

    public SpaceShip() {

        super(polyXArray, polyYArray, 5);
    }

    public double getXCenter() { return centerX; }
    public double getYCenter() { return centerY; }

    public void setXCenter(double XCent) { this.centerX = XCent; }
    public void setYCenter(double YCent) { this.centerY = YCent; }

    public void increaseXPos(double incAmt) { this.centerX += incAmt; }
    public void increaseYPos(double incAmt) { this.centerY += incAmt; }

    public double getuLeftXPos() { return uLeftXPos; }
    public double getuLeftYPos() { return uLeftYPos; }

    public void setuLeftXPos(double xULPos) { this.uLeftXPos = xULPos; }
    public void setuLeftYPos(double yULPos) { this.uLeftYPos = yULPos; }

    public int getShipWidth() { return shipWidth; }
    public int getShipHeight() { return shipHeight; }

    public double getXVelocity() { return  xVelocity; }
    public double getYVelocity() { return  yVelocity; }

    public void setXVelocity(double xVel) { this.xVelocity = xVel; }
    public void setYVelocity(double yVel) { this.yVelocity = yVel; }

    public void increaseXVelocity(double xVelInc) { this.xVelocity += xVelInc; }
    public void increaseYVelocity(double yVelInc) { this.yVelocity += yVelInc; }
    public void decreaseXVelocity(double xVelInc) {
        if(this.xVelocity > 0.5){
            this.xVelocity -= xVelInc;
//            if(this.yVelocity == 0){
//                this.xVelocity = 0;
//            }
        }else if(this.xVelocity < 0.5 && this.xVelocity > 0){
            this.xVelocity = 0;
        }else if(this.xVelocity < -0.5){
            this.xVelocity -= xVelInc;
//            if(this.yVelocity == 0){
//                this.xVelocity = 0;
//            }
        }else if(this.xVelocity > -0.5 && this.xVelocity < 0){
            this.xVelocity = 0;
        }
    }
    public void decreaseYVelocity(double yVelInc) {
        if(this.yVelocity > 0.5) {
            this.yVelocity -= yVelInc;
//            if(this.xVelocity == 0){
//                this.yVelocity = 0;
//            }
        }else if(this.yVelocity < 0.5 && this.yVelocity > 0){
            this.yVelocity = 0;
        }else if(this.yVelocity < -0.5){
            this.yVelocity -= yVelInc;
//            if(this.xVelocity == 0){
//                this.yVelocity = 0;
//            }
        }else if(this.yVelocity > -0.5 && this.yVelocity < 0){
            this.yVelocity = 0;

        }
    }

    public void setMovingAngle(double moveAngle) { this.movingAngle = moveAngle; }

    public double getMovingAngle() { return movingAngle; }

    public void increaseMovingAngle(double moveAngle) { this.movingAngle += moveAngle; }

    public double shipXMoveAngle(double xMoveAgnle) {
        return (double) (Math.cos(xMoveAgnle * Math.PI / 180));
    }

    public double shipYMoveAngle(double yMoveAgnle) {
        return (double) (Math.sin(yMoveAgnle * Math.PI / 180));
    }

    public double getRotationAngle() { return rotationAngle; }

    public void increaseRotationAngle() {
        if(getRotationAngle() >= 355) { rotationAngle = 0; }

        else { rotationAngle += 5; }
    }

    public void decreaseRotationAngle() {
        if(getRotationAngle() < 0) { rotationAngle = 355; }

        else { rotationAngle -= 5; }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)getXCenter() - 14, (int)getYCenter() - 14, getShipWidth(), getShipHeight());
    }

    public double getShipNoseX() {
        return this.getXCenter() + Math.cos(rotationAngle) * 14;
    }
    public double getShipNoseY() {
        return this.getYCenter() + Math.sin(rotationAngle) * 14;
    }

    public void move() {

        this.increaseXPos(this.getXVelocity());

        if(this.getXCenter() < 0) {
            this.setXCenter(gBWidth);
        } else {
            if(this.getXCenter() > gBWidth) {
                this.setXCenter(0);
            }
        }

        this.increaseYPos(this.getYVelocity());

        if(this.getYCenter() < 0) {
            this.setYCenter(gBHeight);
        } else {
            if(this.getYCenter() > gBHeight) {
                this.setYCenter(0);
            }
        }
    }
}
