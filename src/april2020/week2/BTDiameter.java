package april2020.week2;


/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class BTDiameter {
    static int diameter = Integer.MIN_VALUE;
    public static Node insert(Node root, int value) {
        if(root == null) return new Node(value);

        if(value < root.value) {
            root.left = insert(root.left, value);
        }
        if(value > root.value) {
            root.right = insert(root.right, value);
        }
        return root;
    }
    public static int findMaxDepth(Node root) {
        if(root == null) return 0;
        return 1 + Math.max(findMaxDepth(root.left), findMaxDepth(root.right));
    }

    /**
     * This approach depends on 3 assumptions:
     * 1. The diameter is just the height of left subtree + height of right subtree of a given node
     * 2. The diameter may pass through the root
     * 3. The diameter may not pass through the root
     * We compute the diameter in both cases, since we wouldn't know before hand
     * which case we are dealing with.
     * Then we return the max of both as the final_diameter
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * @param root
     * @return diameter
     */
    public static int computeDiameter(Node root) {
        if(root == null) return  0;
        // for each node, go all the way left and right
        // add the length during the process
        // the diameter is the highest
        int diameterThroughRoot = findMaxDepth(root.left) + findMaxDepth(root.right) ;
        int lDiameter = computeDiameter(root.left);
        int rDiameter = computeDiameter(root.right);

        int final_diameter = Math.max(diameterThroughRoot, Math.max(lDiameter, rDiameter)) ;

        return final_diameter;
    }

    // Optimized solution

    /**
     * This approach uses the post order traversal of a BT
     * We start from the bottom and return the height of subtree rooted at a given node
     * to its parent node. 🎨
     * During the process, we keep a global 'diameter' variable that we update,
     * each time the diameter of the subtree rooted at a given node is greater than the
     * current stored diameter.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param node
     * @return
     */
    public static int depthFS(Node node) {
        // we are returning -1 so as to not count the leaf node as part of the height
        if(node == null) return -1; // when you get to a leaf node, subtract 1 from height so as not to count it.
        // compute leftHeight
        int leftHeight = 1 + depthFS(node.left); // count height by adding 1 for each level
        //compute rightHeight
        int rightHeight = 1 + depthFS(node.right);
        // compute the diameter of subtree rooted at the given node
        // diameter of subtree rooted at the given node = leftHeight + rightHeight
        diameter = Math.max(diameter, leftHeight + rightHeight);
        // return the height of subtree rooted at the given node
        return Math.max(leftHeight, rightHeight);
    }

    public static int diameterOfBT(Node root) {
        if(root ==  null) return 0;
        depthFS(root);
        return diameter;
    }


    public static void main(String[] args) {
        int[] keys = {1, 3, 2, 5, 4};

        Node root = null;

        for(int key: keys) {
            root = insert(root, key);
        }

        System.out.println("Diameter is: " + computeDiameter(root));
    }
}
