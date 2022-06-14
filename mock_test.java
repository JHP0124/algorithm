package step02_Search;

import java.util.*;

public class mock_test {
	
	
	  public static int[] solution(int[] answers) {
	        int[] answer = {};
	        int[] p1 = {1,2,3,4,5}; //각 수포자패턴 // 수포자 1 패턴
	        int[] p2 = {2,1,2,3,2,4,2,5}; // 수포자 2 패턴
	        int[] p3 = {3,3,1,1,2,2,4,4,5,5}; // 수포자 3 패턴
	        int a1=0, a2 =0, a3 =0; // 수포자 1,2,3 별 정답 카운트
	        
	        for(int i =0; i<answers.length; i++){
	            if(p1[i%p1.length] == answers[i]) a1++; // 수포자 패턴 길이로 나눠서 나머지 값을 기반으로 한 p1[배열값]과  
	            if(p2[i%p2.length] == answers[i]) a2++; // 문제(answers)배열 값을 매칭하여 각 수포자별 맞춘 횟수를 카운트함.
	            if(p3[i%p3.length] == answers[i]) a3++;
	        }
	        int max = Math.max(Math.max(a1, a2),a3); // Math.max 함수로 최대값을 구하고 
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        if(max==a1) list.add(1); //max값이랑 순서대로 넣는다.
	        if(max==a2) list.add(2);
	        if(max==a3) list.add(3);
	        
	        answer = new int[list.size()]; // 해당 list 크기만큼 answer배열에 대입함.
	        
	        for(int i =0; i<answer.length; i++) { // answer 길이만큼 반복해서 list 값을 순서대로 answer배열에 대입함. 
	        	answer[i] = list.get(i);
	        }
	        
	        return answer;
	    }
	
	/*for문 문제길이에 맞춰서 하고 각 수포자 별로 for문을 문제길이만큼 배열에 반복해서 진행. 각 수포자 for문마다 정답answer배열과 비교하고 카운트해서 
	 수포자별로 많이 맞문 사람은 한명만 출력. / 결과 값이 수포자들의 결과값이 같으면 순서대로 list에 저장해서 동시 출력 */
	/*1, 2, 3, 4, 5*/
	/*2, 1, 2, 3, 2, 4, 2, 5*/
	/*3, 3, 1, 1, 2, 2, 4, 4, 5, 5*/
	
	
	
	

	public static void main(String[] args) {

		int[] answers = {1,3,2,4,2};
		int[] result= {};
		result = solution(answers);
		
		for(int i : result)
		System.out.print(i);
		
	}
	
	
	
	

}
