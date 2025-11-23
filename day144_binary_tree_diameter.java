class NodeD {
    int data;
    NodeD left, right;
    NodeD(int d) { data = d; }
}

public class day144_binary_tree_diameter {

    static class Height {
        int h;
    }

    public static int diameter(NodeD root, Height height) {
        if (root == null) {
            height.h = 0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int ldiameter = diameter(root.left, lh);
        int rdiameter = diameter(root.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;

        int rootDiameter = lh.h + rh.h + 1;

        return Math.max(rootDiameter, Math.max(ldiameter, rdiameter));
    }

    public static void main(String[] args) {
        NodeD root = new NodeD(1);
        root.left = new NodeD(2);
        root.right = new NodeD(3);
        root.left.left = new NodeD(4);
        root.left.right = new NodeD(5);

        Height ht = new Height();
        System.out.println("Diameter of Tree: " + diameter(root, ht));
    }
}
