public class Philosopher extends Thread {
    private final Table table;
    private final int num;

    private int countRice = 0;
//    private PhilosopherTask task = PhilosopherTask.Think;

    public Philosopher(Table table, int num) {
        this.table = table;
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }

    private void think() {
        System.out.println("Философ №" + num + " думает");
    }

    private void eat() {
        table.eat(num);
        countRice++;
        System.out.println("Философ №" + num + " съел " + countRice + " порций риса");
    }


//    public PhilosopherTask getTask() {
//        return task;
//    }
//
//    public void setTask(PhilosopherTask task) {
//        this.task = task;
//    }
}
