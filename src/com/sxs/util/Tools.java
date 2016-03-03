package com.sxs.util;

import java.util.Random;

public class Tools {
    
    public static  int  getRondom(){
	Random random = new Random();
	int s = random.nextInt(75);
	if(s==0){
	    getRondom();
	}
	return s ;
    }

}
