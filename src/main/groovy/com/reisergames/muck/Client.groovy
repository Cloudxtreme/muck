package com.reisergames.muck

import com.reisergames.muck.ansi.Ansi

import java.util.concurrent.ConcurrentLinkedQueue

/**
 * Created by aeon on 6/22/2016.
 */
class Client {

    def Player player
    def queue = new ConcurrentLinkedQueue<Command>()
    def Socket socket
    def command = ''

    def Client(Socket sc){
        socket = sc

    }

    def read(){
        def inputStream = socket.inputStream
        def buffer = new byte[inputStream.available()]
        inputStream.read(buffer)
        command += new String(buffer, "ASCII")
        if(command.endsWith("\n")){
            def c = CommandManager.instance.get(command, this)
            if(!c){
                writeln("^RED^Command not found!!")
            } else {
                queue.add(c)
            }
            command = ''
        }
    }

    def writeln(String message){
        write(message+"\r\n")
    }
    def write(String message){
        def outputStream = socket.outputStream
        outputStream.write(Ansi.parse(message).bytes)
    }
}
