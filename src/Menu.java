import java.util.Scanner;

public class Menu {
  LinkedList<String> nameList;
  Scanner scanner;

  public Menu(LinkedList<String> nameList, Scanner scanner) {
    this.nameList = nameList;
    this.scanner = scanner;
  }

  private void showMenu() {
    System.out.println("1 -  Adicionar um nome no início da lista");
    System.out.println("2 -  Adicionar um nome no final da lista");
    System.out.println("3 -  Remover um nome");
    System.out.println("4 -  Imprimir a lista");
    System.out.println("5 -  Sair");
    System.out.print("\n-> ");
  }

  private void waitForEnter() {
    System.out.println("\nPressione ENTER para continuar...");
    scanner.nextLine();
  }

  private void addNameAtStart() {
    System.out.println("\n== Adicionar um nome no início da lista ==");
    System.out.print("-> ");
    String name = scanner.nextLine();

    
    try  {
      nameList.addFirst(name);
    } catch(IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
    
    System.out.println();
  }

  private void addNameAtEnd() {
    System.out.println("\n== Adicionar um nome no fim da lista ==");
    System.out.print("-> ");
    String name = scanner.nextLine();
    System.out.println();
    
    try  {
     nameList.addLast(name);   
    } catch(IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
    
    System.out.println();
  }

  private void removeName() {
    System.out.println("\n== Remover nome ==");
    System.out.print("-> ");
    String name = scanner.nextLine();
    
    try  {
      nameList.remove(name);
    } catch(IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
    
    System.out.println();
  }

  private void printList() {
    System.out.println("\n== Imprimir a lista ==");
    nameList.print();
    System.out.println();
  }

  public void run() {
    while (true) {
      showMenu();

      int option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          addNameAtStart();
          break;
        case 2:
          addNameAtEnd();
          break;
        case 3:
          removeName();
          break;
        case 4:
          printList();
          waitForEnter();
          break;
        case 5:
          System.exit(0);
        default:
          System.out.println("Opção inválida!");
      }

    }
  }
}
