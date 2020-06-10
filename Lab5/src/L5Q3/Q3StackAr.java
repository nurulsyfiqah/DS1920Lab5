package L5Q3;
import java.util.ArrayList;

public class Q3StackAr<T> {

        private ArrayList<T> list = new ArrayList<>();

        public boolean isEmpty(){
            return list.isEmpty();
        }

        public int size(){
            return list.size();
        }
        public T peek(){
            return list.get(size() - 1);
        }

        public T pop(){
            T o;
            o = list.get(size() -1);
            list.remove(size() - 1);
            return o;
        }

        public void push(T o){
            list.add(o);
        }

        public T get(T index){
            return list.get((int)index);
        }

        @Override
        public String toString() {
            return "stack " + list.toString();
        }
    }

