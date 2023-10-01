package com.kerimsenturk.linkbranch.util.IconManager;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class IconManager {

    //It sends a query to Gstatic api with provided parameters
    public byte[] solveBySiteURL(String url, IconSize iconSize) throws IOException {
         final String PARAMETERIZED_URL_QUERY =
                "https://t0.gstatic.com/" +
                        "faviconV2?" +
                        "client=SOCIAL&" +
                        "type=FAVICON&" +
                        "fallback_opts=TYPE,SIZE,URL&" +
                        "url=%s&" + // URL of site
                        "size=%d&"; // Icon size

        //Create the query
        String query = String.format(PARAMETERIZED_URL_QUERY,  url, iconSize.value());

        return getIconByUrl(query);
    }

    //It gets the resource by using given url.
    public byte[] getIconByUrl(String url) throws IOException {

        byte[] iconByteArr;

        URL iconUrl = new URL(url);
        iconByteArr = iconUrl.openStream().readAllBytes();

        return iconByteArr;
    }

    //We can save the icons of most popular sites. (Instagram, twitter, facebook...)

}
