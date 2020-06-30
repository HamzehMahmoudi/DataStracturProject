public class BinarySearchTree {
    class Node{
        String Name;
        int ID,Unit;
        Node left,right;

        public Node(int ID , int unit , String name) {
            Name = name;
            right=null;
            left=null;
            this.ID = ID;
            Unit=unit;

        }
    }
    Node root;


    public BinarySearchTree() {
        this.root = null;
    }
    public void Insert(int id ,int unit ,String name ){
        Node node=new Node(id,unit,name);
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
    public Node SearchById(int id ){
        Node temp = root;
        while (temp.ID!=id){
            if (id <= temp.ID) {
                temp = temp.left;
            }else {
                temp = temp.right;
            }
            if (temp==null)
                return null;
        }
        System.out.printf("id : %d  Name : %s and Unit count : %d", temp.ID, temp.Name,temp.Unit);
        return temp;
    }

}
