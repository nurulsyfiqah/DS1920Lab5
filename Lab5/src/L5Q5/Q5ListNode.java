package L5Q5;

public class Q5ListNode<T> {
    private T data;
    private Q5ListNode link;

    public Q5ListNode() {
        this.data = null;
        this.link = null;
    }

    public Q5ListNode(T data, Q5ListNode link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Q5ListNode getLink() {
        return link;
    }

    public void setLink(Q5ListNode link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return " <-- "+data;
    }
}
