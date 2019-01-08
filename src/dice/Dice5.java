package dice;

import java.util.Random;

/**
 * Xúc sắc  có mặt 6 chấm là 20 %, các mặt còn lại là 16%
 * @author ManhVD
 *
 */
public class Dice5 implements IDice{
	@Override
	public int dropDice() {
		// TODO Auto-generated method stub
		int resultArray[]= new int [25];
		
		//create array
		for(int i=0;i<25;i++) {
			if(i<4) resultArray[i]=1;
			else if(i<8) resultArray[i]=2;
			else if(i<12) resultArray[i]=3;
			else if(i<16) resultArray[i]=4;
			else if(i<20) resultArray[i]=5;
			else resultArray[i]=6;
		}
		
		//receive random value of array to face which has 2 point is 20 %
		Random rand = new Random();
		int number = rand.nextInt(25);
		return resultArray[number];
	}
}
