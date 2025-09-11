package testdome;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

class DecoratorStream extends OutputStream {
    private OutputStream stream;
    private String prefix;
    private Boolean isFirstWrite = true;

    public DecoratorStream(OutputStream stream, String prefix) {
        super(); //생략해도 되지만, 명시적으로 분명히 호출.
        this.stream = stream;
        this.prefix = prefix;
    }

    @Override
    public void write(int b) throws IOException {
        byte[] result = new byte[4];

        result[0] = (byte) (b >> 24);
        result[1] = (byte) (b >> 16);
        result[2] = (byte) (b >> 8);
        result[3] = (byte) (b);

        write(result, 0, 4);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        String content = new String(b, off, len, "UTF-8");

        String[] lines = content.split("\n", -1);
        StringBuilder result = new StringBuilder();

        for (int i=0; i<lines.length; i++) {
            result.append(lines[i]);
            if (i < lines.length - 1){
                result.append("\n");
            }
        }
        byte[] outputBytes = result.toString().getBytes("UTF-8");
        stream.write(outputBytes);    }

    @Override
    public void write(byte[] b) throws IOException {
        if (isFirstWrite) {
            byte[] prefixBytes = prefix.getBytes("UTF-8");
            stream.write(prefixBytes);
            isFirstWrite = false;
        }
        write(b, 0, b.length);
    }

    public static void main(String[] args) throws IOException {
        byte[] message = new byte[]{0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21};
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            DecoratorStream decoratorStream = new DecoratorStream(baos, "First line: ");
            decoratorStream.write(message);

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()), "UTF-8"))) {
                System.out.println(reader.readLine());  //should print "First line: Hello, world!"
            }
        }
    }
}