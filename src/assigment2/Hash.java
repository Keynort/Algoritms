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
            Hash nptr = new Hash(val);
            if (table[pos] == null)
                table[pos] = nptr;
            else
            {
                nptr.next = table[pos];
                table[pos] = nptr;
            }
        }
        //Функция удаления элемента
        public void remove(int val) {
            int pos = hash(val);
            Hash start = table[pos];
            Hash end = start;
            if (start.data == val) {
                size--;
                table[pos] = start.next;
                return;
            }
            while (end.next != null && end.next.data != val)
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
            table[pos] = start;
        }
        // Функция для очистки таблицы
        public void makeEmpty() {
            int l = table.length;
            table = new Hash[l];
            size = 0;
        }
        private int hash(Integer x ) {
            int hashVal = x.hashCode( );
            hashVal %= table.length;
            if (hashVal < 0)
                hashVal += table.length;
            return hashVal;
        }
        //Генерируем простое число которое  >= n
        private static int nextPrime( int n ) {
            if (n % 2 == 0)
                n++;
            for ( ; !isPrime( n ); n += 2);

            return n;
        }
        //Проверяем является ли числом простым
        private static boolean isPrime( int n ) {
            if (n == 2 || n == 3)
                return true;
            if (n == 1 || n % 2 == 0)
                return false;
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
                Hash start = table[i];
                while(start != null) {
                    System.out.print(start.data +" ");
                    start = start.next;
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
                System.out.println("1. remove");
                System.out.println("2. insert ");
                System.out.println("3. clear");
                System.out.println("4. size");
                int choice = scan.nextInt();
                switch (choice){
                    case 1 :
                        System.out.println("Enter integer element to delete");
                        hashTable.remove( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter integer element to insert");
                        hashTable.insert( scan.nextInt() );
                        break;
                    case 3 :
                        hashTable.makeEmpty();
                        System.out.println("Hash Table Cleared\n");
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
