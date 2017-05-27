package net.happybrackets.peter;

import net.beadsproject.beads.data.Buffer;
import net.beadsproject.beads.data.BufferFactory;

/**
 * Created by Peter on 07-May-17.
 * Adjustable duty cycle square wave in the range -1 to 1
 * duty cycle 0 to 1.0f. (1 to 99). This is getting ugly
 */
public class SquareDuty extends BufferFactory {
    @Override
    public Buffer generateBuffer(int duty) {
        int bufferSize=	DEFAULT_BUFFER_SIZE; // @todo
        Buffer b = new Buffer(bufferSize);
        int highBufferSize = Math.round(bufferSize * duty/100);
        if (highBufferSize<1) {
            highBufferSize=1;
        }
        else
        if (highBufferSize>=bufferSize) {
            highBufferSize=bufferSize-1;
        }
        for(int i = 0; i < highBufferSize; i++) {
            b.buf[i] = 1f;
        }
        for(int i = highBufferSize; i < bufferSize; i++) {
            b.buf[i] = -1f;
        }
        return b;    }

    @Override
    public String getName() {
        return "SquareDuty";
    }
}
