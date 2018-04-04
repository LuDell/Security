package com.chinaup.security;

import com.chinaup.security.block.Block;
import com.chinaup.security.block.BlockChain;
import org.junit.Test;

public class MainTest {
    @Test
    public void blockCreate(){
        BlockChain.blockChain("0");
        BlockChain.blockChain("this is second block");
        BlockChain.blockChain("this is thread block");
        System.out.println(BlockChain.getBlockList());
    }
}
