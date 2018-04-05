package tef.kpi.ua.view;

/**
 * Created by SkarletRED on 01.03.2018.
 */

import java.util.ArrayList;

/**
 * View is the class appointed to show to
 * User results of program execution and
 * another data which user see.
 */
public class View implements RecordStringConstants {

    // Any symbols
    public static final String SPACE_SING = " ";
    public static final String DOT_SING = ".";
    public static final String SLASH_SING = "/";
    public static final String MINUS_SING = "-";
    public static final String UNDERLINE = "_";
    public static final String COMMA_SING = ",";
    public static final String VERTICAL_LINE = "|";
    public static final String OPENS_SQUARE_BRACKET = "[";
    public static final String CLOSING_SQUARE_BRACKET = "]";
    public static final String NEXT_LINE_SING = "\n";

    /**
     * This method is used to print message which it
     * accept as a parameter. This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     * @param msg
     */
    public void printMessage(String msg) {
        System.out.print(msg);
    }

    /**
     * This is analog ti printMessage method but
     * this method use line translation too
     * @param msg
     */
    public void printlnMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * This method is used to print message which it
     * accept as a parameter or parameters, but it
     * print the messages translated with resource
     * bundle
     * @param msgs
     */
    public void printLocaleMessage(String... msgs) {
        for (String msg :
                msgs) {
            System.out.print(bundle.getString(msg));
        }
    }

    /**
     * This is analog ti printMessage method but
     * this method use line translation too
     * @param msgs
     */
    public void printlnLocaleMessage(String... msgs) {
        for (String msg :
                msgs) {
            System.out.print(bundle.getString(msg));
        }
        System.out.println();
    }

    /**
     * This method is used to get message which it
     * accept as a parameter, but translated with
     * resource bundle
     * @param bundleMsg
     * @return
     */
    public static String getLocaleMassage(String bundleMsg){
        return bundle.getString(bundleMsg);
    }

    /**
     * This method complete concatenation strings
     * with using class StringBuffer
     * @param strings
     * @return
     */
    public static String concatenationStrings(String... strings) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String s :
                strings) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    public static String concatenationStringsWithBundle(ArrayList<String> messages) {
        StringBuilder result = new StringBuilder("");
        for (String item : messages) {
            result.append(bundle.getString(item));
        }
        return result.toString();
    }

    /**
     * This method return cutted string without
     * some characters from beginning of the line
     * @param string
     * @return
     */
    public static String getSubstringForOutput(String string) {
        return string.substring(localeCorrection);
    }
}
