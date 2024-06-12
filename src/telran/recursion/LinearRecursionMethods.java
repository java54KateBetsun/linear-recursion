package telran.recursion;

public class LinearRecursionMethods {
	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n cannot be a negative");
		}
		int res = 1; // when n=0 res=1 -> because factorial(0)=1;
		if (n != 0) {
			res = n * factorial(n - 1);
		}
		return res;
	}

	/*
	 * a - any integer 
	 * b - positive integer
	 */
	public static int pow1(int a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (b != 0) {
			res = a * pow1(a, b - 1);
		}
		return res;
	}

	/*
	 * @param a - any integer number
	 * @param b - positive integer number 
	 * @return a ^ b no cycles only arithmetic operations +, - 
	 * additional functions if any with the same limitations
	 */
	public static int pow(int a, int b) {
		// TODO
		if (b < 0) {
			throw new IllegalArgumentException();
		} 
		int res = 1;
		if(b == 0) {
			res = 1;
		} else {
			res = multiply(a, pow(a, b-1));
		}
		return res;
	}
	
	private static int multiply(int x, int y) {
		int resMulti;
		if(y == 0) {
			resMulti =  0;
		} else if (y > 0) {
			resMulti =  x + multiply(x, y - 1);
		} else {
			resMulti =  -multiply(x, -y);  
		}
		return resMulti;
	}

	public static void displayArray(int[] array) {
		displayArray(0, array, false);
	}

	public static void displayArrayReversed(int[] array) {
		displayArray(0, array, true);
	}

	private static void displayArray(int index, int[] array, boolean isReserved) {
		if (index < array.length) {
			if (isReserved) {
				displayArray(index + 1, array, isReserved);
				System.out.print(array[index] + " ");
			} else {
				System.out.print(array[index] + " ");
				displayArray(index + 1, array, isReserved);
			}
		}
	}

	public static int sum(int[] array) {
		return sum(0, array);
	}

	private static int sum(int index, int[] array) {
		int res = 0;
		if (index < array.length) {
			res = array[index] + sum(index + 1, array);
		}
		return res;
	}

	public static void reverse(int[] array) {
		reverse(0, array.length - 1, array);
	}

	private static void reverse(int left, int right, int[] array) {
		if (left < right) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			reverse(left + 1, right - 1, array);
		}

	}

	/*
	 * @param x - any integer number
	 * 
	 * @return x^2 no cycles allowed only arithmetic operations +, - no additional
	 * functions allowed no static fields
	 */
	public static int square(int x) {
		if (x < 0) {
			x = -x;
		}
		return square(x, x);
	}

	private static int square(int x, int count) {
		if (count == 0) {
			return 0;
		}
		return x + square(x, count - 1);
	}

	/*
	 *@param str - string
	 * @param substr - substring
	 * @return true if substr is a substring of a string, false otherwise
	 * no cycles
	 * allowed only three String methods are charAt(int index);substring(int beginIndex); length()
	 */
	public static boolean isSubstring(String str, String subStr) {
        return isSubstring(str, subStr, 0);
    }

    private static boolean isSubstring(String str, String subStr, int index) {
    	
    	boolean res = false;
        if (subStr.length() == 0) {
        	res = true;
        } else if (index > str.length() - subStr.length()) {
        	res = false;
        } else if(isPrefix(str, subStr, index)) {
        	res = true;
        } else {
        	res = isSubstring(str, subStr, index + 1);
        }
        return res;
    }

    private static boolean isPrefix(String str, String subStr, int index) {
    	
    	boolean res = false;
        if (subStr.isEmpty()) {
        	res = true;
        }else if (index >= str.length()) {
        	res = false;
        }else if (str.charAt(index) != subStr.charAt(0)) {
        	res = false;
        } else {
        	res = isPrefix(str, subStr.substring(1), index + 1);
        }
        return res;
    }
    
    
    
	public static boolean isSubstring1(String str, String substr) {

		boolean res = false;
		if (substr.length() == 0) {
			res = true; 
        }
	    if (str.length() < substr.length()) {
	    	res = false;
	    	
	    } else if (str.length() == substr.length()) {
	    	res = str.equals(substr);
	    } else {
	    	res = str.substring(0, substr.length()).equals(substr) || isSubstring1(str.substring(1), substr);
	    }
	    return res;
	}
}
