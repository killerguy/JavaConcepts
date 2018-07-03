package com.mukul.threads;

public class WaitExampleWithSynchronizedBlock {

    public synchronized static void main(String[] args) throws Exception {
        Message message = new Message();
        MessageProcessor messageProcessor = new MessageProcessor();

        new Thread(() -> messageProcessor.m1(message)).start();
        new Thread(() -> messageProcessor.m2(message)).start();
    }
}

class Message {
}

class MessageProcessor {

    public void m1(Message message) {
        synchronized (message) {
            System.out.println("MessageProcessor.process000000000001");
            try {
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MessageProcessor.process11111111111111");
        }
    }

    public void m2(Message message) {
        synchronized (message) {
            System.out.println("MessageProcessor.m2A");
            message.notify();
            System.out.println("MessageProcessor.m2B");
        }
    }
}
