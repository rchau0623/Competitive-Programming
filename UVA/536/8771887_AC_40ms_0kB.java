import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        char[] preorder;
        char[] inorder;
        while ((s = br.readLine()) != null) {
            String[] in = s.split("\\s+");
            preorder = in[0].toCharArray();
            inorder = in[1].toCharArray();
            f(preorder, inorder, inorder.length);
            System.out.println("");
        }
    }

    public static void f(char[] preorder, char[] inorder, int x) {
        int root = search(inorder, preorder[0], x);
        if (root != 0) {
            f(Arrays.copyOfRange(preorder,1, preorder.length), inorder, root);
        }
        if (root != x-1) {
            f(Arrays.copyOfRange(preorder,root+1, preorder.length), Arrays.copyOfRange(inorder,root+1, inorder.length), x-root-1);
        }
        System.out.print(preorder[0]);
    }

    public static int search(char inorder[], char a, int x) {
        for (int i = 0; i < x; i++) {
            if (inorder[i] == a) return i;
        }
        return -1;
    }
}
