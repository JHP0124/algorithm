package step01_StacknQueue;
import java.util.*;

public class bridge_truck {
	
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
		int sum = 0;
		int time = 0; 
		// truck_weight : 7/4
		for(int i = 0; i < truck_weights.length; i++) { // 트럭 개수만큼 반복.
			int truck = truck_weights[i];

			while(true) { // break; 문이 나올 때까지 반복
				// 큐에 아무것도 없는 경우 = 어떠한 트럭도 다리위에 없음 
				if(queue.isEmpty()) { 
					queue.add(truck); //다리위에 트럭 추가   [7, ]
					sum += truck; // weight 값과 비교하기 위해서 0->7
					time++; // 다리에 오를 때만 시간 추가  // s: 7 / t: 1
					break; // while문 벗어남.
				} else if(queue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우 
					sum -= queue.poll(); // 큐의 첫번째 값을 반환하고 제거. / sum :7-> 0
										 //	queue [7,0]=> [0, ]->[0,4]
				} else  { // 다리 길이만큼 큐가 차지않았음
					// weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌 
					if(sum + truck <= weight) {  //7+4 <=10  ->0+4<=10 아래 else문으로 
						queue.add(truck); // [0,4]  
						sum += truck; // sum 0->4
						time++; //3 
						break; // while문 깨고 다음 i=3이라 for문 종료
					} else { 
						// weight 값을 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬 
						queue.add(0); // [7/0]->
						time++; //2 
					}
				}
			}
		}

        // 마지막 트럭에서 반복문이 끝나는데, 마지막 트럭도 다리 길이만큼 지나가야하기에  다리 길이를 더한다. 
		return time + bridge_length; 
    }
	
	
	
	
	
	

	public static void main(String[] args) {
		int bri_l = 2;
		int wei = 10;
		int [] tru_w= {7,4};
		
			int ans=solution(bri_l, wei, tru_w);
			System.out.println("걸린 시간 : " + ans);
			
	}

}


/*
 	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        ArrayList<Integer> start = new ArrayList<>();
        Queue<Integer> bridge = new LinkedList<>();
        ArrayList<Integer> fin = new ArrayList<>();
        int sum =0;
        int count =0;
        
        	for(int i =0; i< truck_weights.length ; i++) {
        		sum= truck_weights[i]; //ex) 4
        		
        		if( sum <weight) {
        			bridge.offer(truck_weights[i]);  
            		count++;
        			for(int j=i+1; j<truck_weights.length;j++) {
        			if(sum+truck_weights[j]<weight) { //ex:4+5
        				sum=sum+truck_weights[j];
        				bridge.offer(truck_weights[j]);
        				count++;
        				}
        			else 	{
        				bridge.clear();
        				count++;
        				break;
        				}	
        			}
        		}
        		
        }
        answer = count;
        return answer;
	}

 */
