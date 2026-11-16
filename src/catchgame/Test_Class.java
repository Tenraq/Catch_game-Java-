package catchgame;
import java.awt.*;

import javax.swing.*;
public class Test_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void setup() {
		ZeichenFlaeche14 zf = new ZeichenFlaeche14();
		JFrame window = zf.window();
		JLabel text = new JLabel("Hello");
		window.add(text);
	}
}
