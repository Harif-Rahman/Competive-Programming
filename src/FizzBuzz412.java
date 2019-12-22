import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
 */

    // with modulo operator
    public List<String> fizzBuzz(int n) {
        List<String> ls = new ArrayList<>(n);
        int fizz = 0,buzz=0;
        for(int i=1;i<=n;i++){
            fizz++;
            buzz++;
            if(fizz == 3 && buzz == 5){
                fizz =0;
                buzz =0;
                ls.add("FizzBuzz");
                continue;
            }
            if(fizz == 3){
                fizz =0;
                ls.add("Fizz");
                continue;
            }
            if(buzz == 5){
                buzz =0;
                ls.add("Buzz");
                continue;
            }
            ls.add(""+i);

        }
        return ls;
    }
    // without modulo operator
    public List<String> fizzBuzz1(int n) {
        List<String> ls = new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            if(i % 3 == 0 && i % 5 == 0){
                ls.add("FizzBuzz");
                continue;
            }
            if(i % 3 == 0){
                ls.add("Fizz");
                continue;
            }
            if(i % 5 == 0){
                ls.add("Buzz");
                continue;
            }
            ls.add(""+i);
        }
        return ls;
    }

}
