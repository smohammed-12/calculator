/*
 * Utils.java
 *
 * Created on 2006. december 5., 23:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.ivadam.subnetcalculator;

import java.util.Vector;

/**
 *
 * @author chiro
 */
public class Utils
{
    
    public static String getAddressClass(String ipAddress)
    {
        String ret = "";
        String[] address = split(ipAddress, ".");
        if (Integer.parseInt(address[0]) >= 1 && Integer.parseInt(address[0]) <= 126)
            ret = "A";
        else if (Integer.parseInt(address[0]) >= 128 && Integer.parseInt(address[0]) <= 191)
            ret = "B";
        else if (Integer.parseInt(address[0]) >= 192 && Integer.parseInt(address[0]) <= 223)
            ret = "C";
        else if (Integer.parseInt(address[0]) >= 224 && Integer.parseInt(address[0]) <= 239)
            ret = "D";
        else if (Integer.parseInt(address[0]) >= 240 && Integer.parseInt(address[0]) <= 254)
            ret = "E";
        
        return ret;
    }
    
    public static int getDefaultMaskPreffix(String ipClass)
    {
        int preffix = 0;
        if (ipClass.equals("A"))
            preffix = 8;
        else if (ipClass.equals("B"))
            preffix = 16;
        else if (ipClass.equals("C"))
            preffix = 24;
        
        return preffix;
    }
    
    public static String getMask(int preffix)
    {
        int[] powMask = {7, 6, 5, 4, 3, 2, 1, 0};
        int[] fields = new int[4];
        fields[0] = 0;
        fields[1] = 0;
        fields[2] = 0;
        fields[3] = 0;
        
        int j = 0;
        int index = 0;
        for (int i = 0; i < preffix; i++)
        {
            fields[index] += pow(2, powMask[j]);
            j++;
            if (j == 8)
            {
                j = 0;
                index++;
            }
        }
        
        return String.valueOf(fields[0]) + "." + String.valueOf(fields[1]) + "." + String.valueOf(fields[2]) + "." + String.valueOf(fields[3]);
    }
    
    /**
     * Split string into multiple strings
     * @param original      Original string
     * @param separator     Separator string in original string
     * @return              Splitted string array
     */
    public static String[] split(String original, String separator)
    {
        Vector nodes = new Vector();
        
        // Parse nodes into vector
        int index = original.indexOf(separator);
        while(index>=0)
        {
            nodes.addElement( original.substring(0, index) );
            original = original.substring(index+separator.length());
            index = original.indexOf(separator);
        }
        // Get the last node
        nodes.addElement( original );
        
        // Create splitted string array
        String[] result = new String[ nodes.size() ];
        if( nodes.size()>0 )
        {
            for(int loop=0; loop<nodes.size(); loop++)
                result[loop] = (String)nodes.elementAt(loop);
        }
        return result;
    }
    
    public static long pow(int a, int a0)
    {
        int result = 1;
        for (int i = 0; i < a0; i++)
            result *= a;
        return result;
    }
    
    
    
    
}
