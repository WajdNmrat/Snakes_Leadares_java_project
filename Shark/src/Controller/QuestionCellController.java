package Controller;

import java.util.ArrayList;

import Model.QuestionCell;

public class QuestionCellController {

	private static ArrayList<QuestionCell> cells;
	
	public static void createQuestionCells() {
		cells = new ArrayList<QuestionCell>();
	}
	
	public static void addQuestionCell(int id, int position) {
		cells.add(new QuestionCell(id, position));
	}
	
	public static boolean isQuestionCell(int position) {
		for(QuestionCell cell: cells) {
			if(cell.getPosition()==position) {
				return true;
			}
		}
		return false;
	}
}
