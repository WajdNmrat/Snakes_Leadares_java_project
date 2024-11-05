package Controller;


import java.util.Random;
public class SurpriseCellController {

	
	public static void setSurpriseCell(int position) {
		CellController.setCellType(position, "surprise");
	}
	
	
	public static int getSurpriseMove() {
		 Random random = new Random();
	        int rand = random.nextInt(1);
	        switch(rand) {
	        case 0:
	        	return 10;
	        default:
	        	return -10;
	        }	
	}
}
