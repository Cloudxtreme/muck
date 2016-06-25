package com.reisergames.muck.utils

import java.nio.ByteBuffer
import java.nio.charset.Charset

/**
 * Created by aeon on 6/22/2016.
 */
class BufferUtils {

    static def encode(final String message){
        ByteBuffer buffer = ByteBuffer.allocate(message.bytes.length)
        buffer.put(message.getBytes(Charset.forName("ASCII")))
        return buffer
    }

}
