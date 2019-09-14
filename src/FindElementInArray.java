import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FindElementInArray {
	// Complete the findNumber function below.
	static String findNumber(List<Integer> arr, int k) {
		if (arr.contains(k)) {
			return "YES";
		} else {
			return "NO";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
