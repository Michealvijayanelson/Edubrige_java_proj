package megsjava;

import java.util.*;

class Bank implements Comparable<Bank> {
    private int bankid;
    private String bankname;
    private String banklocation;

    public Bank(int bankid, String bankname, String banklocation) {
        this.bankid = bankid;
        this.bankname = bankname;
        this.banklocation = banklocation;
    }

    public int getBankid() {
        return bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public String getBanklocation() {
        return banklocation;
    }
    public String toString() {
        return bankid + " " + bankname + " " + banklocation;
    }
    @Override
    public int compareTo(Bank o) {
        if (this.bankid > o.bankid) {
            return 1;
        } else if (this.bankid < o.bankid) {
            return -1;
        } else {
            return 0;
        }
    }
}
class BankManage {
    public static void main(String[] args) {
        List<Bank> c = new ArrayList<Bank>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1 INSERT");
            System.out.println("2 DISPLAY");
            System.out.println("3 SEARCH");
            System.out.println("4 DELETE");
            System.out.println("5 UPDATE");
            System.out.println("6 SORT BANK LIST");
            System.out.print("Enter your choice: ");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter bank id: ");
                    int id = s.nextInt();
                    System.out.print("Enter bank name: ");
                    String name = s1.nextLine();
                    System.out.print("Enter bank location: ");
                    String location = s1.nextLine();
                    c.add(new Bank(id, name, location));
                    System.out.println("-----------------------");
                    System.out.println("Bank Inserted successfully");
                    System.out.println("-----------------------");
                    break;

                case 2:
                    System.out.println("-----------------------");
                    Iterator<Bank> i = c.iterator();
                    while (i.hasNext()) {
                        Bank b = i.next();
                        System.out.println(b);
                    }
                    System.out.println("-----------------------");
                    break;

                case 3:
                    boolean search = false;
                    System.out.print("Enter bank id: ");
                    id = s.nextInt();
                    i = c.iterator();
                    while (i.hasNext()) {
                        Bank b = i.next();
                        if (b.getBankid() == id) {
                            search = true;
                            System.out.println("-----------------------");
                            System.out.println(b);
                        }
                    }
                    if (!search) {
                        System.out.println("-----------------------");
                        System.out.println("Bank not found");
                    }
                    System.out.println("-----------------------");
                    break;

                case 4:
                    search = false;
                    System.out.print("Enter bank id which you want to delete: ");
                    id = s.nextInt();
                    i = c.iterator();
                    while (i.hasNext()) {
                        Bank b = i.next();
                        if (b.getBankid() == id) {
                            i.remove();
                            search = true;
                        }
                    }
                    if (!search) {
                        System.out.println("-----------------------");
                        System.out.println("Bank not found");
                    } else {
                        System.out.println("-----------------------");
                        System.out.println("Bank Deleted successfully ");
                    }
                    System.out.println("-----------------------");
                    break;

                case 5:
                    search = false;
                    System.out.print("Enter bank id which you want to update: ");
                    id = s.nextInt();
                    ListIterator<Bank> li = c.listIterator();
                    while (li.hasNext()) {
                        Bank b = li.next();
                        if (b.getBankid() == id) {
                            System.out.print("Enter bank name: ");
                            name = s1.nextLine(); 
                            System.out.print("Enter bank location: ");
                            location = s1.nextLine();
                            li.set(new Bank(id, name, location));
                            search = true;
                        }
                    }
                    if (!search) {
                        System.out.println("-----------------------");
                        System.out.println("Bank not found");
                    } else {
                        System.out.println("Bank Updated successfully ");
                    }
                    System.out.println("-----------------------");
                    break;

                case 6:
                    Collections.sort(c);
                    System.out.println("-----------------------");
                    System.out.println("Sorted Bank List by Bank ID:");
                    for (Bank bank : c) {
                        System.out.println(bank);
                    }
                    System.out.println("-----------------------");
                    break;
                case 7:
                    
                    System.out.println("Exiting... Thank you!");
                    s.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (ch != 0);
    }
    
}
