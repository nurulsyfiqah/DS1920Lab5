package L5Q1;

public class Q1Stack<T> {
    private Q1ListNode head;

    public Q1Stack() {
        this.head = null;
    }

    public int getSize(){
        int count=0;
        Q1ListNode current=head;
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
        head = new Q1ListNode(a,head);
    }

    public T pop(){
        if(head==null)return null;
        else {
            T temp=(T)head.getData();
            head=head.getLink();
            return temp;
        }
    }

    public T peek(){
        if(head==null)return null;
        else
            return (T)head.getData();
    }

    public void showStack(){
        if (head==null){
            System.out.println("Empty Stack");
        }else{
            Q1ListNode current=head;
            while(current!=null){
                System.out.print(current.toString());
                current=current.getLink();
            }
        }
    }
}
