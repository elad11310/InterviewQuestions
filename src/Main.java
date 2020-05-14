public class Main {

    /**
     * this class represents some interview questions.
     * 1)printAllPermutations - recursively prints all arr permutations.
     * 2)RandInO_I - this function gets an array in length of N and prints i random numbers without any memory use to save numbers we already print
     * and in complexity - O(I) - whats means if i==4 we print 4 different numbers from the arr in a loop that runs 4 times at all.
     * 3)swap - swap 2 int variables in arr without a temp variable
     * 4) by given an arr with numbers 1-100 , if we take out 1 variable, whats the value we took out?(we are allowed to iterate once on the arr)
     *  if we take out 2 variables , what the value of them? (we are allowed to iterate once on the arr)
     *  for the first answer  - we know that sum of arithmetic sequence from 1-100 is 5050,so we will count the sum of the arr and do 5050 - sum and that's the value we took
     *  for the second answer - for the first iteration we will do as same as the first question. now we have a number that is the sum of 2 numbers we took out.
     *  we will make it's average (dividing by two), because zero is out of the game so we know that 1 number is greater then the average and 1 is lower.
     *  for example if the sum was 100, so we know 1 num is less then 50 and the other is greater then 50.
     *  so in the second iteration we will count the numbers that are lower/greater then 50 (we can choose), and then we will make an arithmetic sequence between 1-50,
     *  and substract the sum from it. and that's will be the first of two numbers, the second we can find by subtracting the num from 100. ( no implementation for this ex)
     *  */
    public static void main(String[] args) {

        int arr[] = {1,464,123,435,664,2};
       // printAllPermutations(arr, "", 0);
        RandInO_I(arr,4);

    }

    private static void printAllPermutations(int[] arr, String ans,int count) {
        for (int i = 0; i < arr.length; i++) {
            // checking if this number already exists in the string or not,if not add it.
            if (!contains(ans,String.valueOf(arr[i]))) { // i got problem here if i got 17 in the string and i need to add 1 it wont done because 1 of the 17 already exists.
                ans += arr[i] + " ";
                count++;
                if(count==arr.length){
                    System.out.println(ans);
                    return;
                }


                //recursively calling the function again.
                printAllPermutations(arr, ans,count);
                ans = subString(ans);
                count--;
                if(count==0){
                    ans="";
                }

            }


        }

    }

    private static boolean contains(String ans,String c){
        String [] temp = ans.split(" ");
        for (int i=0;i<temp.length;i++){
            if(c.equals(temp[i])){
                return true;
            }
        }
        return false;
    }

    private static String subString(String ans) {
        int i = ans.length()-2;
        if(i>0) {
            while (ans.charAt(i) != ' ') {
                i--;
                if(i<0){
                    break;
                }
            }
            ans=ans.substring(0,i+1);
            return ans;
        }
        else{
            return "";
        }

    }

    private static void RandInO_I(int arr[],int i){
        int numberToRand = arr.length,ind =0;
        for(int k=0;k<i;k++){
            ind = (int)(Math.random()*numberToRand);
            System.out.print("num of index " + ind +" , ");
            System.out.print(arr[ind] +" ");

            swap(arr,ind,numberToRand-1);
            numberToRand--;

        }
    }

    private static void swap(int[] arr, int ind, int indToSwitch) {
        // this function makes a swap between 2 arr variables without using temp variable.
        arr[ind] = arr[ind]+arr[indToSwitch];
        arr[indToSwitch] = arr[ind]-arr[indToSwitch];
        arr[ind]=arr[ind]- arr[indToSwitch];
    }


}