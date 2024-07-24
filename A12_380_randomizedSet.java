package top150;
import java.util.*;

/**
 * 380. 插入删除获取随机数 O(1)
 * 实现RandomizedSet类：
 *
 * RandomizedSet()初始化RandomizedSet对象。
 * bool insert(int val) 如果不存在就插入，返回true,否则就返回false
 * bool remove(int val) 如果存在则从集合中移除,返回true, 否则就返回false
 * int getRandom()从当前元素集中返回一个随机元素（调用此方法时保证至少存在一个元素）。每个元素被返回的概率必须相同。
 * 您必须实现该类的函数，使得每个函数都以 平均 O(1) 时间复杂度运行。
 */


public class A12_380_randomizedSet {

    int len;

    Map<Integer, Integer> map; // 存放对应的索引
    List<Integer> list; //存放元素

    A12_380_randomizedSet(){
        len = 0;
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            list.add(val);
            len++;
            map.put(val,len - 1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            list.set(index , list.get(len - 1));
            map.put(list.get(index), index );
            list.remove(len - 1);
            len--;
            map.remove(val);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(len));
    }
}
