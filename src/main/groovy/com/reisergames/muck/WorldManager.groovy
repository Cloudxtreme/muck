package com.reisergames.muck

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by aeon on 6/22/2016.
 */
@Singleton
class WorldManager {

    def ConcurrentHashMap<Integer, Room> rooms = new ConcurrentHashMap<Integer, Room>()

    static def running = false
    def thread = new Thread([
            run:{
                while(running){
                    pulse()
                    Thread.sleep(1000)
                }
            }
    ] as Runnable, "pulse-thread")

    def init() {
        running = true
        thread.start()
    }

    @Override
    void finalize(){
        running = false
    }

    def pulse(){

    }
}
