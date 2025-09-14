class AVLNode {
    int key,height;
    AVLNode left,right;
    AVLNode(int d){key=d;height=1;}
}

public class day75_avl_tree {
    AVLNode root;

    int height(AVLNode N){return N==null?0:N.height;}
    int getBalance(AVLNode N){return N==null?0:height(N.left)-height(N.right);}

    AVLNode rightRotate(AVLNode y){
        AVLNode x=y.left; AVLNode T2=x.right;
        x.right=y; y.left=T2;
        y.height=Math.max(height(y.left),height(y.right))+1;
        x.height=Math.max(height(x.left),height(x.right))+1;
        return x;
    }

    AVLNode leftRotate(AVLNode x){
        AVLNode y=x.right; AVLNode T2=y.left;
        y.left=x; x.right=T2;
        x.height=Math.max(height(x.left),height(x.right))+1;
        y.height=Math.max(height(y.left),height(y.right))+1;
        return y;
    }

    AVLNode insert(AVLNode node,int key){
        if(node==null) return new AVLNode(key);
        if(key<node.key) node.left=insert(node.left,key);
        else if(key>node.key) node.right=insert(node.right,key);
        else return node;
        node.height=1+Math.max(height(node.left),height(node.right));
        int balance=getBalance(node);
        if(balance>1 && key<node.left.key) return rightRotate(node);
        if(balance<-1 && key>node.right.key) return leftRotate(node);
        if(balance>1 && key>node.left.key){node.left=leftRotate(node.left); return rightRotate(node);}
        if(balance<-1 && key<node.right.key){node.right=rightRotate(node.right); return leftRotate(node);}
        return node;
    }

    void preOrder(AVLNode node){
        if(node!=null){
            System.out.print(node.key+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args){
        day75_avl_tree tree=new day75_avl_tree();
        tree.root=tree.insert(tree.root,10);
        tree.root=tree.insert(tree.root,20);
        tree.root=tree.insert(tree.root,30);
        tree.root=tree.insert(tree.root,40);
        tree.root=tree.insert(tree.root,50);
        tree.preOrder(tree.root);
    }
}
