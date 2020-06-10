package L5Q6;

public class Q6ListNode<T> {
    private T data;
    private Q6ListNode link;

    public Q6ListNode() {
        this.data = null;
        this.link = null;
    }

    public Q6ListNode(T data, Q6ListNode link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Q6ListNode getLink() {
        return link;
    }

    public void setLink(Q6ListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return " <-- "+data;
    }
}
