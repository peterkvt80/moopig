package net.happybrackets.peter;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.data.BufferFactory;

/**
 * Created by Peter on 07-May-17.
 */
public class SawReverse extends BufferFactory {

    @Override
    public Buffer generateBuffer(int bufferSize) {
        Buffer b = new Buffer(bufferSize);
        for(int i = 0; i < bufferSize; i++) {
            b.buf[bufferSize-i-1] = (float)i / (float)bufferSize * 2.0f - 1.0f;
        }
        return b;
    }

    @Override
    public String getName() {
        return "Reverse Saw";
    }

    public Buffer generateBuffer() {
        return generateBuffer(DEFAULT_BUFFER_SIZE);
    }
}
