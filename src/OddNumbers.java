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

public class OddNumbers {

	// Complete the oddNumbers function below.
	static List<Integer> oddNumbers(int l, int r) {
		List<Integer> odds = new ArrayList<Integer>();
		if (l > r) {
			return odds;
		}
		if (l % 2 == 0) {
			l++;
		}
		while (l <= r) {
			odds.add(l);
			l += 2;
		}
		return odds;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
