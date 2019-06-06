package util;

import java.util.List;
import java.util.ArrayList;

/** Generates a permutation of r integers selected from n integers (1...n) using a random number generator. */
public class RandomPermutation implements Permutation
{
   private int r;
   private List<Integer> numbers;

   /** 
	* Specify the number of integers to be selected from the permutation as well as the range of integers (1..n) in the permutation.
	*	<b>Preconditions</b>: r <= n, r >= 0
	*/
   public RandomPermutation(int r, int n)
   {
      this.r = r;

      numbers = new ArrayList<Integer>();
      for (int i = 1; i <= n; i++)
      {
         numbers.add(i);
      }
   }
   
   /** Indicates whether r integers have already been returned or not. */
   public boolean hasNext()
   {
	   return (r > 0);
   }

   /** 
	* If r integers have not already been returned, gets the next one from the permutation and returns it. <br>
	* Otherwise, -1 is returned.
	*/
   public int next()
   {
      if (r == 0) return -1;

      int rand = Random.getRandomNumberGenerator().randomInt(1, numbers.size());
      int value = numbers.get(rand - 1);
      numbers.remove(rand - 1);
      r--;

      return value;
   }
}
