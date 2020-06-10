package L5Q2;

public class Q2ListNode<T> {
    private T data;
    private Q2ListNode link;

    public Q2ListNode() {
        this.data = null;
        this.link = null;
    }

    public Q2ListNode(T data, Q2ListNode link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Q2ListNode getLink() {
        return link;
    }

    public void setLink(Q2ListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "<--"+data;
    }
}
