import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;


class Student implements Comparable<Student>{
	
	int start, end;
	
	public Student(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Student o) {
		if(this.start == o.start) {
			return this.end - o.end;
		} else {
			return this.start - o.start;
		}
	}
	
}


public class Main {

	static int N;
	static ArrayList<Student> studyTime = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 1; //Integer.parseInt(in.readLine().trim());
		StringTokenizer tokens;
		
		for (int tc = 1; tc <= T; tc++) {
			int t_start= 0, t_end=0;
			int max_in = 0, max_notIn = 0;
			
			N = Integer.parseInt(in.readLine().trim());
			studyTime.clear();
			
			for (int i = 0; i < N; i++) {
				tokens = new StringTokenizer(in.readLine().trim());
				studyTime.add(new Student(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
			}
			
			Collections.sort(studyTime);
			
			Student cur_s = studyTime.get(0);
			t_start = cur_s.start;		// start point of continuous one
			t_end = cur_s.end;			// end point of continuous one
			
			max_in = t_end - t_start;	// global maximums
			
			for (int i = 1, size = studyTime.size(); i < size; i++) {
				cur_s = studyTime.get(i);
 			
				if(cur_s.start <= t_end) {		// if continuous
					if(t_end < cur_s.end) {		// has further bound
						t_end = cur_s.end;
						if(max_in < t_end-t_start) {
							max_in = t_end-t_start;
						}
					}
				} else {
					if(max_notIn < cur_s.start - t_end) {
						max_notIn = cur_s.start - t_end;
					}
					t_start = cur_s.start;
					t_end = cur_s.end;
				}
			}
			
			System.out.println(max_in + " " +  max_notIn);
		}
		
	}
}
