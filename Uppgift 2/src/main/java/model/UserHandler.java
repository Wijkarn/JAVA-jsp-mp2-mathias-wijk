package model;

public class UserHandler {
	private static String[] user1 ={"Wijk", "Yeet"};
	private static String[] user2 ={"David", "Deez"};
	
	public static Boolean logIn(String userName, String password) {
		
		if(userName.equals(user1[0]) && password.equals(user1[1])) {
			return true;
		}
		else if(userName.equals(user2[0]) && password.equals(user2[1])) {
			return true;
		}
		else {
			return false;
		}
	}
}
