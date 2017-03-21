/*
Given a string and a non-negative int n, return a larger string that is n copies of the original string.

stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"
*/

public String stringTimes(String str, int n) {
  String copy = "";
  for(int i = 0; i < n; i++){
    copy = copy+str;
  }
  return copy;
}

/*
Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;

frontTimes("Chocolate", 2) → "ChoCho"
frontTimes("Chocolate", 3) → "ChoChoCho"
frontTimes("Abc", 3) → "AbcAbcAbc"
*/

public String frontTimes(String str, int n) {
  String copy = "";
  for (int i = 0; i < n; i++){
    if(str.length()<3){
      copy = copy+str;
    }else{
      copy = copy+str.substring(0,3);
    }
  }
  return copy;
}

/*
Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".

countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3
*/

int countXX(String str) {
  int count = 0;
  for (int i = 0; i < str.length()-1; i++){
    if(str.substring(i, i+2).equals("xx")) count++;
  }
  return count;
}

/*
Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".

doubleX("axxbb") → true
doubleX("axaxax") → false
doubleX("xxxxx") → true
*/

boolean doubleX(String str) {
  int startingPositionX = str.indexOf("x");
  if (startingPositionX == -1){
    return false;
  }
  if (startingPositionX+1 >= str.length()){
    return false;
  }
  return str.substring(startingPositionX+1,startingPositionX+2).equals("x");
}

/*
Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".

stringBits("Hello") → "Hlo"
stringBits("Hi") → "H"
stringBits("Heeololeo") → "Hello"
*/

public String stringBits(String str) {
  String newString = "";
  for (int i = 0; i < str.length(); i+=2){
    newString = newString+str.substring(i,i+1);
  }
  return newString;
}

/*
Given a non-empty string like "Code" return a string like "CCoCodCode".

stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"
*/

public String stringSplosion(String str) {
  String explosion = "";
  for (int i = 0; i < str.length(); i++){
    explosion = explosion+str.substring(0,i+1);
  }
  return explosion;
}

/*
Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).

last2("hixxhi") → 1
last2("xaxxaxaxx") → 1
last2("axxxaaxx") → 2
*/

public int last2(String str) {
  if(str.length()>1){
    String last = str.substring(str.length()-2);
    int counter = 0;
    //str.length()-2 om de laaste twee niet mee te tellen
    for(int i = 0; i < str.length()-2; i++){
      if(str.substring(i,i+2).equals(last)) {
        counter++;
      }
    }
    return counter;
  }
  return 0;
}

/*
Given an array of ints, return the number of 9's in the array.

arrayCount9([1, 2, 9]) → 1
arrayCount9([1, 9, 9]) → 2
arrayCount9([1, 9, 9, 3, 9]) → 3
*/

public int arrayCount9(int[] nums) {
  int counter = 0;
  for (int i=0; i < nums.length; i++){
    if (nums[i] == 9) {
      counter++;
    }
  }
  return counter;
}

/*
Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.

arrayFront9([1, 2, 9, 3, 4]) → true
arrayFront9([1, 2, 3, 4, 9]) → false
arrayFront9([1, 2, 3, 4, 5]) → false
*/

public boolean arrayFront9(int[] nums) {
  for (int i=0; i < nums.length; i++){
    if (nums[i] == 9) {
      if(i >= 4){
        return false;
      }
      return true;
    }
  }
  return false;
}

/*
Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.

array123([1, 1, 2, 3, 1]) → true
array123([1, 1, 2, 4, 1]) → false
array123([1, 1, 2, 1, 2, 3]) → true
*/

public boolean array123(int[] nums) {
  if (nums.length < 3) return false;
  for (int i=0; i<nums.length-2; i++) {
    if (nums[i] == 1 && nums[i+1] == 2 && nums[i+2] == 3) return true;  
  }
  return false;
}

// Ik had een alternatief die niet werkt maar waarom ik niet weet WAAROM hij niet werkt.
public boolean array123(int[] nums) {
  if (nums.length < 3) return false;
  for (int i=0; i<nums.length-2; i++) {

    // nums[i]+nums[i+1]+nums[1+2] moet als uitkomst hebben 123......
    if (nums[i]+nums[i+1]+nums[i+2] == 123) return true;  
  }
  return false;
}

/*
Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.

stringMatch("xxcaazz", "xxbaaz") → 3
stringMatch("abc", "abc") → 2
stringMatch("abc", "axc") → 0
*/

public int stringMatch(String a, String b) {
  int counter = 0;
  if (a.length()>=b.length()){
    for(int i=0; i<b.length()-1; i++){
      if(a.substring(i,i+2).equals(b.substring(i,i+2))) counter++;
    }
  }
  if(a.length()<b.length()){
    for(int i=0; i<a.length()-1; i++){
      if(b.substring(i,i+2).equals(a.substring(i,i+2))) counter++;
    }
  }
  return counter;
}

//ALTERNATIVE -> het verschil zit in de bepaling welke korter of langer is

public int stringMatch(String a, String b) {
  int counter = 0;
  int length = Math.min(a.length(), b.length());
  for(int i=0; i<length-1; i++){
    if(b.substring(i,i+2).equals(a.substring(i,i+2))) counter++;
  }
  return counter;
}