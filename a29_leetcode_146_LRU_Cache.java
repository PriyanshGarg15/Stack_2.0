//this question is not of stack or queues but taught here !


import java.util.HashMap;

public class a29_leetcode_146_LRU_Cache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private HashMap<Integer, Node> cacheMap;
    private int capacity;
    private Node head, tail;

    public a29_leetcode_146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            remove(node);
            insertAtFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
        } else {
            if (cacheMap.size() == capacity) {
                cacheMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            insertAtFront(newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        a29_leetcode_146_LRU_Cache lruCache = new a29_leetcode_146_LRU_Cache(2); // Instantiate the LRUCache object
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // should print 1
        lruCache.put(3, 3); // LRU key 2 is evicted
        System.out.println(lruCache.get(2)); // should print -1 (evicted)
        lruCache.put(4, 4); // LRU key 1 is evicted
        System.out.println(lruCache.get(1)); // should print -1 (evicted)
        System.out.println(lruCache.get(3)); // should print 3
        System.out.println(lruCache.get(4)); // should print 4
    }
}
