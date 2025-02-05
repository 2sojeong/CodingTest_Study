import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> num = new ArrayList<>();
        
        int[] answer = {0,0};
        
        for(int i = 0; i < operations.length; i++){
            String[] temp = operations[i].split(" ");
            
            if(temp[0].equals("D")){
                if(temp[1].equals("1") && !num.isEmpty()) {
                  
                    num.remove(num.size()-1);
                    }
                
                if(temp[1].equals("-1") && !num.isEmpty()) {
                    num.remove(0);
                  
                }
            }
            
            else if (temp[0].equals("I")){
                num.add(Integer.parseInt(temp[1]));
                Collections.sort(num);
    
            }
        }
        
        if(num.size()!=0) {
            answer[1] = num.get(0);
            answer[0] = num.get(num.size()-1); 
                           }
        
        return answer;

    }
}



//         //오름차순 큐, 1 2 3 4
//         PriorityQueue<Integer> min = new PriorityQueue<>();
//         //내림차순 큐, 4 3 2 1
//         PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
//         int[] answer = {0,0};
        
//         for(int i = 0; i < operations.length; i++){
//             String[] temp = operations[i].split(" ");
//             if(temp[0].equals("D")){
//                 //최댓값 삭제
//                 if(temp[1] == "1" && !max.isEmpty()){
//                     max.poll();
//                 }
                
//                 //최솟값 삭제
//                 if(temp[1] == "-1" && !min.isEmpty()){
//                     min.poll();
//                 }
//             }
//             else if(temp[0].equals("I")){
//                 min.offer(Integer.parseInt(temp[1]));
//                 max.offer(Integer.parseInt(temp[1]));
//                 System.out.println(i);
//                 System.out.println(min);
//                 System.out.println(max);
//                 System.out.println("===============");
//             }
            

//         }
        
//         if(!max.isEmpty() && !min.isEmpty()){
//             answer[0] = max.poll();
//             answer[1] = min.poll();
//         }
//         return answer;