package com.practice1;
import java.io.*;
import java.lang.Math;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Inherited means can access
//subclasses can only inherit(access) the protected and public members of superclass
//all public member functions of a class can access its own private/public/protected variables/functions
//static variables/methods can be invoked using className.methodName/className.variableName
//                           Modifiers/////////check https://www.geeksforgeeks.org/access-modifiers-java/ for more info
//Access Levels       default  private  protected   public
//1) Same Class          Y        Y         Y         Y
//
//2) Same package        Y        N         Y         Y
// subclass
//
//3) Same package        Y        N         Y         Y
//non-subclass
//
//4) Different package   N        N         Y         Y
//subclass
//
//5) Different package   N        N         N         N
//non-subclass


public class practice1 {
    //********only one public class per source file************
    public static void main(String[] args) throws IOException {

        System.out.println();


        ///**********parsing string to int/double*************
        int myInt = Integer.parseInt("1234");
        System.out.println(myInt);//prints "1234" as int 1234
        double myDouble = Double.parseDouble("1.276");
        System.out.println(myDouble); //prints "1.276" as double 1.276

        ///**********Converting int -> double and double -> int*****************

        double double1 = 1.23;
        int int1 = 34;
        double intToDouble = (double)int1;
        int doubleToInt = (int)double1;
        System.out.println(intToDouble);//prints 34.0
        System.out.println(doubleToInt);//prints 1
        System.out.println();

        //*************Objects and classes*****************

        Employee e1 = new Employee("Minh Durbin");
        Employee e2 = new Employee("Sarah Parker");


        e1.setAge(24);
        e1.setDesignation("Software developer");
        e1.setSalary(100000.00);
        e1.printEmployee();
        System.out.println();
        e2.setAge(34);
        e2.setDesignation("CEO");
        e2.setSalary(500000.00);
        e2.printEmployee();
        System.out.println();
        //testing if static variable is shared among objects
        System.out.println("e1 static variable NUMOBJ is "+ e1.getNUMOBJ());
        System.out.println("e2 static variable NUMOBJ is "+ e2.getNUMOBJ());
        boolean result = e1.getNUMOBJ() == e2.getNUMOBJ();
        System.out.println(result + " this shows static variable NUMOBJ is shared among objects");
        //new Engineer objects
        Engineer e3 = new Engineer();
        e3.setAge(25);
        e3.setDesignation("mechanical engineer");
        e3.setSalary(75000.00);

        Engineer e4 = new Engineer("Carl Sean");
        e4.setAge(30);
        e4.setDesignation("civil engineer");
        e4.setSalary(65000.00);
        //new Doctor objects
        Doctor e5 = new Doctor("Dr.Dao");
        e5.setAge(45);
        e5.setDesignation("brain surgeon");
        e5.setSalary(500000.00);

        Doctor e6 = new Doctor("Dr.house");
        e6.setAge(60);
        e6.setDesignation("family physician");
        e6.setSalary(200000.00);

        //returns the number of objects created for all classes;
        //each class has a static variable to keep count of number of objects created for that class
        //a constructor for each class increments the counter by 1 every time an object for that class is created
        //all objects of their respective class will share the copy of the static variable for that class
        System.out.println("Number of employees are: "+ (Employee.NUMOBJ + Engineer.numObj + Doctor.numObj - 2) );//minus 2 due to subclass constructor invoking superclass constructor
        System.out.println();

        //////////************Super class reference in subtypes
        //super class array holds all sub class objects and objects of super class
        //e1,e2 are Employee objs; e3,e4 are Engineer objs; e5,e6 are Doctor objs
        //Subtype Polymorphism -  e3-e6 are subtypes of Employee so they can be considered of supertype Employee and their own subtype
        ////Employee e = new Engineer(); ///all engineers are considered to be an employee
        ////Engineer eng = new Employee();///ERROR!; not all employees are engineers

        Employee[] arrObj = {e1, e2, e3, e4, e5, e6};
        for(Employee e : arrObj)
        {
            e.printEmployee();
            System.out.println();
        }


        //objects of subclass with super class reference type can only access variables/methods of superclass, not
        //subclass
        Employee e0 = new Engineer();

        /// Employee e0 = new Engineer();
        //e0 cannot access greet() in Engineer class because its of type is Employee.

        //can do type cast
        Engineer e7 = (Engineer)e0;
        e7.greet();//prints greet() in Engineer class
        System.out.println();


        ///*********Loops***************

        ////******Wrapper classes (Number)*************

        //These are all subclasses of Number abstract class
        //Byte, Double, Float, Integer, Short, Long
        //Use className.methodName or Math.methodName to access

        //1 xxxValue()
        //Converts the value of this Number object to the xxx data type and returns it.
        //
        //2	compareTo()
        //Compares this Number object to the argument.
        //
        //3	equals()
        //Determines whether this number object is equal to the argument.
        //
        //4	valueOf()
        //Returns an Integer object holding the value of the specified primitive.
        //
        //5	toString()
        //Returns a String object representing the value of a specified int or Integer.
        //
        //6	parseInt()
        //This method is used to get the primitive data type of a certain String.
        //
        //7	abs()
        //Returns the absolute value of the argument.
        //
        //8	ceil()
        //Returns the smallest integer that is greater than or equal to the argument. Returned as a double.
        //
        //9	floor()
        //Returns the largest integer that is less than or equal to the argument. Returned as a double.
        //
        //10	rint()
        //Returns the integer that is closest in value to the argument. Returned as a double.
        //
        //11	round()
        //Returns the closest long or int, as indicated by the method's return type to the argument.
        //
        //12	min()
        //Returns the smaller of the two arguments.
        //
        //13	max()
        //Returns the larger of the two arguments.
        //
        //14	exp()
        //Returns the base of the natural logarithms, e, to the power of the argument.
        //
        //15	log()
        //Returns the natural logarithm of the argument.
        //
        //16	pow()
        //Returns the value of the first argument raised to the power of the second argument.
        //
        //17	sqrt()
        //Returns the square root of the argument.
        //
        //18	sin()
        //Returns the sine of the specified double value.
        //
        //19	cos()
        //Returns the cosine of the specified double value.
        //
        //20	tan()
        //Returns the tangent of the specified double value.
        //
        //21	asin()
        //Returns the arcsine of the specified double value.
        //
        //22	acos()
        //Returns the arccosine of the specified double value.
        //
        //23	atan()
        //Returns the arctangent of the specified double value.
        //
        //24	atan2()
        //Converts rectangular coordinates (x, y) to polar coordinate (r, theta) and returns theta.
        //
        //25	toDegrees()
        //Converts the argument to degrees.
        //
        //26	toRadians()
        //Converts the argument to radians.
        //
        //27	random()
        //Returns a random number.

        Double d1 = 3.14;
        System.out.println(d1.equals(3.14));//prints true
        System.out.println(Integer.max(35,45)); //prints max value between two arguments
        System.out.println();


        Integer i1 = 49;
        double iDoub = i1.doubleValue(); //part of xxxValue(); converts Integer obj to double
        System.out.println(Math.sqrt(iDoub));

        ///*********Wrapper class (Character)**************
        Character c0 = 'f';
        //
        //1	isLetter()
        //Determines whether the specified char value is a letter.
        //
        //2	isDigit()
        //Determines whether the specified char value is a digit.
        //
        //3	isWhitespace()
        //Determines whether the specified char value is white space.
        //
        //4	isUpperCase()
        //Determines whether the specified char value is uppercase.
        //
        //5	isLowerCase()
        //Determines whether the specified char value is lowercase.
        //
        //6	toUpperCase()
        //Returns the uppercase form of the specified char value.
        //
        //7	toLowerCase()
        //Returns the lowercase form of the specified char value.
        //
        //8	toString()
        //Returns a String object representing the specified character value that is, a one-character string.

        char c1 = Character.toUpperCase(c0);
        System.out.println(c1);
        boolean checkDigit = Character.isDigit(c1);
        System.out.println(checkDigit);//returns false because c0 is not digit

        ///********Wrapper class (String)**********
        //returnType methodName
        //can use " ".methodName or obj.methodName
        //
        //1	char charAt(int index)
        //Returns the character at the specified index.
        //
        //2	int compareTo(Object o)
        //Compares this String to another Object.
        //
        //3	int compareTo(String anotherString)
        //Compares two strings lexicographically.
        //
        //4	int compareToIgnoreCase(String str)
        //Compares two strings lexicographically, ignoring case differences.
        //
        //5	String concat(String str)
        //Concatenates the specified string to the end of this string.
        //
        //6	boolean contentEquals(StringBuffer sb)
        //Returns true if and only if this String represents the same sequence of characters as the specified StringBuffer.
        //
        //7	static String copyValueOf(char[] data)
        //Returns a String that represents the character sequence in the array specified.
        //
        //8	static String copyValueOf(char[] data, int offset, int count)
        //Returns a String that represents the character sequence in the array specified.
        //
        //9	boolean endsWith(String suffix)
        //Tests if this string ends with the specified suffix.
        //
        //10	boolean equals(Object anObject)
        //Compares this string to the specified object.
        //
        //11	boolean equalsIgnoreCase(String anotherString)
        //Compares this String to another String, ignoring case considerations.
        //
        //12	byte getBytes()
        //Encodes this String into a sequence of bytes using the platform's default charset, storing the result into a new byte array.
        //
        //13	byte[] getBytes(String charsetName)
        //Encodes this String into a sequence of bytes using the named charset, storing the result into a new byte array.
        //
        //14	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
        //Copies characters from this string into the destination character array.
        //
        //15	int hashCode()
        //Returns a hash code for this string.
        //
        //16	int indexOf(int ch)
        //Returns the index within this string of the first occurrence of the specified character.
        //
        //17	int indexOf(int ch, int fromIndex)
        //Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
        //
        //18	int indexOf(String str)
        //Returns the index within this string of the first occurrence of the specified substring.
        //
        //19	int indexOf(String str, int fromIndex)
        //Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
        //
        //20	String intern()
        //Returns a canonical representation for the string object.
        //
        //21	int lastIndexOf(int ch)
        //Returns the index within this string of the last occurrence of the specified character.
        //
        //22	int lastIndexOf(int ch, int fromIndex)
        //Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index.
        //
        //23	int lastIndexOf(String str)
        //Returns the index within this string of the rightmost occurrence of the specified substring.
        //
        //24	int lastIndexOf(String str, int fromIndex)
        //Returns the index within this string of the last occurrence of the specified substring, searching backward starting at the specified index.
        //
        //25	int length()
        //Returns the length of this string.
        //
        //26	boolean matches(String regex)
        //Tells whether or not this string matches the given regular expression.
        //
        //27	boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
        //Tests if two string regions are equal.
        //
        //28	boolean regionMatches(int toffset, String other, int ooffset, int len)
        //Tests if two string regions are equal.
        //
        //29	String replace(char oldChar, char newChar)
        //Returns a new string resulting from replacing all occurrences of oldChar in this string with newChar.
        //
        //30	String replaceAll(String regex, String replacement
        //Replaces each substring of this string that matches the given regular expression with the given replacement.
        //
        //31	String replaceFirst(String regex, String replacement)
        //Replaces the first substring of this string that matches the given regular expression with the given replacement.
        //
        //32	String[] split(String regex)
        //Splits this string around matches of the given regular expression.
        //
        //33	String[] split(String regex, int limit)
        //Splits this string around matches of the given regular expression.
        //
        //34	boolean startsWith(String prefix)
        //Tests if this string starts with the specified prefix.
        //
        //35	boolean startsWith(String prefix, int toffset)
        //Tests if this string starts with the specified prefix beginning a specified index.
        //
        //36	CharSequence subSequence(int beginIndex, int endIndex)
        //Returns a new character sequence that is a subsequence of this sequence.
        //
        //37	String substring(int beginIndex)
        //Returns a new string that is a substring of this string.
        //
        //38	String substring(int beginIndex, int endIndex)
        //Returns a new string that is a substring of this string.
        //
        //39	char[] toCharArray()
        //Converts this string to a new character array.
        //
        //40	String toLowerCase()
        //Converts all of the characters in this String to lower case using the rules of the default locale.
        //
        //41	String toLowerCase(Locale locale)
        //Converts all of the characters in this String to lower case using the rules of the given Locale.
        //
        //42	String toString()
        //This object (which is already a string!) is itself returned.
        //
        //43	String toUpperCase()
        //Converts all of the characters in this String to upper case using the rules of the default locale.
        //
        //44	String toUpperCase(Locale locale)
        //Converts all of the characters in this String to upper case using the rules of the given Locale.
        //
        //45	String trim()
        //Returns a copy of the string, with leading and trailing whitespace omitted.
        //
        //46	static String valueOf(primitive data type x)
        //Returns the string representation of the passed data type argument.
        String s0 = "Merry Christmas";
        char cahr = s0.charAt(7);
        System.out.println(cahr);//returns 'h'
        System.out.println(s0.substring(4,10));//returns a substring starting from index  4 to 10(non inclusive)


        //*****************Arrays*************88888
        //public static returnType methodName()
        //Invoke using Arrays.methodName
        //1
        //public static int binarySearch(Object[] a, Object key)
        //
        //Searches the specified array of Object ( Byte, Int , double, etc.) for the specified value using the binary search algorithm. The array must be sorted prior to making this call. This returns index of the search key, if it is contained in the list; otherwise, it returns ( – (insertion point + 1)).
        //
        //2
        //public static boolean equals(long[] a, long[] a2)
        //
        //Returns true if the two specified arrays of longs are equal to one another. Two arrays are considered equal if both arrays contain the same number of elements, and all corresponding pairs of elements in the two arrays are equal. This returns true if the two arrays are equal. Same method could be used by all other primitive data types (Byte, short, Int, etc.)
        //
        //3
        //public static void fill(int[] a, int val)
        //
        //Assigns the specified int value to each element of the specified array of ints. The same method could be used by all other primitive data types (Byte, short, Int, etc.)
        //
        //4
        //public static void sort(Object[] a)
        //
        //Sorts the specified array of objects into an ascending order, according to the natural ordering of its elements. The same method could be used by all other primitive data types ( Byte, short, Int, etc.)
        int[] iArray = {11,2,3,46,53};
        Arrays.sort(iArray);
        for(int i: iArray)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("46 is found at index "+ Arrays.binarySearch(iArray,46) );

        //************Array as parameter and returning an array (reverse list function)*************
        //public static int[] reverse(int[] list)
        //{
        //   int[] result = new int[list.length];
        //
        //   for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
        //      result[j] = list[i];
        //   }
        //   return result;
        // }

        //************Date/Time***************
        /////////has two constructors for Date class
        //1
        //Date( )
        //
        //This constructor initializes the object with the current date and time.
        //
        //2
        //Date(long millisec)
        //
        //This constructor accepts an argument that equals the number of milliseconds that have elapsed since midnight, January 1, 1970.
        //
        /////////Class methods
        //1
        //boolean after(Date date)
        //
        //Returns true if the invoking Date object contains a date that is later than the one specified by date, otherwise, it returns false.
        //
        //2
        //boolean before(Date date)
        //
        //Returns true if the invoking Date object contains a date that is earlier than the one specified by date, otherwise, it returns false.
        //
        //3
        //Object clone( )
        //
        //Duplicates the invoking Date object.
        //
        //4
        //int compareTo(Date date)
        //
        //Compares the value of the invoking object with that of date. Returns 0 if the values are equal. Returns a negative value if the invoking object is earlier than date. Returns a positive value if the invoking object is later than date.
        //
        //5
        //int compareTo(Object obj)
        //
        //Operates identically to compareTo(Date) if obj is of class Date. Otherwise, it throws a ClassCastException.
        //
        //6
        //boolean equals(Object date)
        //
        //Returns true if the invoking Date object contains the same time and date as the one specified by date, otherwise, it returns false.
        //
        //7
        //long getTime( )
        //
        //Returns the number of milliseconds that have elapsed since January 1, 1970.
        //
        //8
        //int hashCode( )
        //
        //Returns a hash code for the invoking object.
        //
        //9
        //void setTime(long time)
        //
        //Sets the time and date as specified by time, which represents an elapsed time in milliseconds from midnight, January 1, 1970.
        //
        //10
        //String toString( )
        //
        //Converts the invoking Date object into a string and returns the result.

        //Print current time and date
        Date date0 = new Date();
        System.out.println(date0.toString());
        System.out.println(new Date(99, 2, 12).before(new Date (99, 2, 18)));//prints true because 2/12/99 is before 2/18/99

        ///////SimpleDateFormat
        SimpleDateFormat ft = new SimpleDateFormat("E hh:mm:ss aa MM/dd/yyyy");
        System.out.println("Current date/time: "+ ft.format(date0));//returns a date object that matches the format "ft" of another date object
        ////////////**************SimpleDateFormat Codes
        //Character	Description	Example
        //G	Era designator	AD
        //y	Year in four digits	2001
        //M	Month in year	July or 07
        //d	Day in month	10
        //h	Hour in A.M./P.M. (1~12)	12
        //H	Hour in day (0~23)	22
        //m	Minute in hour	30
        //s	Second in minute	55
        //S	Millisecond	234
        //E	Day in week	Tuesday
        //D	Day in year	360
        //F	Day of week in month	2 (second Wed. in July)
        //w	Week in year	40
        //W	Week in month	1
        //a	A.M./P.M. marker	PM
        //k	Hour in day (1~24)	24
        //K	Hour in A.M./P.M. (0~11)	10
        //z	Time zone	Eastern Standard Time
        //'	Escape for text	Delimiter
        //"	Single quote	`

        //************Date Formatting Using printf
        //********must start with %t

        System.out.printf("Due Date: %2$tB %2$td, %2$tY aka %2$tD \n","", date0);//used for a single date object to format all parts.
        System.out.printf("Current date/time: %tD %tr \n", date0, date0); //can be used for multiple date objects or single

        ///////////****************Date/Time conversion Characters
        //Character	Description	Example
        //c	Complete date and time	Mon May 04 09:51:52 CDT 2009
        //F	ISO 8601 date	2004-02-09
        //D	U.S. formatted date (month/day/year)	02/09/2004
        //T	24-hour time	18:05:19
        //r	12-hour time	06:05:19 pm
        //R	24-hour time, no seconds	18:05
        //Y	Four-digit year (with leading zeroes)	2004
        //y	Last two digits of the year (with leading zeroes)	04
        //C	First two digits of the year (with leading zeroes)	20
        //B	Full month name	February
        //b	Abbreviated month name	Feb
        //m	Two-digit month (with leading zeroes)	02
        //d	Two-digit day (with leading zeroes)	03
        //e	Two-digit day (without leading zeroes)	9
        //A	Full weekday name	Monday
        //a	Abbreviated weekday name	Mon
        //j	Three-digit day of year (with leading zeroes)	069
        //H	Two-digit hour (with leading zeroes), between 00 and 23	18
        //k	Two-digit hour (without leading zeroes), between 0 and 23	18
        //I	Two-digit hour (with leading zeroes), between 01 and 12	06
        //l	Two-digit hour (without leading zeroes), between 1 and 12	6
        //M	Two-digit minutes (with leading zeroes)	05
        //S	Two-digit seconds (with leading zeroes)	19
        //L	Three-digit milliseconds (with leading zeroes)	047
        //N	Nine-digit nanoseconds (with leading zeroes)	047000000
        //P	Uppercase morning or afternoon marker	PM
        //p	Lowercase morning or afternoon marker	pm
        //z	RFC 822 numeric offset from GMT	-0800
        //Z	Time zone	PST
        //s	Seconds since 1970-01-01 00:00:00 GMT	1078884319
        //Q	Milliseconds since 1970-01-01 00:00:00 GMT	1078884319047

        ////****************Parsing strings into Dates with SimpleDateFormat
        SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd");
        String input = "1811-07-04";
        System.out.print(input + " parses as ");

        try
        {
            Date t = ft1.parse(input);//returns a date object matching a string of the format "ft1"
            System.out.println(t);

        } catch(Exception e)
        {
            System.out.println("error try again");
        }

        ///////*************Sleep (threads) and Measuring Elapsed Time
        try
        {
            long start = System.currentTimeMillis();
            System.out.println(new Date() + "\n");
            Thread.sleep(3000);//milliseconds
            System.out.println(new Date() + "\n");
            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("Time elapsed is "+ diff + " ms");

        }catch(Exception e)
        {
            System.out.println(e);
        }

        ////////**************GregorianCalendar class
        //***************Constructor and description
        //
        //1
        //GregorianCalendar()
        //
        //Constructs a default GregorianCalendar using the current time in the default time zone with the default locale.
        //
        //2
        //GregorianCalendar(int year, int month, int date)
        //
        //Constructs a GregorianCalendar with the given date set in the default time zone with the default locale.
        //
        //3
        //GregorianCalendar(int year, int month, int date, int hour, int minute)
        //
        //Constructs a GregorianCalendar with the given date and time set for the default time zone with the default locale.
        //
        //4
        //GregorianCalendar(int year, int month, int date, int hour, int minute, int second)
        //
        //Constructs a GregorianCalendar with the given date and time set for the default time zone with the default locale.
        //
        //5
        //GregorianCalendar(Locale aLocale)
        //
        //Constructs a GregorianCalendar based on the current time in the default time zone with the given locale.
        //
        //6
        //GregorianCalendar(TimeZone zone)
        //
        //Constructs a GregorianCalendar based on the current time in the given time zone with the default locale.
        //
        //7
        //GregorianCalendar(TimeZone zone, Locale aLocale)
        //
        //Constructs a GregorianCalendar based on the current time in the given time zone with the given locale.

        ///******************Methods in GregorianCalendar class
        //
        //1
        //void add(int field, int amount)
        //
        //Adds the specified (signed) amount of time to the given time field, based on the calendar's rules.
        //
        //2
        //protected void computeFields()
        //
        //Converts UTC as milliseconds to time field values.
        //
        //3
        //protected void computeTime()
        //
        //Overrides Calendar Converts time field values to UTC as milliseconds.
        //
        //4
        //boolean equals(Object obj)
        //
        //Compares this GregorianCalendar to an object reference.
        //
        //5
        //int get(int field)
        //
        //Gets the value for a given time field.
        //
        //6
        //int getActualMaximum(int field)
        //
        //Returns the maximum value that this field could have, given the current date.
        //
        //7
        //int getActualMinimum(int field)
        //
        //Returns the minimum value that this field could have, given the current date.
        //
        //8
        //int getGreatestMinimum(int field)
        //
        //Returns highest minimum value for the given field if varies.
        //
        //9
        //Date getGregorianChange()
        //
        //Gets the Gregorian Calendar change date.
        //
        //10
        //int getLeastMaximum(int field)
        //
        //Returns lowest maximum value for the given field if varies.
        //
        //11
        //int getMaximum(int field)
        //
        //Returns maximum value for the given field.
        //
        //12
        //Date getTime()
        //
        //Gets this Calendar's current time.
        //
        //13
        //long getTimeInMillis()
        //
        //Gets this Calendar's current time as a long.
        //
        //14
        //TimeZone getTimeZone()
        //
        //Gets the time zone.
        //
        //15
        //int getMinimum(int field)
        //
        //Returns minimum value for the given field.
        //
        //16
        //int hashCode()
        //
        //Overrides hashCode.
        //
        //17
        //boolean isLeapYear(int year)
        //
        //Determines if the given year is a leap year.
        //
        //18
        //void roll(int field, boolean up)
        //
        //Adds or subtracts (up/down) a single unit of time on the given time field without changing larger fields.
        //
        //19
        //void set(int field, int value)
        //
        //Sets the time field with the given value.
        //
        //20
        //void set(int year, int month, int date)
        //
        //Sets the values for the fields year, month, and date.
        //
        //21
        //void set(int year, int month, int date, int hour, int minute)
        //
        //Sets the values for the fields year, month, date, hour, and minute.
        //
        //22
        //void set(int year, int month, int date, int hour, int minute, int second)
        //
        //Sets the values for the fields year, month, date, hour, minute, and second.
        //
        //23
        //void setGregorianChange(Date date)
        //
        //Sets the GregorianCalendar change date.
        //
        //24
        //void setTime(Date date)
        //
        //Sets this Calendar's current time with the given Date.
        //
        //25
        //void setTimeInMillis(long millis)
        //
        //Sets this Calendar's current time from the given long value.
        //
        //26
        //void setTimeZone(TimeZone value)
        //
        //Sets the time zone with the given time zone value.
        //
        //27
        //String toString()
        //
        //Returns a string representation of this calendar.

        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec"};

        // Create a Gregorian calendar initialized
        // with the current date and time in the
        // default locale and timezone.
        GregorianCalendar gcal = new GregorianCalendar();
        int year = gcal.get(Calendar.YEAR);
        System.out.print("Date: ");
        System.out.print(months[gcal.get(Calendar.MONTH)]);//returns index of current month
        System.out.print(" "+ gcal.get(Calendar.DATE));
        System.out.println(" "+ year);

        System.out.println("Time: "+ gcal.get(Calendar.HOUR)+ ":"+
                gcal.get(Calendar.MINUTE)+":"+ gcal.get(Calendar.SECOND) + " " +
                gcal.get(Calendar.AM_PM));//AM_PM returns 1 for PM

        //test if current year is a leap year

        if(gcal.isLeapYear(year))
        {
            System.out.printf("%d is a leap year\n", year);
        }else
        {
            System.out.printf("%d is NOT a leap year\n", year);
        }
        GregorianCalendar m = new GregorianCalendar();

        //*****************************Regular Expressions********************************
        ///////Regular Expression Syntax
        //
        //Subexpression	Matches
        //^	Matches the beginning of the line.
        //$	Matches the end of the line.
        //.	Matches any single character except newline. Using m option allows it to match the newline as well.
        //[...]	Matches any single character in brackets.
        //[^...]	Matches any single character not in brackets.
        //\A	Beginning of the entire string.
        //\z	End of the entire string.
        //\Z	End of the entire string except allowable final line terminator.
        //re*	Matches 0 or more occurrences of the preceding expression.
        //re+	Matches 1 or more of the previous thing.
        //re?	Matches 0 or 1 occurrence of the preceding expression.
        //re{ n}	Matches exactly n number of occurrences of the preceding expression.
        //re{ n,}	Matches n or more occurrences of the preceding expression.
        //re{ n, m}	Matches at least n and at most m occurrences of the preceding expression.
        //a| b	Matches either a or b.
        //(re)	Groups regular expressions and remembers the matched text.
        //(?: re)	Groups regular expressions without remembering the matched text.
        //(?> re)	Matches the independent pattern without backtracking.
        //\w	Matches the word characters.
        //\W	Matches the nonword characters.
        //\s	Matches the whitespace. Equivalent to [\t\n\r\f].
        //\S	Matches the nonwhitespace.
        //\d	Matches the digits. Equivalent to [0-9].
        //\D	Matches the nondigits.
        //\A	Matches the beginning of the string.
        //\Z	Matches the end of the string. If a newline exists, it matches just before newline.
        //\z	Matches the end of the string.
        //\G	Matches the point where the last match finished.
        //\n	Back-reference to capture group number "n".
        //\b	Matches the word boundaries when outside the brackets. Matches the backspace (0x08) when inside the brackets.
        //\B	Matches the nonword boundaries.
        //\n, \t, etc.	Matches newlines, carriage returns, tabs, etc.
        //\Q	Escape (quote) all characters up to \E.
        //\E	Ends quoting begun with \Q.

        ////**********Match the input string to the regular expression (pattern)
        //////////Check to see input string matches regular expression (pattern)

        String inpput = "This placed is on 3000placed order 3000 was placed for QT3000! OK?";
        String patternRegEx = "\\b3000\\b";//matching boundaries, not substring in a word; for matching ONLY "3000", NOT "3000placed"
        Pattern p = Pattern.compile(patternRegEx);
        Matcher mat = p.matcher(inpput);
        int count = 0;

        while(mat.find())
        {
            count++;

            System.out.println("start:"+ mat.start());//returns index of starting match
            System.out.println("end:"+ mat.end());//returns index of ending match + 1
        }
        System.out.println("found "+ count + " instances");

        //////////*************Methods of matcher class
        //////Index Methods
        //1
        //public int start()
        //
        //Returns the start index of the previous match.
        //
        //2
        //public int start(int group)
        //
        //Returns the start index of the subsequence captured by the given group during the previous match operation.
        //
        //3
        //public int end()
        //
        //Returns the offset after the last character matched.
        //
        //4
        //public int end(int group)
        //
        //Returns the offset after the last character of the subsequence captured by the given group during the previous match operation.

        ///////////Study Methods - Study methods review the input string and return a Boolean indicating whether or not the pattern is found −
        //
        //1
        //public boolean lookingAt()
        //
        //Attempts to match the input sequence, starting at the beginning of the region, against the pattern.
        //
        //2
        //public boolean find()
        //
        //Attempts to find the next subsequence of the input sequence that matches the pattern.
        //
        //3
        //public boolean find(int start)
        //
        //Resets this matcher and then attempts to find the next subsequence of the input sequence that matches the pattern, starting at the specified index.
        //
        //4
        //public boolean matches()
        //
        //Attempts to match the entire region against the pattern.

        ///////////////Replacement methods - Replacement methods are useful methods for replacing text in an input string
        //
        //1
        //public Matcher appendReplacement(StringBuffer sb, String replacement)
        //
        //Implements a non-terminal append-and-replace step.
        //
        //2
        //public StringBuffer appendTail(StringBuffer sb)
        //
        //Implements a terminal append-and-replace step.
        //
        //3
        //public String replaceAll(String replacement)
        //
        //Replaces every subsequence of the input sequence that matches the pattern with the given replacement string.
        //
        //4
        //public String replaceFirst(String replacement)
        //
        //Replaces the first subsequence of the input sequence that matches the pattern with the given replacement string.
        //
        //5
        //public static String quoteReplacement(String s)
        //
        //Returns a literal replacement String for the specified String. This method produces a String that will work as a literal replacement s in the appendReplacement method of the Matcher class.

        ////////matches() REQUIRES the entire input sequence to be matched, while lookingAt() DOES NOT
        String re = "foo";
        String inputStr = "fooChaoMo coRafoo";
        Pattern pat0 = Pattern.compile(re);
        Matcher mat0 = pat0.matcher(inputStr);
        System.out.println(mat0.matches());//prints false because input string does not match the regExp
        System.out.println(mat0.lookingAt());//prints true because it looks only for occurrence

        ////////replaceFirst() replaces first occurrence and replaceAll() replaces all occurrences
        inputStr = mat0.replaceAll("Minh");//returns an updated string with replacement string, "Minh", applied
        System.out.println(inputStr);
        ///
        //Private members in superclass cannot be accessed by subclass; can only be accessed with public or protected inherited methods of superclass
        Engineer e9 = new Engineer();
        Employee ed9 = new Employee();
        Doctor d9 = new Doctor();
        ///since race is protected in Employee, all subclasses (objects of subclasses) can access it
        ed9.race = "mixed race";
        e9.race = "asian";
        d9.race = "white";
        System.out.printf("%s, %s, %s\n", ed9.race, e9.race, d9.race);
        Doctor.hello();//prints testing static method from public static method in Doctor class               <<<<<<<<
        d9.hello();//Don't need to be instantiated to call static methods. Can call using classname.methodName ^^^^^^^
        e9.greet();///all public member functions of a class can access its private/public/protected variables/functions



        ///////////////appendReplacement and appendTail
        //////finds a matching regular expression in the input string and replace it with another expression; similar to replaceAll()

        String REGEX = "a*b";//0 or more occurrences of 'a' followed by at least one 'b'
        String INPUT = "aabfooaabfooabfoob";
        Pattern pat1 = Pattern.compile(REGEX);
        Matcher mat1 = pat1.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(mat1.find())
        {
            mat1.appendReplacement(sb,"-" );//returns -foo-foo-foo-
        }
        System.out.println(sb.toString());

        //***********************Methods**************************************************
        ////////Pass by value
        //public static void main(String[] args) {
        //      int a = 30;
        //      int b = 45;
        //      System.out.println("Before swapping, a = " + a + " and b = " + b);
        //
        //      // Invoke the swap method
        //      swapFunction(a, b);
        //      System.out.println("\n**Now, Before and After swapping values will be same here**:");
        //      System.out.println("After swapping, a = " + a + " and b is " + b);///uses local a and b from this function(main), not from swapFunction()
        //   }
        //
        //   public static void swapFunction(int a, int b) {////passed arguments is local to this function
        //      System.out.println("Before swapping(Inside), a = " + a + " b = " + b);
        //
        //      // Swap n1 with n2
        //      int c = a;
        //      a = b;//this takes the argument variable 'a' and assigns it the value of variable 'b'
        //      b = c;//this takes the argument variable 'b' and assigns it the value of variable 'c',
        //      System.out.println("After swapping(Inside), a = " + a + " b = " + b);///uses local a and b from this function(swapFunction)
        //   }
        //}

        //////Method Overloading - same name but different signature
        //////Method Overriding - same name , same signature

        //////////Method overloading can improve readability
        ///find the min between two passed arguments
        //// for integer
        //   public static int minFunction(int n1, int n2) {
        //      int min;
        //      if (n1 > n2)
        //         min = n2;
        //      else
        //         min = n1;
        //
        //      return min;
        //   }
        //
        //   // for double
        //   public static double minFunction(double n1, double n2) {
        //     double min;
        //      if (n1 > n2)
        //         min = n2;
        //      else
        //         min = n1;
        //
        //      return min;
        //   }

        ///////////////////"this" keyword - refers to the instance variable , NOT local variables
        Doctor dt1 = new Doctor();
        dt1.greet(50);//favNum = 50 is local to greet(); this.favNum = 24 is an instance variable of dt1 object

        ///////////////////Variable arguments - can hold an arbitrary number of values of the same type-
        ////format = typename... parameterName
        Engineer.printmax(3.5,7.9,120.0,2.45,9.0,13.2,1000.34);//static method don't need instance to invoke; can invoke using className.methodName
        e3.printmax(3.7,8.9);//Can also use instance to invoke
        e4.printmax(new double[]{2.3,5.67,100.3,54.54});//create new double[] as argument


        ///********************************Files and I/O********************************
        //
        //Scanner class - reading from console
        //Checks if the user input is an int, double, or string
        Scanner in = new Scanner(System.in);
        String rs;
        do {
            System.out.println("enter a string: 'q' to quit");

             rs = in.nextLine(); ///read from keyboard and saves as string
            // use .nextDataType for other data types

            String iRegex = "[+-]?[0-9][0-9]*";///Regex for integer
            String dRegex = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";///Regex for floating point numbers
            Pattern ipat = Pattern.compile(iRegex);
            Pattern dpat = Pattern.compile(dRegex);
            Matcher imat = ipat.matcher(rs);
            Matcher dmat = dpat.matcher(rs);

            if (imat.matches()) {
                System.out.println(rs + " is an integer");
            } else if (dmat.matches()) {
                System.out.println(rs + " is a double");
            } else {
                System.out.println(rs + " is a string");
            }
        }while(!rs.equals("q"));

        /////////////////FileInputStream and FileOutputStream Class(reads and writes 1 byte at a time)
        //works same as...
        //FileReader and FileWriter Class(reads and writes 2 bytes at a time)
        /////reading from a file and writing it to another file

        FileInputStream inFile = new FileInputStream("input.txt");//FileInputStream class
        FileOutputStream outFile = new FileOutputStream("output.txt");//can also use location like ("C:/IdeaProjects/javaPractice")
        FileReader frdr = new FileReader("input.txt");//FileReader class
        int c = inFile.read(), c2 = frdr.read();
        System.out.println(c);//both prints the same ascii code for the character being read
        System.out.println(c2);


        //inFile.read() returns the ascii code of the read character from 0-255

        while ((c = inFile.read()) != -1)///While reading a character and storing it in c and c != -1
        {////this infile.read() will read the second character because the first infile.read() was invoked
                outFile.write(c);///write that character to output file
        }
        if (inFile != null)
        {
                inFile.close();
        }
        if (outFile != null)
        {
                outFile.close();
        }


        /////////PrintWriter - used for write formatted text
        ///////FileOutputStream/FileInputStream - used for write/read binary data
        //////DataOutputStream/DataInputStream - used for write/read primitive types
        /////RandomAccessFile write to a specific position
        /////FileChannel writes faster in larger files
        /////FileWriter/FileReader

        ////write data to a file and read data from that file and print to console
        ///WRITE DATA TO FILE
        String[] sArr = {"hello", "minh", "durbin"};
        int[] iArr = {1,2,500,2000};

        File myFile = new File("testFile.txt");///create a File obj
        PrintWriter pw = new PrintWriter(myFile);


        for(String s: sArr){
            pw.print(s+" ");


        }

        for(int i: iArr){
            pw.print(i);
            pw.print(" ");
        }
        pw.format("%s, %d, %f", "JESUS", 899, 19.764);//format write to file
        pw.close();

        ////Reading from the output file and print it
        ///Reads each character
        FileReader fr = new FileReader(myFile);
        int cc1;
        while((cc1 = fr.read()) != -1){ ///.read() returns ascii codes 0-255 for each character read
            System.out.print((char)cc1);//convert ascii code to char
        }
        System.out.println();
       fr.close();

        //////Use scanner to read each word up to a whitespace
        Scanner scn = new Scanner(myFile);
        while(scn.hasNext()){
            String s = scn.next();
            System.out.println(s);
        }
        scn.close();


        /////////////File Navigation
        ///mkdir() and mkdirs()
        File myFile2 = new File("C:\\Users\\clams\\IdeaProjects\\javaPractice\\newDir");
        myFile2.mkdirs();///creates a folder called newDir in javaPractice

        //////////list() creates a list off all folders in a directory
        File myFile3 = new File("C:\\Users\\clams\\IdeaProjects\\javaPractice");
        String dir[] = myFile3.list();
        try{
            for(String i: dir){
                System.out.println(i);
            }

        }catch(Exception e){
            System.out.println("No folders found");
        }

        ///////****************************Exceptions*****************************************
        //////"finally" block executes no regardless if an exception is thrown or not. Used for closing
        /////can have multiples catch block for one try
        //////throws - declaring that the method will throw an exception; written in method signature; -> public void hello() throws exceptionName
        /////throw - execution of throwing the exception; written in block of method; ->
        // public void hello() throws exceptionName{
        //      throw new exceptionName();
        //}


        //////////TRY-W/-Resources - automatically closes the resource in try block
        ///To use, must declare resource in the parenthesis
        try(FileReader fr3 = new FileReader("input.txt")){
            char[] arrayChar = new char[50];
            fr3.read(arrayChar); //reads the whole file into an array 'arrayChar'
            for(char c3: arrayChar){
                System.out.printf("%s ", c3);
            }
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
        //////User defined exception class
        //////Must extend the Exception class
        try{
            System.out.println("enter a number");
            int tInt = in.nextInt();
            throw new MyException();///must throw user-defined exception obj in try block

        }catch(MyException e) {
            e.stmt();
        }
        //******************************Inner Classes******************************************
        int j = 0;
        for(int i =0; i <5; i++){
            j = i;
            System.out.println(i);
        }

        System.out.println(j);































    }



    }











