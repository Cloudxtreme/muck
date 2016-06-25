package com.reisergames.muck

/**
 * Created by aeon on 6/24/2016.
 */
class Command {

    Script script
    String command
    Client client

    def execute(){
        try {
            def result = script.invokeMethod(command, null) as String
            //def result = script.evaluate("$command()") as String
            result ? client.write(result as String) : null
        }catch(Exception ex){
            println ex
        }
    }
}
