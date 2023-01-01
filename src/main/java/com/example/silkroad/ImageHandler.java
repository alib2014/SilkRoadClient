package com.example.silkroad;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;


public class ImageHandler
{
    private static File file;
    private static String format;
    private static int id;

    public ImageHandler(File image, int id) {
        String extension = "";

        int i = image.getAbsolutePath().lastIndexOf('.');
        if (i > 0) {
            extension = image.getAbsolutePath().substring(i+1);
        }

        format = "." + extension;
        file = image;
        ImageHandler.id = id;
    }

    public synchronized static void sendImage () throws IOException {
        CreateSocket createSocket = new CreateSocket();

        Socket socket = createSocket.getSocket();

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


        dataOutputStream.flush();
        dataOutputStream.writeUTF(format);
        dataOutputStream.flush();

        dataOutputStream.writeUTF(String.valueOf(id));
        dataOutputStream.flush();


        //sending size of file
        System.out.println("size of file: " + (int) file.length());
        byte[] byteArray = new byte[(int) file.length()];
        byte[] size = ByteBuffer.allocate(4).putInt(byteArray.length).array();
        outputStream.write(size);
        outputStream.flush();

        // getting a stream to file
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

        // reading from file and saving in byteArray
        bufferedInputStream.read(byteArray, 0, byteArray.length);

        // writing in the output stream of socket
        outputStream.write(byteArray, 0, byteArray.length);
        outputStream.flush();
        System.out.println("Sent the file! :D");
        bufferedInputStream.close();
    }

    public synchronized static void receiveADImage() throws IOException {
        InputStream inputStream = new CreateSocket().getSocket().getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        String format = dataInputStream.readUTF();
        int id = Integer.parseInt(dataInputStream.readUTF());

        String filePath = System.getProperty("user.dir") + "\\AdImages";
        if (! new File(filePath).exists())
            new File(filePath).mkdir();

        filePath += "\\" + id + format;


        // getting the size of file
        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

        System.out.println("size of file: " + size);

        byte[] byteArray = new byte[size];

        // getting a stream to the directory we want to save the file in
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        //reading input from the stream of socket and saving in byteArray
        int bytesRead = inputStream.read(byteArray, 0, byteArray.length);
        // bytes will be read gradually (not all at once)
        // so we save the current number of bytes that have been read
        // and continue reading remaining bytes in a loop
        // until read function returns 0, which means no more bytes are left unread
        int current = bytesRead;
        do {
            bytesRead =
                    inputStream.read(byteArray, current, (byteArray.length - current));
            if (bytesRead >= 0) {
                current += bytesRead;
            }

        } while(bytesRead > 0);

        System.out.println("bytes read: " + current);


        // writing to the directory
        bufferedOutputStream.write (byteArray, 0, current);
        System.out.println("Saved the file! :D");
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public synchronized static String receiveUserImage() throws IOException {
        InputStream inputStream = new CreateSocket().getSocket().getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        String format = dataInputStream.readUTF();
        int id = Integer.parseInt(dataInputStream.readUTF());

        String filePath = System.getProperty("user.dir") + "\\UserImages";
        if (! new File(filePath).exists())
            new File(filePath).mkdir();

        filePath += "\\" + id + format;


        // getting the size of file
        byte[] sizeAr = new byte[4];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

        System.out.println("size of file: " + size);

        byte[] byteArray = new byte[size];

        // getting a stream to the directory we want to save the file in
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        //reading input from the stream of socket and saving in byteArray
        int bytesRead = inputStream.read(byteArray, 0, byteArray.length);
        // bytes will be read gradually (not all at once)
        // so we save the current number of bytes that have been read
        // and continue reading remaining bytes in a loop
        // until read function returns 0, which means no more bytes are left unread
        int current = bytesRead;
        do {
            bytesRead =
                    inputStream.read(byteArray, current, (byteArray.length - current));
            if (bytesRead >= 0) {
                current += bytesRead;
            }

        } while(bytesRead > 0);

        System.out.println("bytes read: " + current);


        // writing to the directory
        bufferedOutputStream.write (byteArray, 0, current);
        System.out.println("Saved the file! :D");
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        return filePath;
    }
}
