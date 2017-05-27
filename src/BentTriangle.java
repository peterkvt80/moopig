package net.happybrackets.peter;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.data.BufferFactory;

import static net.beadsproject.beads.data.BufferFactory.DEFAULT_BUFFER_SIZE;

/**
 * Created by Peter on 15-May-17.
 */
public class BentTriangle extends BufferFactory {
    @Override
    public Buffer generateBuffer(int bufferSize) {
        Buffer b = new Buffer(bufferSize);
        for(int i = 0; i < bufferSize; i++) {
            b.buf[bufferSize-i-1] = (float)i / (float)bufferSize * 2.0f - 1.0f;
        }
        for(int i = 0; i < bufferSize; i++) {
            if(i < bufferSize / 2) {
                b.buf[i] += (float)i / ((float)bufferSize / 2f) * 2.0f - 1.0f;
            } else {
                b.buf[i] += (1f - ((float)(i - (bufferSize / 2)) / ((float)bufferSize / 2f))) * 2.0f - 1.0f;
            }
            b.buf[i]/=2;
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
