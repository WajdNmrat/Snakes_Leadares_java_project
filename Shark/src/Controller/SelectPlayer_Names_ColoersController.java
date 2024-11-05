package Controller;

import Model.Player;
import View.Names_Colores;
import View.Select_Player;

public class SelectPlayer_Names_ColoersController {
	public static int flag=0;
	public static    Player p1 = new Player(1,"123","123",Select_Player.test, 1);
    public static   Player p2 = new Player(2,"321","321",Select_Player.test, 1);
    public static  Player p3 = new Player(3,"","",Select_Player.test, 1);
    public static   Player p4 = new Player(4,"","",Select_Player.test, 1);
	public static void edit()
	{
		
			if(flag==2)
			{
			 
	    p1.setPlayerID(1);
	    p1.setName(Names_Colores.textField.getText());
	    p1.setPlayerColor(Names_Colores.player1.getBackground().toString());
	    p1.setObject(Names_Colores.player1);
	    p1.setCurrentPosition(1);
	    p2.setPlayerID(2);
	    p2.setName(Names_Colores.textField_1.getText());
	    p2.setPlayerColor(Names_Colores.player2.getBackground().toString());
	    p2.setObject(Names_Colores.player2);
	    p2.setCurrentPosition(1);
			}
			if(flag==3)
			{
	    p1.setPlayerID(1);
	    p1.setName(Names_Colores.textField.getText());
	    p1.setPlayerColor(Names_Colores.player1.getBackground().toString());
	    p1.setObject(Names_Colores.player1);
	    p1.setCurrentPosition(1);
	    
	    p2.setPlayerID(2);
	    p2.setName(Names_Colores.textField_1.getText());
	    p2.setPlayerColor(Names_Colores.player2.getBackground().toString());
	    p2.setObject(Names_Colores.player2);
	    p2.setCurrentPosition(1);
	    
	    p3.setPlayerID(3);
	    p3.setName(Names_Colores.textField_2.getText());
	    p3.setPlayerColor(Names_Colores.player3.getBackground().toString());
	    p3.setObject(Names_Colores.player3);
	    p3.setCurrentPosition(1);
			}
	    
			if(flag==4)
			{
	    p1.setPlayerID(1);
	    p1.setName(Names_Colores.textField.getText());
	    p1.setPlayerColor(Names_Colores.player1.getBackground().toString());
	    p1.setObject(Names_Colores.player1);
	    p1.setCurrentPosition(1);
	    
	    p2.setPlayerID(2);
	    p2.setName(Names_Colores.textField_1.getText());
	    p2.setPlayerColor(Names_Colores.player2.getBackground().toString());
	    p2.setObject(Names_Colores.player2);
	    p2.setCurrentPosition(1);
	    
	    p3.setPlayerID(3);
	    p3.setName(Names_Colores.textField_2.getText());
	    p3.setPlayerColor(Names_Colores.player3.getBackground().toString());
	    p3.setObject(Names_Colores.player3);
	    p3.setCurrentPosition(1);
	    
	    p4.setPlayerID(4);
	    p4.setName(Names_Colores.textField_3.getText());
	    p4.setPlayerColor(Names_Colores.player4.getBackground().toString());
	    p4.setObject(Names_Colores.player4);
	    p4.setCurrentPosition(1);
			}
	  
	}
	
}

