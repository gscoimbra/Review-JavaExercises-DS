package ListaSimplesmenteEncadeada.Ex01;

//Implemente um gerenciador de tarefas onde cada tarefa é um nó em uma lista
//simplesmente encadeada. Permita que o usuário adicione, remova, e marque tarefas
//como concluídas.

import java.util.Scanner;

class Task {
    String description;
    boolean completed;
    Task next;

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.next = null;
    }

    @Override
    public String toString() {
        return (completed ? "[X]" : "[ ] ") + description;
    }
}

class TaskManager {
    private Task head;
}

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\nGerenciador de Tarefas");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Remover Tarefa");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Exibir Tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (choice) {
                case 1:
                    System.out.print("Digite a descrição da tarefa:");
                    String description = scanner.nextLine();
                    manager.addTask(description);
                    break;
                case 2:
                    System.out.print("Digite o índice da tarefa a ser removida: ");
                    int removeIndex = scanner.nextInt();
                    manager.removeTask(removeIndex);
                    break;
                case 3:
                    System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
                    int completeIndex = scanner.nextInt();
                    manager.markTaskCompleted(completeIndex);
                    break;
                case 4:
                    manager.displayTasks();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
