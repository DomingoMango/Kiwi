package com.example.kiwis;

import android.util.Log;

public class Queue {
    private QueueNode first;
    private QueueNode last;
    private int i=0;
    public Queue(){
        first = null;
        last = null;
    }
    public void add (int data){
        i=1;
        QueueNode node = new QueueNode(data);
        QueueNode aux= first;
        QueueNode aux2=null;

        if (node==null){
            Log.i("log","Queue over flow");
        }else{
            if (first == null) {
                first = node;
            } else {
                while (aux.getNext() != null) {
                    i++;
                    aux = aux.getNext();
                    if(aux.getData()==node.getData()){
                        aux2=aux;
                    }
                }
                if (i >= 8) {
                    Log.i("pan", "Limit reached");
                } else if(aux2!=null){
                    Log.i("pan","ID already in");
                }else{
                    last.setNext(node);
                }
            }
            last = node;

        }

    }
    public String print() {
        String result = "";
        QueueNode aux = first;
        if (first != null) {
            while (aux!= null) {
                result += aux.getData()+ "->";
                aux = aux.getNext();

            }
            Log.i("pan", result);
            return result;
        }
        return "No hay nadie en cola";
    }
    public int remove()
    {
        if(first==null){
            return -1;
        }else{
            QueueNode kiwi = first;
            first = first.getNext();
            if(first==null){
                last=null;
            }

            return kiwi.getData();
        }
    }
    public QueueNode getFirst() {
        return first;
    }

    public QueueNode getLast() {
        return last;
    }
}
