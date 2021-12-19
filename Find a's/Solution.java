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

class Result {

    public static long repeatedString(String s, long n) {
        long str_len = s.length();
        boolean all = true;
        long count = 0;
        for(int i = 0; i < str_len; i++)
        {
            if(s.charAt(i) != 'a')
                all = false;
            else count++;
        }
        if(all)
            return n;

        if(n%str_len == 0)
            return count*(n/str_len);
        else{
            count = count * (long)Math.floor(n / str_len);
            long k = n%str_len;
            for(int i = 0; i < k; i++)
            {
                if(s.charAt(i) == 'a')
                    count++;
            }
            return count;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
