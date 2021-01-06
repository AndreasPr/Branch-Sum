import java.util.ArrayList;
import java.util.List;

/**
 * Created on 06/Jan/2021 to BranchSums
 */
public class branchSums {

    static class Node{
        int data;
        Node left, right;
    }

    static Node newNode(int data){
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    public static List<Integer> branchSums(Node root){
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    private static List<Integer> calculateBranchSums(Node node, int sum, List<Integer> sums){
        if (node == null){
            return sums;
        }
        sum = sum + node.data;

        if(node.left == null && node.right == null){
            //We are on a leaf node
            sums.add(sum);
        }

        if(node.left != null){
            calculateBranchSums(node.left, sum, sums);
        }

        if(node.right != null){
            calculateBranchSums(node.right, sum, sums);
        }
        return sums;
    }

    public static void main(String args[]){
        Node root = newNode(2);
        root.left = newNode(7);
        root.right = newNode(5);
        root.left.left = newNode(2);
        root.left.right = newNode(6);
        root.right.right = newNode(9);
        root.left.right.left = newNode(5);
        root.left.right.right = newNode(11);
        root.right.right.left = newNode(4);

        System.out.println(branchSums(root));
    }

}
