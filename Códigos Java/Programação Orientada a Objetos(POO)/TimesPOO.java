import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
import java.nio.charset.*;

public class TimesPOO{
   public static String convertUTF8toISO(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return ret;
    }

	public static String convertISOtoUTF8(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("UTF-8"), "ISO-8859-1");
        }
        catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return ret;
    }

    public static void main(String[] args){
        
    }
}
