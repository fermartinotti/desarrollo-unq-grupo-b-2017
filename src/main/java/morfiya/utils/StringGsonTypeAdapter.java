package morfiya.utils;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public final class StringGsonTypeAdapter implements JsonDeserializer<String> {

   public static StringGsonTypeAdapter INSTANCE = new StringGsonTypeAdapter();

    ///////////////////////////////////////////////////////////////////////////////////////////
    
    public static final String SPACE = " ";

    public static final String EMPTY = "";
    
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
    
    public static String normalizeSpace(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        final int size = str.length();
        final char[] newChars = new char[size];
        int count = 0;
        int whitespacesCount = 0;
        boolean startWhitespaces = true;
        for (int i = 0; i < size; i++) {
            final char actualChar = str.charAt(i);
            final boolean isWhitespace = Character.isWhitespace(actualChar);
            if (!isWhitespace) {
                startWhitespaces = false;
                newChars[count++] = (actualChar == 160 ? 32 : actualChar);
                whitespacesCount = 0;
            } else {
                if (whitespacesCount == 0 && !startWhitespaces) {
                    newChars[count++] = SPACE.charAt(0);
                }
                whitespacesCount++;
            }
        }
        if (startWhitespaces) {
            return EMPTY;
        }
        return new String(newChars, 0, count - (whitespacesCount > 0 ? 1 : 0)).trim();
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////
    
    public static StringGsonTypeAdapter instance() {
        return INSTANCE;
    }

    public String deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
       return normalizeSpace(trimToNull(jsonElement.getAsString()));
    	  
    }
}