import java.sql.Time;
import java.util.ArrayList;

public class arr {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> a = null;
		int[] b = null;
		a = new ArrayList<>();
		b = new int[1];
		a.add(1);
		
		long start = System.nanoTime();
		for (int i = 0; i < 1000000000; i++) {
//			a.set(0, 1);
			b[0] = 1;
		}
		long end =System.nanoTime();
		
		long start2 = System.nanoTime();
		for (int i = 0; i < 1000000000; i++) {
			a.set(0, 1);
//			b[0] = 1;
		}
		long end2 =System.nanoTime();
		
		
		System.out.println(end-start);
		System.out.println(end2-start2);
	}
	
	

}
