package com.example.silkroad;

import java.io.*;
import java.net.Socket;

public class AccountHandler {
    private static Account account;
    private static Socket socket;
    private BufferedReader input;
    private BufferedWriter output;

    public AccountHandler(Account account, Socket socket) throws IOException {
        AccountHandler.account = account;
        AccountHandler.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public AccountHandler() {

    }

    public AccountHandler(Account account) throws IOException {
        AccountHandler.account = account;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public Account getAccount() {
        return account;
    }

    public boolean emailVerificationCodeRequest() {
        String jsonInString  = new JsonHandler().jsonAccountInString(account, "emailVerificationCode");
        try {
            output.write(jsonInString);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isEmailSent = false;
        try {
            isEmailSent = Boolean.parseBoolean(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isEmailSent;
    }

    public boolean checkSignUpAccount() {
        String jsonInString = new JsonHandler().jsonAccountInString(account, "checkForSignUp");
        try {
            output.write(jsonInString);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isExist = false;
        try {
            isExist = Boolean.parseBoolean(input.readLine());
            return isExist;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isExist;
    }

    public static void setAccount(Account account) {
        AccountHandler.account = account;
    }
}
