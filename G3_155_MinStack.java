package top150;


import java.util.LinkedList;
import java.util.Stack;

/**
 *155. 最小堆栈

 * 设计一个支持入栈、出栈、顶栈以及在常数时间内检索最小元素的堆栈。
 *
 * 实现MinStack类：
 * MinStack()初始化堆栈对象。
 * void push(int val)将元素推val入堆栈。
 * void pop()移除堆栈顶部的元素。
 * int top()获取堆栈顶部元素。
 * int getMin()检索堆栈中的最小元素。
 * O(1)您必须为每个函数实现一个具有时间复杂度的解决方案。
 *
 * 示例 1：
 *
 * 输入
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[],[]]
 *
 * 输出
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释
 * MinStack minStack = new MinStack();
 * 最小堆栈.推(-2);
 * 最小堆栈.推(0);
 * 最小堆栈.推(-3);
 * 最小堆栈.getMin(); // 返回 -3
 * 最小堆栈.pop()；
 * minStack.top(); // 返回 0
 * 最小堆栈.getMin(); // 返回 -2
 *
 */

public class G3_155_MinStack {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    public G3_155_MinStack(){
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }
    public void push(int val) {
        dataStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(!dataStack.isEmpty()){
            int needRemoved = dataStack.pop();
            if(needRemoved == minStack.peek()) minStack.pop();
        }
    }

    public int top() {
        return  dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
