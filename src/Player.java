import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
public class Player extends GameObject {

    Sprite sprite;

    Point2D pointFacing;

    int moveSpeed = 5;
    int sprintModifier = 5;
    Point2D.Double playerDirection;

    Player(double x, double y, double width, double height) {
        super(x, y, width, height, 200);

        this.sprite = new Sprite(Sprite.SpriteType.PLAYER);

        this.pointFacing = new Point2D.Double(1, 1);
    }

    void setDirection(Point2D.Double direction) {
        this.playerDirection = direction;
    }

    double getPlayerAngle() {
        Point2D.Double playerLoc = new Point2D.Double(getX(), getY());
        Point2D.Double toTheRight = new Point2D.Double(getX() + 1, 0);
        return VectorUtils.getThetaBetweenVectors(toTheRight, playerDirection, playerLoc);
    }

    void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    int getMoveSpeed() {
        return this.moveSpeed;
    }

    @Override
    boolean canMove(double x, double y, ArrayList<GameObject> others) {
        for(GameObject other : others) {
            // translate intersect to the top left.
            if (!(other instanceof Enemy) && other != this && other.isColliding() && isColliding() && this.intersects(getX() + x - getWidth()/2, getY() + y - getHeight()/2, other)) {
                return false;
            }
        }
        return true;
    }

    @Override
    Image getImage() {
        sprite.rotate(getPlayerAngle());
        return sprite.getImage();
    }
}
