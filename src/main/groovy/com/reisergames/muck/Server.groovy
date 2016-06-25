package com.reisergames.muck

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by aeon on 6/22/2016.
 */
class Server {

    def Thread thread;
    def ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<Integer, Client>()

    def ServerSocket serverSocket

    static def running = false

    def Server(){
        serverSocket = new ServerSocket()
    }
    def start(int port){

        serverSocket.bind(new InetSocketAddress(port))

        running = true

        thread = new Thread([
                run: {
                    while(running){
                        loop();
                    }
                }
        ] as Runnable)
        thread.start()

    }

    private def loop(){
        serverSocket.accept(true, { socket ->
            def client = new Client(socket)
            clients.put(socket.hashCode(), client)
            while(socket.connected){
                client.read()
            }
        })
    }

    def await(){
        while(running){
            Thread.sleep(1000)
            clients.each({client ->
                client.value.queue.poll()?.execute()
            })
        }
    }

    def stop(){
        running = false
        serverSocket.close()
    }


    public static void main(final String[] args){
        WorldManager.instance.init()
        def server = new Server()
        server.start(5000)
        server.await()
        server.stop()
    }
}

