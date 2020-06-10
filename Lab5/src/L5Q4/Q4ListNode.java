package L5Q4;

public class Q4ListNode<T> {
    private T data;
    private Q4ListNode link;

    public Q4ListNode() {
        this.data = null;
        this.link = null;
    }

    public Q4ListNode(T data, Q4ListNode link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Q4ListNode getLink() {
        return link;
    }

    public void setLink(Q4ListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return data+" ";
    }
}
