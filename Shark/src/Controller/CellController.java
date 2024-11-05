package Controller;

import java.util.ArrayList;

import Model.CellinBoard;

public class CellController {

	private static ArrayList<CellinBoard> cells = new ArrayList<CellinBoard>();
	
	public static void createCell(int i, int j) {
		cells.add(new CellinBoard(i,j));
	}
	
	public static void setCellPosition(int i, int j, int position) {
		for(CellinBoard cell:cells) {
			if (cell.GetI()==i && cell.GetJ()==j) {
				cell.setPosition(position);
			}
		}
	}
	
	public static void setCellType(int position, String type) {
		for(CellinBoard cell: cells) {
			if (cell.getPosition()==position) {
				cell.setType(type);
			}
		}
	}
	
	public static String getCellType(int position) {
		for(CellinBoard cell: cells) {
			if (cell.getPosition()==position) {
				return cell.getType();
			}
		}
		return null;
	}
	
	public static ArrayList<CellinBoard> getAllCells(){
		return cells;
	}
}
