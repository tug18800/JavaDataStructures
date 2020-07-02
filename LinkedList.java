package interview;

public class LinkedList<E>{
    
    Node<E> head;
    private int size;
    
    
    
    public LinkedList(){
        this.size = 0;
        this.head = null;
    }
    
    public boolean add(E item){
        add(size, item);
        return true;
    }
    
    private void add(int index, E item) {
        if(index < 0 || index > size){
            System.err.println("This index is out of bounds!");
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        Node<E> node = new Node<E>(item);
 
        if(index == 0){
            node.next = head;
            head = node;
        }
        else{
            Node<E> prev = getNode(index - 1);
            node.next = prev.next;
            prev.next = node;
        }
        
        size++;
    }
    
    public E remove(int index){
        if(index < 0 || index > size){
            System.err.println("This index is out of bounds!");
            throw new ArrayIndexOutOfBoundsException(index);
        }
        
        E retval = null;
        
        if(size == 0){
            System.err.println("There is no data within this list!");
        }
        else if(index == 0){
            retval = head.item;
            head = head.next;
        }
        else{
            Node<E> prev = getNode(index-1);
            retval = prev.next.item;
            prev.next=prev.next.next;
        }
        
        size--;
        return retval;
    }
    
    public Node<E> getNode(int index){
        if(index < 0 || index > size){
            System.err.println("This index is out of bounds!");
            throw new ArrayIndexOutOfBoundsException(index);
        }
        Node<E> current = head;
        
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current;
    }
    
    public int size(){
        return size;
    }
    
    public E get(int index){
        return getNode(index).item;
    }
    
    public String toString(){
        String str = "";
        Node<E> current = head;
        
        for(int i = 0 ; i < size; i++){
            if(current.next == null){
                str = str + current.item.toString();
            }
            else{
            str = str + current.item.toString() + " ==> ";
            current = current.next;
            }
        }
        
        return str;
    }
}
