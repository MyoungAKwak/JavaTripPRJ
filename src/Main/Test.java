package Main;

import DAO.UserDao.UserDao_;

public class Test {
	
	public static void main(String[] args) {

         String patternString = "^\\d{4}.(0[1-9]|1[012]).(0[1-9]|[12][0-9]|3[01])$";
        final String string = "2023.02.20";
        boolean mat = string.matches(patternString);
        System.out.println(mat);
        //final Pattern pattern = Pattern.compile(pattern);
        //final Matcher matcher = pattern.matcher(string);
        
        //System.out.println(matcher);
        
        UserDao_ dao = new UserDao_();
        
        dao.insertUser();
        
        
        
	}
	
	
}
