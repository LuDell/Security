package com.chinaup.security.block;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BlockChain {

    private static List<Block> blockList = new ArrayList<>();

    public static void blockChain(String data){
        if(CollectionUtils.isEmpty(blockList)){
            blockList.add(new Block(data,"0"));
        }else{
            blockList.add(new Block(data, blockList.get(blockList.size()-1).getHash()));
        }
    };

    public static String getBlockList() {
        return JSONObject.toJSONString(blockList);
    }
}
