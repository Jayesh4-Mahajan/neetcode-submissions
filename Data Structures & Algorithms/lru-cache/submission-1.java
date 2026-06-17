public class Node {
    int key;
    int val;
    Node left;
    Node right;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class LRUCache {

    private int cap;
    private Node left;
    private Node right;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        cap = capacity;
        left = new Node(-1, -1);
        right = new Node(-1, -1);
        left.right = right;
        right.left = left;
        map = new HashMap<>();
    }

    private void remove(Node node) {
        Node prev = node.left;
        Node nxt = node.right;
        prev.right = nxt;
        nxt.left = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.left;
        prev.right = node;
        node.left = prev;
        node.right = this.right;
        this.right.left = node;

    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if (map.size() > cap) {
            Node lru = this.left.right;
            remove(lru);
            map.remove(lru.key);
        }
        
    }
}
