package morfiya.utils;

public class StringUtils {
	
	 public static String trimToNull(String str) {
	        final String ts = trim(str);
	        return isEmpty(ts) ? null : ts;
	    }
	 
	    public static String trim(final String str) {
	        return str == null ? null : str.trim();
	    }
	    
	    public static boolean isEmpty(final CharSequence cs) {
	        return cs == null || cs.length() == 0;
	    }
}
