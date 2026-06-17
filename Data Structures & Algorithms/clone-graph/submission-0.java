/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        if (node.neighbors.isEmpty()) return new Node();
        
        Map<Node, Set<Node>> adjMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> nodeMap = new HashMap<>();
        
        stack.push(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            nodeMap.put(cur, new Node(cur.val));
            if (visited.contains(cur)) {
                continue;
            }
            visited.add(cur);
            for (Node n: cur.neighbors) {
                Set<Node> set = adjMap.computeIfAbsent(cur, k -> new HashSet<>());
                set.add(n);
                stack.push(n);
            }
        }
        
        for (Node key: adjMap.keySet()) {
            for (Node n: adjMap.get(key)) {
                nodeMap.get(key).neighbors.add(nodeMap.get(n));
            }
        }

        return nodeMap.get(node);
    }
}