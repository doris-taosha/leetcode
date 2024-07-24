package top150;

import java.util.*;


/***
 *
 *146. LRU 缓存
 * 设计一个遵循最近最少使用（LRU）缓存约束的数据结构。
 *
 * 实现LRUCache类：
 * LRUCache(int capacity)使用正数大小初始化 LRU 缓存capacity。
 * int get(int key)key如果键存在则返回值，否则返回-1。
 * void put(int key, int value)key如果存在，则更新的值key。否则，将该对添加到缓存中。如果此操作导致key-value键的数量超过，则逐出最近最少使用的键。capacity
 * 函数get和必须以平均时间复杂度put运行。O(1)
 *
 */
public class H11_146_LRUCache {

    int capacity;

    private Map<Integer, Node> cacheMap;

    private Node head ;

    private Node tail ;

    public H11_146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;
        put(key, cacheMap.get(key).value);

        return cacheMap.get(key).value;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            remove(cacheMap.get(key));
        }
        if (cacheMap.size() >= capacity) {
            remove(tail.prev);
        }
        Node newNode = new Node(key, value);
        cacheMap.put(key, newNode);
        insert(newNode);
    }

    public void remove(Node node) {
        cacheMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}