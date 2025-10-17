import java.util.*;

class Solution {
    private static HashMap<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        
        for(int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }
        
        return answer;
    }
    
    private static long findRoom(long room) {
        if(!map.containsKey(room)) {
            map.put(room, room+1);
            return room;
        }
        
        long nextRoom = map.get(room);
        long emptyRoom = findRoom(nextRoom);
        map.put(room, emptyRoom);
        return emptyRoom;
    }
}