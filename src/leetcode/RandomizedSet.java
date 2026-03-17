package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

//O(1) -> LinkedList 추가 삭제, HashMap.. 해시 충돌 없다고 하면 평균 O(1)
//하지만, getRandom 은 할수 없음. 배열에 들어 있어야 사이즈 기준으로 랜덤 돌려서..
//GetRandom 을 어떻게 hashMap 할 수 없다.
//remove 는 O(N)..
//indexing -> hashMap || 찾기: 맨뒤에 있는애 &내가 삭제하고자 하는애의 위치 바꾸기.
//LRU CACHE 도 여러 자료구조 섞어서 O(1)을 보장..

class RandomizedSet {
    List<Integer> numbers = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int cnt = 0; //호출횟수

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.get(val)!=null) return false;
        else {
            numbers.add(val);
            map.put(val, numbers.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        }

        int lastVal = numbers.get(numbers.size()-1);
        int index = map.get(val);
        //삭제할 값 Index에 lastVal넣기. 이렇게 함으로써 해당 값이 제거됨.
        numbers.set(index, lastVal);
        //위치 갱신해주기
        map.put(lastVal, index);
        //
        numbers.remove(numbers.size()-1); //removeByIndex
        map.remove(val);
        return true;
    }

    //0 이상 list.size() 미만의 랜덤 숫자 생성해서 조회
    public int getRandom() {
        return numbers.get(ThreadLocalRandom.current().nextInt(numbers.size()));
    }
}
