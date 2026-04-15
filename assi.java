public class assi {

    // ---------------- Q1 ----------------
    static int reverseInteger(int n) {
        int rev = 0;

        while (n != 0) {
            int digit = n % 10;

            if (rev > 214748364 || rev < -214748364)
                return 0;

            rev = rev * 10 + digit;
            n = n / 10;
        }
        return rev;
    }

    // ---------------- Q2 ----------------
    static boolean isArmstrong(int n) {
        int temp = n, digits = 0, sum = 0;

        while (temp > 0) {
            digits++;
            temp = temp / 10;
        }

        temp = n;
        while (temp > 0) {
            int d = temp % 10;
            int power = 1;

            for (int i = 0; i < digits; i++)
                power = power * d;

            sum = sum + power;
            temp = temp / 10;
        }

        return sum == n;
    }

    // ---------------- Q3 ----------------
    static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact = fact * i;
        return fact;
    }

    static boolean isStrong(int n) {
        int temp = n, sum = 0;

        while (temp > 0) {
            int d = temp % 10;
            sum = sum + factorial(d);
            temp = temp / 10;
        }

        return sum == n;
    }

    // ---------------- Q4 ----------------
    static void primesInRange(int N) {
        int count = 0;

        for (int i = 2; i <= N; i++) {
            int flag = 1;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nCount = " + count);
    }

    // ---------------- Q5 ----------------
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // ---------------- Q6 ----------------
    static boolean isPerfect(int n) {
        int sum = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                sum = sum + i;
        }

        return sum == n;
    }

    // ---------------- Q7 ----------------
    static void moveZeros(int arr[], int n) {
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < n) {
            arr[index] = 0;
            index++;
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // ---------------- Q8 ----------------
    static int findDuplicate(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] = arr[index] + n;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] / n > 1)
                return i;
        }
        return -1;
    }

    // ---------------- Q9 ----------------
    static void leaders(int arr[], int n) {
        int max = arr[n - 1];
        System.out.print(max + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                System.out.print(max + " ");
            }
        }
        System.out.println();
    }

    // ---------------- Q10 ----------------
    static void leftRotate(int arr[], int n, int k) {
        for (int i = 0; i < k; i++) {
            int first = arr[0];

            for (int j = 0; j < n - 1; j++)
                arr[j] = arr[j + 1];

            arr[n - 1] = first;
        }

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // ---------------- Q11 ----------------
    static boolean subarraySum(int arr[], int n, int target) {
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum = sum + arr[j];

                if (sum == target)
                    return true;
            }
        }
        return false;
    }

    // ---------------- Q12 ----------------
    static int longestSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int visited[] = new int[256];
            int len = 0;

            for (int j = i; j < s.length(); j++) {
                if (visited[s.charAt(j)] == 1)
                    break;

                visited[s.charAt(j)] = 1;
                len++;
            }

            if (len > max)
                max = len;
        }
        return max;
    }

    // ---------------- Q13 ----------------
    static void compress(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int count = 1;

            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            System.out.print(ch);
            System.out.print(count);
        }
        System.out.println();
    }

    // ---------------- Q14 ----------------
    static void hollowPyramid(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = i; j < n; j++)
                System.out.print(" ");

            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1 || i == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        System.out.println(reverseInteger(123));

        if (isArmstrong(153))
            System.out.println("Armstrong");
        else
            System.out.println("Not Armstrong");

        if (isStrong(145))
            System.out.println("Strong");
        else
            System.out.println("Not Strong");

        primesInRange(20);

        int a = 12, b = 18;
        System.out.println("GCD = " + gcd(a, b));
        System.out.println("LCM = " + lcm(a, b));

        if (isPerfect(28))
            System.out.println("Perfect");
        else
            System.out.println("Not Perfect");

        int arr1[] = {1, 0, 2, 0, 3};
        moveZeros(arr1, arr1.length);

        int arr2[] = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr2, arr2.length));

        int arr3[] = {16, 17, 4, 3, 5, 2};
        leaders(arr3, arr3.length);

        int arr4[] = {1, 2, 3, 4, 5};
        leftRotate(arr4, arr4.length, 2);

        int arr5[] = {1, 2, 3, 7, 5};
        if (subarraySum(arr5, arr5.length, 12))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println(longestSubstring("abcabcbb"));

        compress("aabcc");

        hollowPyramid(5);

        // ---------------- Q15 ----------------
        int arr6[] = {1, 2, 2, 3, 1};
        int n = arr6.length;

        for (int i = 0; i < n; i++) {
            int count = 1;

            if (arr6[i] == -1)
                continue;

            for (int j = i + 1; j < n; j++) {
                if (arr6[i] == arr6[j]) {
                    count++;
                    arr6[j] = -1;
                }
            }
            System.out.println(arr6[i] + " -> " + count);
        }
    }
}