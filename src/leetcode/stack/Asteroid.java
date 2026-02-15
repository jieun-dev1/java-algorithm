package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class Asteroid {

    //뒤에서부터 밀고 들어옴.
    //하나의 행동 하고 나면, 뒤의 행동은 똑같다. 소행성 들어온 인풋 하나가 여러개 깸.
    //한번에 하나씩 깨면,, 더 간단해짐 (iteration 을 해서 지저분해짐)
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid: asteroids) {
            boolean alive = true; //asteroid is alive
            while (alive && !stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int peeked = stack.peek();
                if (Math.abs(asteroid) > peeked) {
                    stack.pop();
                } else if (Math.abs(asteroid) == peeked) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            //
            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        // deque's head is the stack's top
        //if  stream() then, it will return from the last one.
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;

    }

}
