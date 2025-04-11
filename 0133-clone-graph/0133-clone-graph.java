/*
// Definition for a Node.
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
    public Node cloneUtil(Node node,HashMap<Node,Node> hm){
        Node newNode = new Node(node.val);
        hm.put(node,newNode);
        for(Node neighbor : node.neighbors){
        if(!hm.containsKey(neighbor)){
            newNode.neighbors.add(cloneUtil(neighbor,hm));
        }else{
            newNode.neighbors.add(hm.get(neighbor));
        }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Node,Node> hm = new HashMap<>();
        return cloneUtil(node,hm);
    }
}