package com.reisergames.muck



/**
 * Created by aeon on 6/24/2016.
 */
@Singleton
class CommandManager {

    def engine = new GroovyScriptEngine("./scripts/commands")

    def get(String command, Client client){
        def commandArray = command.replace("\r","").replace("\n","").split(" ").collect({ item-> return item as String })
        def commandName = commandArray.first().toLowerCase()
        commandArray.remove(0)
        def commandArgs = commandArray
        def binding = new Binding([
                _commandManager: CommandManager.instance,
                _client:client,
                _itemManager: ItemManager.instance,
                _shipManager: ShipManager.instance,
                _player:client.player,
                _args:commandArgs
        ])
        try {
            def c = engine.createScript(commandName+".groovy", binding)
            return new Command(command:commandName, client:client, script:c)
        } catch (Exception ex){
            println ex.toString()
            return null
        }

    }
}
