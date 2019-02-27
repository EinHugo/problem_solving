#include <iostream>
#include <vector>

using namespace std;
int main(){
    int t_num = 0;
    cin >> t_num; // # of Test Case

    int day = 0, rest_max = 0, rest_offset = -1 ;
    long long profit = 0;
    for(int i = 1 ; i <= t_num ; i++){
        day = 0; // # of Days of Each Test
        cin >> day;
        vector<int> prices(day);
        for (int j = 0 ; j < day ; j++){
            cin >> prices[j];
        }
		profit = 0;
		rest_max = 0;
		rest_offset = -1;
		
		for (int base = 0 ; base < day ; base++){

			if (base < rest_offset){
				int tmp = rest_max - prices[base];
				if (tmp > 0)
					profit += rest_max - prices[base];
				continue;
			} else if (base == rest_offset){
				rest_max = 0;
				rest_offset = -1;
				continue;
			}
			for (int offset = base ; offset < day ; offset++){
				int tmp = prices[offset];
				if (tmp >= rest_max){
					rest_max = tmp;
					rest_offset = offset;
				}
			}
			if (base == rest_offset){
				rest_max = 0;
				rest_offset = -1;
				continue;
			}
			if (base < rest_offset){
				int tmp = rest_max - prices[base];
				if (tmp > 0)
					profit += rest_max - prices[base];
            }
		}
        cout << "#" << i << " " << profit << endl;
    }
}