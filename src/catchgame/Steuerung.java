package catchgame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
public class Steuerung implements KeyListener{
	ZeichenFlaeche14 zf;
	Test_Class tc;
	private int spielerX = 400;
	private int spielerY = 300;
	private int ballX = 250;
	private int ballY = 300;
	private int zeilen = 80;
	private int spalten = 60;
	private int fensterhoehe = 600;
	private int fensterbreite = 800;
	private int hoehe = fensterhoehe/spalten;
	private int breite = fensterbreite/zeilen;
	Random ran = new Random();
	public void Starten() {
		
		zf = new ZeichenFlaeche14();
		zf.macheZeichenFlaecheSichtbar(fensterbreite, fensterhoehe);
		int [][] spielfeld = Background(zeilen, spalten);
		zeichneBackground(spielfeld);
		player();
		ball(ballX, ballY);
		zf.requestFocus();
		zf.addKeyListener(this);
		tc.setup();
		
	}
	public int[][] Background(int zeilen, int spalten) {
		
		int [][] spielfeld = new int [zeilen][spalten];
		for(int i = 0; i < spielfeld.length; i++) {
			for(int g = 0; g < spielfeld[i].length; g++) {
				spielfeld[i][g] = ran.nextInt(0, 4);
			}
		}
		return spielfeld;
	}
	public void zeichneBackground(int [][] background) {
		for(int i = 0; i < background.length; i++) {
			for(int  g = 0; g < background[i].length; g++) {
				if (background[i][g] == 0) {
					zf.setzeGefuelltesRechteck(100, i*hoehe, g*breite, hoehe, breite, Color.cyan);
				} else if (background[i][g] == 1) {
					zf.setzeGefuelltesRechteck(100, i*hoehe, g*breite, hoehe, breite, Color.green);
				} else if (background[i][g] == 2) {
					zf.setzeGefuelltesRechteck(100, i*hoehe, g*breite, hoehe, breite, Color.orange);
				} else if (background[i][g] == 3) {
					zf.setzeGefuelltesRechteck(100, i*hoehe, g*breite, hoehe, breite, Color.yellow);
				} else {
					zf.setzeGefuelltesRechteck(100, i*hoehe, g*breite, hoehe, breite, Color.magenta);
				}
			}
		}
		
	}
	public void player() {
		zf.setzeGefuelltesRechteck(101, spielerX, spielerY, 20, 20, Color.black);
	}
	public void ball(int ballX, int ballY) {
		zf.setzeGefuellteElipse(200, ballX, ballY, 20, 20, Color.blue);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		if (key == 'w') {
			if (spielerY > 0) {
				zf.verschieben(101, 0, -10);
				spielerY-=10;
				System.out.println(spielerY);
			}
			
		} else if (key == 'a') {
			if (spielerX > 0) {
				zf.verschieben(101, -10, 0);
				spielerX-=10;
				System.out.println(spielerX);
			}
			
		} else if (key == 's') {
			if (spielerY < fensterhoehe - 20) {
				zf.verschieben(101, 0, 10);
				spielerY+=10;
				System.out.println(spielerY);
			}
			
		} else if (key == 'd') {
			if (spielerX < fensterbreite - 20) {
				zf.verschieben(101, 10, 0);
				spielerX+=10;
				System.out.println(spielerX);
			}
			
		}
		if (spielerX == ballX && spielerY == ballY) {
			ballX = ran.nextInt(0, 78) * 10;
			ballY = ran.nextInt(0, 58) * 10;
			zf.loeschen(200);
			ball(ballX, ballY);
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}	
