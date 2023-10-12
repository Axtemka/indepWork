import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Здравствуйте, вас приветствует программа, посвященная первой незабываемой самостоятельной в учебном учереждении,\n" +
                "именуемом как 'Легендарная Itschool Samsung'. \n" +
                "Эта программа умеет в шифр цезаря, пожалуйста введите любой текст на русском или на английском языке,\n" +
                "а также ключ в диапазоне от -10 до 10, по которому будет выполнятся шифрование.");
        System.out.println("Введите команду: cip/   dec/   quit/");
        String command = sc.nextLine();


        while(!Objects.equals(command, "quit/")){

            if (!Objects.equals(command, "cip/") && !Objects.equals(command, "dec/")) {
                System.out.println("Введите команду: cip/   dec/   quit/");
                command = sc.nextLine();
                continue;
            }
            System.out.print("T/...");
            String inp = sc.nextLine().toLowerCase();
            char[] input = inp.toCharArray();
            System.out.print("Ключ:");
            int key = sc.nextInt();
            System.out.println();
            while(key > 10 || key < -10){
                System.out.println("Вы вышли за рамки дозволенного. Попробуйте снова.");
                System.out.print("K/...");
                key = sc.nextInt();
            }
            if (Objects.equals(command, "cip/")) {
                System.out.print("Зашифровано: ");
                System.out.println((Caesar_cipher(input, key)));
                System.out.println("Введите команду: cip/   dec/   quit/");
                command = sc.nextLine();
            }
            if (Objects.equals(command, "dec/")) {
                System.out.print("Расшифровано: ");
                System.out.println((Caesar_decipher(input, key)));
                System.out.println("Введите команду: cip/   dec/   quit/");
                command = sc.nextLine();
            }



        }

    }
    public static char[] Caesar_cipher(char[] old, int key){
        char[] ciphered = new char[old.length];
        String en_alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ru_alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for(int i = 0; i < old.length; i++){
            int new_ind;
            if (old[i] == ' ') {
                ciphered[i] = ' ';
                continue;
            }
            if (find(old[i], 0) != -1){
                new_ind = (find(old[i], 0) + key) % 26;
                if (new_ind < 0) new_ind = en_alphabet.length() + new_ind;
                ciphered[i] = en_alphabet.charAt(new_ind);
            }

            if (find(old[i], 1) != -1){
                new_ind = (find(old[i], 1) + key) % 33;
                if (new_ind < 0) new_ind = ru_alphabet.length() + new_ind;
                ciphered[i] = ru_alphabet.charAt(new_ind);
            }
        }
        return ciphered;
    }
    public static String Caesar_cipher(String old, int key){
        char[] ciphered = new char[old.length()];
        String en_alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ru_alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for(int i = 0; i < old.length(); i++){
            int new_ind;
            if (old.charAt(i) == ' ') {
                ciphered[i] = ' ';
                continue;
            }
            if (find(old.charAt(i), 0) != -1){
                new_ind = (find(old.charAt(i), 0) + key) % 26;
                if (new_ind < 0) new_ind = en_alphabet.length() + new_ind;
                ciphered[i] = en_alphabet.charAt(new_ind);
            }

            if (find(old.charAt(i), 1) != -1){
                new_ind = (find(old.charAt(i), 1) + key) % 33;
                if (new_ind < 0) new_ind = ru_alphabet.length() + new_ind;
                ciphered[i] = ru_alphabet.charAt(new_ind);
            }
        }
        return new String(ciphered);
    }
    public static char[] Caesar_decipher(char[] old, int key){
        char[] ciphered = new char[old.length];
        String en_alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ru_alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for(int i = 0; i < old.length; i++){
            int new_ind;
            if (old[i] == ' ') {
                ciphered[i] = ' ';
                continue;
            }
            if (find(old[i], 0) != -1){
                new_ind = (find(old[i], 0) - key) % 26;
                if (new_ind < 0) new_ind = en_alphabet.length() + new_ind;
                ciphered[i] = en_alphabet.charAt(new_ind);
            }

            if (find(old[i], 1) != -1){
                new_ind = (find(old[i], 1) - key) % 33;
                if (new_ind < 0) new_ind = ru_alphabet.length() + new_ind;
                ciphered[i] = ru_alphabet.charAt(new_ind);
            }
        }
        return ciphered;
    }
    public static String Caesar_decipher(String old, int key){
        char[] ciphered = new char[old.length()];
        String en_alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ru_alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for(int i = 0; i < old.length(); i++){
            int new_ind;
            if (old.charAt(i) == ' ') {
                ciphered[i] = ' ';
                continue;
            }
            if (find(old.charAt(i), 0) != -1){
                new_ind = (find(old.charAt(i), 0) + key) % 26;
                if (new_ind < 0) new_ind = en_alphabet.length() + new_ind;
                ciphered[i] = en_alphabet.charAt(new_ind);
            }

            if (find(old.charAt(i), 1) != -1){
                new_ind = (find(old.charAt(i), 1) + key) % 33;
                if (new_ind < 0) new_ind = ru_alphabet.length() + new_ind;
                ciphered[i] = ru_alphabet.charAt(new_ind);
            }
        }
        return new String(ciphered);
    }
    public static int find(char sym, int lang){
        String en_alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ru_alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        if (lang == 0){
            for(int i = 0; i < 26; i++){
                if (sym == en_alphabet.charAt(i)) return i;
            }
        }
        if (lang == 1){
            for(int i = 0; i < 33; i++){
                if (sym == ru_alphabet.charAt(i)) return i;
            }
        }
        return -1;
    }
}