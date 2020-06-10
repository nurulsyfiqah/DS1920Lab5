package L5Q2;

public class Q2Stack<T> {
    private Q2ListNode head;

    public Q2Stack() {
        this.head = null;
    }

    public boolean isEmpty(){
        return(head==null);
    }

    public int getSize(){
        Q2ListNode current=head;
        int count=0;
        while(current!=null){
            current=current.getLink();
            count++;
        }
        return count;
    }

    public void push(T a){
        head=new Q2ListNode(a,head);
    }

    public T pop(){
        if(head==null)return null;
        else{
            T temp=(T)head.getData();
            head=head.getLink();
            return temp;
        }
    }

    public T peek(){
        if(head==null)return null;
        else{
            return (T)head.getData();
        }
    }

    public void showStack(){
        if(head==null){
            System.out.println("Empty Stack");
        }else{
            Q2ListNode current=head;
            while(current!=null){
                System.out.print(current+" ");
                current=current.getLink();
            }
        }
    }
}
