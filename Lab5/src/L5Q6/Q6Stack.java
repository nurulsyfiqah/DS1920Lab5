package L5Q6;


public class Q6Stack<T> {
    private Q6ListNode head;

    public Q6Stack() {
        this.head = null;
    }

    public int size(){
        Q6ListNode current=head;
        int count=0;
        while(current!=null){
            current=current.getLink();
            count++;
        }
        return count;
    }

    public boolean isEmpty(){
        return(head==null);
    }

    public void push(T a){
        Q6ListNode current = new Q6ListNode();
        current.setData(a);
        current.setLink(head);
        head = current;
    }

    public T pop(){
        if(head==null) return null;
        else {
            T temp=(T)head.getData();
            head=head.getLink();
            return temp;
        }
    }

    public T peek(){
        return (T)head.getData();
    }

    public void showStack(){;
        if(head==null){
            System.out.println("Empty Stack");
        }else{
            Q6ListNode current=head;
            while(current!=null){
                System.out.print(current.toString());
                current=current.getLink();
            }
        }
    }
}
