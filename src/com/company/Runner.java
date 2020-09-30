package com.company;

public class Runner extends Thread {
        private Runner nextRunner;

        public Runner(String name, Runner nextRunner) {
                this.nextRunner = nextRunner;
                this.setName(name);
        }

        public Runner(String name) {
                this.nextRunner = nextRunner;
                this.setName(name);
        }

        public void run() {
                try {
                        this.sleep(3000);
                } catch (InterruptedException ie) {
                }
                if (nextRunner != null) {
                        nextRunner.start();
                }
                System.out.printf(
                        "\n%s берет палочку и бежит к ", this.getName());
                if (nextRunner != null) {
                        System.out.print(nextRunner.getName() + "\n");
                        try {
                                nextRunner.join();
                                this.sleep(3000);
                                System.out.printf(
                                        "\n%s берет палочку и бежит к ", nextRunner.getName());
                                System.out.print(this.getName() + "\n");
                        } catch (InterruptedException ie) {
                                ie.printStackTrace();
                        }
                } else {
                        System.out.print("финишу\n");
                }
                if (this.getName().equals("Runner 1")) {
                        System.out.println(this.getName() + " берет палочку");
                }

        }
}
