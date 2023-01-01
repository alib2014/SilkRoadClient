package com.example.silkroad;

import ADS.AD;
import org.json.JSONObject;

import java.util.Date;

public class JsonHandler {


    private Date getDate() {
        return new Date(System.currentTimeMillis());
    }

    public String jsonAccountInString(Account account, String typeOfRequest) {
        JSONObject jsonObject = new JSONObject(account);
        jsonObject.put("Request", typeOfRequest);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String checkEmailVerificationCode(String data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Code", data);
        jsonObject.put("Request", "checkEmailVerificationCode");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String login(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("Request", "loginAccount");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getMyAccount(String username) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("Request", "getMyAccount");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getMyAccountByEmail(String email) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", email);
        jsonObject.put("Request", "getMyAccountByEmail");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }
    
    public String sendMessage(TextMessage textMessage){
        JSONObject jsonObject = new JSONObject(textMessage);
        jsonObject.put("Request", "sendMessage");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String postNewAd(AD ad, String category) {
        JSONObject jsonObject = new JSONObject(ad);
        System.out.println(jsonObject);
        jsonObject.put("Request", "postNewAd");
        jsonObject.put("Category", category);
        System.out.println(jsonObject);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getMyMessages(int firstUserId, int secondUserID) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstUserID", firstUserId);
        jsonObject.put("secondUserID", secondUserID);
        jsonObject.put("Request", "getMyMessages");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String loadNewMessages(int receiverID,int senderID) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("senderID", senderID);
        jsonObject.put("receiverID", receiverID);
        jsonObject.put("Request", "loadNewMessages");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String search(JSONObject filter)
    {
        filter.put("Request", "search");
        filter.put("from", AdsNumberHandler.start);
        filter.put("to", AdsNumberHandler.end);
        return new SilkRoadCipher().doEncrypt(String.valueOf(filter));
    }

    public String getBookmarks (int id)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accID", id);
        jsonObject.put("Request", "getBookmark");
        jsonObject.put("from", AdsNumberHandler.start);
        jsonObject.put("to", AdsNumberHandler.end);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getHistory (int id)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accID", id);
        jsonObject.put("Request", "getHistory");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getMyAds (int id)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accID", id);
        jsonObject.put("Request", "getMyAds");
        jsonObject.put("from", AdsNumberHandler.start);
        jsonObject.put("to", AdsNumberHandler.end);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }


    public String saveUserPicture(int accID) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "saveUserPicture");
        jsonObject.put("accID", accID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getUserPicture (int accID)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "getUserPicture");
        jsonObject.put("accID", accID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String saveAdPicture (int adID)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "saveAdPicture");
        jsonObject.put("adID", adID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getAdPicture (int adID)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "getAdPicture");
        jsonObject.put("adID", adID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }


    public String changeOnlineStatus(int accountID, boolean status) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("Request", "changeStatusOnline");
        jsonObject.put("accountID", accountID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    /*public String addADToBookmarks(AD ad) {
        JSONObject jsonObject = new JSONObject(ad);
        jsonObject.put("Request", "addADToBookmarks");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }*/

    public String addADToHistory(int adID, int accID) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "updateHistory");
        jsonObject.put("adID", adID);
        jsonObject.put("accID", accID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getNotifications(int receiverID) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "getNotifications");
        jsonObject.put("receiverID", receiverID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String checkMyPassword(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("Request", "checkMyPassword");
        jsonObject.put("password", password);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String changeMyData(int accId, String city, String lastName, String name, String pass, String username) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accId", accId);
        jsonObject.put("city", city);
        jsonObject.put("lastName", lastName);
        jsonObject.put("name", name);
        jsonObject.put("password", pass);
        jsonObject.put("username", username);
        jsonObject.put("Request", "updateInfo");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }
    public String getSpecificAd (int adID)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("adID", adID);
        jsonObject.put("Request", "getSpecificAd");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String add_delete_bookmark (int adID, int accID){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("adID", adID);
        jsonObject.put("accID", accID);
        jsonObject.put("Request", "updateBookmarks");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String passwordRecovery(String email) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", email);
        jsonObject.put("Request", "passwordRecovery");
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getContacts (int accID)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "getContacts");
        jsonObject.put("accID", accID);
        jsonObject.put("from", AdsNumberHandler.accStart);
        jsonObject.put("to", AdsNumberHandler.acccEnd);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }

    public String getSuggestion (int accID)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Request", "getSuggestion");
        jsonObject.put("accID", accID);
        return new SilkRoadCipher().doEncrypt(String.valueOf(jsonObject));
    }
}
