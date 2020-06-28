public class BinarySearchTree {
    class Node{
        String FirstName , LastName ;
        int ID;
        Node left,right;

        public Node(int ID , String firstName, String lastName ) {
            FirstName = firstName;
            LastName = lastName;
            this.ID = ID;
            this.right=null;
            this.right=null;
        }
    }
    Node root;


    public BinarySearchTree() {
        this.root = null;
    }
    public void Insert(int id , String fname , String lname){
        Node node=new Node(id,fname,lname);
        if(root==null){
            root=node;
        }
        Node temproot = root;
        Node parent;
        while (true){
            parent=temproot;
            if (id<=temproot.ID) {
                temproot = temproot.left;
                if (temproot==null){
                    parent.left=node;
                }

            }else {
                temproot = temproot.right;
                if (temproot==null){
                    parent.right = node;
                }
            }


        }

    }
    public void InOrder(Node node){
        if (node!=null){
            InOrder(node.left);
            System.out.printf("%d ,",node.ID);
            InOrder(node.right);
        }
    }
    public void preOrder(Node node){
        if (node!=null){
            System.out.printf("%d ,",node.ID);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void postOrder(Node node){
        if (node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.printf("%d ,",node.ID);
        }
    }
}
