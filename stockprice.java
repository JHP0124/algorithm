package step01_StacknQueue;

import java.util.Stack;

public class stockprice {
	
	
	
	public static int[] solution(int[] prices) {
        /*2022-06-04(토)
        문제를 보면 이중 for문 같기도 한데.... 나중에 이중 for문으로 푼거를 추가하고 
        1주차 스택 큐 문제로 추천한 거라 일단 스택으로 풀어보자 
        첫 생성된 stack은 아예 비어 있다.
         이중for문으로도 풀수 있지만  문제를 풀게 될 경우 시간 복잡도는 O(n2)로 prices의 길이 범위가 10만이므로 
         최악의 경우 100억, 약 100초의 시간이 소요되게 되기에 이중FOR문으로는 무리. (1억당 1초라고 가정)
        */
        
        
        Stack<Integer> stack = new Stack<Integer>(); // Integer 타입의 스택 구조인 stack을 생성하고 
        int [] answer= new int [prices.length];//입력 받은 prices의 길이에 int타입 배열인 arr에 값을 저장하도록하자
        
        //for문을 prices 길이 만큼 반복하게 만들자
        for(int i =0; i<prices.length;i++){// 가격이 한번 떨어진 시점을 찾는다.
            while(!stack.isEmpty()) { // 처음엔 stack이 비어있고 i=0이라서 지나가고 두번째 i=1에서 진행.
            	System.out.println("while문1 시작=============");
            	System.out.println("stack peek값 :" + stack.peek()); // 확인용
            	System.out.println("i 값 : " + i);
            	
            	if(prices[stack.peek()] > prices[i]) { // 가격이 떨어지는 시점 찾기
            		answer[stack.peek()] = i - stack.peek(); // answer[2]= 3-2
            		System.out.println("answer[ "+stack.peek()+" stack.peek()] : "+answer[stack.peek()]);
            		stack.pop();  // stack의 맨 윗값인 2가 빠진다.
            	}
            	
            	else {
            		break; // 반복문을 종료한다. // return은 메서드를 종료 시킨다.
            	}
            }
           System.out.println("스택에 값 저장 : "+i);
            stack.push(i);	 // 인덱스 값 저장
        }
        // 끝까지 값이 떨어지지 않은 주식일 경우 
        while(!stack.isEmpty()) {
        	System.out.println("while 문 2 시작=============");
        	System.out.println("stack.peek() : " + stack.peek());
        	answer[stack.peek()] = prices.length - stack.peek() -1;
        	stack.pop();
        } 
        return answer;
    }
	
	public static void main(String[] args) {
//		int []arr = {1,2,3,2,3};			
		int []arr = {1,2,3,2,3,4,5};			
//		int []arr = {4,5,3,2,0,2,3,2};			
//		int []arr = {1,2,5,4,0,5,4,3};			
//		int []arr = {1,2,7,4,1,7,8,6,0};			
		int []ans=solution(arr);
		
		for(int i =0; i<arr.length;i++) {
		System.out.println( i+"번째"+ans[i]);
		}
	}

}
