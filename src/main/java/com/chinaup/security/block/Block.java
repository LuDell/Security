package com.chinaup.security.block;

import com.chinaup.security.common.EncryptString;
import io.netty.util.internal.StringUtil;

public class Block {

    private String hash;

    private String previousHash;//上一个区块的hash

    private String data;//区块数据

    private long timeStamp;

    private int nonce;

    public Block(String data,String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = encryptString();
    }


    private String encryptString(){
        String blockHash = previousHash + Long.toString(timeStamp) + data;
        return EncryptString.applySHA256(blockHash);
    }

    public String getHash() {
        return hash;
    }
}
