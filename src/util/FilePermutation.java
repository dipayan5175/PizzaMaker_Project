package util;

import java.util.List;
import java.util.ArrayList;

public class FilePermutation implements Permutation
{
   private int r;
   private List<Integer> numbers;
   private ReadTextFile file;

   //pick r of them from 1 to n
   public FilePermutation(String file_name, int r)
   {
	   numbers = new ArrayList<Integer>();
		file = new ReadTextFile(file_name);
		
		String text = file.readLine();
		
		while (!file.EOF())
		{
			numbers.add(Integer.parseInt(text));
			text = file.readLine();
		}
		
		file.close();
		this.r = r;
   }
   
   public boolean hasNext()
   {
		return (r > 0);
   }

   public int next()
   {
		if (r == 0) return -1;

		int value = numbers.get(0);
		numbers.remove(0);
		r--;
		return value;
   }
}
