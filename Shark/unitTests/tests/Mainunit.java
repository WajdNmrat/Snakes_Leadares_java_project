package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class Mainunit {

	

public Boolean checkLogin(String userName, String password) {
	if(userName.equals("admin")&&password.equals("123")) {
		return true;
	}else {
		return false;
	}
}

public int nextPosition(int a, int b,int c) {
	 
	if(a+b>=c) {
		return c;
	}
		else {
			return a+b;
		}
	}

public Boolean CheckPossibleDiceValue(int value) {
	
	switch(value) {
	
	case 0:
	return true;
	case 1:
	return true;
	case 2:
	return true;
	case 3:
	return true;
	case 4:
	return true;
	case 5:
	return true;
	case 6:
	return true;
	case 7:
	return true;
	case 8:
	return true;
	case 9:
	return true;
	case 10:
	return true;
	default:
		return false;
	
	
	
	}
	
	
}

public Boolean checkTrueAnswer(int trueAnswer) {
	switch(trueAnswer) {
	case 1:
		return false;
		
	case 2:
		return false;
	case 3: 
		return true;
	
	default:
			return false;
	}

}
}


