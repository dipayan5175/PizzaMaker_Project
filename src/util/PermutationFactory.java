package util;

public class PermutationFactory
{
   public static Permutation getPermutation(String file_name, int r, int n)
   {
	   //return new FilePermutation(file_name, r);
	   return new RandomPermutation(r, n);
   }
}
