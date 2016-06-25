package com.reisergames.muck.utils

import com.reisergames.muck.telnet.TelnetCommand
import com.reisergames.muck.telnet.TelnetOption

import java.nio.ByteBuffer

/**
 * Created by aeon on 6/22/2016.
 */
class TelnetCommandUtils {

    static final def IAC = 255
    static final def WILL = 251
    static final def WONT = 252
    static final def DO = 253
    static final def DONT = 254

    static final def ECHO = 1
    def byte[] data

    def TelnetCommandUtils(byte[] command){
        data = command;
    }
    def ByteBuffer get(){
        return ByteBuffer.wrap(data)
    }
    private static b(int i){
        return (byte) i
    }

    private static i(byte b){
        return Byte.toUnsignedInt(b)
    }

    static def willEcho(){
        return [(byte)TelnetCommand.IAC, (byte)TelnetCommand.WILL, (byte)TelnetOption.ECHO] as byte[]
    }

    static def wontEcho(){
        return [(byte)TelnetCommand.IAC, (byte)TelnetCommand.WONT, (byte)TelnetOption.ECHO] as byte[]
    }

    static def doEcho() {
        return [(byte)TelnetCommand.IAC, (byte)TelnetCommand.DO, (byte)TelnetOption.ECHO] as byte[]
    }

    static def dontEcho() {
        return [(byte)TelnetCommand.IAC, (byte)TelnetCommand.DONT, (byte)TelnetOption.ECHO] as byte[]
    }
}
