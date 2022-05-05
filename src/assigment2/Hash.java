package assigment2;

import java.util.Scanner;

public class Hash {
    //Ноды для нашего linked list
    Hash next;
    int data;
    //Конуструктор как обычно
    public Hash(int x) {
        data = x;
        next = null;
    }
}

class HashTableLinkedList {
    private Hash[] table;
    private int size ;

    //Конструктор
    public HashTableLinkedList(int tableSize) {
        table = new Hash[ nextPrime(tableSize) ];
        size = 0;
    }
    //Получаем размер
    public int getSize(){
        return size;
    }
    //Функция для добавления элемента
    public void insert(int val) {
        size++;
        int pos = hash(val);
        Hash np = new Hash(val);
            np.next = table[pos];
            table[pos] = np;
    }
    //Функция удаления элемента
    public void remove(int value) {
        int position = hash(value);
        Hash st = table[position];
        Hash end = st;
        if (st.data == value) {
            size--;
            table[position] = st.next;
            return;
        }
        while (end.next != null && end.next.data != value)
            end = end.next;
        if (end.next == null) {
            System.out.println("\nElement not found\n");
            return;
        }
        size--;
        if (end.next.next == null) {
            end.next = null;
            return;
        }
        end.next = end.next.next;
        table[position] = st;
    }
    // Функция для очистки таблицы
    public void empty() {
        int len = table.length;
        table = new Hash[len];
        size = 0;
    }
    private int hash(Integer xcor ) {
        int hashValue = xcor.hashCode( );
        hashValue %= table.length;
        if (hashValue < 0)
            hashValue += table.length;
        return hashValue;
    }
    //Генерируем простое число которое  >= n
    private static int nextPrime( int n ) {
        if (n % 2 == 0)
            n++;
        for ( ; !isPrime( n ); n =n+2);

        return n;
    }
    //Проверяем является ли числом простым
    private static boolean isPrime( int n ) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n == 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
    // Принтим нашу таблицу
    public void printHashTable () {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print ("Index " + i + ":  ");
            Hash st = table[i];
            while(st != null) {
                System.out.print(st.data +" ");
                st = st.next;
            }
            System.out.println();
        }
    }
}

//Тестируем код
class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size");
        //Обьект класса HashTableLinkedList
        HashTableLinkedList hashTable = new HashTableLinkedList(scan.nextInt() );

        char check;
        do {
            System.out.println("1.remove");
            System.out.println("2.insert ");
            System.out.println("3.clear");
            System.out.println("4.size");
            int inputChoice = scan.nextInt();
            switch (inputChoice){
                case 1 :
                    System.out.println("Enter int to remove an element");
                    hashTable.remove( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter int element to insert/add");
                    hashTable.insert( scan.nextInt() );
                    break;
                case 3 :
                    hashTable.empty();
                    System.out.println("Hash Table Was Cleared\n");
                    break;
                case 4 :
                    System.out.println("Size of hash table is = "+ hashTable.getSize() );
                    break;
                default :
                    System.out.println("Wrong input, try again \n ");
                    break;
            }
            //Выводит нашу таблицу
            hashTable.printHashTable();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            check = scan.next().charAt(0);
        } while (check == 'Y'|| check == 'y');
    }
}