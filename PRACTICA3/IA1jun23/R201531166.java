package IA1jun23;
import robocode.*;
//import java.awt.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * R201531166 - a robot by (your name here)
 */
public class R201531166 extends AdvancedRobot 
{
	/**
	 * run: R201531166's default behavior
	 */
	private boolean avanzar;

	public void run() {
		// Initialization of the robot should be put here
		
		setColors(Color.black,Color.black,Color.red,Color.black,Color.red); // body,gun,radar

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			/*avanzar = true;
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);*/
			avanzar = true;
            ahead(2000 - getX()); // Mueve hacia la pared de la derecha

            // Gira el robot 90 grados a la derecha para seguir la pared
            avanzar = false;
            turnRight(360);
            waitFor(new TurnCompleteCondition(this));

            // Realiza un movimiento aleatorio hacia el medio
            avanzar = true;
            int distancia = (int) (Math.random() * 400) + 100; // Distancia aleatoria entre 100 y 500 píxeles
            ahead((2000 - getY() - distancia) / 2); // Mueve hacia el centro

            // Gira el robot 90 grados a la izquierda para seguir la pared
            avanzar = false;
            turnLeft(90);
            waitFor(new TurnCompleteCondition(this));
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// robot al alcance o en la mira
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
		avanzar = true;
        int distancia = (int) (Math.random() * 100) + 50; // Distancia aleatoria entre 50 y 150 píxeles
        ahead(distancia);

        avanzar = false;
        int giroAleatorio = (int) (Math.random() * 180) - 90; // Giro aleatorio entre -90 y 90 grados
        turnRight(giroAleatorio);
        waitFor(new TurnCompleteCondition(this));
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		/*back(20);*/
		// Cambia de dirección cuando el robot choca contra una pared
        if (avanzar) {
            back(200);
        } else {
            ahead(200);
        }
	}	

	public void onHitRobot(HitRobotEvent e) {
        // Cambia de dirección cuando el robot choca contra otro robot
        if (avanzar) {
            back(200);
        } else {
            ahead(200);
        }
    }
}
