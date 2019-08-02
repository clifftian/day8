package com.day8.io;

import java.io.*;
import java.util.Random;
import java.util.zip.*;

public class IOBenchMark {

    public static void main(String[] args) {
        
        
      try {
          int[] sizes = new int[]{1000,10000,100000,1000000,10000000, 1024*1024*20};
          Random r = new Random(System.currentTimeMillis());
          for(int i=0;i<sizes.length;i++){
              byte[] arr = new byte[sizes[i]];
              r.nextBytes(arr);
              //System.out.println("Beginning next round: " + arr.length);
              long start =System.currentTimeMillis();
              byte[] result = zipInputStream2("test", arr,1);
              System.out.println("size: " + arr.length + " time: " +  ((System.currentTimeMillis() - start)/1000.));
          }
          
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
    public static byte[] zipInputStream2(String entryName, byte[] arr, int level) throws IOException  {
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(myOut);
        //zipOut.setLevel(-1);
        
        for (int i=0; i<1000; i++) {
        	entryName = entryName + Integer.toString(i);
        zipOut.putNextEntry(new ZipEntry(entryName));
        }
        
        zipOut.write(arr);
        zipOut.closeEntry();
        zipOut.finish();
        zipOut.close();
        
        
        return myOut.toByteArray();
    }

}