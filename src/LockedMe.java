import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMe {
    public static void main(String[] args) {
        System.out.println("|-----------------------|");
        System.out.println("|Welcome to LockedMe.com|");
        System.out.println("|-----------------------|");

        Scanner sc = new Scanner(System.in);
        List<String> fileList = new ArrayList<>();
        fileList.add("b.txt");
        fileList.add("z.txt");
        fileList.add("d.txt");

        boolean exit = false;

        while (!exit) {
            displayOption();
            int option = sc.nextInt();

            switch (option) {
                case 1 -> displayFileList(fileList);
                case 2 -> addFile(fileList);
                case 3 -> deleteFile(fileList);
                case 4 -> searchFile(fileList);
                case 5 -> exit = true;
                default -> System.out.println("Invalid option! Please try again.");
            }
        }

        System.out.println("Application closed.");
    }
    
    private static void displayOption() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Retrieve current file names");
        System.out.println("2. Add a file");
        System.out.println("3. Delete a file");
        System.out.println("4. Search a file");
        System.out.println("5. Close the application");
    }

    private static void displayFileList(List<String> fileList) {
        if (fileList.isEmpty()) {
            System.out.println("The directory is empty.");
        }
        else {
            int len = fileList.size();
            for(int i=len-1;i>=2;i--){
                for(int j=0;j<i;j++){
                    if(fileList.get(j).compareTo(fileList.get(j+1)) > 0){
                        String temp = fileList.get(j);
                        fileList.set(j, fileList.get(j+1));
                        fileList.set(j+1, temp);
                    }
                }
            }

            System.out.println("File names in ascending order:");
            System.out.println(fileList);
        }
    }

    private static void addFile(List<String> fileList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name to add(-1 to return to main menu): ");
        String name = sc.nextLine();
        if(name.equals("-1"))
            return;

        fileList.add(name);
        System.out.println("File added successfully.");
    }

    private static void deleteFile(List<String> fileList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name to delete (-1 to return to main menu): ");
        String name = sc.nextLine();
        if(name.equals("-1"))
            return;

        if (fileList.removeIf(f -> f.equalsIgnoreCase(name)))
            System.out.println("File deleted successfully.");
        else
            System.out.println("File not found.");
    }

    private static void searchFile(List<String> fileList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name to search (-1 to return to main menu): ");
        String name = sc.nextLine();
        if(name.equals("-1"))
            return;

        for (String fName : fileList) {
            if (fName.equalsIgnoreCase(name)) {
                System.out.println("File found.");
                return;
            }
        }
            System.out.println("File not found.");
    }
}

