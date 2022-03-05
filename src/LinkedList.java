
/* 
  o do while é usado em algumas situaçoes pois na lista circular de apenas um descritor,
  a única maneira de parar o loop, é chegando no primeiro elemento da lista, porém se for
  utilizado o while, o loop nem se inicia, já que ele começa com o primeiro elemento
 */

/**
 * <h1>Lista Encadeada</h1>
 * 
 * Lista duplamente encadeada com apenas um descritor de cabeça.
 * 
 */
public class LinkedList<T> {

  private class Node {
    private T data;
    private Node next;
    private Node prev;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node head;

  public LinkedList() {
    head = null;
  }

  /**
   * Adiciona um elemento no início da lista.
   *
   * @param data o elemento a ser adicionado.
   * @throws IllegalArgumentException se o elemento já existe na lista.
   */
  public void addFirst(T data) {
    if (this.contains(data))
      throw new IllegalArgumentException("o elemento já existe na lista");

    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      head.next = head;
      head.prev = head;
      return;
    }

    newNode.next = head;
    newNode.prev = head.prev;
    head.prev.next = newNode;
    head.prev = newNode;
    head = newNode;

  }

  /**
   * Adiciona um elemento no final da lista.
   *
   * @param data o elemento a ser adicionado.
   * @throws IllegalArgumentException se o elemento já existe na lista.
   */
  public void addLast(T data) {
    if (this.contains(data))
      throw new IllegalArgumentException("o elemento já existe na lista");

    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      head.next = head;
      head.prev = head;
      return;
    }
    Node current = head;

    // o while pode ser usado aqui pois o objetivo é apenas chegar no último
    // elemento
    // sem nenhuma lógica dentro do loop, assim, mesmo que o loop nao seja
    // executado,
    // o current será o último elemento da lista

    while (!current.next.equals(head)) {
      current = current.next;
    }
    current.next = newNode;
    newNode.prev = current;

    newNode.next = head;
    head.prev = newNode;
  }

  /**
   * Verifica se a lista contém um elemento.
   * 
   * @param data o elemento a ser verificado.
   * @return true se a lista contém o elemento, false caso contrário.
   */
  public boolean contains(T data) {
    if (head == null)
      return false;

    Node current = head;

    do {
      if (current.data.equals(data))
        return true;
      current = current.next;
    } while (!current.equals(head));
    return false;
  }

  /**
   * Remove um elemento da lista.
   *
   * @param data o elemento a ser removido.
   * @throws IllegalArgumentException se o elemento não existe na lista.
   */
  public void remove(T data) {
    if (!this.contains(data))
      throw new IllegalArgumentException("o elemento não existe na lista");

    Node current = head;

    do {
      if (current.data.equals(data)) {
        if (current.equals(head)) {
          if (head.next.equals(head)) {
            head = null;
            return;
          }
          head = current.next;
        }
        current.next.prev = current.prev;
        current.prev.next = current.next;
        return;
      }
      current = current.next;
    } while (!current.equals(head));
  }

  /**
   * Exibe os elementos da lista.
   */
  public void print() {
    Node current = head;
    do {
      System.out.println(current.data);
      current = current.next;
    } while (!current.equals(head));
  }

}
