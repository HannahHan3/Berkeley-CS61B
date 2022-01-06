

public class LinkedListDeque<T> {

    private class StuffNode{
        private StuffNode prev;
        private T item;
        private StuffNode next;

        public StuffNode(T item,StuffNode prev, StuffNode next){
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }
    private int size;
    private StuffNode sentinel;
    /* construct an empty LinkedlistDeque*/

    public LinkedListDeque(){
        this.sentinel = new StuffNode(null,null,null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;

    }

    public void addFirst(T item){

        StuffNode first = new StuffNode(item,sentinel,sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;


    }

    public void addLast(T item){
        StuffNode last = new StuffNode(item,sentinel.prev,sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;

    }

    public boolean isEmpty(){
        return size == 0;

    }

    public int size(){
        return size;

    }

    public void printDeque(){
        StuffNode target = sentinel.next;
        System.out.print("( ");
        for (int i=0; i<size; i++){
            System.out.print(target.item+" ");
            target = target.next;

        }
        System.out.println(")");


    }

    public T removeFirst(){
        if (sentinel.next == null){
            return null;
        }
        StuffNode removeFirst = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return removeFirst.item;
    }

    public T removeLast(){
        if (sentinel.next == null){
            return null;
        }
        StuffNode removeLast = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return removeLast.item;

    }

    public T get(int index){
        if (sentinel.next == null){
            return null;
        }
        StuffNode target = sentinel.next;
        for (int i=0; i != index; i++){
            target = target.next;
            if (i == index){
                return target.item;
            }

        }
        return null;

    }


}