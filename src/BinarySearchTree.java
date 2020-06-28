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
}
