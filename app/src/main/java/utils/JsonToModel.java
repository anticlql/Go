package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import Model.MyActivity;

/**
 * Created by 刘青林 on 2017/12/14.
 */

public class JsonToModel {

    public static List<MyActivity> userFromJson(String content) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<MyActivity> activityList = null;
        try {
            //再将这个type作为转换的目标type
            activityList = objectMapper.readValue(content, new TypeReference<List<MyActivity>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activityList;
    }
}
