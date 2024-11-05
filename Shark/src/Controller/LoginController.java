package Controller;

public class LoginController {

	public static Boolean checkAdminDetails(String userName, String password) {
		if(userName.equals("admin")&&password.equals("123")) {
			return true;
		}else {
			return false;
		}
	}
	
}
