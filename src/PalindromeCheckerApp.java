import java.util.*;

class PalindromeCheckerApp {

class PalindromeCheckerApp {

        Map<String, Boolean> results = new LinkedHashMap<>();
        Map<String, Long> timings = new LinkedHashMap<>();

        String[] names = {
                "ReverseLoop1", "ReverseLoop2", "CharArray",
                "Stack", "QueueStack", "Deque",
                "LinkedList", "Recursive",
                "IgnoreCaseSpace", "CleanedStack"
        };

        for (String name : names) {

            long start = System.nanoTime();
            boolean result = false;

            switch (name) {
                case "ReverseLoop1":
                    result = isPalindromeReverseLoop1(input);
                    break;
                case "ReverseLoop2":
                    result = isPalindromeReverseLoop2(input);
                    break;
                case "CharArray":
                    result = isPalindromeUsingCharArray(input);
                    break;
                case "Stack":
                    result = isPalindromeUsingStack(input);
                    break;
                case "QueueStack":
                    result = isPalindromeUsingQueueStack(input);
                    break;
                case "Deque":
                    result = isPalindromeUsingDeque(input);
                    break;
                case "LinkedList":
                    result = isPalindromeUsingLinkedList(input);
                    break;
                case "Recursive":
                    result = isPalindromeRecursive(input, 0, input.length() - 1);
                    break;
                case "IgnoreCaseSpace":
                    result = isPalindromeIgnoreCaseAndSpace(input);
                    break;
                case "CleanedStack":
                    result = checkPalindrome(input);
                    break;
            }

            long end = System.nanoTime();
            long duration = end - start;

            results.put(name, result);
            timings.put(name, duration);
        }

        System.out.println("\nPerformance Results");

        System.out.printf("%-20s %-20s %-15s%n", "Algorithm", "Execution Time (ns)", "Result");
        System.out.println("_______________________________________________________________");

        for (String name : timings.keySet()) {
            System.out.printf("%-20s %-20d %-15s%n",
                    name,
                    timings.get(name),
                    results.get(name));
        }

        System.out.println("_______________________________________________________________");

        String fastest = Collections.min(timings.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\nFastest Algorithm: " + fastest);

        scanner.close();
    }
}
