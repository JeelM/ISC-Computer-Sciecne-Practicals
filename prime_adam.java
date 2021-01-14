package isc_practiclas;

import java.io.*;
import java.util.ArrayList;

public class prime_adam {
	boolean isPrime(int num) {
		boolean prime = true;
		int i = 2;
		while (i <= Math.sqrt(num) && prime) {
			if (num % i == 0) {
				prime = false;
			}
			i++;
		}
		return prime;
	}

	boolean isAdam(int num) {
		int rev = reverse(num);
		int sqr_of_num = num * num;
		int sqr_of_rev = rev * rev;
		return sqr_of_num == reverse(sqr_of_rev);

	}

	int reverse(int num) {
		int rev_num = 0;
		while (num > 0) {
			int digit = num % 10;
			rev_num = (rev_num * 10) + digit;
			num /= 10;
		}
		return rev_num;
	}

	public static void main(String args[]) throws IOException {
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		System.out.print("m = ");
		int m = Integer.parseInt(in.readLine());
		System.out.println();
		System.out.print("n = ");
		int n = Integer.parseInt(in.readLine());
		System.out.println("The Prime Adam integers are: ");
		if (m >= 0 && n > 0 && m < n) {
			prime_adam obj = new prime_adam();
			int count = 0;
			for (int i = m; i <= n; i++) {
				if (obj.isPrime(i) && obj.isAdam(i)) {
					System.out.print(i + " ");
					count++;
				}
			}
			System.out.println();
			System.out.println("Frequency of Prime Adam numbers: " + count);
		} else {
			System.out.println("Invalid Input");
		}
	}
}
