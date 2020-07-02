package interview;

public class BST<E extends Comparable<E>>{
    
    Node<E> root;
    private int size;
    
    public BST(){
        this.size = 0;
    }
    
    public boolean add(E item){
        this.root = add(this.root, item);
        size++;
        return true;
    }

    private Node<E> add(Node<E> root, E item) {
        if(root == null){
            return new Node<E>(item);
        }
        else if(item.compareTo(root.item) < 0){
            root.left = add(root.left, item);
            return root;
        }
        else{
            root.right = add(root.right, item);
            return root;
        }   
    }
    
    public void delete(E item){
        this.root = delete(this.root, item);
    }

    private Node<E> delete(Node<E> root, E item) {
        if(root == null){
            return null;
        }
        
        if(item.compareTo(root.item) < 0){
            root.left = delete(root.left, item);
            return root;
        }
        if(item.compareTo(root.item) > 0){
            root.right = delete(root.right, item);
            return root;
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left != null && root.right == null){
                return root.left;
            }
            else if(root.left == null && root.right != null){
                return root.right;
            }
            else{
                if(root.left.right == null){
                    Node<E> grand = root.left;
                    grand.right = root.right;
                    return grand;
                }
                else{
                    Node<E> parent = root.left;
                    Node<E> grand = parent.right;
                    while(grand.right !=null){
                        grand = grand.right;
                        parent = parent.right;
                    }
                    
                    root.item = parent.item;
                    parent.right = grand.left;
                    return root;
                }
            }
        }
    }
    
    public boolean contains(E item) {
		return contains(this.root, item);
	}

	public boolean contains(Node<E> root, E item) {
		if(root==null) {
			return false;
		}

		if(item.compareTo(root.item) == 0) {
			return true;
		} else if(item.compareTo(root.item) < 0) {
			return contains(root.left, item);
		} else {
			return contains(root.right, item);
		}
	}
        
        public int size() {
		return size(root);
	}

	public int size(Node<E> root) {
		if(root== null) {
			return 0;
		}
		int leftSize = size(root.left);
		int rightSize= size(root.right);
		int mySize  = 1;

		return leftSize +rightSize + mySize;

	}
        
        
        public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}


	private void preOrderTraverse(Node<E> root, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("  "); // indentation
		}
		if (root == null) {
			sb.append("null\n");
		} else {
			sb.append(root.item.toString());
			sb.append("\n");
			preOrderTraverse(root.left, depth + 1, sb);
			preOrderTraverse(root.right, depth + 1, sb);
		}
	}
        
        public E largestSmall(){
            E biggest = root.left.item;
            
            return largestSmall(root.left, biggest);
        }

    private E largestSmall(Node<E> root, E biggest) {
        if(root.right == null && root.item.compareTo(biggest) >= 0){
            return biggest = root.item;
        }
            return largestSmall(root.right, biggest);
    }




	public String toString(Node<E> root) {
		if(root == null) {
			return "";
		}

		String leftSide = toString(root.left);
		String rightSide = toString(root.right);
		String mySide = root.item.toString();

		return  mySide +"\n" +leftSide +"\n" + rightSide;

	}

   
    
}
