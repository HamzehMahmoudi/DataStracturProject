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
    public Node SearchByUnit(int unit ){/*TODO:SearchByUnit*/}
    public Node SearchByName(String name){/*TODO:SearchByName*/}
    public boolean RemoveByID(int id) {
        Node node = root;
        Node parent = root;
        boolean isLeft = true;
        while (node.ID != id) {
            parent = node;
            if (id < node.ID) {
                isLeft = true;
                node = node.left;
            } else {
                isLeft = false;
                node = node.right;
            }
            if (node == null)
                return false;
        }
        if (node.left == null && node.right == null) {
            if (node == root)
                root = null;
            else if (isLeft)
                parent.left = null;
            else
                parent.right = null;
        }
        else if (node.right == null) {
                if (node == root)
                    root = node.left;
                else if (isLeft)
                parent.left = node.left;
                parent.right = node.left;
        }
        else if (node.left == null) {
             if (node == root)
                root = node.right;
            else if (isLeft)
                parent.left = node.right;
            else
                parent.right = node.right;
        }

        else {
            Node replacement = getReplacementNode(node);
            if (node == root)
            root = replacement;
            else if (isLeft)
            parent.left = replacement;
            else
            parent.right = replacement;
            replacement.left = node.left;
        }
        return true;
    }
    public boolean RemoveBYUnit(int unit){/*TODO:RemoveByUnit */ return true;}
    public boolean RemoveByName(String name) {/*TODO:RemoveByName */ return true;}
    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.right;
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.left;
        }
        if (replacement != replacedNode.right) {
            replacementParent.left = replacement.right;
            replacement.right = replacedNode.right;
        }
        return replacement;
    }
}
