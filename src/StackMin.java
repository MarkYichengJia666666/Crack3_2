import java.util.EmptyStackException;

/**
 * Created by jiayicheng on 17/7/26.
 */
public class StackMin {
    public class Mystack<T>
    {
        private class StackNode<T>
        {
            private T data;
            private StackNode<T> next;
            public StackNode(T data){
                this.data=data;
            }
        }

        private StackNode<T> top;

        public T pop(){
            if(top==null ) throw new EmptyStackException();
            T item=top.data;
            top=top.next;
            return item;
        }

        public void push(T item)
        {
            StackNode<T> t=new StackNode<T>(item);
            t.next=top;
            top=t;
        }

        public T peek(){
            if(top==null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty()
        {
            return top ==null;
        }
    }


    public class StackMIn extends Mystack<NodewithMin>
    {

        public void push(int value)
        {
         int newMin=Math.min(value,min());
         super.push(new NodewithMin(value,newMin));
        }
        public int min(){
        if(this.isEmpty()){ return Integer.MAX_VALUE;}
        else
        {return peek().min;}
        }
    }

    public class NodewithMin{
        public int value;
        public int min;
        public NodewithMin(int v,int min){
            this.min=min;
            value=v;
        }
    }



    public class StackwithMin2 extends Mystack<Integer>
    {
        Mystack<Integer> s2;

        public StackwithMin2(){
        s2=new Mystack<Integer>();
    }

        public void push(int value)
        {
            if(value<min())
            {
                s2.push(value);
            }else{
                super.push(value);
            }
        }

        public Integer pop()
        {int value=super.pop();
            if(value==min())
                s2.pop();
            return value;
        }

        public int min()
        {
           if(s2.isEmpty())
               return Integer.MAX_VALUE;
            else
                return s2.peek();
        }

    }
}
