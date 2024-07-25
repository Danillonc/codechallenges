package org.example.thread.print;

class MyThread extends Thread {

    public MyThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {

        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        play();

    }

    private void play() {
        System.out.print(getName());
        System.out.print(getName());
    }

}
