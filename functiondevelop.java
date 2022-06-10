package step01_StacknQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 큐 명령어 관련 참조
 * https://coding-factory.tistory.com/602
 * */

public class functiondevelop {
	
		
	    public static int[] solution(int[] progresses, int[] speeds) {
	        Queue<Integer> q = new LinkedList<>();  // 링크드 리스트로 큐 q 생성
	        List<Integer> answerList = new ArrayList<>(); //배열 answerList 생성
	        		// p : 93/30/55  //s : 1/30/5 // date : 7/3/9 -> (7,3)(9)
	        for (int i = 0; i < speeds.length; i++) { // progresses.length로 해도 상관없음.
	            double remain = (100 - progresses[i]) / (double) speeds[i]; //  각 작업별로 (100-작업진도)/진행속도 = (double) 남은 일수 구하기
	             // System.out.println("double remain : " + remain); ㄴ >>>>>> 나누어서 double값에 대입하는 경우 반드시 double을 추가하자 
	            // System.out.println("(int) remain : " + (int)remain);
	               int date= (int) Math.ceil(remain); // double형 remain을 int로 변환하기 전에 
	               									  // remain보다 크거나 같은 정수값으로 바꾼다. ex)2.3->3 으로 바꿈.

	            if (!q.isEmpty() && q.peek() < date) { // 즉 q가 비어있지 않고 q의 첫값이 다음 작업의 남은 일수인 data보다 작으면 
	            	answerList.add(q.size());		   // 현재의 q의 사이즈를 answerlist 배열에 넣고  
	                q.clear();						   // 큐인 q를 초기화한다. 
	               
	            } 
	              
	            // length   : 배열의 길이를 알고자할 때
	            // length() : 문자열의 길이를 알고자할 때  
	            // size()   : ArrayList, Queue 같은 컬렉션 프레임워크 타입의 길이를 알고자 할 때 

	            q.offer(date); // or q.add(date); 처음엔 큐가 비어 있으니 q에 바로 7값을 넣는다.  [7(q.peek()),3,/9]
	        }

	        answerList.add(q.size()); // 마지막으로 q에 들어간 date들의 사이즈(9)를 answerlist에 1로 추가한다. 

	        int[] answer = new int[answerList.size()]; // answer배열에 길이를 answerlist 크기만큼 할당하고
	        
	        
	        for (int i = 0; i < answer.length; i++) {
	            answer[i] = answerList.get(i); // answerlist의 값들을 순서대로 대입한다.
	        }

	        return answer;
	    }
	

	public static void main(String[] args) {
			int [] pro = {93, 30, 55};
			int [] spe = {1, 30, 5};
//			int [] pro = {95, 90, 99, 99, 80, 99};
//			int [] spe = {1, 1, 1, 1, 1, 1};
			
			
			int[] ans = solution(pro, spe);
			
			for(int i=0 ; i<ans.length;i++) {
				System.out.println(ans[i]);
			}
			
	}




}
