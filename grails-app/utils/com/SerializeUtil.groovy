package com

/**
 * Created by michael on 11/12/2016.
 */
class SerializeUtil {

    def static path = "/Users/michael/cookies/"

    def static writeCookies(url, username, cookies) {
        File file = new File("${path+url.replace("http://", "")+username}.obj")
        if (!file.exists()) {
            file.createNewFile()
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(cookies)
        out.flush()
        out.close()
    }

    def static readCookies(url, username) {
        File file = new File("${path+url.replace("http://", "")+username}.obj")
        if (file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            org.apache.http.impl.client.BasicCookieStore cookieStore = (org.apache.http.impl.client.BasicCookieStore) ois.readObject();
            ois.close()
            return cookieStore
        } else {
            return null
        }
    }
}
