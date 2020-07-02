package interview;


public class StackedQueue<E>{
    
   Node<E> top;
   private int size;
   
   public StackedQueue(){
       this.size = 0;
       this.top = null;
   }
   
   public void enqueue(E item){
       Node<E> node = new Node<E>(item);
      
           node.next = top;
           top = node;
           
       size++;
   }
   
   public E dequeue(){
       E retval = top.item;
       
       if(top == null){
           retval = null;
       }

        retval = top.item;
        top = top.next;

        size--;
        return retval;
   }
   
   public boolean empty(){
       return top == null;
   }
   
   public int size(){
       return size;
   }
   
    
}
