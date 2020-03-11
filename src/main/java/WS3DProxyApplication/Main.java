/*
 * This is a basic WS3D Proxy Application Template
 */
package WS3DProxyApplication;

import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;
import ws3dproxy.model.WorldPoint;

/**
 * @author Cedric Matheus (@cedric-matheus) (https://github.com/cedric-matheus)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creature movement speed
        double C_SPEED = 4;
        // creature movement x point
        double X_POINT = 250;
        // creature movement y point
        double Y_POINT = 250;

        // creating new ws3d proxy
        WS3DProxy proxy = new WS3DProxy();

        // try this block
        try {
            // getting world (ws3d) instance
            World w = World.getInstance();

            // reseting world
            w.reset();

            // creating foods
            World.createFood(0, 350, 75);
            World.createFood(0, 100, 220);
            World.createFood(0, 250, 210);

            // creating creature
            Creature c = proxy.createCreature(100, 450, 0);

            // starting motor system of creature
            c.start();

            // getting creature world point position
            WorldPoint position = c.getPosition();

            // getting creature pitch (angle of vision)
            double pitch = c.getPitch();
            // getting creature fuel
            double fuel = c.getFuel();

            // moving creature
            c.moveto(C_SPEED, X_POINT, Y_POINT);

            // catch command exec exceptions
        } catch (CommandExecException e) {
            // print message
            System.out.println("Erro capturado");
        }
    }

}
