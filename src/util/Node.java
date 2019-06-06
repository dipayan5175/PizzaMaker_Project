package util;

public class Node<T>
{

  private T item;
  private Node<T> next;  //reference to another node

  public Node(T item) 
  {
    this.item = item;
    next = null;
  } 

  public Node(T item, Node<T> next) 
  {
    this.item = item;
    this.next = next;
  }

  public void setItem(T item) 
  {
    this.item = item;
  }

  public T getItem() 
  {
    return item;
  } 

  public void setNext(Node<T> next) 
  {
    this.next = next;
  } 

  public Node<T> getNext() 
  {
    return next;
  }

}