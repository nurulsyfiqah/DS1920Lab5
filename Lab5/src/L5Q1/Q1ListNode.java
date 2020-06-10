package L5Q1;

public class Q1ListNode<T> {
    private T data;
    private Q1ListNode link;

    public Q1ListNode() {
        this.data = null;
        this.link = null;
    }

    public Q1ListNode(T data, Q1ListNode link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Q1ListNode getLink() {
        return link;
    }

    public void setLink(Q1ListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return " <-- "+data;
    }
}
