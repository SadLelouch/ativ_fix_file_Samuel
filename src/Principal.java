import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        InputStreamReader input = new InputStreamReader(System.in);
        int opcao = 0;
        while (opcao != 7) {
            System.out.println("Bem vindo ao nosso sistema.\n\n");
            System.out.println("1 - CreateFile");
            System.out.println("2 - WriteFile");
            System.out.println("3 - ReadFile");
            System.out.println("4 - GetFileInfo");
            System.out.println("5 - DeleteFile");
            System.out.println("6 - DeleteFolder\n");
            System.out.println("7 - Sair do programa\n");
            System.out.print("Por favor, selecione uma opção: ");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    try{
                        String nome;
                        System.out.println("Por favor, insira o nome do arquivo e sua extensão (.txt, .java, etc): ");
                        nome = scan.nextLine();
                        File myObj = new File(nome);
                        if (myObj.createNewFile()) {
                            System.out.println("File created: " + myObj.getName());
                        } else {
                            System.out.println("Arquivo já existente");
                        }
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        System.out.println("An error has ocurred");
                        e.printStackTrace();
                    }
                    continue;

                case 2:
                    try {
                        String nome;
                        System.out.println("Insira o nome do arquivo que deseja alterar (com a extensão): ");
                        nome = scan.nextLine();
                        FileWriter myWriter = new FileWriter(nome);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e){
                        System.out.println("An error has ocurred");
                        e.printStackTrace();
                    }
                    continue;

                case 3:
                    try {
                        System.out.println("Insira o nome do arquivo que deseja realizar a busca (com a extensão): ");
                        String nome = scan.nextLine();
                        File myObj = new File(nome);
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("An error ocurred");
                        e.printStackTrace();
                    }
                    continue;

                case 4:
                    String nome;
                    System.out.println("Insira o nome do arquivo que deseja ver os dados (com a extensão): ");
                    nome = scan.nextLine();
                    File myObj = new File(nome);
                    if (myObj.exists()) {
                    System.out.println("Nome do arquivo: " + myObj.getName());
                    System.out.println("Caminho absoluto: " + myObj.getAbsolutePath());
                    System.out.println("Editável: " + myObj.canWrite());
                    System.out.println("Possibilita leitura: " + myObj.canRead());
                    System.out.println("Tamanho do arquivo em bytes: " + myObj.length());
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                } else {
                    System.out.println("O arquivo não existe.");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
                    continue;

                case 5:
                    System.out.println("Insira o nome do arquivo que deseja excluir (com a extensão): ");
                    nome = scan.nextLine();
                    myObj = new File(nome);
                    if (myObj.delete()) {
                        System.out.println("Deleted the file: " + myObj.getName());
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Failed to delete the file");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    continue;

                case 6:
                    System.out.println("Insira o diretório da pasta que deseja excluir: ");
                    String path = scan.nextLine();
                    myObj = new File(path);
                    if (myObj.delete()) {
                        System.out.println("Deletando o diretório: " + myObj.getName());
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Falha ao deletar a pasta.");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    continue;

                case 7:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    try {
                        input.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;
            }
        }
    }
}
