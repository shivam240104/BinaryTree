
public class Diameter {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
     }
    //  approach -1 
     public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftDia =diameter(root.left);
            int leftht = height(root.left);
            int rightDia =diameter(root.right);
            int rightht = height(root.right);

            int selfDia = leftht + rightht +1;

            return Math.max(selfDia, Math.max(leftDia,rightDia));
        }
//  Approach - 2
static class Info{
    int diam;
    int ht;
    public Info (int diam,int ht){
        this.diam=diam;
        this.ht = ht;

    }
}
public static Info diameter2(Node root){
    Info leftInfo= diameter2(root.left);
    Info rightInfo = diameter2(root.right);
    int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht +1);
    int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
    return new Info(diam, ht);
}
        public static void main(String[] args) {
            Node root= new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
           System.out.println(diameter2(root).diam);
           
        }
}
